package dev.shreya.springbootindepth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpeakerDto {

  @NotBlank(message = "First name is required")
  private String first_name;
  @NotBlank(message = "Last name is required")
  private String last_name;
  private String title;
  @NotBlank(message = "Company is required")
  private String company;
  private String speaker_bio;
}
