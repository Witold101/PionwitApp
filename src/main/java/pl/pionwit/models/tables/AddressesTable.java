package pl.pionwit.models.tables;


import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.pionwit.dbmain.HibernateUtil;
import pl.pionwit.models.AddressesEntity;
import pl.pionwit.models.CountryEntity;
import pl.pionwit.models.interfaces.AddressImpl;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class AddressesTable implements AddressImpl {

    private List<AddressesEntity> addresses;

    private static AddressesTable ourInstance = new AddressesTable();

    public static AddressesTable getInstance() {

        return ourInstance;
    }

    private AddressesTable() {
        addresses = null;
        addresses=new ArrayList<AddressesEntity>();
        setAddressesTable();
    }

    // Инициализирует и синхронизирует таблицу и поле класса
    private void setAddressesTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.addresses = session.createCriteria(AddressesEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Добавляет или обновляет запись в таблице, если есть ID то запись обнавляетсе и наоборот
    public void addUpdate(AddressesEntity address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(address);
            session.flush();
            this.addresses = session.createCriteria(AddressesEntity.class).list();
        }catch (PersistenceException e){
            System.out.println("Данные не уникальны.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // Удаляет запись из таблицы
    public void dell(AddressesEntity address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(address);
        session.flush();
        this.addresses = session.createCriteria(AddressesEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Возвращает запись по ID
    public AddressesEntity search(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        AddressesEntity rez =new AddressesEntity();
        try {
            Query query = session.createQuery("from AddressesEntity where id=:paramName");
            query.setParameter("paramName",id);
            rez = (AddressesEntity) query.list().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Нет такой записи.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
        return rez;
    }

    // Возвращает данные о существовании конкретной записи. Поиск идет по ID.
    public boolean isSet(AddressesEntity address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from AddressesEntity where id=:paramName");
        query.setParameter("paramName",address.getId());
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

    //Возвращает поле класса
    public String toString(){
        String s = "";
        for (AddressesEntity rez : addresses)  {
            s = s+ (" id-"+rez.getId()+" Street1-"+rez.getStreet1()+" Street2-"+rez.getStreet2()
                    +" City-"+rez.getCity()+" Post Code-"+rez.getPostCode()
                    +" ContragentId-"+rez.getContragentId()+" CountryID-"+rez.getCountryId()
                    +" TypeID-"+rez.getTypeId()
            );
        }
        return s;
    }
}
