package pl.pionwit.dbmain.dbtables;

import javax.persistence.*;

@Entity
@Table(name = "addresses", schema = "db_pionwit", catalog = "")
public class AddressesEntity {
    private Long id;
    private String street1;
    private String street2;
    private String city;
    private String postCode;
    private Long countryId;
    private Long contragentId;
    private Long typeId;
    private CountryEntity countryByCountryId;
    private TypesAddressEntity typesAddressByTypeId;
    private ContragentsEntity contragentsByContragentId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "street1", nullable = true, length = 100)
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @Basic
    @Column(name = "street2", nullable = true, length = 100)
    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "post_code", nullable = true, length = 10)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "country_id", nullable = false, insertable = false, updatable = false)
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "contragent_id", nullable = false, insertable = false, updatable = false)
    public Long getContragentId() {
        return contragentId;
    }

    public void setContragentId(Long contragentId) {
        this.contragentId = contragentId;
    }

    @Basic
    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressesEntity that = (AddressesEntity) o;

        if (id != that.id) return false;
        if (countryId != that.countryId) return false;
        if (contragentId != that.contragentId) return false;
        if (typeId != that.typeId) return false;
        if (street1 != null ? !street1.equals(that.street1) : that.street1 != null) return false;
        if (street2 != null ? !street2.equals(that.street2) : that.street2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (street1 != null ? street1.hashCode() : 0);
        result = 31 * result + (street2 != null ? street2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + countryId.hashCode();
        result = 31 * result + contragentId.hashCode();
        result = 31 * result + typeId.hashCode();
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public TypesAddressEntity getTypesAddressByTypeId() {
        return typesAddressByTypeId;
    }

    public void setTypesAddressByTypeId(TypesAddressEntity typesAddressEntity) {
        this.typesAddressByTypeId = typesAddressEntity;
    }

    @ManyToOne
    @JoinColumn(name = "contragent_id", referencedColumnName = "id", nullable = false)
    public ContragentsEntity getContragentsByContragentId() {
        return contragentsByContragentId;
    }

    public void setContragentsByContragentId(ContragentsEntity contragentsByContragentId) {
        this.contragentsByContragentId = contragentsByContragentId;
    }
}
