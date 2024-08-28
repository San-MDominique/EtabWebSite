package com.example.monwebetable.controller;

import com.example.monwebetable.models.User;
import com.example.monwebetable.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class usersController {

    private final UserService userService;

    @GetMapping
    public String showUserPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/liste";
    }

    @GetMapping("/add")
    public String showUserForm(Model model) {
        log.debug("request to show add User form");
        model.addAttribute("user", new User());
        return "users/forms";
    }

    @PostMapping
    public String saveUser(User user) {
        log.debug("Request to save user: {}", user);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showUpdateForm(Model model, @PathVariable long id) {
        log.debug("Request to show update User form");
        Optional<User> user = userService.findOne(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "users/forms";
        } else {
            return "redirect:/users";
        }
    }
}
