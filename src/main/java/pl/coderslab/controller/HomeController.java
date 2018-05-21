package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/")
    public String viewHomePageWithTweets(@Valid @ModelAttribute User user, BindingResult result, Model model){
        if(result.hasErrors() || user == null){
            return "redirect:/loginPage";
        }
        model.addAttribute("tweets", tweetRepository.findAll());
        return "index";
    }

    @GetMapping("/user/{id}/tweets")
    public String showUserTweets(@PathVariable Long id, Model model){
        model.addAttribute("tweets", userRepository.findAllByUser(id));

        return "userTweets";
    }

    @GetMapping("/loginPage")
    public String userLogin(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @PostMapping("/loginPage")
    public String saveForm(@Valid @ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){
            return "loginPage";
        }

        //add user to sess!! or pass it somehow
        return "redirect:/";
    }

}
