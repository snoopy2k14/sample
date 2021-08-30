package com.hackerrank.sample.service;


import com.hackerrank.sample.dto.StringResponse;
import com.hackerrank.sample.repository.SampleRepository;
import com.hackerrank.sample.exception.StringResponseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public StringResponse create(StringResponse stringResponse) {
        return sampleRepository.save(stringResponse);
    }


    @Override
    public StringResponse getStringResponseByMessage(String message) {

        Optional<StringResponse> optionalStringResponse = Optional.ofNullable(sampleRepository.findByMessage(message));

        if(optionalStringResponse.isPresent())
            return optionalStringResponse.get();
        else
            throw new StringResponseNotFoundException("String Response Not Found");
    }



}
