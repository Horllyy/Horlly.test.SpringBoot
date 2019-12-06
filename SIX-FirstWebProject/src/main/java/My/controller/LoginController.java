package My.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
//    @RequestParam的作用是 若不提交此参数 就报错
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登陆成功以后 防止表单重复提交 可重定向到主页
            session.setAttribute("loginUserName",username);
            return "redirect:/main";
        }
        else {
            map.put("message","用户名密码错误");
            return "login";
//            return "forward:/index";
        }
    }
}
