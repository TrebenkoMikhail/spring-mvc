package springBoot;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class ProductRepository {

    private List<Product> productList;
    @PostConstruct
    public List productRepository(){
        List<Product> productList = List.of(
        new Product(1, "Apple", 10),
        new Product(2, "Orange", 10),
        new Product(3, "Cherry", 10),
        new Product(4, "Peach", 10),
        new Product(5, "Banana", 10));

        return productRepository();
    }
    public List<Product> getProductList() {return Collections.unmodifiableList(productList);}

    public Product findById(int id) {
        return productList.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

    }
    public List<Product> addProd(Product p){
        productList.add(p);
        return productList;
    }

    public void delById(int id) {
        productList.removeIf(p -> Objects.equals(p.getId(), id));
    }
}

