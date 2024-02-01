package PayGoal.demo.Services;

import PayGoal.demo.Entities.Product;
import jakarta.validation.Valid;


import java.util.List;

public interface productServices {
  List<Product> getProducts(String sortBy, String sortOrder);
    void deleteProduct(Long id);
    void registerProduct(@Valid Product product);
    Product getProductById(Long id);
    Product getProductByIdAndUpdate(@Valid Long id, Product updatedProduct) ;

}
