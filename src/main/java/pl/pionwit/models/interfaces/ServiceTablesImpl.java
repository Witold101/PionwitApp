package pl.pionwit.models.interfaces;

import pl.pionwit.dbmain.dbtables.CountryEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "PionwitService")
public interface ServiceTablesImpl {

// Country table
    @WebMethod
    void addUpdateCountry(CountryEntity country);
    @WebMethod
    void dellCountry (CountryEntity country);
    @WebMethod
    CountryEntity searchCountry (Long id);
    @WebMethod
    boolean isSetCountry (CountryEntity country);
    @WebMethod
    List<CountryEntity> getCountrys();
//--------------------------------------------//

}
