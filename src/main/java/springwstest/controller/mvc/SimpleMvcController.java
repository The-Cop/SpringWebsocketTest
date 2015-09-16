package springwstest.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class SimpleMvcController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome! This is passed through mvc!");
        return "ThymeleafMessaging";
    }
}
