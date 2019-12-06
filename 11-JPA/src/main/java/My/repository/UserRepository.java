package My.repository;

import My.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//User是类的类型 Integer是此类的主键类型
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
