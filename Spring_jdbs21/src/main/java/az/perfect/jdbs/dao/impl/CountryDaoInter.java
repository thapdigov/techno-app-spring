package az.perfect.jdbs.dao.impl;

import az.perfect.jdbs.dao.inter.CategoryDaoInter;
import az.perfect.jdbs.dao.inter.CountryDaoImpl;
import az.perfect.jdbs.entity.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CountryDaoInter implements CountryDaoImpl {

   private  JdbcTemplate jdbcTemplate;

    public CountryDaoInter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Country c) {
        String query="insert into country (country_id,country_name) values(?,?);";
        jdbcTemplate.update(query,c.getCountry_id(),c.getCountry_name());
    }

    @Override
    public void update(Country c) {
        String query="update country set country_id=?,country_name=?;";
        jdbcTemplate.update(query,c.getCountry_id(),c.getCountry_name());


    }

    @Override
    public void delete(int id) {
        String query="delete from country where country_id=?;";
        jdbcTemplate.update(query,id);


    }

    @Override
    public Country getCountryById(int id) {
        String query="select *from country where country_id=?;";
        return  jdbcTemplate.queryForObject(query,new CountryMapp(),id);

    }

    @Override
    public List<Country> getAllCountry() {
        String query="select *from country;";
        return  jdbcTemplate.query(query,new CountryMapp());
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from country;",Integer.class);
    }

    public class CountryMapp implements RowMapper<Country>{

        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Country.builder().country_id(rs.getInt("country_id")).
                    country_name(rs.getString("country_name")).build();
        }
    }
}
