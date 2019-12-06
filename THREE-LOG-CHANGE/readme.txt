详情参考：B站收藏 P27

1.（不推荐此更换）我把springboot默认的日志：
   slf4j+logback
换成了：
   slf4j+log4j

 pom.xml改动后如下：

           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
               <exclusions>
                   <exclusion>
                       <artifactId>logback-classic</artifactId>
                       <groupId>ch.qos.logback</groupId>
                   </exclusion>
                   <exclusion>
                       <artifactId>log4j-to-slf4j</artifactId>
                       <groupId>org.apache.logging.log4j</groupId>
                   </exclusion>
               </exclusions>
           </dependency>

           <dependency>
               <groupId>org.slf4j</groupId>
               <artifactId>slf4j-log4j12</artifactId>
           </dependency>

   引入后要在resources中加入一个log4j.properties配置文件 可用于配置格式属性等


2.我把以上修改注释掉（springboot真的方便）
  官方文件说除了默认的 spring-boot-starter-logging 可以实现 slf4j+logback 日志配置
  还可以用 spring-boot-starter-log4j2

  pom.xml配置改动后如下：
      <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
             <exclusions>
                 <exclusion>
                     <artifactId>spring-boot-starter-logging</artifactId>
                     <groupId>org.springframework.boot</groupId>
                 </exclusion>
             </exclusions>
         </dependency>

         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-log4j2</artifactId>
         </dependency>


      说明：因为之前第一次修改是在spring-boot-starter-logging 基础上 所以我把整个spring-boot-starter-logging 替换掉以后 第一次的修改影响已经不复存在
            所以我直接整个换成 spring-boot-starter-log4j2 后 和最开始的配置几乎没差别 使用也没差别
            唯一一点要注意的是： 之前的专门日志修改文件是：logback.xml或者logback-spring.xml
                                 现在要换成：log4j2.xml或者log4j2-spring.xml
                                 等价替换罢了。
log4j2.x
