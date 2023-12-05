package com.example.mybatis.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
    public List<Map<String,Object>> selectList();
    public List<Map<String,Object>> selectDetail(String seq);
    public void insertBoard(String title, String content, String writer, String writeDate);
    public void updateBoard(String seq, String title, String content, String writeDate);
}