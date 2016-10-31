package pl.pionwit.models.interfaces;


import pl.pionwit.models.AddressesEntity;

public interface AddressImpl {
    void addUpdate(AddressesEntity address);
    void dell (AddressesEntity address);
    AddressesEntity search (int id);
    boolean isSet (AddressesEntity address);
}
