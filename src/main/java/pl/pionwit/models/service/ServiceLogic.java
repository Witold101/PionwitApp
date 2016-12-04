package pl.pionwit.models.service;

import pl.pionwit.dbmain.dbtables.CountryEntity;
import pl.pionwit.models.interfaces.DBManipulationImpl;
import pl.pionwit.models.tables.CountryTable;

import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PionwitService")
public class ServiceLogic implements DBManipulationImpl {

    CountryTable countryTable = CountryTable.getInstance();

    public List<CountryEntity> getAllCountrys(){
        return countryTable.getCountrys();
    }

    public ServiceLogic() {
    }
}
