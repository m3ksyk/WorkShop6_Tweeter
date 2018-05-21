package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;

import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class CommentController {


    //ALL FUNCS MOVED TO TWEETCONTROLLER
//    @Autowired
//    CommentRepository commentRepository;

//    @GetMapping("/tweetView/{id}")
//    public String commentForm(Model model) {
//        model.addAttribute("comment", new Comment());
//        return "tweetView";
//    }
//
//    @PostMapping("/tweetView/{id}")
//    public String saveForm(@Valid @ModelAttribute Comment comment, BindingResult result) {
//        if (result.hasErrors()) {
//            return "tweetView";
//        }
//
//        comment.setCreated(Date.valueOf(LocalDate.now()));
//        commentRepository.save(comment);
//        return "tweetView";
//    }
}
