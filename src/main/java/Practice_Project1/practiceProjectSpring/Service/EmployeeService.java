package Practice_Project1.practiceProjectSpring.Service;


import Practice_Project1.practiceProjectSpring.DTO.EmployeeResponse;
import Practice_Project1.practiceProjectSpring.Entity.Department;
import Practice_Project1.practiceProjectSpring.Entity.Employee;
import Practice_Project1.practiceProjectSpring.Exception.DepartmentNotFoundException;
import Practice_Project1.practiceProjectSpring.Exception.EmployeeNotFoundException;
import Practice_Project1.practiceProjectSpring.Repository.DepartmentRepository;
import Practice_Project1.practiceProjectSpring.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<EmployeeResponse> getEmployeeByDepartment(int department_id){
        Department department =departmentRepository.findById(department_id)
                .orElseThrow(()->new DepartmentNotFoundException(
                        "department not found"
                ));

        return department.getEmployeeList().stream()
                .map(employee-> new EmployeeResponse(
                        employee.getEmployee_id(),
                        employee.getName(),
                        employee.getSalary(),
                        employee.getDepartment().getName()

                ))
                .toList();
    }

    public EmployeeResponse createEmployee(int departmentId, Employee employee){
        Department department =departmentRepository.findById(departmentId)
                .orElseThrow(()->new DepartmentNotFoundException("department not find "));


        employee.setDepartment(department);
        Employee savedEmployee= employeeRepository.save(employee);
        return new EmployeeResponse(
                savedEmployee.getEmployee_id(),
                savedEmployee.getName(),
                savedEmployee.getSalary(),
                savedEmployee.getDepartment().getName()
        );
    }

    public String deleteEmployee(int employeeId){


        Employee deleteEmployee =employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EmployeeNotFoundException("not found employee"));
        employeeRepository.deleteById(deleteEmployee.getEmployee_id());

        return "deleted";
    }
}
