package com.linskating.springbootvue_demo.entity;

import lombok.Data;

@Data
public class TimeCapsule {
    private Integer id;
    private String author;
    private String sentence;
    private Integer star;
    private Integer view;
    private Integer common;
    private Boolean likeStatus;
}
