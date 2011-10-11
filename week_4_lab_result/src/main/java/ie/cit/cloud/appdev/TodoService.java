package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    /* simple in-memory data repository (!not persistent! and instance specific) */
    private List<Todo> repository;

    public TodoService() {
	repository = new ArrayList<Todo>();
    }

    public Date getTime() {
	return new Date();
    }

    public List<Todo> getAllTodos() {
	return repository;
    }

    public void addNewTodo(Todo todo) {
	repository.add(todo);
    }

    public Todo getTodo(int todoIndex) {
	return repository.get(todoIndex);
    }
}