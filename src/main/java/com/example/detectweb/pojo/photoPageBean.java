package com.example.detectweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class photoPageBean {
    private ArrayList<PhotoList> photoLists;
    private int pageSize;//每页展示几条数据
    private int pageNumber;//当前页
    private int pageCount; //数据库的总条数
    private int pageTotal;//总页数
}