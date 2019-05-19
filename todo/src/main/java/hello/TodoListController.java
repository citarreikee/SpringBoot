package hello;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TodoListController {
	private TodoList todolist = new TodoList();
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ArrayList<Todo> getAllTodoTask() {
		return todolist.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Todo getTodoTaskById(@PathVariable("id") String id) {	
		return todolist.getById(Long.valueOf(id));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ArrayList<Todo> addTodoTask() {
		return todolist.create("new task");
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ArrayList<Todo> deleteTodoTaskById(@PathVariable("id") String id) {	
		return todolist.deleteById(Long.valueOf(id));
	}
}
