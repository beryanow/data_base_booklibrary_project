package bookLibrary.hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Book", schema = "book_library")
public class BookEntity {
    private int id;
    private String name;
    private Integer authorId;
    private Integer genreId;
    private AuthorEntity authorByAuthorId;
    private GenreEntity genreByGenreId;
    private Collection<BookReadSectionEntity> bookReadSectionsById;
    private Collection<BookReadingSectionEntity> bookReadingSectionsById;
    private Collection<BookToReadSectionEntity> bookToReadSectionsById;
    private Collection<FavouritesEntity> favouritesById;

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
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "genre_id")
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (genreId != null ? !genreId.equals(that.genreId) : that.genreId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    public GenreEntity getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(GenreEntity genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookReadSectionEntity> getBookReadSectionsById() {
        return bookReadSectionsById;
    }

    public void setBookReadSectionsById(Collection<BookReadSectionEntity> bookReadSectionsById) {
        this.bookReadSectionsById = bookReadSectionsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookReadingSectionEntity> getBookReadingSectionsById() {
        return bookReadingSectionsById;
    }

    public void setBookReadingSectionsById(Collection<BookReadingSectionEntity> bookReadingSectionsById) {
        this.bookReadingSectionsById = bookReadingSectionsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookToReadSectionEntity> getBookToReadSectionsById() {
        return bookToReadSectionsById;
    }

    public void setBookToReadSectionsById(Collection<BookToReadSectionEntity> bookToReadSectionsById) {
        this.bookToReadSectionsById = bookToReadSectionsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<FavouritesEntity> getFavouritesById() {
        return favouritesById;
    }

    public void setFavouritesById(Collection<FavouritesEntity> favouritesById) {
        this.favouritesById = favouritesById;
    }
}
