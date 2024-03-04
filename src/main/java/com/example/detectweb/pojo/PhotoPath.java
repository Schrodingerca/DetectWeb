package com.example.detectweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhotoPath {
    private int id;
    private int category_id;
    private int subcategory_id;
    private String imgPath;
}
