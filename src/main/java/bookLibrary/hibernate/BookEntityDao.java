package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookEntityDao {

    public void saveBook(BookEntity book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void updateBook(BookEntity book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }

    public void deleteBook(BookEntity book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
    }

    public List<BookEntity> findAllBooks() {
        List<BookEntity> books = (List<BookEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookEntity ").list();
        return books;
    }

    public List<BookEntity> findBooksByAuthorId(int author_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookEntity where authorId = :author_id");
        query.setParameter("author_id", author_id);
        return query.list();
    }

    public BookEntity findBooksByNullAuthorId() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From BookEntity where authorId = null");
        BookEntity bookEntity = (BookEntity) query.list().get(0);
        session.close();
        return bookEntity;
    }

    public BookEntity findBookByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From BookEntity where name = :name");
        query.setParameter("name", name);
        BookEntity bookEntity = (BookEntity) query.list().get(0);
        session.close();
        return bookEntity;
    }

    public List<BookEntity> findBooksByGenreId(int genre_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From BookEntity where genreId = :genre_id");
        query.setParameter("genre_id", genre_id);
        return query.list();
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public BookToReadSectionEntity findBookToReadById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookToReadSectionEntity.class, id);
    }

    public BookReadingSectionEntity findBookReadingById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookReadingSectionEntity.class, id);
    }

    public BookReadSectionEntity findBookReadById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookReadSectionEntity.class, id);
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Book AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}