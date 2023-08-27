package dev.shreya.springbootindepth.controllers;

import dev.shreya.springbootindepth.dto.SpeakerDto;
import dev.shreya.springbootindepth.dto.SpeakerDto;
import dev.shreya.springbootindepth.models.Speaker;
import dev.shreya.springbootindepth.repositories.SpeakerRepository;
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
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

  @Autowired
  SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> all() {
    return speakerRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Speaker> get(@PathVariable Long id) {
    return speakerRepository.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker create(@RequestBody final Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Speaker> update(@PathVariable Long id, @Valid @RequestBody SpeakerDto speakerDto) {
    Optional<Speaker> existingSpeaker = speakerRepository.findById(id);
    if(existingSpeaker.isPresent()) {
      Speaker speaker = existingSpeaker.get();
      //BeanUtils.copyProperties(speakerDto,speaker,"speaker_id");
      speaker.setFirst_name(speakerDto.getFirst_name());
      speaker.setLast_name(speakerDto.getLast_name());
      speaker.setTitle(speakerDto.getTitle());
      speaker.setCompany(speakerDto.getCompany());
      speaker.setSpeaker_bio(speakerDto.getSpeaker_bio());

      return ResponseEntity.ok(speakerRepository.saveAndFlush(speaker));
    }
    else
      return ResponseEntity.notFound().build();
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    Optional<Speaker> speakerTobeDeleted = speakerRepository.findById(id);
    if(speakerTobeDeleted.isPresent()) {
      speakerRepository.deleteById(id);
      return ResponseEntity.ok("Speaker Deleted : ID "+ id);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
