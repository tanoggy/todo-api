package ductan.me.todoapi.repository;

import ductan.me.todoapi.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
