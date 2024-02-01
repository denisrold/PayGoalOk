package PayGoal.demo.Dao;

import PayGoal.demo.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productDao {
    List<Product> getProducts( String sortBy, String sortOrder);
    void deleteProduct(Long id);
    void registerProduct(Product product);

    Product getProductByIdAndUpdate(Long id, Product product) ;
}
