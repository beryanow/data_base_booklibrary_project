package bookLibrary.hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Author", schema = "book_library")
public class AuthorEntity {
    private int id;
    private String name;
    private Integer addressId;
    private AddressEntity addressByAddressId;
    private Collection<BookEntity> booksById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address_id")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AddressEntity getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(AddressEntity addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "authorByAuthorId")
    public Collection<BookEntity> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<BookEntity> booksById) {
        this.booksById = booksById;
    }
}
