package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookToReadSectionEntityDao {

    public void saveBookToRead(BookToReadSectionEntity bookToRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookToRead);
        transaction.commit();
        session.close();
    }

    public void updateBookToRead(BookToReadSectionEntity bookToRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bookToRead);
        transaction.commit();
        session.close();
    }

    public void deleteBookToRead(BookToReadSectionEntity bookToRead) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bookToRead);
        transaction.commit();
        session.close();
    }

    public List<BookToReadSectionEntity> findAllBooksToRead() {
        List<BookToReadSectionEntity> booksToRead = (List<BookToReadSectionEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookToReadSectionEntity ").list();
        return booksToRead;
    }

    public BookToReadSectionEntity findBookToReadByBookId(int book_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from BookToReadSectionEntity where bookId = :book_id");
        query.setParameter("book_id", book_id);
        if (query.list().size() != 0) {
            return (BookToReadSectionEntity) query.list().get(0);
        }
        return null;
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE BookToReadSection AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}