package My.service;

import My.bean.Employee;
import My.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     *     @Cacheable：  将方法的运行结果进行缓存 结果
     *                   此方法每次调用之前 先check一下缓存看看有没有数据
     *
     *       @Cacheable(cacheNames = "emp",key="#id")这个key写不写都行 因为默认就是用参数作为key
     *       cacheManager/key： 二选一
     *       condition: 进行缓存的条件
     *       unless： 此种情况不缓存
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "emp",key="#id",condition = "#id>2",unless = "#id=1")
    @Cacheable(cacheNames = "emp",key="#id",condition = "#id>2")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工成功");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePur :更新缓存中的数据：改完数据库中数据后把缓存中数据也变成最新数据
     *
     *            有此注释的方法直接调用方法 完事再把数据更新到缓存
     * @param employee
     * @return
     */
//    @CachePut(value = "emp",key = "#employee.id") 这种和下面这种都可以 但是@Cacheable不可以用result
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 清除缓存 当然你要是想的话顺便也可以调用mapper中的方法把数据库中数据一起删除 但是这个和这个注释关联不大
     *
     @CacheEvict(value = "emp",key = "#id") 中的key不写的话默认就是参数 我这里写不写依旧一样 但我还是写一下表格式
     *@CacheEvict(value = "emp",allEntries = true) 删除所有缓存
     *
      * 1.key 删除指定参数
      * 2.allEntries 删除所有缓存
      * @param id
     */
    @CacheEvict(value = "emp",key = "#id")
//    @CacheEvict(value = "emp",allEntries = true)
    public void deleteEmp(Integer id){
        System.out.println("缓存中删除的员工id:"+id);
//        employeeMapper.deleteEmp(id); 我并不想直接删除数据库中员工数据所以我注释掉 我只是想操作一下缓存
    }
}
