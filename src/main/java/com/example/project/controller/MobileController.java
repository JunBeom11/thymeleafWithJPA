package com.example.project.controller;

import com.example.project.model.MobileNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MobileController {

    @GetMapping("/mobileNumbers")
    public String getMobileNumbers(Model model) {
        List<MobileNumber> mobileNumbers = new ArrayList<>();

        // GroupCode 'A'로 데이터 생성
        mobileNumbers.add(MobileNumber.builder()
                .mobileNumber("010-1234-5678")
                .groupCode("A")
                .groupName("Group A")
                .build());

        mobileNumbers.add(MobileNumber.builder()
                .mobileNumber("010-2345-6789")
                .groupCode("A")
                .groupName("Group A")
                .build());

        // GroupCode 'B'로 데이터 생성
        mobileNumbers.add(MobileNumber.builder()
                .mobileNumber("010-3456-7890")
                .groupCode("B")
                .groupName("Group B")
                .build());

        // 모델에 데이터 추가
        model.addAttribute("mobileNumbers", mobileNumbers);

        return "mobileNumbers";
    }
}
