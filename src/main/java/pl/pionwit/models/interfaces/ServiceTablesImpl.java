package pl.pionwit.models.interfaces;

import pl.pionwit.dbmain.dbtables.CountryEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PionwitService")
public interface ServiceTablesImpl {

// Country table
    @WebMethod
    void addUpdate(CountryEntity country);
    @WebMethod
    void dell (CountryEntity country);
    @WebMethod
    CountryEntity search (Long id);
    @WebMethod
    boolean isSet (CountryEntity country);
    @WebMethod
    List getCountrys();
//--------------------------------------------//

}
