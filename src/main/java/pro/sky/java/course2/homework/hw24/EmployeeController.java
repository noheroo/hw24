package pro.sky.java.course2.homework.hw24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (@RequestParam String lastname, @RequestParam String firstname){
        return employeeService.addEmployee(lastname, firstname);
    }
    @GetMapping("/remove")
    public Employee deleteEmployee (@RequestParam String lastname, @RequestParam String firstname){
        return employeeService.removeEmployee(lastname, firstname);
    }
    @GetMapping("/find")
    public Employee findEmployee (@RequestParam String lastname, @RequestParam String firstname){
        return employeeService.findEmployee(lastname, firstname);
    }
}
