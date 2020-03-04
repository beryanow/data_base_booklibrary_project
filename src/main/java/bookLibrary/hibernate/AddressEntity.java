package bookLibrary.hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Address", schema = "book_library")
public class AddressEntity {
    private int id;
    private Integer countryId;
    private Integer cityId;
    private CountryEntity countryByCountryId;
    private CityEntity cityByCityId;
    private Collection<AuthorEntity> authorsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (id != that.id) return false;
        if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<AuthorEntity> getAuthorsById() {
        return authorsById;
    }

    public void setAuthorsById(Collection<AuthorEntity> authorsById) {
        this.authorsById = authorsById;
    }
}
