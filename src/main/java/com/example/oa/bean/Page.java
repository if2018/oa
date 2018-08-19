package com.example.oa.bean;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    private Integer currentPage;//当前页
    private int pageSize;//每页显示记录条数
    private int totalPage;//总页数
    private List<?> dataList;//每页显示的数据
    private int star;//开始数据
}
