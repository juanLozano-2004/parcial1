package edu.eci.cvds.repository;
import edu.eci.cvds.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    public default Product saveProduct(Product product) {
        return save(product);
    }

    public default ArrayList<Product> findAll() {
        return findAll();
    }

    public default void deleteProduct(Product product) {
        if (existsById(product.getId())) {
            delete(product);
        }
        ;
    }


    public default Product updateProduct(Product product) {
        if (existsById(product.getId())) {
            return save(product);
        } else {
            return null;
        }
    }
}