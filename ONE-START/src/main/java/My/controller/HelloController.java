package My.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody的作用是 把方法的返回值直接写给浏览器 不用经过返回“succeed” succeed定位到succeed.jsp页面等操作
//如果是对象 还自动转为json数据
//@ResponseBody
//@Controller

//@RestController = @ResponseBody + @Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick";
    }
}
