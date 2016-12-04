package pl.pionwit;



import pl.pionwit.dbmain.dbtables.AddressesEntity;
import pl.pionwit.dbmain.dbtables.CountryEntity;
import pl.pionwit.models.tables.AddressesTable;
import pl.pionwit.models.tables.CountryTable;

public class AppMain {

    public static void main(String[] args) {

        CountryEntity country = new CountryEntity();
        country.setName("BY");
        country.setNumber(375);
        country.setFlag(25);
        //country.setId(4);

        CountryTable countryTable = CountryTable.getInstance();

            countryTable.addUpdate(country);

        System.out.print(countryTable.toString());
        CountryEntity countryEntity = countryTable.search(5L);

        AddressesTable addressesTable = AddressesTable.getInstance();
        AddressesEntity address = addressesTable.search(1L);

//        System.out.println("id-"+countryEntity.getId()+" KOD-"+countryEntity.getNumber()
//                +" Name-"+countryEntity.getName()
//                +" Flag-"+countryEntity.getFlag());

       System.out.println(countryTable.isSet(countryEntity));


//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        try {
//
//            session.beginTransaction();
//            session.saveOrUpdate(country);
//            session.getTransaction().commit();
//
//        }catch (PersistenceException e){
//
//            //e.printStackTrace();
//
//            for (StackTraceElement el:e.getStackTrace())
//                {
//                    System.out.println(el);
//            }
//            e.getStackTrace();
//
//            //System.out.println("!!!!!!! - "+e.printStackTrace(););
//
//        }
//
//        finally {
//            session.close();
//        }
    }
}
