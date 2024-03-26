package az.perfect.jdbs.dao.inter;

import az.perfect.jdbs.entity.Country;

import java.util.List;

public interface CountryDaoImpl {

    public void insert(Country c);

    public void update(Country c);

    public void delete(int id);

     Country getCountryById(int id);

    List<Country> getAllCountry();

    public int count();

}
