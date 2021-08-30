package com.hackerrank.sample.repository;

import com.hackerrank.sample.dto.StringResponse;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<StringResponse, String> {
    StringResponse findByMessage(String message);
}
