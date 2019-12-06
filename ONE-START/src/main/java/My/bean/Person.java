package My.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 简单类型 map list 和jopo的yaml配置文件的值获取
 *
 * 将配置文件中配置的不同类型属性值，映射到此组件中
 *
 * @ConfigurationProperties:告诉springboot 本类中的所有属性和配置来自于配置文件内配置
 *
 * prefix = "person":表示取自此person下的属性进行一一映射
 *
 * 只有这个组件是容器中的组件 才能使用容器提供的@ConfigurationProperties 所以在@ConfigurationProperties前面必须使用@Component
 * 不然报错 @ConfigurationProperties下方一直有红线
 */

@Component
@ConfigurationProperties(prefix = "person1")
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birthday;

    private Map<String,Object> map;
    private List<Object> list;

    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
