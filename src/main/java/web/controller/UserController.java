package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "usersIndex";
    }
    @GetMapping(value = "/new")
    public String createNewUser(Model model) {
        model.addAttribute("user",new User());
        return "new";
    }
    @PostMapping
    public String addNewUser(@ModelAttribute("user") User user){
        userService.addNewUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}/")
    public String editUserForm(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.findUserById(id));
        System.out.println("Finding user: "+userService.findUserById(id));
        userService.deleteUser(id);
        return "edit_user";
    }

    @PostMapping("edit")
    public String updateUserInfo(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/users";
    }

}
