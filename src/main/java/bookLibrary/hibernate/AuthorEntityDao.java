package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorEntityDao {
    public AuthorEntity findAuthorById(int authorId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AuthorEntity.class, authorId);
    }

    public void saveAuthor(AuthorEntity author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    public void updateAuthor(AuthorEntity author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }

    public void deleteAuthor(AuthorEntity author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public List<AuthorEntity> findAllAuthors() {
        List<AuthorEntity> authors = (List<AuthorEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AuthorEntity ").list();
        return authors;
    }

    public AuthorEntity findAuthorByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from AuthorEntity where name = :name");
        query.setParameter("name", name);

        AuthorEntity authorEntity = null;
        if (query.list().size() != 0) {
            authorEntity = ((AuthorEntity) query.list().get(0));
        }
        session.close();

        return authorEntity;
    }

    public int findAuthorIdByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from AuthorEntity where name = :name");
        query.setParameter("name", name);
        int authorId = ((AuthorEntity) query.list().get(0)).getId();
        session.close();

        return authorId;
    }

    public AuthorEntity findAuthorByNullAddressId() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From AuthorEntity where addressId = null");
        AuthorEntity authorEntity = (AuthorEntity) query.list().get(0);
        session.close();
        return authorEntity;
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Author AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}