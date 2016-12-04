package pl.pionwit.models.tables;


import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.pionwit.dbmain.HibernateUtil;
import pl.pionwit.dbmain.dbtables.TypesAddressEntity;
import pl.pionwit.models.interfaces.TypesAddressImpl;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class TypeAddressTable implements TypesAddressImpl {

    private List<TypesAddressEntity> typeAddresses;

    private static TypeAddressTable ourInstance = new TypeAddressTable();

    public static TypeAddressTable getInstance() {

        return ourInstance;
    }

    private TypeAddressTable() {
        typeAddresses = null;
        typeAddresses=new ArrayList<TypesAddressEntity>();
        setTypesAddressTable();
    }

    // Инициализирует и синхронизирует таблицу и поле класса
    private void setTypesAddressTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.typeAddresses = session.createCriteria(TypesAddressEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Добавляет или обновляет запись в таблице, если есть ID то запись обнавляетсе и наоборот
    public void addUpdate(TypesAddressEntity typeAddress){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(typeAddress);
            session.flush();
            this.typeAddresses = session.createQuery("from TypesAddressEntity").list();
            session.getTransaction().commit();
        }
        catch (PersistenceException ex) {
            Throwable sq = ex.getCause();
            sq=sq.getCause();
            String s = sq.getMessage();
            System.out.println(s);
        }
        finally {
            session.close();
        }
    }

    // Удаляет запись из таблицы
    public void dell(TypesAddressEntity typeAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(typeAddress);
        session.flush();
        this.typeAddresses = session.createCriteria(TypesAddressEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Возвращает запись по ID
    public TypesAddressEntity search(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypesAddressEntity rez = new TypesAddressEntity();
        try {
            Query query = session.createQuery("from TypesAddressEntity where id=:paramName");
            query.setParameter("paramName",id);
            rez = (TypesAddressEntity) query.list().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Нет такой записи.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
        return rez;
    }

    // Возвращает данные о существовании конкретной записи. Поиск идет по ID.
    public boolean isSet(TypesAddressEntity typeAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from TypesAddressEntity where id=:paramName");
        query.setParameter("paramName",typeAddress.getId());
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
        for (TypesAddressEntity rez : typeAddresses)  {
            s = s+ (" id-"+rez.getId()+" Name-"+rez.getName());
        }
        return s;
    }
}
