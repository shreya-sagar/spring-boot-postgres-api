package dev.shreya.springbootindepth.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

  @NotBlank(message = "Session name is required")
  private String session_name;
  private String session_description;
  @Min(value = 10, message = "Session length should be atleast 10")
  @Max(value = 1000, message = "Session length should be maximum 1000")
  private int session_length;

}
