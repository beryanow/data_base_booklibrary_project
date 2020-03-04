package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FavouritesEntityDao {
    public FavouritesEntity findFavouriteByBookId(int book_id) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From FavouritesEntity where bookId = :book_id");
        query.setParameter("book_id", book_id);
        if (query.list().size() != 0) {
            return (FavouritesEntity) query.list().get(0);
        }
        return null;
    }

    public void saveFavourites(FavouritesEntity favourites) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(favourites);
        transaction.commit();
        session.close();
    }

    public void updateFavourites(FavouritesEntity favourites) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(favourites);
        transaction.commit();
        session.close();
    }

    public void deleteFavourites(FavouritesEntity favourites) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(favourites);
        transaction.commit();
        session.close();
    }

    public AddressEntity findAddressById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AddressEntity.class, id);
    }

    public List<FavouritesEntity> findAllFavourites() {
        List<FavouritesEntity> favourites = (List<FavouritesEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From FavouritesEntity ").list();
        return favourites;
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Favourites AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}