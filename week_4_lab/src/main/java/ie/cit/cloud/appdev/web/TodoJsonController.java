package ie.cit.cloud.appdev.web;

import ie.cit.cloud.appdev.TodoService;
import ie.cit.cloud.appdev.model.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * TODO add proper annotations 
 * 1. make this class "Controller"
 * 2. define proper RequestMapping with "api" prefix 
 */
public class TodoJsonController {
    @Autowired
    private TodoService todoService;
    
    /*
     * TODO add methods to handle various REST requests
     * 1. GET /api/todo   -> to list all todo Items (as JSON)
     * 2. GET /api/todo/{index}  -> to show only Todo item at index
     * 3. POST /api/todo   -> to create new todo
     * 4. PUT /api/todo/{index} -> to modify todo (done/open states)
     * 5. ..
     */
    @RequestMapping(value="todo", method=RequestMethod.GET)
    @ResponseBody
    public List<Todo> index() {
	return todoService.getAllTodos();
    }
    
}
