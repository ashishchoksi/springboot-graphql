package com.graphql.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInput {
    private String title;
    private String description;
    private String author;
    private double price;
    private int pages;
}
