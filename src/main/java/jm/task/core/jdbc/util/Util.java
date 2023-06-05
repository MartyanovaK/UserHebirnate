package jm.task.core.jdbc.util;

import java.sql.Statement;
import com.sun.jdi.connect.spi.Connection;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "89118324695";
    private static Util instance = null;
    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("ok");
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}
