package dev.shreya.springbootindepth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.BinaryJdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

@Entity(name = "speakers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long speaker_id;
  private String first_name;
  private String last_name;
  private String title;
  private String company;
  private String speaker_bio;

  @Lob
  @JdbcType(VarbinaryJdbcType.class)
  private byte[] speaker_photo;
  
  @ManyToMany(mappedBy = "speakers")
  private List<Session> sessions;
}
