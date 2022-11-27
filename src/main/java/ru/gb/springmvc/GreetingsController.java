package ru.gb.springmvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Controller
public class GreetingsController extends ProductRepository {

    @GetMapping(value = "http://localhost:8180/app/products/{id}")
    @ResponseBody
    public String getProduct(@PathVariable int id, List<Product> productList){
        Product product = productList.stream().filter(it -> Objects.equals(id, it.getId())).findFirst().orElse(null);
        return product.getTitle();
    }
        @GetMapping(value = "http://localhost:8180/app/products")
        public String productRepository(@RequestParam List<Product> productList,  Model model){
        model.addAllAttributes(productList);
        return productRepository(productList, model);
    }

    @GetMapping(value = "http://localhost:8180/app/add")
    @ResponseBody
    public String addProd(List<Product> productList){
        return addProd(productList);
    }
}
