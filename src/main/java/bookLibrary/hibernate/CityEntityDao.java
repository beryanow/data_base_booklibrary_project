package bookLibrary.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class CityEntityDao {

    public CityEntity findCityById(int cityId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CityEntity.class, cityId);
    }

    public void saveCity(CityEntity city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public void updateCity(CityEntity city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
        session.close();
    }

    public void deleteCity(CityEntity city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
        session.close();
    }

    public AddressEntity findAddressById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AddressEntity.class, id);
    }

    public List<CityEntity> findAllCities() {
        List<CityEntity> cities = (List<CityEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From CityEntity ").list();
        return cities;
    }

    public int findCityIdByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CityEntity where name = :name");
        query.setParameter("name", name);
        int cityEntityId = ((CityEntity) query.list().get(0)).getId();
        session.close();

        return cityEntityId;
    }

    public CityEntity findCityByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CityEntity where name = :name");
        query.setParameter("name", name);

        CityEntity cityEntity = null;
        if (query.list().size() != 0) {
            cityEntity = ((CityEntity) query.list().get(0));
        }
        session.close();

        return cityEntity;
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE City AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}