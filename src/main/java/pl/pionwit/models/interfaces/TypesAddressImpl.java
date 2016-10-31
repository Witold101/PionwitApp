package pl.pionwit.models.interfaces;


import pl.pionwit.models.TypesAddressEntity;

public interface TypesAddressImpl {
    void addUpdate(TypesAddressEntity typeAddress);
    void dell (TypesAddressEntity typeAddress);
    TypesAddressEntity search (int id);
    boolean isSet (TypesAddressEntity typeAddress);
}
