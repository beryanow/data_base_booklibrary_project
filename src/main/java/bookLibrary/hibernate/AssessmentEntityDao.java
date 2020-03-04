package bookLibrary.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AssessmentEntityDao {
    public AssessmentEntity findAssessmentById(int assessmentId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AssessmentEntity.class, assessmentId);
    }

    public void saveAssessment(AssessmentEntity assessment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(assessment);
        transaction.commit();
        session.close();
    }

    public void updateAssessment(AssessmentEntity assessment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(assessment);
        transaction.commit();
        session.close();
    }

    public void deleteAssessment(AssessmentEntity assessment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(assessment);
        transaction.commit();
        session.close();
    }

    public List<AssessmentEntity> findAllAssessments() {
        List<AssessmentEntity> assessments = (List<AssessmentEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AssessmentEntity ").list();
        return assessments;
    }

    public int findAssessmentIdByGrade(byte grade) {
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from AssessmentEntity where grade = :grade");
        query.setParameter("grade", grade);
        return ((AssessmentEntity) query.list().get(0)).getId();
    }

    public void resetAutoIncrement() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("ALTER TABLE Assessment AUTO_INCREMENT=1").executeUpdate();
        transaction.commit();
        session.close();
    }
}