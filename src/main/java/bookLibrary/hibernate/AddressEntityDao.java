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

public class AddressEntityDao {
    public AddressEntity findAddressById(int addressId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AddressEntity.class, addressId);
    }

    public void saveAddress(AddressEntity address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        session.close();
    }

    public void updateAddress(AddressEntity address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(address);
        transaction.commit();
        session.close();
    }

    public void findAndUpdateAddress(AddressEntity address) {
        AddressEntity addressEntity = findAddressByNullCountryId();
    }

    public void deleteAddress(AddressEntity address) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(address);
        transaction.commit();
        session.close();
    }

    public AuthorEntity findAuthorById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AuthorEntity.class, id);
    }

    public List<AddressEntity> findAllAddresses() {
        List<AddressEntity> addresses = (List<AddressEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AddressEntity ").list();
        return addresses;
    }

    public AddressEntity findAddressByIds(int countryId, int cityId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from AddressEntity where countryId = :countryId and cityId = :cityId");
        query.setParameter("countryId", countryId);
        query.setParameter("cityId", cityId);

        AddressEntity addressEntity = null;
        if (query.list().size() != 0) {
            addressEntity = ((AddressEntity) query.list().get(0));
        }
        session.close();

        return addressEntity;
    }

    public int findAddressIdByIds(int countryId, int cityId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from AddressEntity where countryId = :countryId and cityId = :cityId");
        query.setParameter("countryId", countryId);
        query.setParameter("cityId", cityId);

        int addressEntityId = ((AddressEntity) query.list().get(0)).getId();
        session.close();

        return addressEntityId;
    }

    public AddressEntity findAddressByNullCountryId() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From AddressEntity where countryId = null");
        AddressEntity addressEntity = (AddressEntity) query.list().get(0);
        session.close();
        return addressEntity;
    }

    public AddressEntity findAddressByNullCityId() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From AddressEntity where cityId = null");
        AddressEntity addressEntity = (AddressEntity) query.list().get(0);
        session.close();
        return addressEntity;
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Address AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}