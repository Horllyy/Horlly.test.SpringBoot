1.springboot 2.1.7  默认mysql的数据源：
      class com.zaxxer.hikari.HikariDataSource

2.获取到的连接：
      HikariProxyConnection@373973695 wrapping com.mysql.jdbc.JDBC4Connection@11ebb1b6

3.如果你在创建项目时直接勾选mysql 依赖是这样的：
             <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
                  <scope>runtime</scope>
              </dependency>

     版本是：
       <modelVersion>4.0.0</modelVersion>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.17</version>
       <packaging>jar</packaging>

     没错 默认8.0版本了。

 这个版本和我的5.0mysql版本不兼容 所以我手动依赖
              <!--<dependency>-->
                  <!--<groupId>mysql</groupId>-->
                  <!--<artifactId>mysql-connector-java</artifactId>-->
                  <!--<scope>runtime</scope>-->
              <!--</dependency>-->

              <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
                  <version>5.1.6</version>
              </dependency>
  OK。
  （当然 你也可以直接把在上面那个原始依赖上加上版本号锁定 但我更倾向于保留修改痕迹）