package com.withtoowithtwo.demo.api;

import com.withtoowithtwo.demo.domain.*;
import com.withtoowithtwo.demo.domain.Enum.Gender;
import com.withtoowithtwo.demo.domain.Enum.OrderOption;
import com.withtoowithtwo.demo.domain.Enum.PostStatus;
import com.withtoowithtwo.demo.repository.post.JpaPostRepository;
import com.withtoowithtwo.demo.repository.post.PostRepository;
import com.withtoowithtwo.demo.repository.post.PostSearch;
import com.withtoowithtwo.demo.service.CategoryService;
import com.withtoowithtwo.demo.service.PostService;
import com.withtoowithtwo.demo.service.UserService;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final JpaPostRepository jpaPostRepository;
    private final CategoryService categoryService;
    private final UserService userService;

    @PostMapping("/posts")
    public CreatePostResponse savePost(@RequestBody CreatePostRequest request) {
        List<GroupUser> companions = new ArrayList<>();
        companions.add(new GroupUser(userService.findOne(request.getWriter_id())));
        for (Long id : request.getCompanions()) companions.add(new GroupUser(userService.findOne(id)));

        TripGroup tripGroup = new TripGroup(companions,
                request.getFirstDay(),
                request.getLastDay());

        Post post = new Post(categoryService.findOne(request.getCategory_id()),
                tripGroup,
                userService.findOne(request.getWriter_id()),
                request.getTitle(),
                request.getContent(),
                request.getHeadCount(),
                new Preference(request.getPreferGender(), request.getPreferMinAge(), request.getPreferMaxAge()));

        return new CreatePostResponse(postService.savePost(post));
    }

/*    @GetMapping("/posts")
    public Result posts() {
        List<Post> all = postRepository.findAll();

        return new Result(all.stream()
                .map(o -> new PostDtoForList(o))
                .collect(toList()));
    }*/

    @GetMapping("/posts")
    public Result posts(@RequestParam("category") @Nullable String category,
                        @RequestParam("order") @Nullable OrderOption option) {
        PostSearch postSearch = new PostSearch();
        Category findCategory = categoryService.findOneByName(category);
        postSearch.setCategory(findCategory);
        postSearch.setOption(option);
        List<Post> all = jpaPostRepository.findAllWithFilter(postSearch);

        return new Result(all.stream()
                .map(o -> new PostDtoForList(o))
                .collect(toList()));
    }

    @GetMapping("/posts/{id}")
    public PostDto post(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        Post post = postRepository.findById(id).get();
        return new PostDto(post);
    }

    /**
     * DTO
     */
    @Data
    static class CreatePostRequest {
        private Long category_id;
        private Long writer_id;
        private String title;
        private String content;

        private LocalDate firstDay;
        private LocalDate lastDay;
        private int headCount; //동행 인원

        private List<Long> companions = new ArrayList<>();

        private Gender preferGender;
        private int preferMinAge;
        private int preferMaxAge;
    }

    @Data
    static class CreatePostResponse {
        private Long id;

        public CreatePostResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class PostDtoForList {
        private UserDto writer;
        private String title;
        private String content;
        private PostStatus status;
        private LocalDateTime postDate;
        private int hits;
        private int preferHeadCount; //여행 인원
        private int headCount; //여행 인원

        public PostDtoForList(Post post) {
            this.writer = new UserDto(post.getWriter());
            this.title = post.getTitle();
            this.content = post.getContent();
            this.status = post.getStatus();
            this.postDate = post.getPostDate();
            this.hits = post.getHits();
            preferHeadCount = post.getHeadCount();
            this.headCount = post.getGroup().getHeadCount();
        }
    }

    @Data
    static class PostDto {
        private String title;
        private UserDto writer;
        private LocalDateTime postDate;
        private int hits;

        private String category;

        private String content;
//        private List<Image> images;
        private TripDto tripInfo;

        private int preferHeadCount; //선호 동행 인원

        public PostDto(Post post) {
            this.title = post.getTitle();
            this.writer = new UserDto(post.getWriter());
            this.postDate = post.getPostDate();
            this.hits = post.getHits();
            this.category = post.getCategory().getName();
            this.content = post.getContent();
            this.tripInfo = new TripDto(post.getGroup());
            preferHeadCount = post.getHeadCount();
        }
    }

    @Data
    static class UserDto {
        private Long id;
        private String nickname;

        public UserDto(User user) {
            this.id = user.getId();
            this.nickname = user.getNickname();
        }
    }

    @Data
    static class TripDto {
        private List<GroupUser> members = new ArrayList<>();
        private LocalDate firstDay;
        private LocalDate lastDay;

        private int headCount; //동행 인원

        public TripDto(TripGroup tripGroup) {
            this.members = tripGroup.getMembers();
            this.firstDay = tripGroup.getFirstDay();
            this.lastDay = tripGroup.getLastDay();
            this.headCount = tripGroup.getHeadCount();
        }
    }
}
