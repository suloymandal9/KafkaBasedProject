package Practice_Project1.practiceProjectSpring.Controller;


import Practice_Project1.practiceProjectSpring.Entity.Employee;
import Practice_Project1.practiceProjectSpring.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<?>> getEmployeesByDepartment(@PathVariable int departmentId){
        return ResponseEntity.ok(employeeService.getEmployeeByDepartment(departmentId));
    }

    @PostMapping("/department/{departmentId}")
    public ResponseEntity<?> createEmployee(@PathVariable int departmentId,
                                            @RequestBody Employee employee){

        return ResponseEntity.ok(employeeService.createEmployee(departmentId,employee));
    }



}
