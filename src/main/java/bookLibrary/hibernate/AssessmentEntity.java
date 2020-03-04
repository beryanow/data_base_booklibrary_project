package bookLibrary.hibernate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Assessment", schema = "book_library")
public class AssessmentEntity {
    private int id;
    private byte grade;
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
    @Column(name = "grade")
    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssessmentEntity that = (AssessmentEntity) o;

        if (id != that.id) return false;
        if (grade != that.grade) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) grade;
        return result;
    }

    @OneToMany(mappedBy = "assessmentByAssessmentId")
    public Collection<BookReadSectionEntity> getBookReadSectionsById() {
        return bookReadSectionsById;
    }

    public void setBookReadSectionsById(Collection<BookReadSectionEntity> bookReadSectionsById) {
        this.bookReadSectionsById = bookReadSectionsById;
    }
}
