package My.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class thymleafController {

   @RequestMapping("/succeed")
    public String testThymleaf(Map<String,Object> map) {
        map.put("whoAreYou","阿柳");
        return "succeed";
    }
}
