package dev.shreya.springbootindepth.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

  String greetingPage = "greeting";

  @GetMapping("greeting")
  public String greeting(Map<String,Object> message) {
    message.put("message","Hello World by Shreya!!");
    return greetingPage;
  }
}
