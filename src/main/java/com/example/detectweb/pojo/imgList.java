package com.example.detectweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class imgList {
    private int id;
    private String imgFile;
    private String classes;
    private String imgName;
    private String detectTime;
}

