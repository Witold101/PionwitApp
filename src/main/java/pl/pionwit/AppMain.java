package pl.pionwit;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.internal.ExceptionConverterImpl;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import pl.pionwit.dbmain.HibernateUtil;
import pl.pionwit.models.CountryEntity;
import pl.pionwit.models.tables.CountryTable;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

public class AppMain {

    public static void main(String[] args) {

        CountryEntity country = new CountryEntity();
        country.setName("USA");
        country.setNumber(375);
        country.setFlag(25);
        //country.setId(4);

        CountryTable countryTable = CountryTable.getInstance();

        try {
            countryTable.addUpdate(country);
        } catch (PersistenceException e){
            System.out.println("Данные не уникальны!");
        }


        System.out.print(countryTable.toString());
        CountryEntity countryEntity = new CountryEntity();
        countryEntity =countryTable.search(5);



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
