package pl.pionwit.models.interfaces;


import pl.pionwit.models.CountryEntity;

public interface CountryImpl {
    void addUpdate(CountryEntity country);
    void dell (CountryEntity country);
    CountryEntity search (int id);
    boolean isSet (CountryEntity country);
}
