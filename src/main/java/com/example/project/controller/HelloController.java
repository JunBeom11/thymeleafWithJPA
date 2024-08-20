package com.example.project.controller;

import com.example.project.dto.TableRowDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping()
    public String hello() {
        return "hello";
    }

    @GetMapping("/table")
    public String table01() {
        return "table01";
    }

    @GetMapping("/table/load")
    public String loadTable(Model model) {
        /*
        전화번호
            -필드1
                -value
            -필드2
                -value
            -필드3
                -value

        01012345678
            - 생년월일
                - value
            - 주소
                - value
            - 성별
                - value

        List<전화번호Dto>
        - List<필드Dto>
                - value

        model 필드
        model 전화번호
        */

        TableRowDto tableRowDto1 = new TableRowDto(1L,"생년월일");
        TableRowDto tableRowDto2 = new TableRowDto(2L,"주소");
        TableRowDto tableRowDto3 = new TableRowDto(3L, "성별");
        List<TableRowDto> tableRowList = Arrays.asList(tableRowDto1, tableRowDto2, tableRowDto3);

        model.addAttribute("tableRowlist", tableRowList);

        return "table01::#udoTable";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @PostMapping("/submitData")
    public ResponseEntity submitData(@RequestParam("name") String name,
                                     @RequestParam("age") int age,
                                     @RequestParam("email") String email,
                                     Model model) {
        // 입력받은 데이터를 사용하여 로직 처리
        // 여기서는 입력받은 데이터를 모델에 추가하여 뷰로 전달

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("email", email);

        // 처리 결과를 보여줄 뷰의 이름을 반환
        return null;
        // return "result";
    }

}

