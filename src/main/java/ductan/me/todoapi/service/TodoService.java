package ductan.me.todoapi.service;


import ductan.me.todoapi.models.Todo;
import ductan.me.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("todo")
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        }
        return null;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo todoFind = getById(id);
        if (todoFind != null || id == todo.getId()) {
            return todoRepository.save(todo);
        }
        return null;
    }

    public Todo deleteTodo(Long id) {
        Todo todoFind = getById(id);
        if (todoFind != null) {
            todoRepository.delete(todoFind);
            return todoFind;
        }
        return null;
    }

}
