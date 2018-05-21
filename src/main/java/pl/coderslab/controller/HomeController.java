package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.BCrypt;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.print.Book;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @RequestMapping("/")
    public String viewHomePageWithTweets(HttpSession httpSession, Model model){
        User user = (User) httpSession.getAttribute("currentUser");
        if(user == null){
            return "redirect:/loginPage";
        }
        model.addAttribute("tweets", tweetRepository.findAll());

        return "index";
    }

    @PostMapping("/loginPage")
    public String UserLogin(Model model, HttpSession httpSession, @RequestParam String email, @RequestParam String password){
        User user = userRepository.findByEmail(email);
        String checkPass = BCrypt.hashpw(password, user.getcSalt());

        if(checkPass.equals(user.getPassword())){
            httpSession.setAttribute("userName", user.getUserName());
            httpSession.setAttribute("User", user);
            httpSession.setAttribute("UserId", user.getId());
            model.addAttribute("LoggedUser", user);
            return "index";
        } else {
            return "loginPage";
        }

    }


}
