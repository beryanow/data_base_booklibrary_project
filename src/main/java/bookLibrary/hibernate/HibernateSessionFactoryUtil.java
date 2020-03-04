package bookLibrary.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AddressEntity.class);
                configuration.addAnnotatedClass(AssessmentEntity.class);
                configuration.addAnnotatedClass(AuthorEntity.class);
                configuration.addAnnotatedClass(BookEntity.class);
                configuration.addAnnotatedClass(BookReadingSectionEntity.class);
                configuration.addAnnotatedClass(BookReadSectionEntity.class);
                configuration.addAnnotatedClass(BookToReadSectionEntity.class);
                configuration.addAnnotatedClass(CityEntity.class);
                configuration.addAnnotatedClass(CountryEntity.class);
                configuration.addAnnotatedClass(GenreEntity.class);
                configuration.addAnnotatedClass(QuoteEntity.class);
                configuration.addAnnotatedClass(FavouritesEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}