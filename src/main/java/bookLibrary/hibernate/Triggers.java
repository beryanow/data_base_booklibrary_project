package bookLibrary.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

class NewBookAddedInterceptor extends EmptyInterceptor {
    private String genreName;
    private String authorName;
    private String cityName;
    private String countryName;

    NewBookAddedInterceptor(String genreName, String authorName, String cityName, String countryName) {
        this.genreName = genreName;
        this.authorName = authorName;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        return false;

    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        System.out.println("onFlushDirty");
        return false;
    }

    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("onDelete");
    }

    //called before commit into database
    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }

    //called after committed into database
    public void postFlush(Iterator iterator) {
        GenreEntity genreEntity = new GenreEntityDao().findGenreByName(genreName);
        if (genreEntity == null) {
            GenreEntity newGenreEntity = new GenreEntity();
            newGenreEntity.setName(genreName);
            new GenreEntityDao().saveGenre(newGenreEntity);
        }

        CountryEntity countryEntity = new CountryEntityDao().findCountryByName(countryName);
        if (countryEntity == null) {
            CountryEntity newCountryEntity = new CountryEntity();
            newCountryEntity.setName(countryName);
            new CountryEntityDao().saveCountry(newCountryEntity);
        }

        CityEntity cityEntity = new CityEntityDao().findCityByName(cityName);
        if (cityEntity == null) {
            CityEntity newCityEntity = new CityEntity();
            newCityEntity.setName(cityName);
            new CityEntityDao().saveCity(newCityEntity);
        }

        int countryId = new CountryEntityDao().findCountryIdByName(countryName);
        int cityId = new CityEntityDao().findCityIdByName(cityName);

        AddressEntity addressEntity = new AddressEntityDao().findAddressByIds(countryId, cityId);
        if (addressEntity == null) {
            AddressEntity newAddressEntity = new AddressEntity();
            newAddressEntity.setCityId(cityId);
            newAddressEntity.setCountryId(countryId);
            new AddressEntityDao().saveAddress(newAddressEntity);
        }

        AuthorEntity authorEntity = new AuthorEntityDao().findAuthorByName(authorName);
        if (authorEntity == null) {
            AuthorEntity newAuthorEntity = new AuthorEntity();
            newAuthorEntity.setName(authorName);
            int addressId = new AddressEntityDao().findAddressIdByIds(countryId, cityId);
            newAuthorEntity.setAddressId(addressId);
            new AuthorEntityDao().saveAuthor(newAuthorEntity);
        }
    }
}

public class Triggers {
    String bookName;
    String genreName;
    String authorName;
    String cityName;
    String countryName;

    public void saveBookTriggered(BookEntity book) {
        NewBookAddedInterceptor newBookAddedInterceptor = new NewBookAddedInterceptor(genreName, authorName, cityName, countryName);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().withOptions().interceptor(newBookAddedInterceptor).openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public Triggers(String bookName, String genreName, String authorName, String cityName, String countryName) {
        this.bookName = bookName;
        this.genreName = genreName;
        this.authorName = authorName;
        this.cityName = cityName;
        this.countryName = countryName;

        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthorId(null);
        bookEntity.setGenreByGenreId(null);
        bookEntity.setName(bookName);
        saveBookTriggered(bookEntity);

        int genreId = new GenreEntityDao().findGenreIdByName(genreName);
        int authorId = new AuthorEntityDao().findAuthorIdByName(authorName);

        BookEntity newBookEntity = new BookEntityDao().findBookByName(bookName);
        newBookEntity.setGenreId(genreId);
        newBookEntity.setAuthorId(authorId);
        new BookEntityDao().updateBook(newBookEntity);
    }


}
