package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictionaryService;
import service.IDictionaryService;

@Controller
public class DictionaryController {
    private final IDictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/dictionary")
    public String showFormSearch() {
        return "index";
    }

    @PostMapping("/dictionary")
    public ModelAndView search(@RequestParam String search) {
        dictionaryService.getDictionary();
        ModelAndView modelAndView = new ModelAndView("/result");
        String result = dictionaryService.findDictionary(search);
        if(result != null){
            modelAndView.addObject("result",result);
        }else{
            modelAndView.addObject("result","Not found!");
        }
        return modelAndView;
    }
}
