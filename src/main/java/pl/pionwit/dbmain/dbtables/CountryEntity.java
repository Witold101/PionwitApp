package pl.pionwit.dbmain.dbtables;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "country", schema = "db_pionwit", catalog = "")
public class CountryEntity {
    private long id;
    private int number;
    private String name;
    private Integer flag;
    private Collection<AddressesEntity> addressesById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, unique = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "flag", nullable = true)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<AddressesEntity> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Collection<AddressesEntity> addressesById) {
        this.addressesById = addressesById;
    }

    public CountryEntity() {
    }

}
