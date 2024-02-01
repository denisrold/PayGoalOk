package PayGoal.demo.Dao;

import PayGoal.demo.Entities.Product;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public  class ProductDaoImp implements productDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> getProducts( String sortBy, String sortOrder) {
        String jpqlQuery = "SELECT p FROM Product p";
        if (sortBy != null && !sortBy.isEmpty()) {
            jpqlQuery += " ORDER BY";
            if ("name".equalsIgnoreCase(sortBy)) {
                jpqlQuery += " p.name";
            } else {
                jpqlQuery += " p." + sortBy;
            }
            if ("desc".equalsIgnoreCase(sortOrder)) {
                jpqlQuery += " DESC";
            } else {
                jpqlQuery += " ASC";
            }
        }
        return entityManager.createQuery(jpqlQuery, Product.class).getResultList();
    }

    public Product getProductbyId(Long id){
        String query = "FROM Product WHERE id = :id";
        Product existingProduct = entityManager.find(Product.class,id);
        if(existingProduct != null ){return existingProduct;}
        else{throw new EntityNotFoundException("Product with ID " + id + " not found");}
    }
    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);

    }


    public void registerProduct(Product product) {
    entityManager.persist(product);
    }


    public Product getProductByIdAndUpdate(Long id, Product updatedProduct)  {
        String query = "FROM Product WHERE id = :id";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("id", id);

        try {
            Product existingProduct = typedQuery.getSingleResult();
            System.out.println(existingProduct);
            if (existingProduct != null) {
                // Actualizar solo si el campo no es nulo en updatedProduct
                if (updatedProduct.getName() != null) {
                    existingProduct.setName(updatedProduct.getName());
                }
                if (updatedProduct.getDescription() != null) {
                    existingProduct.setDescription(updatedProduct.getDescription());
                }
                if (updatedProduct.getPrice() != null) {
                    existingProduct.setPrice(updatedProduct.getPrice());
                }
                if (String.valueOf(updatedProduct.getQuantity()) != null) {
                    existingProduct.setQuantity(updatedProduct.getQuantity());
                }

                entityManager.merge(existingProduct);
                return existingProduct;
            } else {
                throw new EntityNotFoundException("Product with ID " + id + " not found");
            }
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Product with ID " + id + " not found");
        }
    }
}
