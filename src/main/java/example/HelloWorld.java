package example;

import pl.pionwit.models.logic.LogicTables;
import pl.pionwit.models.tables.CountryTable;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService()
public class HelloWorld {
//  @WebMethod
//  public String sayHelloWorldFrom(String from) {
//    String result = "Hello, world, from " + from;
//    System.out.println(result);
//    return result;
//  }
  public static void main(String[] argv) {
    LogicTables logicTables = new LogicTables();

    System.out.print("NAME - "+logicTables.searchCountry(18L).getName());
    logicTables = null;

    Object implementor = new LogicTables();


    String address = "http://localhost:9000/PionwitService";
    Endpoint.publish(address, implementor);
  }
}
