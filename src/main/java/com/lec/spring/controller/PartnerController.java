package com.lec.spring.controller;


import com.lec.spring.domain.Partner;

import com.lec.spring.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/partner")
public class PartnerController {


    private final PartnerService partnerService;


    //매장리스트
    @GetMapping("/list")
    public ResponseEntity<?> list (){
        return new ResponseEntity<>(partnerService.list(), HttpStatus.OK);
    }

    //매장등록
    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody Partner partner){
        return new ResponseEntity<>(partnerService.write(partner),HttpStatus.CREATED);
    }

    //매장정보 디테일
    @GetMapping("/detail{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        return new ResponseEntity<>(partnerService.detail(id),HttpStatus.OK);
    }

    //매장수정
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Partner partner){
        return new ResponseEntity<>(partnerService.update(partner),HttpStatus.OK);
    }



    //매장삭제  직접 x  신청받고 삭제가능
    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(partnerService.delete(id),HttpStatus.OK);
    }



}