package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userDao = new UserServiceImpl();
        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 20);
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        userDao.saveUser("Name4", "LastName4", (byte) 38);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
////        userDao.dropUsersTable();
//         String testName = "Ivan";
//         String testLastName = "Ivanov";
//         byte testAge = 5;
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            userService.removeUserById(1L);
//        } catch (Exception e) {
//            System.out.println("При тестировании удаления пользователя по id произошло исключение\n" + e);
//        }
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//
//            User user = userService.getAllUsers().get(0);
//
//            if (!testName.equals(user.getName())
//                    || !testLastName.equals(user.getLastName())
//                    || testAge != user.getAge()
//            ) {
//                System.out.println("User был некорректно добавлен в базу данных");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Во время тестирования сохранения пользователя произошло исключение\n" + e);
//        }


    }

    }

