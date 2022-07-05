package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterAppController {
//    @GetMapping("/converter")
//    public ModelAndView listProducts(){
//        ModelAndView modelAndView = new ModelAndView("/views/index");
//        return  modelAndView;
//    }

    @GetMapping("/converter")
    public String formConverter(){
        return "index";
    }

    @PostMapping("/converter")
    public ModelAndView convert(@RequestParam int exchangeRate, int money) {
        ModelAndView modelAndView = new ModelAndView("/convert");
        modelAndView.addObject("exchangeRate",exchangeRate);
        modelAndView.addObject("money",money);

        return modelAndView;
    }
}
