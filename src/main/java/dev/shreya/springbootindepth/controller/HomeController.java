package dev.shreya.springbootindepth.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {

  @Value("${app.version}")
  private String appVersion;

  @GetMapping("/version")
  public Map<String,String> getAppVersion() {
    Map<String,String> map = new HashMap<String,String>();
    map.put("app-version",appVersion);
    return map;
  }
}
