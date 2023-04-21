package kr.ac.jejunu.user;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from userinfo where id = ?");
            preparedStatement.setLong(1, id);

            return preparedStatement;
        };
        return jdbcContext.jdbcContextForFindById(statementStrategy);
    }


    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userInfo (name, password) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            return preparedStatement;
        };
        jdbcContext.jdbcContextForInsert(user, statementStrategy);
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update userInfo set name = ?, password = ? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getId());

            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("delete from userInfo where id = ?");
            preparedStatement.setLong(1, id);

            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }
}
