package My.controller;

import My.bean.Employee;
import My.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emp/find/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    @RequestMapping("/emp/update")
    public Employee pudateEmp(Employee employee){
        System.out.println("更新的员工信息："+employee);
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }

    @RequestMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        System.out.println("删除的员工缓存："+id);
        employeeService.deleteEmp(id);
        return "success";
    }
}
