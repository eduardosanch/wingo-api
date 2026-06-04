package com.wingo.api.category.controller;

import com.wingo.api.category.entity.Category;
import com.wingo.api.category.service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {

        return ResponseEntity.ok(
                categoryService.getAllCategories()
        );
    }
}