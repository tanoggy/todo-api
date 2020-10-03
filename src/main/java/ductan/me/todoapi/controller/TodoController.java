package ductan.me.todoapi.controller;


import ductan.me.todoapi.models.Todo;
import ductan.me.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return todoService.getById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable("id") Long id) {
        return todoService.deleteTodo(id);
    }
}
