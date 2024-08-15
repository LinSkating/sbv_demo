package com.linskating.springbootvue_demo.entity;

import lombok.Data;

@Data
public class AuthorReaderPreference {
    private Integer id;
    private String reader;
    private String author;
    private String works;
    private Boolean likeStatus;
}
