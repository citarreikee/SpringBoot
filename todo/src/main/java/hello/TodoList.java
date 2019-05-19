package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class TodoList {
	private ArrayList<Todo> todolist = new ArrayList<Todo>();
	private final AtomicLong counter = new AtomicLong();
	private final Date date = new Date();
	public TodoList() {
		todolist.add(new Todo(counter.incrementAndGet(),
				"Restful API homework","2019-05-15T00:00:00Z"));
		todolist.add(new Todo(counter.incrementAndGet(),
				"Restful API homework1", date.toLocaleString()));
		todolist.add(new Todo(counter.incrementAndGet(),
				"Restful API homework2",date.toLocaleString()));
		todolist.add(new Todo(counter.incrementAndGet(),
				"Restful API homework3",date.toLocaleString()));
		todolist.add(new Todo(counter.incrementAndGet(),
				"Restful API homework4",date.toLocaleString()));
	}
	static public void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toLocaleString());
		long a =5;
		System.out.println("asda"+a);
	}
	public ArrayList<Todo> getAll(){
		return todolist;
	}
	public Todo getById(long id) {
		for(int index = 0; index < todolist.size(); index++) {
			if(todolist.get(index).getId() == id)
				return todolist.get(index);
		}
		return null;
	}
	public ArrayList<Todo> create(String content) {
		long id = counter.incrementAndGet();
		todolist.add(new Todo(id, "New task" + id, date.toLocaleString()));
		return todolist;
	}
	public ArrayList<Todo> deleteById(long id) {
		for(int index = 0; index < todolist.size(); index++) {
			if(todolist.get(index).getId() == id) {
				todolist.remove(index);
				break;
			}	
		}
		return todolist;
	}
}
