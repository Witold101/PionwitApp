package pl.pionwit.models.interfaces;


import pl.pionwit.dbmain.dbtables.CountryEntity;

import java.util.List;

public interface CountryImpl {
    void addUpdate(CountryEntity country);
    void dell (CountryEntity country);
    CountryEntity search (Long id);
    boolean isSet (CountryEntity country);
    List getCountrys();
}
