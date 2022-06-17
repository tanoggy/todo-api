package ductan.me.todoapi.service;


import ductan.me.todoapi.models.Todo;
import ductan.me.todoapi.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("todo")
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    Logger logger = LoggerFactory.getLogger(TodoService.class);
 

    public List<Todo> getAll() {
        logger.info("getAll");
        return todoRepository.findAll();
    }

    public Todo getById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
          logger.info("getById");
        if (todo.isPresent()) {
            return todo.get();
        }
        logger.error("Not Found");
        return null;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
          logger.info("updateTodo");
        Todo todoFind = getById(id);
        if (todoFind != null || id == todo.getId()) {
            return todoRepository.save(todo);
        }
        return null;
    }

    public Todo deleteTodo(Long id) {
          logger.info("deleteTodo");
        Todo todoFind = getById(id);
        if (todoFind != null) {
            todoRepository.delete(todoFind);
            return todoFind;
        }
        return null;
    }

}
