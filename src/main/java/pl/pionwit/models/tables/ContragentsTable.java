package pl.pionwit.models.tables;


import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.pionwit.dbmain.HibernateUtil;
import pl.pionwit.models.ContragentsEntity;
import pl.pionwit.models.interfaces.ContragentImpl;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class ContragentsTable implements ContragentImpl {

    private List<ContragentsEntity> contragents;

    private static ContragentsTable ourInstance = new ContragentsTable();

    public static ContragentsTable getInstance() {

        return ourInstance;
    }

    private ContragentsTable() {
        contragents = null;
        contragents=new ArrayList<ContragentsEntity>();
        setContragentsTable();
    }

    // Инициализирует и синхронизирует таблицу и поле класса
    private void setContragentsTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        this.contragents = session.createCriteria(ContragentsEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Добавляет или обновляет запись в таблице, если есть ID то запись обнавляетсе и наоборот
    public void addUpdate(ContragentsEntity contragent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(contragent);
            session.flush();
            this.contragents = session.createCriteria(ContragentsEntity.class).list();
        }catch (PersistenceException e){
            System.out.println("Данные не уникальны.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // Удаляет запись из таблицы
    public void dell(ContragentsEntity contragent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(contragent);
        session.flush();
        this.contragents = session.createCriteria(ContragentsEntity.class).list();
        session.getTransaction().commit();
        session.close();
    }

    // Возвращает запись по ID
    public ContragentsEntity search(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ContragentsEntity rez = new ContragentsEntity();
        try {
            Query query = session.createQuery("from ContragentsEntity where id=:paramName");
            query.setParameter("paramName",id);
            rez = (ContragentsEntity) query.list().get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Нет такой записи.");
        }finally {
            session.getTransaction().commit();
            session.close();
        }
        return rez;
    }

    // Возвращает данные о существовании конкретной записи. Поиск идет по ID.
    public boolean isSet(ContragentsEntity contragent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ContragentsEntity where id=:paramName");
        query.setParameter("paramName",contragent.getId());
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
        for (ContragentsEntity rez : contragents)  {
            s = s+ (" id-"+rez.getId()+" Name-"+rez.getName()+" FullName-"+rez.getFullName()
                    +" ChDate-"+rez.getChangeDate()+" Regist date-"+rez.getRegistDate());
        }
        return s;
    }
}
