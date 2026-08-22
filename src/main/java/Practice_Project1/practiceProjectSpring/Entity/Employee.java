package Practice_Project1.practiceProjectSpring.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String name;
    private int salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "employee_id") ,
    inverseJoinColumns =@JoinColumn(name = "project_id")
    )
    private Set<Project> projectSet=new HashSet<>();


}
