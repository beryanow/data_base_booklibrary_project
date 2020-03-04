package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuoteEntityDao {

    public QuoteEntity findQuoteById(int quoteId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(QuoteEntity.class, quoteId);
    }

    public void saveQuote(QuoteEntity quote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quote);
        transaction.commit();
        session.close();
    }

    public void updateQuote(QuoteEntity quote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(quote);
        transaction.commit();
        session.close();
    }

    public void deleteQuote(QuoteEntity quote) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(quote);
        transaction.commit();
        session.close();
    }

    public List<QuoteEntity> findAllQuotes() {
        List<QuoteEntity> quotes = (List<QuoteEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From QuoteEntity ").list();
        return quotes;
    }

    public QuoteEntity findQuoteByContent(String content) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from QuoteEntity where content = :content");
        query.setParameter("content", content);
        return (QuoteEntity) query.list().get(0);
    }

    public void deleteQuoteByContent(String content) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from QuoteEntity where content = :content");
        query.setParameter("content", content);

        QuoteEntity quoteEntity = (QuoteEntity) query.list().get(0);

        Transaction transaction = session.beginTransaction();
        session.delete(quoteEntity);
        transaction.commit();
        session.close();
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Quote AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}