package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {

    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodolist(){
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Belajar java dasar");
        todolistRepository.data[1] = new Todolist("Belajar java oop");
        todolistRepository.data[2] = new Todolist("Belajar java standar classes");

        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.showTodolist();
    }

    public static void testAddTodoList(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodoList("Belajar java dasar");
        todolistService.addTodoList("Belajar java oop");
        todolistService.addTodoList("Belajar java standar classes");

        todolistService.showTodolist();
    }

    public static void testRemoveTodoList(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodoList("Belajar java dasar");
        todolistService.addTodoList("Belajar java oop");
        todolistService.addTodoList("Belajar java standar classes");

        todolistService.showTodolist();

        todolistService.removeTodoList(1);
        todolistService.removeTodoList(5);
        todolistService.removeTodoList(1);

        todolistService.showTodolist();

    }
}

