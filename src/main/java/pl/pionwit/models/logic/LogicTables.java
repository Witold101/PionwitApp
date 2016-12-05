package pl.pionwit.models.logic;


import pl.pionwit.dbmain.dbtables.CountryEntity;
import pl.pionwit.models.interfaces.ServiceTablesImpl;
import pl.pionwit.models.tables.CountryTable;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "PionwitService")
public class LogicTables implements ServiceTablesImpl{

    public LogicTables() {

    }

    public void addUpdate(CountryEntity country) {
        CountryTable.getInstance().addUpdate(country);
    }

    public void dell(CountryEntity country) {
        CountryTable.getInstance().dell(country);
    }

    public CountryEntity search(Long id) {
        return CountryTable.getInstance().search(id);
    }

    public boolean isSet(CountryEntity country) {
        return CountryTable.getInstance().isSet(country);
    }

    public List<CountryEntity> getCountrys() {
        return CountryTable.getInstance().getCountrys();
    }
}
