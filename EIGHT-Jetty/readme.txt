很简单 就换依赖就行。

  比如tomcat换jetty：

       <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-web</artifactId>
                 <exclusions>
                     <exclusion>
                         <artifactId>spring-boot-starter-tomcat</artifactId>
                         <groupId>org.springframework.boot</groupId>
                     </exclusion>
                 </exclusions>
             </dependency>

             <!--引入其他的servlet容器-->
             <dependency>
                 <artifactId>spring-boot-starter-jetty</artifactId>
                 <groupId>org.springframework.boot</groupId>
             </dependency>


    换回来 或者换成undertow 一样的。（就是下载网速不好要配半天啊。。。十分钟吧 我哭 好的网速加急速运转的电脑真的能让程序员爽到飞起）


2.当然 我顺便把上一把配的servlet定制器也copy过来了 试试看是不是对所有servlet容器通杀。


3.好的 下载卡住可能是我的电脑出现了问题。我应该及时重启软件才对 不应该傻等一小时。
  实践出真知 坑里长记性。