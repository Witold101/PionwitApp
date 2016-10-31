package pl.pionwit.models.tables;


import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.pionwit.dbmain.HibernateUtil;
import pl.pionwit.models.CountryEntity;
import pl.pionwit.models.interfaces.CountryImpl;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;


//Класс для работы с таблицей Country (Singleton)
public class CountryTable implements CountryImpl{

    private List<CountryEntity> countrys;

    private static CountryTable ourInstance = new CountryTable();

    public static CountryTable getInstance() {

        return ourInstance;
    }

    private CountryTable() {
        countrys = null;
        countrys=new ArrayList<CountryEntity>();
        setCountryTable();
    }

    // Инициализирует и синхронизирует таблицу и поле класса
    private void setCountryTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.countrys = session.createCriteria(CountryEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Добавляет или обновляет запись в таблице, если есть ID то запись обнавляетсе и наоборот
    public void addUpdate(CountryEntity country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(country);
            session.flush();
            this.countrys = session.createCriteria(CountryEntity.class).list();
        }catch (PersistenceException e){
            System.out.println("Данные не уникальны.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // Удаляет запись из таблицы
    public void dell(CountryEntity country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(country);
        session.flush();
        this.countrys = session.createCriteria(CountryEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Возвращает запись по ID
    public CountryEntity search(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CountryEntity country = new CountryEntity();
        try {
            Query query = session.createQuery("from CountryEntity where id=:paramName");
            query.setParameter("paramName",id);
            country = (CountryEntity) query.list().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Нет такой записи.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
        return country;
    }

    // Возвращает данные о существовании конкретной записи. Поиск идет по ID.
    public boolean isSet(CountryEntity country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from CountryEntity where id=:paramName");
        query.setParameter("paramName",country.getId());
        if (query.list().size()>0){
            session.getTransaction().commit();
            session.close();
            return true;
        }else {
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    //Возвращает поле countrys
    public String toString(){
        String s = "";
        for (CountryEntity country : countrys)  {
            s = s+ (" id-"+country.getId()+" KOD-"+country.getNumber()+" Name-"+country.getName()
            +" Flag-"+country.getFlag());
        }
        return s;
    }

}
