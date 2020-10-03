package ductan.me.todoapi.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Hibernate entity
@Data // Lombok
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private boolean done;

}
