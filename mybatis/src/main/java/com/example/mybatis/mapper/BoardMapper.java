package com.example.mybatis.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public List<Map<String, Object>> selectList();
    public List<Map<String, Object>> selectDetail(String seq);
    public void insertBoard(String title, String content, String writer, String date);
    public void update(String seq, String title, String content, String date);
    public void delete(String seq);
}