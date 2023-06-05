package jm.task.core.jdbc.dao;

import com.sun.jdi.connect.spi.Connection;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;


public class UserDaoJDBCImpl implements UserDao {
    Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }


   public void createUsersTable() {
//        try(Statement statement = Util.getConnection().createStatement()) {
//            statement.executeUpdate("create table User(id int primary key auto_icrement, name varchar, lastName varchar, age int)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//       }
   }

   public void dropUsersTable() {
//        try(Statement statement = connection.createStatement()) {
//            statement.executeUpdate("drop table User");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM User WHERE id = ?")) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

   public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        try(Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT ID, NAME, LASTNAME, AGE FROM User");
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("ID"));
//                user.setName(resultSet.getString("NAME"));
//                user.setLastName(resultSet.getString("LASTNAME"));
//                user.setAge(resultSet.getByte("AGE"));
//
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
       return null;
   }
//
   public void cleanUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("TRUNCATE TABLE User");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
