package ductan.me.todoapi.controller;


import ductan.me.todoapi.models.Todo;
import ductan.me.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/todo")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(TodoController.class);
 
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


    @GetMapping("/error/{id}")
    public String getError(@PathVariable("id") String id) {
       
        try {
            int a = Integer.parseInt(id);
            return String.valueOf(a); 
        } catch (Exception e) {
            logger.info(e.toString());
           
        }
        return "Success";
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
