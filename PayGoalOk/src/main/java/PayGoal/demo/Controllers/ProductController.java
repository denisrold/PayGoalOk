package PayGoal.demo.Controllers;
import PayGoal.demo.Entities.Product;
import PayGoal.demo.Services.ProductServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @GetMapping("api/product/{id}")
    public ResponseEntity getAllProducts(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.getProductById(id));
        }
        catch (Exception e){
            String NotFound = "Source not found with id: "+ id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NotFound);
        }
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
    public ResponseEntity registerProduct(@RequestBody Product product){
        try{
            service.registerProduct(product);
            Map<String, Object> created = new HashMap<>();
            String createdOk = "Created Product Ok";
            created.put("Status",createdOk);
            created.put("Name",product.getName());
            created.put("Description",product.getDescription());
            created.put("Price",product.getPrice());
            created.put("Quantity",product.getQuantity());
            return ResponseEntity.ok().body(created);
        }
        catch(Exception e){
            String NotNull = "Not Null Values  / " + e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(NotNull);
        }
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try{
            service.getProductByIdAndUpdate(id,product);
            Map<String, Object> updated = new HashMap<>();
            String updatedOk = "Updated Product Ok";
            updated.put("Status",updatedOk);
            updated.put("Name",product.getName());
            updated.put("Description",product.getDescription());
            updated.put("Price",product.getPrice());
            updated.put("Quantity",product.getQuantity());
            return ResponseEntity.ok().body(updated);
        }
        catch(Exception e){
            String ErrorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ErrorMessage);
        }
    }
}

