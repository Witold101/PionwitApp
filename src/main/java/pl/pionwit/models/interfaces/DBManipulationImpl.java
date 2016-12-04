package pl.pionwit.models.interfaces;


import pl.pionwit.dbmain.dbtables.CountryEntity;

import java.util.List;

public interface DBManipulationImpl {
    List<CountryEntity> getAllCountrys();
}
