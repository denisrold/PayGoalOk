package PayGoal.demo.Controllers;


import PayGoal.demo.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    @Autowired
    private Product product;
    /*
    @DeleteMapping("/api/product/{id}")
    public void remove(@PathVariable String id){
        service.remove(Long.parseLong(id));
    }
    @PostMapping("/api/product")
    public void save(@RequestBody Product product){
        service.save(customer);
    }*/
}

