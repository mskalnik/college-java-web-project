package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "public", catalog = "java-simple-webshop")
public class Address {
    private int addressId;
    private String street;
    private String city;
    private String postalCode;
    private Collection<Person> peopleByAddressId;
    private Country countryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 100)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postal_code", nullable = false, length = 5)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, street, city, postalCode);
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Person> getPeopleByAddressId() {
        return peopleByAddressId;
    }

    public void setPeopleByAddressId(Collection<Person> peopleByAddressId) {
        this.peopleByAddressId = peopleByAddressId;
    }

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
}
