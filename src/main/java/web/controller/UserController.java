package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/")
    public String showAllUsers(ModelMap modelMap) {

        List<User> allUsers = userService.getAllUsers();

        modelMap.addAttribute("allUsers", allUsers);

        return "users";
    }

    @PostMapping(value = "/addUser")
    public String addNewUser(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age) {

        User user = new User(name, surname, age);

        userService.saveUser(user);

        return "redirect:/";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age) {

        User user = new User(name, surname, age);

        user.setId(id);

        userService.updateUser(user);

        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam long id) {

        userService.deleteUser(id);

        return "redirect:/";
    }
}