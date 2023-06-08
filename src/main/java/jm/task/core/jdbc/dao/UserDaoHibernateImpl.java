package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    User user = new User();
    Session session = getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        Util.closed();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        Util.closed();
    }




    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            transaction.commit();
            Util.closed();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        try {
            user.setId(id);
            session.remove(user);
            transaction.commit();
            Util.closed();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return session.createQuery("from User ", User.class).list();
    }

    @Override
    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE User";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        Util.closed();
    }
}
