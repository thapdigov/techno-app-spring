package az.perfect.jdbs.dao.inter;

import az.perfect.jdbs.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductDaoInter {

    public void insert(Product p);

    public void update(Product p);

    public void Delete(int id);

    Product getproductById(int id);

    List<Product> getAllProducts();

    public int count();

}
