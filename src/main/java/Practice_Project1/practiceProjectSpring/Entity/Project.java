package Practice_Project1.practiceProjectSpring.Entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;
    private String name;

    @ManyToMany(mappedBy = "projectSet")
    private Set<Employee> employeeSet =new HashSet<>();
}
