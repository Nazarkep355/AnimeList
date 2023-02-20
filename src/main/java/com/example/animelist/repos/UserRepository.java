package com.example.animelist.repos;

import com.example.animelist.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    @Query(value = "select avg(rates) " +
            "from user_rates group by user_rates.rates_key having rates_key = ?1 ",nativeQuery = true)
    Double avarageRate(Long animeId);

    @Query(value = "select rates_key " +
            "from user_rates group by user_rates.rates_key order by avg(rates) desc limit ?1",nativeQuery = true)
    List<Long> topRating(int number);

}
