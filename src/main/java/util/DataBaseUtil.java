package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseUtil {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_todolist");
        configuration.setUsername("root");
        configuration.setPassword("wildan123");

        // Pool
        configuration.setMaximumPoolSize(10);
        configuration.setMinimumIdle(5);
        configuration.setIdleTimeout(60_000);
        configuration.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(configuration);
    }

    public static HikariDataSource getDataSource(){
        return hikariDataSource;
    }
}
