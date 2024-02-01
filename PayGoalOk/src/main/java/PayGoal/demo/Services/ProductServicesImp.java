package PayGoal.demo.Services;

import PayGoal.demo.Dao.ProductDaoImp;
import PayGoal.demo.Entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
@Service
@Transactional
public class ProductServicesImp implements productServices{
    @Autowired
    ProductDaoImp productDaoImp;
    @Override
    public List<Product> getProducts(String sortBy, String sortOrder) {
        return productDaoImp.getProducts(sortBy,sortOrder);
    }
    @Override
    public void deleteProduct(Long id) {
    productDaoImp.deleteProduct(id);
    }
    @Override
    public void registerProduct(Product product) {
    productDaoImp.registerProduct(product);
    }
    @Override
    public Product getProductByIdAndUpdate(Long id, Product updatedProduct) {
        return productDaoImp.getProductByIdAndUpdate(id,updatedProduct);
    }
}
