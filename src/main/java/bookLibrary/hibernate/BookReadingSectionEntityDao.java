package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookReadingSectionEntityDao {

    public void saveBookReading(BookReadingSectionEntity bookReading) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookReading);
        transaction.commit();
        session.close();
    }

    public void updateBookReading(BookReadingSectionEntity bookReading) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bookReading);
        transaction.commit();
        session.close();
    }

    public void deleteBookReading(BookReadingSectionEntity bookReading) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bookReading);
        transaction.commit();
        session.close();
    }

    public List<BookReadingSectionEntity> findAllBooksReading() {
        List<BookReadingSectionEntity> booksReading = (List<BookReadingSectionEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookReadingSectionEntity ").list();
        return booksReading;
    }

    public BookReadingSectionEntity findBookReadingByBookId(int book_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from BookReadingSectionEntity where bookId = :book_id");
        query.setParameter("book_id", book_id);
        if (query.list().size() != 0) {
            return (BookReadingSectionEntity) query.list().get(0);
        }
        return null;
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE BookReadingSection AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}