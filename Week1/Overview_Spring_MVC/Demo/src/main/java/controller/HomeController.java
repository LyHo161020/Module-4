package controller;

import javafx.print.Printer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    @GetMapping("/home")
//    public String greeting(@RequestParam String name, Model model) {
//        model.addAttribute("name", name);
//        return "/home/index";
//
//    }

    @GetMapping("/home")
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }


//    @GetMapping("/home")
//    public String welcomeAsHTML1() {
//        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
//                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
//    }
}
