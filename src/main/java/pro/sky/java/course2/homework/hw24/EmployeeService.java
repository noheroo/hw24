package pro.sky.java.course2.homework.hw24;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework.hw24.exeptions.BadRequestException;
import pro.sky.java.course2.homework.hw24.exeptions.InternalServerErrorException;
import pro.sky.java.course2.homework.hw24.exeptions.NotFoundException;

@Service
public class EmployeeService {

    private final Employee[] employees = new Employee[2];

    public Employee addEmployee(String lastName, String firstName) {
        if (isFull()) {
            throw new InternalServerErrorException();
        }
        if (isSame(lastName, firstName)) {
            throw new BadRequestException();
        }
        int num = -1;
        Employee employee = new Employee(lastName, firstName);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                num = i;
                break;
            }
        }
        return employees[num];
    }

    public Employee removeEmployee(String lastName, String firstName) {
        int num = isFound(lastName, firstName);
        if (num == -1) {
            throw new NotFoundException();
        }
        Employee employeeDel = new Employee(employees[num].getLastName(), employees[num].getFirstName());
        employees[num] = null;
        return employeeDel;
    }

    public Employee findEmployee(String lastName, String firstName) {
        int num = isFound(lastName, firstName);
        if (num == -1) {
            throw new NotFoundException();
        }
        return employees[num];
    }

    private boolean isFull() {
        for (Employee employee : employees) {
            if (employee == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isSame(String lastName, String firstName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equalsIgnoreCase(lastName) &&
                    employees[i].getFirstName().equalsIgnoreCase(firstName)){
                return true;
            }
        }
        return false;
    }

    private int isFound (String lastName, String firstName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equalsIgnoreCase(lastName) &&
                    employees[i].getFirstName().equalsIgnoreCase(firstName)) {
                return i;
            }
        }
        return -1;
    }
}


