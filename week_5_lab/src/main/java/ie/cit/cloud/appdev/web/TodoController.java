package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import ie.cit.cloud.appdev.TodoService;
import ie.cit.cloud.appdev.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Main Todo Application Controller
 * 
 * @author igor.mihalik
 */
@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = { "index", "" }, method = GET)
    public String index(Model model) {
	model.addAttribute("todos", todoService.getAllTodos());
	return "index";
    }

    @RequestMapping(value = { "index", "" }, method = POST)
    public String createNew(@RequestParam String text, Model model) {
	todoService.addNewTodo(new Todo(text));
	return "redirect:index.html";
    }

    @RequestMapping(value = "done", method = GET)
    public String done(@RequestParam int todoIndex, Model model) {
	todoService.getTodo(todoIndex - 1).setDone(true);
	return "redirect:index.html";
    }

    @RequestMapping(value = "open", method = GET)
    public String open(@RequestParam int todoIndex, Model model) {
	todoService.getTodo(todoIndex - 1).setDone(false);
	return "redirect:index.html";
    }
}