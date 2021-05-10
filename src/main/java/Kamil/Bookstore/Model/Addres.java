package Kamil.Bookstore.Model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Addres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String buildingNumber;
    private String apartmentNumber;
    @Column(nullable = false)
    private String zipCode;

    public Addres() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Addres{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
