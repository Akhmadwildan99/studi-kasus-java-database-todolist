package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {
        removeTodolistTest();
    }

    public static void showTodolistTest(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.addTodoList("Belajar java dasar.");
        todolistService.addTodoList("Belajar java OOP.");
        todolistService.addTodoList("Belajar java standard classes.");

        todolistView.showTodolist();
    }

    public static void addTodolistTest(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.addTodolist();

        todolistService.showTodolist();

        todolistView.addTodolist();

        todolistService.showTodolist();
    }

    public static void removeTodolistTest(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.addTodoList("Belajar java dasar.");
        todolistService.addTodoList("Belajar java OOP.");
        todolistService.addTodoList("Belajar java standard classes.");
        todolistService.showTodolist();

        todolistView.removeTodolist();

        todolistService.showTodolist();
    }
}
