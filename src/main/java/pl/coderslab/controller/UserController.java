package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;

    //add action for login


    @GetMapping("/user/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "UserForm";
    }

    @PostMapping("/user/add")
    public String saveForm(@Valid @ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){
            return "UserForm";
        }

        userRepository.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/user/${user.id}/tweets")
    @ResponseBody
    public String showTweets(@PathVariable long id){
        userRepository.findAllByUser(id);
        return "All users deleted";
    }

    @GetMapping("/user/updateform/{id}")
    public String userUpdateForm(@PathVariable long id, Model model){

        model.addAttribute("user",  userRepository.findOne(id));
        return "UserUpdateForm";
    }
    @PostMapping("/user/updateform/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){
            return "UserForm";
        }
        userRepository.save(user);
        return "AllUsersView";
    }

}
