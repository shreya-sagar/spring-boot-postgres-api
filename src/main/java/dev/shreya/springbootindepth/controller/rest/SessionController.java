package dev.shreya.springbootindepth.controller.rest;

import dev.shreya.springbootindepth.dto.SessionDto;
import dev.shreya.springbootindepth.entity.Session;
import dev.shreya.springbootindepth.repository.SessionRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/{id}")
  public Optional<Session> get(@PathVariable Long id) {
    return sessionRepository.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Session create(@RequestBody final Session session) {
    return sessionRepository.saveAndFlush(session);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Session> update(@PathVariable Long id, @Valid @RequestBody SessionDto sessionDto) {
    Optional<Session> existingSession = sessionRepository.findById(id);
    if(existingSession.isPresent()) {
      Session session = existingSession.get();
      //BeanUtils.copyProperties(sessionDto,session,"session_id");
      session.setSession_name(sessionDto.getSession_name());
      session.setSession_description(sessionDto.getSession_description());
      session.setSession_length(sessionDto.getSession_length());
      return ResponseEntity.ok(sessionRepository.saveAndFlush(session));
    }
    else
      return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    Optional<Session> sessionTobeDeleted = sessionRepository.findById(id);
    if(sessionTobeDeleted.isPresent()) {
      sessionRepository.deleteById(id);
      return ResponseEntity.ok("Session Deleted : ID "+ id);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
