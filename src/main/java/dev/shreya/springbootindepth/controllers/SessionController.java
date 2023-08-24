package dev.shreya.springbootindepth.controllers;

import dev.shreya.springbootindepth.models.Session;
import dev.shreya.springbootindepth.repositories.SessionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

  @Autowired
  SessionRepository sessionRepository;

  @GetMapping
  public List<Session> all() {
    return sessionRepository.findAll();
  }

  @GetMapping
  @RequestMapping("/{id}")
  public Optional<Session> get(@PathVariable Long id) {
    return sessionRepository.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Session create(@RequestBody final Session session) {
    return sessionRepository.saveAndFlush(session);
  }
}
