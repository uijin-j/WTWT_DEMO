package com.withtoowithtwo.demo.api;

import com.withtoowithtwo.demo.domain.Birthday;
import com.withtoowithtwo.demo.domain.Enum.Gender;
import com.withtoowithtwo.demo.domain.Image;
import com.withtoowithtwo.demo.domain.Profile;
import com.withtoowithtwo.demo.domain.User;
import com.withtoowithtwo.demo.service.UserService;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller @ResponseBody
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/users")
    public CreateUserResponse saveUser(@RequestBody CreateUserRequest request) {
        Profile profile = new Profile(request.getStatusMessage());
        Birthday birthday = new Birthday(request.getBYear(), request.getBMonth(), request.getBDay());

        User user = new User(profile, request.getName(), request.getPhoneNumber(), request.getEmail(),
                request.getPassword(), request.getNickname(), request.getGender(), birthday);

        System.out.println(user.getNickname() + user.getPhoneNumber());

        Long id = userService.join(user);
        return new CreateUserResponse(id);
    }

    /**
     * DTO
     */
    @Data
    static class CreateUserRequest {
        @NotEmpty
        private String name;
        @NotEmpty
        private String phoneNumber;
        @NotEmpty
        private String email;
        @NotEmpty
        private String password;

//        private Image image;
        @NotEmpty
        private String nickname;
        private String statusMessage;
        private Gender gender; //성별 [MALE, FEMALE, HIDE]
        private String bYear;
        private String bMonth;
        private String bDay;
    }

    @Data
    static class CreateUserResponse {
        private Long id;

        public CreateUserResponse(Long id) {
            this.id = id;
        }
    }
}
