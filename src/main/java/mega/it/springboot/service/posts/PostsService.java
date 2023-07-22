package mega.it.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import mega.it.springboot.domain.posts.Posts;
import mega.it.springboot.domain.posts.PostsRepository;
import mega.it.springboot.web.dto.PostResponseDto;
import mega.it.springboot.web.dto.PostsListResponseDto;
import mega.it.springboot.web.dto.PostsSaveRequestDto;
import mega.it.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  public PostResponseDto findById(Long id){
    Posts entity = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
    return new PostResponseDto(entity);
  }

  @Transactional(readOnly = true)
  public List<PostsListResponseDto> findAllDesc(){
    return postsRepository.findAllDesc().stream()
            .map(PostsListResponseDto::new)
            .collect(Collectors.toList());
  }
}
