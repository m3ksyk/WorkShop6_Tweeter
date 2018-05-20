package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import java.awt.print.Book;


@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/")
    public String viewHomePageWithTweets(@PathVariable Long id, Model model){
        model.addAttribute("tweets", tweetRepository.findAll());
        return "index";
    }

    @GetMapping("/user/{id}/tweets")
    public String showUserTweets(@PathVariable Long id, Model model){
        model.addAttribute("tweets", userRepository.findAllByUser(id));

        return "userTweets";
    }

}
