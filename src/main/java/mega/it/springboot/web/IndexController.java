package mega.it.springboot.web;

import lombok.RequiredArgsConstructor;
import mega.it.springboot.config.auth.LoginUser;
import mega.it.springboot.config.auth.dto.SessionUser;
import mega.it.springboot.service.posts.PostsService;
import mega.it.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    private final HttpSession httpSession;

    @GetMapping(value = "/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        이기능을 @LoginUser SessionUser user 이걸로 대체해서 사용
        if (user != null) {
            model.addAttribute("userName1", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
