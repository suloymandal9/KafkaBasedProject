package Practice_Project1.practiceProjectSpring.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

;import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "departments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList =new ArrayList<>();

}
