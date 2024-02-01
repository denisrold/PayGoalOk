package PayGoal.demo.Services;

import PayGoal.demo.Entities.Product;

import java.util.List;

public interface productServices {
    List<Product> getProducts();
    void deleteProduct(Long id);
    void registerProduct(Product product);

    Product getProductByIdAndUpdate(Long id, Product updatedProduct);
}
