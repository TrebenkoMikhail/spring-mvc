package springBoot;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductlist() {
        return productRepository.getProductList();
    }


    public void delById(int id) {
        productRepository.delById(id);
    }

    public void changeCost(int productId, Integer param) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + param);
    }
}

