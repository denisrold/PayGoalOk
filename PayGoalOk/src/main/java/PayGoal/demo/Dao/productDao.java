package PayGoal.demo.Dao;

import PayGoal.demo.Entities.Product;

import java.util.List;

public interface productDao {
    List<Product> getProducts( String sortBy, String sortOrder);
    Product getProductbyId(Long id);
    void deleteProduct(Long id);
    void registerProduct(Product product);

    Product getProductByIdAndUpdate(Long id, Product product) ;
}
