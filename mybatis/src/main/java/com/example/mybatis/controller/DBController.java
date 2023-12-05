package com.example.mybatis.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mybatis.mapper.BoardDao;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

@RestController
public class DBController{
    @Autowired
    BoardDao boardDao;

    // ('board/list')라는 주소로 들어오면 리스트를 보여지도록 만들기
    @GetMapping("board/list")
    public List<Map<String, Object>> boardList(){
        return boardDao.selectList();
    }

    @GetMapping("board/detail")
    public List<Map<String,Object>> boardDetail(){
        String seq = "3";
        return boardDao.selectDetail(seq);
    }

    @GetMapping("board/insert")
    public String boardInsert(){
        String title = "오늘 아침 날씨";
        String content="추움";
        String writer="김나영";
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString().substring(0,5);
        String writeDate = String.format("%s %s",date,time);
        boardDao.insertBoard(title,content,writer,writeDate);
        return writeDate + "에 잘 저장되었습니다.";
    }

    @GetMapping("board/update")
    public String boardUpdate(){
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString().substring(0,5);
        String writeDate = String.format("%s %s",date,time);
        String seq = "5";
        String title = "오늘 아침 날씨";
        String content="추움";
        boardDao.updateBoard(seq, title, content, writeDate);
        return writeDate +  "에 저장되었습니다.";
    }
}



// import java.util.List;
// import java.util.Map;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.mybatis.mapper.DemoMapper;
// import com.example.mybatis.mapper.BoardMapper;

// @RestController
// public class DBController {
//     @Autowired
//     DemoMapper demoMapper;
//     @Autowired
//     BoardMapper boardMapper;

//     @GetMapping("/mybatis/demo")
//     public List<Map<String,Object>> mybatisDemo(){
//         return demoMapper.select();
//     }

//     @GetMapping("/mybatis/demoid")
//     public List<Map<String,Object>> mybatisDemoId(){
//         return demoMapper.selectById("1");
//     }

//     @GetMapping("/mybatis/demoinsert")
//     public String mybatisInsert(){
//         demoMapper.insert("3","CCC");
//         return "잘 저장되었습니다.";
//     }

//     @GetMapping("/mybatis/demoupdate")
//     public String mybatisUpdate(){
//         demoMapper.update("3","ABC");
//         return "잘 고쳐졌습니다.";
//     }

//     @GetMapping("/mybatis/demodelete")
//     public String mybatisDelte(){
//         demoMapper.delete("3");
//         return "잘 지워졌습니다.";
//     }

//     @GetMapping("/mybatis/boardselect")
//     public List<Map<String,Object>> boardSelect(){
//         return boardMapper.selectList();
//     }
// }