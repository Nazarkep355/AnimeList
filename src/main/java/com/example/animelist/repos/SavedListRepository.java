package com.example.animelist.repos;

import com.example.animelist.entity.SavedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavedListRepository extends JpaRepository<SavedList,Long> {
    Optional<SavedList> findByName(String name);

}
