package pl.pionwit.models.interfaces;


import pl.pionwit.dbmain.dbtables.ContragentsEntity;

public interface ContragentImpl {
    void addUpdate(ContragentsEntity contragent);
    void dell (ContragentsEntity contragent);
    ContragentsEntity search (Long id);
    boolean isSet (ContragentsEntity contragent);
}
