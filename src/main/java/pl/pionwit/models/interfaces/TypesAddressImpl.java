package pl.pionwit.models.interfaces;


import pl.pionwit.dbmain.dbtables.TypesAddressEntity;

public interface TypesAddressImpl {
    void addUpdate(TypesAddressEntity typeAddress);
    void dell (TypesAddressEntity typeAddress);
    TypesAddressEntity search (Long id);
    boolean isSet (TypesAddressEntity typeAddress);
}
