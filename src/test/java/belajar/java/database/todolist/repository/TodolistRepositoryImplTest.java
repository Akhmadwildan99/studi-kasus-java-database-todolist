package belajar.java.database.todolist.repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TodolistRepositoryImplTest {
    private HikariDataSource dataSource;

    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp() {
        dataSource = DataBaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() throws SQLException {
        Todolist todolist = new Todolist();
        todolist.setTodo("Wildan");
        todolistRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(3));
    }

    @Test
    void testGetAll() {
        todolistRepository.add(new Todolist("wildan"));
        todolistRepository.add(new Todolist("akhmad"));
        todolistRepository.add(new Todolist("danu"));

        for (var todo : todolistRepository.getAll()){
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

}
