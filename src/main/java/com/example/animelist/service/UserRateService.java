package com.example.animelist.service;

import com.example.animelist.entity.Anime;
import com.example.animelist.entity.user.User;
import com.example.animelist.repos.AnimeRepository;
import com.example.animelist.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRateService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnimeRepository animeRepository;

    public double getAnimeRate(Anime anime) {
        double rate = userRepository.avarageRate(anime.getId());
        BigDecimal decimal = new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

    public List<Anime> topRating(int quantity) {
        List<Long> ids = userRepository.topRating(quantity);
        return ids.stream()
                .map(a -> animeRepository.findById(a).get())
                .collect(Collectors.toList());
    }

    public double getAnimeRate(long id) {
        double rate = userRepository.avarageRate(id);
        BigDecimal decimal = new BigDecimal(rate).setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

    public Anime addToWatchList(String email, Anime anime) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("not found"));
        if (user.getWatchedList().contains(anime)) {
            return anime;
        }
        user.getWatchedList().add(anime);
        userRepository.save(user);
        return anime;
    }
    public Anime rateAnime(String email,Anime anime, int score){
        score = setCorrectValue(score);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("not found"));
        user.getRates().put(anime,score);
        userRepository.save(user);
        return anime;
    }
    private int setCorrectValue(int score){
        if(score>5)
            return 5;
        if(score<1)
            return 1;
        else return score;
    }

}
