package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TweetController {
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/tweet/add")
    public String tweetForm(Model model, HttpSession session){
        model.addAttribute("tweet", new Tweet());
//        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("LoggedUser", session.getAttribute("LoggedUser"));

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

    @GetMapping("/tweetView/{id}")
    public String showTweet(@PathVariable long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);

        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", tweet.getComments());
        model.addAttribute("comment", new Comment());
        return "tweetView";
    }

    @PostMapping("/tweetView/{id}")
    public String saveForm(@Valid @ModelAttribute Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "tweetView";
        }

        comment.setCreated(Date.valueOf(LocalDate.now()));
        commentRepository.save(comment);
        return "tweetView";
    }

    @GetMapping("/userTweets/{id}")
    public String userTweets(@PathVariable long id, Model model) {
        model.addAttribute("tweets", tweetRepository.findAllByUser(id));
        return "userTweets";
    }



}





