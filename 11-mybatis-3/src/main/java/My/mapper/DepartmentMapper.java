package My.mapper;

import My.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * 这是一个操作数据库的mapper
 */

//为了日后方便 改成批量扫描 在Application.java里最前面@MapperScan(basePackages = "My.mapper")
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
