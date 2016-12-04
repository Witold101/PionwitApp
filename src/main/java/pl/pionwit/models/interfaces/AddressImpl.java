package pl.pionwit.models.interfaces;


import pl.pionwit.dbmain.dbtables.AddressesEntity;

public interface AddressImpl {
    void addUpdate(AddressesEntity address);
    void dell (AddressesEntity address);
    AddressesEntity search (Long id);
    boolean isSet (AddressesEntity address);
}
