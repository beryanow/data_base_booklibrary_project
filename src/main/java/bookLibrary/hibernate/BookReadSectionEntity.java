package bookLibrary.hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "BookReadSection", schema = "book_library")
public class BookReadSectionEntity {
    private int id;
    private int bookId;
    private int quoteId;
    private int assessmentId;
    private Date dateOfCompletion;
    private BookEntity bookByBookId;
    private QuoteEntity quoteByQuoteId;
    private AssessmentEntity assessmentByAssessmentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "quote_id")
    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    @Basic
    @Column(name = "assessment_id")
    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Basic
    @Column(name = "date_of_completion")
    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookReadSectionEntity that = (BookReadSectionEntity) o;

        if (id != that.id) return false;
        if (bookId != that.bookId) return false;
        if (quoteId != that.quoteId) return false;
        if (assessmentId != that.assessmentId) return false;
        if (dateOfCompletion != null ? !dateOfCompletion.equals(that.dateOfCompletion) : that.dateOfCompletion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookId;
        result = 31 * result + quoteId;
        result = 31 * result + assessmentId;
        result = 31 * result + (dateOfCompletion != null ? dateOfCompletion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public QuoteEntity getQuoteByQuoteId() {
        return quoteByQuoteId;
    }

    public void setQuoteByQuoteId(QuoteEntity quoteByQuoteId) {
        this.quoteByQuoteId = quoteByQuoteId;
    }

    @ManyToOne
    @JoinColumn(name = "assessment_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public AssessmentEntity getAssessmentByAssessmentId() {
        return assessmentByAssessmentId;
    }

    public void setAssessmentByAssessmentId(AssessmentEntity assessmentByAssessmentId) {
        this.assessmentByAssessmentId = assessmentByAssessmentId;
    }
}
