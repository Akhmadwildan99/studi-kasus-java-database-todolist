package belajar.java.database.todolist.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    @Test
    void testDataSourceConnection() throws SQLException {
        HikariDataSource hikariDataSource = DataBaseUtil.getDataSource();
        Connection connection = hikariDataSource.getConnection();

        connection.close();
        hikariDataSource.close();
    }
}
