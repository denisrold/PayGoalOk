package PayGoal.demo.Controllers;
import PayGoal.demo.Entities.Product;
import PayGoal.demo.Services.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductServicesImp service;
    @GetMapping("api/products")
    public List<Product> getAllProducts(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder){
        return service.getProducts(sortBy,sortOrder);
    }
    @DeleteMapping("/api/product/{id}")
    public void remove(@PathVariable String id){
        service.deleteProduct(Long.parseLong(id));
    }
    @PostMapping("/api/product")
    public void registerProduct(@RequestBody Product product){
        service.registerProduct(product);
    }
    @PutMapping("/api/product")
    public void updateProduct(@RequestBody Product product) {
        service.getProductByIdAndUpdate(product.getId(),product);
    }
}

