package My.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/ABC")
    public String hello(Model model){
        model.addAttribute("message","嘿！");
        return "success";
    }

}
