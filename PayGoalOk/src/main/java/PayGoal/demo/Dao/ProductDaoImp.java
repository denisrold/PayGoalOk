package PayGoal.demo.Dao;

import PayGoal.demo.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImp implements productDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
    }

    @Override
    public void registerProduct(Product product) {
    entityManager.persist(product);
    }

    @Override
    public Product getProductByIdAndUpdate(Long id, Product updatedProduct) {
        String query = "FROM Product WHERE id = :id";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("id", id);

        try {
            Product existingProduct = typedQuery.getSingleResult();

            if (existingProduct != null) {

                existingProduct.setName(updatedProduct.getName());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setQuantity(updatedProduct.getQuantity());

                entityManager.merge(existingProduct);

                return existingProduct;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
}
