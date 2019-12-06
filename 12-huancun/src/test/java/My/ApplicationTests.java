package My;

import My.bean.Employee;
import My.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Email;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串的 <String,String>

    @Autowired
    RedisTemplate redisTemplate;//操作 k-v 都是对象的 <Object,Object>

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;//自定义的redisTemplate 用来将默认序列化转化成json


    @Test
    public void contextLoads() {

        Employee emp = employeeMapper.getEmpById(2);
        System.out.println(emp);
    }

    /**
     * redis类型：
     *     String，List，Set，Hash，ZSet（有序集）
     *
     *     用 stringRedisTemplate.opsForXXX()方法
     */
    @Test
    public void testRedis() {
        //向redis中存入string k-v
//        stringRedisTemplate.opsForValue().append("message","good morning horlly");

        //按key值取出value
        String message = stringRedisTemplate.opsForValue().get("message");
        System.out.println(message);

        //操作list 放入 取出用pop
        stringRedisTemplate.opsForList().leftPush("mylist","one");
        stringRedisTemplate.opsForList().leftPush("mylist","two");
        stringRedisTemplate.opsForList().leftPush("mylist","three");

        //保存对象 默认情况下使用jdk序列化机制 序列化后的数据保存到redis中 差不多下面这样
        /**
         * key：\xAC\xED\x00\x05t\x00\x04emp1
         *value：\xAC\xED\x00\x05sr\x00\x10My.bean.Employee\x18\xE6&\xC8\xF5\xE7\xDFR\x02\x00\x05L\x00\x03dIdt\x00\x13Ljava/lang/Integer;L\x00\x05emailt\x00\x12Ljava/lang/String;L\x00\x06genderq\x00~\x00\x01L\x00\x02idq\x00~\x00\x01L\x00\x08lastNameq\x00~\x00\x02xpsr\x00\x11java.lang.Integer\x12\xE2\xA0\xA4\xF7\x81\x878\x02\x00\x01I\x00\x05valuexr\x00\x10java.lang.Number\x86\xAC\x95\x1D\x0B\x94\xE0\x8B\x02\x00\x00xp\x00\x00\x03\xEAt\x00\x02xxsq\x00~\x00\x04\x00\x00\x00\x01sq\x00~\x00\x04\x00\x00\x00\x02t\x00\x0D\xC3\xA6\xC5\xBE\xE2\x80\x94\xC3\xA8\xC2\xBE\xC2\xB0
         *
         * 所以我们最好将数据转化成json保存 我们在config/redisConfig 中来写一个转化配置
         */
        Employee emp = employeeMapper.getEmpById(2);
//        redisTemplate.opsForValue().set("emp1",emp);
        empRedisTemplate.opsForValue().set("emp2",emp);


    }
}
