package My.controller;

import My.bean.Employee;
import My.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeMapper.getEmpById(id);
        System.out.println(emp);
        return emp;
    }

    @RequestMapping("/emp")
    public void insertEmp(Employee employee){
        employee.setLastName("林辰");
        employeeMapper.insertEmp(employee);
        System.out.println(employee);
    }
}
