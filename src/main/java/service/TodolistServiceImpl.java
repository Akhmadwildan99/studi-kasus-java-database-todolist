package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService{

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository){
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {

        Todolist[] model = todolistRepository.getAll();

        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){
            var todolist = model[i];
            var no = i + 1;
            if(model[i] != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success){
            System.out.println("SUKSES MENGHAPUS TODO KE " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO KE " + number);
        }
    }
}
