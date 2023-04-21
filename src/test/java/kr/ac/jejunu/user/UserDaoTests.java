package kr.ac.jejunu.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "sejong";
    String password = "1234";
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();

        userDao.insert(user);

        User insertedUser = userDao.findById(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

//    @Test
//    public void getHalla() throws SQLException, ClassNotFoundException {
//        Long id = 1l;
//        ConnectionMaker connectionMaker = new HallaConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        User user = userDao.findById(id);
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
//
//    @Test
//    public void insertHalla() throws SQLException, ClassNotFoundException {
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//
//        ConnectionMaker connectionMaker = new HallaConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//
//        userDao.insert(user);
//
//        User insertedUser = userDao.findById(user.getId());
//        assertThat(insertedUser.getName(), is(name));
//        assertThat(insertedUser.getPassword(), is(password));
//    }
}
