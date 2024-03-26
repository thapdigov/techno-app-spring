package az.perfect.jdbs.dao.impl;

import az.perfect.jdbs.dao.inter.ProductDaoInter;
import az.perfect.jdbs.entity.Category;
import az.perfect.jdbs.entity.Country;
import az.perfect.jdbs.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDaoInter {



    private JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Product p) {
      String query="insert into product(product_name,quantity,category_id,country_id) values(?,?,?,?)";
      jdbcTemplate.update(query,p.getProduct_name(),p.getQuantity(),p.getCategory().getCategory_id(),p.getCountry().getCountry_id());

    }

    @Override
    public void update(Product p) {
      String query="update product set product_name=?,quantity=?,category_id=?,country_id=? where product_id=?";
      jdbcTemplate.update(query,p.getProduct_name(),p.getQuantity(),p.getCategory().getCategory_id(),p.getCountry().getCountry_id(),p.getProduct_id());

    }

    @Override
    public void Delete(int id) {
      String query="delete from  product where product_id=?";
        jdbcTemplate.update(query,id);

    }
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from product",Integer.class);
    }

    @Override
    public Product getproductById(int id) {
          String query="select *from allinfo where product_id=?";
          return  jdbcTemplate.queryForObject(query,new ProductRowMapper(),id);

    }

    @Override
    public List<Product> getAllProducts() {
        String query="select * from allinfo";
        return jdbcTemplate.query(query,new ProductRowMapper());
    }


    public class ProductRowMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            int product_id=rs.getInt("product_id");
            String product_name=rs.getString("product_name");
            int quantity=rs.getInt("quantity");
            int country_id=rs.getInt("country_id_product");
            String country_name=rs.getString("country_name");
            int category_id=rs.getInt("category_id_product");
            String category_name=rs.getString("category_name");
            Product p=new Product(product_id,product_name,quantity,new Country(country_id,country_name),
                    new Category(category_id,category_name));
         return p;

        }
    }
}
