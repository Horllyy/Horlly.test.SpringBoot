1.登陆错误 不想跳到一个提示错误的新页面 这样很low 返回时是还是原来的登录页面
  想直接把此页面更新成提示错误的登陆页面
  那就不要直接return
  需要redirect 或者forward

  但这样碰到两个问题：
  1.redirect 提示错误的message参数传不过去
  2.forward 不支持网页接收参数的POST方法

  望解决。


2.		<link href="/asserts/css/bootstrap.min.css" rel="stylesheet">
		<link href="asserts/css/bootstrap.min.css" rel="stylesheet">
   尼玛为什么啊 天哪。我必须得学会看源码。不然容易成傻逼。


3.  时间转化有问题：首先 按照这个方式来转换 网页格式必须和  @InitBinder中格式一样 不然直接报错。
        1.要么网页格式 yyyy-MM-dd HH:mm

              @InitBinder
                  public void init(WebDataBinder binder) {
                      binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm"), true));
                  }

           HH:mm要自己输入
        显然我感觉这并不科学 应该是自己自动按电脑时间拼接上去的才好。

        2.要么网页格式 yyyy-MM-dd

                          @InitBinder
                              public void init(WebDataBinder binder) {
                                  binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
                              }

          HH:mm为00：00（因为格式转化后并没有提供 HH:mm 默认设置为0）

         3.思路：
           1.我想知道没有设置birth的那些user怎么自动获取birth的 它们有准确的自动时间生成
           2.能不能我提供yyyy-MM-dd 程序帮我自动补上 HH:mm  而不是要么全自己输入 这样主观性太强 也很奇怪，要么就00：00 这样和没输入有啥区别？
           3.寻求新方法

4.	<input type="hidden" name="_method" value="put" th:if="${emp!=null}"/>
  						<!--在put模式下偷偷给你传一个参数 这里是id-->
  						<input type="hidden" name="id" th:if="${emp!=null}" th:value="${emp.id}">