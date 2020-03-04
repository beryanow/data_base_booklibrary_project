package bookLibrary.hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Quote", schema = "book_library")
public class QuoteEntity {
    private int id;
    private String content;
    private Collection<BookReadSectionEntity> bookReadSectionsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteEntity that = (QuoteEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "quoteByQuoteId")
    public Collection<BookReadSectionEntity> getBookReadSectionsById() {
        return bookReadSectionsById;
    }

    public void setBookReadSectionsById(Collection<BookReadSectionEntity> bookReadSectionsById) {
        this.bookReadSectionsById = bookReadSectionsById;
    }
}
