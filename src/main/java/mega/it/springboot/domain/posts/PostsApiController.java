package mega.it.springboot.domain.posts;

import lombok.RequiredArgsConstructor;
import mega.it.springboot.service.posts.PostsService;
import mega.it.springboot.web.dto.PostsResponseDto;
import mega.it.springboot.web.dto.PostsSaveRequestDto;
import mega.it.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestDto) {
    return postsService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
    return postsService.update(id,requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id) { return postsService.findById(id);}

  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete(@PathVariable Long id){
    postsService.delete(id);
    return id;
  }


}
