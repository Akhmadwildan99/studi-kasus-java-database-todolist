package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository{

    private DataSource dataSource;

    public TodolistRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todolist[] getAll() {
        String sql = "SELECT * FROM todolist";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            List<Todolist> todolists = new ArrayList<>();
            while (resultSet.next()){
                Todolist todolist = new Todolist();
                int id = resultSet.getInt("id");
                String todo = resultSet.getString("todo");
                todolist.setId(id);
                todolist.setTodo(todo);
                todolists.add(todolist);
            }
            return todolists.toArray(new Todolist[]{});
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES(?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    private boolean isExist(Integer number){
        String sql = "SELECT * FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, number);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (isExist(number)){
            String sql = "DELETE FROM todolist WHERE id = ?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, number);
                statement.executeUpdate();
                return true;
            } catch (SQLException exception){
                throw new RuntimeException(exception);
            }
        } else {
            return false;
        }
    }

    /**
     * try with resource / block try dengan tanda kurung, Digunakan
     * untuk type data yang harus di close di akhir kode,
     * contoh Connection, DataSource / HikariDatasource,
     * Statement, PreparedStatement, ResultSet
     */
}
