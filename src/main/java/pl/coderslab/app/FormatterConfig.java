package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.converter.CommentConverter;
import pl.coderslab.converter.MessageConverter;
import pl.coderslab.converter.TweetConverter;
import pl.coderslab.converter.UserConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverter());
        registry.addConverter(tweetConverter());
        registry.addConverter(messageConverter());
        registry.addConverter(commentConverter());
    }


    @Bean
    public UserConverter userConverter(){
        return new UserConverter();
    }

    @Bean
    public TweetConverter tweetConverter(){
        return new TweetConverter();
    }

    @Bean
    public MessageConverter messageConverter(){
        return new MessageConverter();
    }

    @Bean
    public CommentConverter commentConverter(){
        return new CommentConverter();
    }

}
