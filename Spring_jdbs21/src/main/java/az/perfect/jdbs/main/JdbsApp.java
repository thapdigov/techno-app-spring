package az.perfect.jdbs.main;

import az.perfect.jdbs.config.SpringJdbsConfig;
import az.perfect.jdbs.dao.impl.ProductDaoImpl;
import az.perfect.jdbs.entity.Category;
import az.perfect.jdbs.entity.Country;
import az.perfect.jdbs.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbsApp {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringJdbsConfig.class);
        ProductDaoImpl pdao= context.getBean(ProductDaoImpl.class);
        System.out.println(pdao.getAllProducts());
    }
}
