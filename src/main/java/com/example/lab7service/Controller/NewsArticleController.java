package com.example.lab7service.Controller;

import com.example.lab7service.APIResponse.API;
import com.example.lab7service.Model.NewsArticle;
import com.example.lab7service.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getNewsArticle() {
        ArrayList<NewsArticle> newsArticles = newsArticleService.getNewsArticles();
        return ResponseEntity.status(200).body(newsArticles);
    }

    @PostMapping("/add")
    public ResponseEntity addNewsArticle(@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(200).body(new API("Successfully added new article"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable int id,@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = newsArticleService.updateNewsArticle(id, newsArticle);
        if (isUpdate) {
        return ResponseEntity.status(200).body(new API ("Successfully updated new article"));
    }
        return ResponseEntity.status(400).body(new API ("News Article Not Found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable int id) {
        boolean isDelete = newsArticleService.deleteNewsArticle(id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new API ("Successfully deleted new article"));
        }
        return ResponseEntity.status(400).body(new API ("News Article Not Found"));

    }
    @PutMapping("/change/{id}")
    public ResponseEntity changeNewsArticle(@PathVariable int id) {
        boolean isChange = newsArticleService.changeNewsArticle(id);
        if (isChange) {
            return ResponseEntity.status(200).body(new API ("Successfully changed new article"));
        }
        return ResponseEntity.status(400).body(new API ("News Article Not Found"));
    }

    @GetMapping("/gets")
    public ResponseEntity getsNewsArticles() {

        return ResponseEntity.status(200).body(newsArticleService.getsPublishNewsArticles());
    }

    @GetMapping("/find/{category}")
    public ResponseEntity findNewsArticles(@PathVariable String category) {
      // NewsArticle newsArticle = newsArticleService.findNewsArticles(category);

        return ResponseEntity.status(200).body(newsArticleService.findNewsArticles(category));
    }
}




