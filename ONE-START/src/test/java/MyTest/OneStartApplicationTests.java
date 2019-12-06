package MyTest;

import My.OneStartApplication;
import My.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 我的测试类不能自动检测到@SpringBootApplication 也就是启动项目 我得加@SpringBootTest(classes = OneStartApplication.class)里的classes参数指定才行
 * 可能原因：
 * 找到了 因为我改过刚开始时设定的文件结构 和初始结构相比 目录结构我换过
 */
@RunWith(SpringRunner.class)
//@SpringBootTest 单用这个报错：
//java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
@SpringBootTest(classes = OneStartApplication.class)
public class OneStartApplicationTests {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
