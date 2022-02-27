package view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist(){
        while (true){
            todolistService.showTodolist();

            System.out.println("MENU: ");
            System.out.println("1. tambah");
            System.out.println("2. hapus");
            System.out.println("x. keluar");

            var input = InputUtil.input("pilih: ");
            if(input.equals("1")){
                addTodolist();
            } else if(input.equals("2")){
                removeTodolist();
            }else if(input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti.");
            }
        }
    }

    public void addTodolist(){
        System.out.println("MENAMBAH TODO LIST");

        var todo = InputUtil.input("input todo (x jika batal): ");

        if(todo.equals("x")){
            //batal
        } else{
            todolistService.addTodoList(todo);
        }
    }

    public void removeTodolist(){
        System.out.println("Mengahpaus Todo List:");

        var index = InputUtil.input("index (x jika batal): ");

        if(index.equals("x")){
            //batal
        } else {
            todolistService.removeTodoList(Integer.valueOf(index));
        }
    }
}
