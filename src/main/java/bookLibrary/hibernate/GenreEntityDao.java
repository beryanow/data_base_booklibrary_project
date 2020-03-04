package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenreEntityDao {

    public GenreEntity findGenreById(int genreId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(GenreEntity.class, genreId);
    }

    public void saveGenre(GenreEntity genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(genre);
        transaction.commit();
        session.close();
    }

    public void updateGenre(GenreEntity genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(genre);
        transaction.commit();
        session.close();
    }

    public void deleteGenre(GenreEntity genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(genre);
        transaction.commit();
        session.close();
    }

    public BookEntity findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(BookEntity.class, id);
    }

    public List<GenreEntity> findAllGenres() {
        List<GenreEntity> genres = (List<GenreEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From GenreEntity ").list();
        return genres;
    }

    public GenreEntity findGenreByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from GenreEntity where name = :name");
        query.setParameter("name", name);

        GenreEntity genreEntity = null;
        if (query.list().size() != 0) {
            genreEntity = ((GenreEntity) query.list().get(0));
        }
        session.close();

        return genreEntity;
    }

    public int findGenreIdByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from GenreEntity where name = :name");
        query.setParameter("name", name);
        int genreId = ((GenreEntity) query.list().get(0)).getId();
        session.close();
        return genreId;
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Genre AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}