package com.example.animelist.service;

import com.example.animelist.entity.Record;
import com.example.animelist.repos.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public Page<Record> getLastUpdates(){
        Pageable pageable = PageRequest.of(0,10, Sort.sort(Record.class).by("date").descending());
        return recordRepository.findAll(pageable);

    }
    public Long getLastRecordIdIncremented(){
        Optional<Record> recordOptional = recordRepository.findLast();
        return recordOptional.map(record -> record.getId() + 1).orElse(1l);
    }


}
