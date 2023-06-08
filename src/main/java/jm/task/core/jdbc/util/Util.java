package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.sql.Connection;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "89118324695";
    private static Util instance = null;

    public Util() throws IOException {
    }

    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    try {
                        instance = new Util();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            connection =  DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch (ClassNotFoundException | SQLException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void closed() {
        getSessionFactory().close();
    }


}
