package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookReadSectionEntityDao {

    public void saveBookRead(BookReadSectionEntity bookRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookRead);
        transaction.commit();
        session.close();
    }

    public void updateBookRead(BookReadSectionEntity bookRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bookRead);
        transaction.commit();
        session.close();
    }

    public void deleteBookRead(BookReadSectionEntity bookRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bookRead);
        transaction.commit();
        session.close();
    }

    public List<BookReadSectionEntity> findAllBooksRead() {
        List<BookReadSectionEntity> booksRead = (List<BookReadSectionEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookReadSectionEntity ").list();
        return booksRead;
    }

    public BookReadSectionEntity findBookReadById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookReadSectionEntity.class, id);
    }

    public List<BookReadSectionEntity> findBooksReadByAssessmentId(int assessment_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from BookReadSectionEntity where assessmentId = :assessment_id");
        query.setParameter("assessment_id", assessment_id);
        return query.list();
    }

    public List<BookReadSectionEntity> findBooksReadByMonth(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        String month = simpleDateFormat.format(date);
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from BookReadSectionEntity where month(dateOfCompletion) = :date ");
        query.setParameter("date", Integer.parseInt(month));

        return query.list();
    }

    public BookReadSectionEntity findBookReadByBookId(int book_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from BookReadSectionEntity where bookId = :book_id");
        query.setParameter("book_id", book_id);
        if (query.list().size() != 0) {
            return (BookReadSectionEntity) query.list().get(0);
        }
        return null;
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE BookReadSection AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}