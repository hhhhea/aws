package mega.it.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

  private final String name;
  private final int amount;
}
