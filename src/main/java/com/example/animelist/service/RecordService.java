package com.example.animelist.service;

import com.example.animelist.entity.Anime;
import com.example.animelist.entity.Episode;
import com.example.animelist.entity.Record;
import com.example.animelist.repos.EpisodeRepository;
import com.example.animelist.repos.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private AnimeSearchService animeSearchService;
    @Autowired
    private UploadFileService uploadService;

    public Page<Record> getLastUpdates(){
        Pageable pageable = PageRequest.of(0,10, Sort.sort(Record.class).by("date").descending());
        return recordRepository.findAll(pageable);

    }
    public Long getLastRecordIdIncremented(){
        Optional<Record> recordOptional = recordRepository.findLast();
        return recordOptional.map(record -> record.getId() + 1).orElse(1l);
    }
    private Record createNewUploadRecord(Episode episode){
        Record record = new Record();
        record.setDate(Date.from(Instant.now()));
        record.setEpisode(episode);
        return recordRepository.save(record);
    }
    public void uploadEpisode(String anime_name, int episode_num, MultipartFile file){
        Anime anime = animeSearchService.findByName(anime_name.trim())
                .orElseThrow(()->new IllegalArgumentException("Anime not found"));
        String fileName = generateNewFileName(file);
        Episode episode = new Episode();
        episode.setEpisodeNum(episode_num);
        episode.setAnime(anime);
        episode.setFileName(fileName);
        uploadService.saveFile(file,fileName);
        episodeRepository.save(episode);
        createNewUploadRecord(episode);
    }
    private String generateNewFileName(MultipartFile file){
       return getLastRecordIdIncremented()+file.getOriginalFilename();
    }


}
