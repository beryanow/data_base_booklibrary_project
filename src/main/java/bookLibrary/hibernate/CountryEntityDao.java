package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CountryEntityDao {

    public CountryEntity findCountryById(int countryId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CountryEntity.class, countryId);
    }

    public void saveCountry(CountryEntity country) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
        session.close();
    }

    public void updateCountry(CountryEntity country) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(country);
        transaction.commit();
        session.close();
    }

    public void deleteCountry(CountryEntity country) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(country);
        transaction.commit();
        session.close();
    }

    public AddressEntity findAddressById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AddressEntity.class, id);
    }

    public CountryEntity findCountryByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CountryEntity where name = :name");
        query.setParameter("name", name);

        CountryEntity countryEntity = null;
        if (query.list().size() != 0) {
            countryEntity = ((CountryEntity) query.list().get(0));
        }
        session.close();

        return countryEntity;
    }

    public int findCountryIdByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CountryEntity where name = :name");
        query.setParameter("name", name);
        int countryEntityId = ((CountryEntity) query.list().get(0)).getId();
        session.close();

        return countryEntityId;
    }

    public List<CountryEntity> findAllCountries() {
        List<CountryEntity> countries = (List<CountryEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From CountryEntity ").list();
        return countries;
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Country AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}