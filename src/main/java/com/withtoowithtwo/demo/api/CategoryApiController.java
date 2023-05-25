package com.withtoowithtwo.demo.api;

import com.withtoowithtwo.demo.domain.Category;
import com.withtoowithtwo.demo.repository.CategoryRepository;
import com.withtoowithtwo.demo.service.CategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RestController
@RequiredArgsConstructor
public class CategoryApiController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public Result categories() {
        return new Result(categoryService.findAll()
                .stream()
                .map(o -> new CategoryDto(o))
                .collect(toList()));
    }

    @Data
    static class CategoryDto {
        private Long id;
        private String name;

        public CategoryDto(Category category) {
            this.id = category.getId();
            this.name = category.getName();
        }
    }
}
