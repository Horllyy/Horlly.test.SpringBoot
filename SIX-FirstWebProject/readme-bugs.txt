1.忘记导thymleaf包 导致不能默认定位到templates文件夹下找首页

2.国际化修改不生效：
  在我copy了index修改成login页面后
  忘记把跳转从index更新到login

3.标签内不能放注释（详情见我的博文 国际化报错xxxx）

4.  //注册拦截器
    //springboot已经自动把静态资源映射排除在外了 所以不用另外处理
    //我去你妈的不用另外处理 版本不同 系统默认确实设置了静态资源 但是addPathPatterns("/**").我第一条就给它否了
    //系统默认访问到 classpath:/META-INF/resources/”, “classpath:/resources/”, “classpath:/static/”, “classpath:/public/”
    //所以把 "/asserts/**","/webjars/**"给我老老实实加上去


5. 端口问题 8080和8081被前面的module占用了 不知道是哪个鬼程序还没放开 引起重视。
   当然 我这里直接使用8082了。

  解决：
  cmd：不确定的话可以先输入
  netstat -ano
  查看一下端口是不是被占用或者listing

  1.查看：
  netstat -ano|findstr "8080"

  2.杀死：
  taskkill /pid 8656 /f


6.学艺不精 对spring还理解不通透 控制层controller调用dao层的时候我还是没有加@AutoWired

7.<!--<td>[[${emp.lastName}}]]</td>-->  这个表达不行

8.去update页面失败 不是映射的问题 是因为update页面有错误