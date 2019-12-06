1.在resources中新建logback.xml时 默认走logback.xml
  application.properties中对log的配置失效 不走application.properties了 绕过application.properties的对日志有关配置

2.在resources中新建logback-spring.xml时 先从 application.properties走一遍
  可以在 application.properties 中选定环境 dev ，default等 来输出不同格式和配置的日志（这个是挺好用的功能）

  比如这个：
  #来自不同环境输出不同格式日志的配置
  #spring.profiles.active=dev
  直接在 application.properties 中加上这条就行 不用其他配置


3.在resources中只有application.properties 那么走application.properties 的配置