package dev.shreya.springbootindepth.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

  String registrationPage = "registration";

  @GetMapping("registration")
  public String registration(Map<String,Object> message) {
    message.put("message","This is the registration page!!");
    return registrationPage;
  }
}
