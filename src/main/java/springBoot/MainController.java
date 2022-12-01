package springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/app")
    @ResponseBody
    public List<Product> showAllProd(){
        return productService.getProductlist();
    }

    @GetMapping("/product/add")
    @ResponseBody
    public String add(@RequestParam int id, @RequestParam String title, @RequestParam int cost) {
        return id + title + cost;
    }

        @GetMapping("/product/del")
    @ResponseBody
    public void delById(@PathVariable int id) {
        productService.delById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam int productId, @RequestParam Integer param){
        productService.changeCost(productId, param);
    }
}
