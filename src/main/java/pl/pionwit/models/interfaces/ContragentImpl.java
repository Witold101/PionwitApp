package pl.pionwit.models.interfaces;


import pl.pionwit.models.ContragentsEntity;

public interface ContragentImpl {
    void addUpdate(ContragentsEntity contragent);
    void dell (ContragentsEntity contragent);
    ContragentsEntity search (int id);
    boolean isSet (ContragentsEntity contragent);
}
