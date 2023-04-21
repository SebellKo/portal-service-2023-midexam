package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        long id = (Long) object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userInfo where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
