package com.genspark.SQRLNutRitionAPI.UserConf.Registration;

import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.Service.UserServiceImpl;
import com.genspark.SQRLNutRitionAPI.UserConf.Error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public class RegistrationController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest req, Model mod)   {
        Dto dto = new Dto();
        mod.addAttribute("user", dto);
        return "registration";
    }
    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid Dto dto, HttpServletRequest request, Errors errors)  {
        try {
            User registered = userService.registerNewUserAccount(dto);
        } catch (UserAlreadyExistException uaeEx)  {

            ModelAndView mav = new ModelAndView("registration", "user", dto);
            mav.addObject("message", "An account for that username already exists.");
            return mav;
        }
        return new ModelAndView("sucessRegistration", "user", dto);
    }
}