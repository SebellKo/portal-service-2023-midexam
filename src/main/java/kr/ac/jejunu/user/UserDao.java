package kr.ac.jejunu.user;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Long id) throws SQLException {
        Object [] params = new Object[] {id};
        String sql = "select id, name, password from userinfo where id = ?";
        return jdbcContext.findById(params, sql);
    }


    public void insert(User user) throws SQLException {
        Object [] params = new Object[] {user.getName(), user.getPassword()};
        String sql = "insert into userInfo (name, password) values(?, ?)";
        jdbcContext.insert(user, params, sql);
    }

    public void update(User user) throws SQLException {
        Object [] params = new Object[] {user.getName(), user.getPassword(), user.getId()};
        String sql = "update userInfo set name = ?, password = ? where id = ?";
        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws SQLException {
        Object [] params = new Object[] {id};
        String sql = "delete from userInfo where id = ?";
        jdbcContext.update(sql, params);
    }

}
