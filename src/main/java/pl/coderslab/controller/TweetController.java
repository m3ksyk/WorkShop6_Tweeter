package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class TweetController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/tweet/add")
    public String tweetForm(Model model){
        model.addAttribute("tweet", new Tweet());
        model.addAttribute("users", userRepository.findAll());
        return "TweetForm";
    }
    @PostMapping("/tweet/add")
    public String saveForm(@Valid @ModelAttribute Tweet tweet, BindingResult result){
        if(result.hasErrors()){
            return "TweetForm";
        }
        tweet.setCreated(LocalDate.now());
        tweetRepository.save(tweet);
        return "index";
    }



}
