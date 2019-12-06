package My.controller;

import My.entity.User;
import My.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user/find/{id}")
    public User getUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @RequestMapping("/user/save")
    public User insertUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @RequestMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @RequestMapping("/user/update")
    public User updateUser(User user){
        User user1 = userRepository.saveAndFlush(user);
        return user1;
    }
}
