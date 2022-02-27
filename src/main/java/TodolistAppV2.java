import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import util.DataBaseUtil;
import view.TodolistView;

import javax.sql.DataSource;

public class TodolistAppV2 {
    public static void main(String[] args) {
        DataSource dataSource = DataBaseUtil.getDataSource();
        TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();
    }
}
