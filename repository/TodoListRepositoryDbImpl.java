package repository;

import config.Database;
import entities.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryDbImpl implements TodoListRepository {

    private final Database database;

    public TodoListRepositoryDbImpl(Database database) {
        this.database = database;
    }
    @Override
    public TodoList[] getALL() {
        Connection connection = database.getConnection();
        String sqlstatement = "SELECT * FROM todos";
        List<TodoList> todoList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlstatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TodoList todolist = new TodoList();
                Integer id = resultSet.getInt(1);
                String todo = resultSet.getNString(2);
                todolist.setId(id);
                todolist.add(todolist);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return todoList.toArray(TodoList[]::new);
    }

    @Override
    public void add(TodoList todoList) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(TodoList todoList) {
        return null;
    }
}
