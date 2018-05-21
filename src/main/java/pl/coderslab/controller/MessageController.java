package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Message;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class MessageController {

    //TODO actions for sending and viewing messages
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/message/send")
    public String messageForm(Model model){
        model.addAttribute("message", new Message());
        model.addAttribute("users", userRepository.findAll());
        return "MessageForm";
    }
    @PostMapping("/message/send")
    public String saveForm(@Valid @ModelAttribute Message message, BindingResult result){
        if(result.hasErrors()){
            return "MessageForm";
        }
        message.setCreated(Date.valueOf(LocalDate.now()));
        messageRepository.save(message);
        return "index";
    }
}
