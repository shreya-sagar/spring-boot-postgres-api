package dev.shreya.springbootindepth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long session_id;

  private String session_name;
  private String session_description;
  private int session_length;

  @ManyToMany
  @JoinTable(
      name = "session_speakers",
      joinColumns = @JoinColumn(name = "session_id"),
      inverseJoinColumns = @JoinColumn(name = "speaker_id")
  )
  private List<Speaker> speakers;
}
