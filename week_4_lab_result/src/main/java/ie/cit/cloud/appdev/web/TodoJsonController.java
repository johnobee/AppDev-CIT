package ie.cit.cloud.appdev.web;

import ie.cit.cloud.appdev.TodoService;
import ie.cit.cloud.appdev.model.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class TodoJsonController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("todo")
    @ResponseBody
    public List<Todo> index() {
	return todoService.getAllTodos();
    }
}
