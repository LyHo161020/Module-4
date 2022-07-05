package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products",productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFomrCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(Product product, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        redirect.addFlashAttribute("success","Them san pham thanh cong!");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

   @PostMapping("/update")
    public ModelAndView editForm(Product product, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success","Sua san pham thanh cong!");
        return modelAndView;
   }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
