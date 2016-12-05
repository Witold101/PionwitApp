package pl.pionwit.models.logic;


import pl.pionwit.dbmain.dbtables.CountryEntity;
import pl.pionwit.models.interfaces.ServiceTablesImpl;
import pl.pionwit.models.tables.CountryTable;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "PionwitService")
public class LogicTables implements ServiceTablesImpl{

    public LogicTables() {
    }

    @WebMethod
    public void addUpdateCountry(CountryEntity country) {
        CountryTable.getInstance().addUpdate(country);
    }

    @WebMethod
    public void dellCountry(CountryEntity country) {
        CountryTable.getInstance().dell(country);
    }

    @WebMethod
    public CountryEntity searchCountry(Long id) {
        return CountryTable.getInstance().search(id);
    }

    @WebMethod
    public boolean isSetCountry(CountryEntity country) {
        return CountryTable.getInstance().isSet(country);
    }

    @WebMethod
    public List<CountryEntity> getCountrys() {
        return CountryTable.getInstance().getCountrys();
    }
}
