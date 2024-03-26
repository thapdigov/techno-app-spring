package az.perfect.jdbs.dao.impl;

import az.perfect.jdbs.dao.inter.CategoryDaoInter;
import az.perfect.jdbs.entity.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDaoImpl  implements CategoryDaoInter {
    private JdbcTemplate jdbcTemplate;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insert(Category c) {
        String query="insert into category (category_id,category_name) values(?,?)";
        jdbcTemplate.update(query,c.getCategory_id(),c.getCategory_name());

    }

    @Override
    public void update(Category c) {
        String query="update category set category_id=?,category_name=?";
        jdbcTemplate.update(query,c.getCategory_id(),c.getCategory_name());

    }

    @Override
    public void Delete(int id) {
        String query="delete from category where category_id=?";
        jdbcTemplate.update(query,id);


    }

    @Override
    public Category getcategory(int id) {
        String query="select * from category where category_id=?";
        return jdbcTemplate.queryForObject(query,new CategoryMapp(),id);
    }

    @Override
    public List<Category> getAllCategorys() {
        String query="select * from category";
        return jdbcTemplate.query(query,new CategoryMapp());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from category",Integer.class);
    }

    public class CategoryMapp implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Category.builder().category_id(rs.getInt("category_id")).
                    category_name(rs.getString("category_name")).build();
        }
    }



}
