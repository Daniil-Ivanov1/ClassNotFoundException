package com.example.repository;

import com.example.entity.SomeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeRepository extends PagingAndSortingRepository<SomeEntity, String> {

}