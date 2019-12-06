package My;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
//        message需要自己构造一个； 定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message);

        Map<String,Object> map=new HashMap<>();
        map.put("firstMessage","这是第一条消息");//string
        map.put("secondMessage", Arrays.asList("helloworld",123,true));//list
       // 常用 发消息 不仅仅是普通类型 list map 还可以传jopo，自己定义的类 new一个构造器 并赋值就行
        rabbitTemplate.convertAndSend("exchange.direct","horlly",map );
        /**
         * 这样发送被序列化了 所以我们来搞个转换器 见config文件夹
         * rO0ABXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAx3CAAAABAAAAACdAAMZmlyc3RN
         * ZXNzYWdldAAV6L+Z5piv56ys5LiA5p2h5raI5oGvdAANc2Vjb25kTWVzc2FnZXNyABpqYXZhLnV0aWwuQXJyYXlzJEFycmF5TGlzdNmkPL7NiAbSAgABWwAB
         * YXQAE1tMamF2YS9sYW5nL09iamVjdDt4cHVyABdbTGphdmEuaW8uU2VyaWFsaXphYmxlO67QCaxT1+1JAgAAeHAAAAADdAAKaGVsbG93b3JsZHNyABFqYXZh
         * LmxhbmcuSW50ZWdlchLioKT3gYc4AgABSQAFdmFsdWV4cgAQamF2YS5sYW5nLk51bWJlcoaslR0LlOCLAgAAeHAAAAB7c3IAEWphdmEubGFuZy5Cb29sZWFu
         * zSBygNWc+u4CAAFaAAV2YWx1ZXhwAXg=
         */

        //收消息 收到以后网页上就没了 当然 网页上收到以后查看并删除了的话 这里应该也收不到 总之就是一条管子的两个出口 谁拿了另一个人就没了拿不到了
        Message message = rabbitTemplate.receive("horlly");
        System.out.println(message);


        //上面都是点对点的direct 下面测试广播
        rabbitTemplate.convertAndSend("exchange.fanout","","a fanout message");

    }

}
