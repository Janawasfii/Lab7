package com.example.lab7service.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message ="ID Should not be empty")
    private int id;


    @NotEmpty(message="Title should not be empty")
    @Size(min=30, max=100)
    private String title;


    @NotEmpty(message="Author should not be empty")
    @Size(min=5, max=20)
    private String author;


    @NotEmpty(message="Content should not be empty")
    @Size(min=20)
    private String content;


    @NotEmpty(message="Category should not be empty")
    @Pattern(regexp ="^(politics|sports|technology)$")
    private String category;


    @NotEmpty(message="image should not be null")
    private String image;


    @AssertFalse
    private boolean isPublished;

    @NotNull(message="Date should not be empty")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate publishedDate;











}
