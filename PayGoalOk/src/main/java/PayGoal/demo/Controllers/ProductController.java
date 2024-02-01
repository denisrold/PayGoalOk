package PayGoal.demo.Controllers;
import PayGoal.demo.Entities.Product;
import PayGoal.demo.Services.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity remove(@PathVariable String id){
    try{
        service.deleteProduct(Long.parseLong(id));
        String Deleted = "Deleted " + id;
        return ResponseEntity.ok(Deleted);
    }
       catch (Exception e){
            String NotFound = "Source not found with id: "+ id;
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NotFound);
       }
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

