package by.vistal;

import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import pl.pionwit.dbmain.dbtables.CountryEntity;
import pl.pionwit.models.interfaces.*;
import pl.pionwit.models.logic.LogicTables;

public class ServiceClient {

    public static void main(String[] arg) throws MalformedURLException {
        URL url = new URL("http://localhost:9000/PionwitService?wsdl");
        QName qName = new QName("http://logic.models.pionwit.pl/","PionwitService");
        Service service = Service.create(url,qName);
        ServiceTablesImpl ltables = service.getPort(LogicTables.class);

        for (CountryEntity country:ltables.getCountrys()) {
            System.out.println("NAME - "+country.getName());
        }
    }
}
