package ie.cit.cloud.appdev.web;

import ie.cit.cloud.appdev.TodoService;
import ie.cit.cloud.appdev.model.Todo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping("api")
public class TodoJsonController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("todo")
    @ResponseBody
    /* try with curl http://localhost:8080/week_4_lab_res/api/todo */
    public List<Todo> index() {
	return todoService.getAllTodos();
    }

    @RequestMapping(value = "/todo/{index}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /* try with curl http://localhost:8080/week_4_lab_res/api/todo/3 */
    public @ResponseBody
    Todo getTodoAt(@PathVariable("index") int todoIndex) {
	return todoService.getTodo(todoIndex - 1);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /*
     * try: curl -i -H "Content-Type: application/json" -X POST -d
     * '{"text":"Remember the Milk"}'
     * http://localhost:8080/week_4_lab_res/api/todo
     */
    public void createTodo(@RequestBody Todo todo, HttpServletRequest request,
	    HttpServletResponse response) {
	todoService.addNewTodo(todo);
	response.addHeader("Location",
		getLocationForChildResource(request, todoService.indexOf(todo)+1));
    }

    @RequestMapping(value = "/todo/{index}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /*
     * try: curl -i -H "Content-Type: application/json" -X PUT -d
     * '{"text":"Remember the Beer"}'
     * http://localhost:8080/week_4_lab_res/api/todo/2
     */
    public void updateTodoAt(@RequestBody Todo todo,
	    @PathVariable("index") int todoIndex) {
	todoService.getAllTodos().set(todoIndex - 1, todo);
    }

    @RequestMapping(value = "/todo/{index}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /*
     * try: curl -X DELETE http://localhost:8080/week_4_lab_res/api/todo/2
     */
    public void deleteTodoAt(@PathVariable("index") int todoIndex) {
	todoService.getAllTodos().remove(todoIndex - 1);
    }

    private String getLocationForChildResource(HttpServletRequest request,
	    Object childIdentifier) {
	// get the current URL from the reguest
	final StringBuffer url = request.getRequestURL();
	// append the /xyz to the URL and make it a UriTemplate
	final UriTemplate template = new UriTemplate(url.append("/{childId}")
		.toString());
	return template.expand(childIdentifier).toASCIIString();
    }
}
