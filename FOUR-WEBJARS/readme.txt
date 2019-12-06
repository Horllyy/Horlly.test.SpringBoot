在学习新知识之前先简单来个项目快速构建 马上就遇到了问题 牛。
 端口问题 8080和8081被前面的module占用了 不知道是哪个鬼程序还没放开 引起重视。
 当然 我这里直接使用8082了。

解决：
cmd：不确定的话可以先输入
netstat -ano
查看一下端口是不是被占用或者listing

1.查看：
netstat -ano|findstr "8081"

2.杀死：
taskkill /pid 8656 /f



1.webjars的使用:
   1.先去这个网站：
     https://www.webjars.org
     找到想要的webjar 复制maven 导入我们的pom.xml
   2. http://localhost:8080 + webjars/jquery/3.4.1/jquery.js 得到：
     http://localhost:8080/webjars/jquery/3.4.1/jquery.js

     后面这个路径是从： jar包所在地： jquery-3.4.1.jar!\META-INF\resources\webjars\jquery\3.4.1 ，从resources\目录以下往后写的
     直到某.js页面或什么页面。



2.自己的静态资源（具体路径看截图 我们自己的静态资源访问路径有.png）
  我写了12345.txt来阐述4类路径。

  请check 4.txt 查看详情使用。



3.欢迎页：
 index页面
 放在上述静态资源文件夹下 直接
http://localhost:8080
 即可找到。
 （各静态资源路径之间应该也是有一定优先级的 因为我写了两个 多次测试都只出现第二个测试页面）


 4.自己的小图标
   也放在上述任意静态资源文件夹下 命名为：favicon.ico 即可


注意点：1.当我们自己定义过静态文件夹以后 以上默认功能就会失效。
        当然 自己定义的就会启用。
        如application.properties中第一句定义。

        2.以上说明 classpath：/ 有以下几种情况：
           1.src-main-java
           2.src-main-resoruces
           (总之就是 src-main- 下的第一个文件夹)