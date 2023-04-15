package com.example.animelist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
@Service
class RecordServiceTest {
@Autowired
    private  RecordService recordService;
    @Test
    void getLastUpdates() {
    }

    @Test
    void getLastRecordId() {
//        Assertions.assertEquals(2,recordService.getLastRecordId());
    }
}