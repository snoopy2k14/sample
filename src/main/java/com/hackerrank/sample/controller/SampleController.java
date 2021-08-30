package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.StringResponse;
import com.hackerrank.sample.exception.StringResponseNotFoundException;
import com.hackerrank.sample.service.SampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SampleController {

    @Autowired
    SampleServiceImpl sampleServiceImpl;
    private Object StringResponse;

    @PostMapping(value = "/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse create(@RequestBody StringResponse stringResponse) {
        return sampleServiceImpl.create(stringResponse);
    }

    @GetMapping(value = "/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponse> getStringResponseById(@PathVariable("message") String message) {

        try {
            return new ResponseEntity<StringResponse>(sampleServiceImpl.getStringResponseByMessage(message), HttpStatus.OK);
        } catch (StringResponseNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StringResponse Not Found");
        }

    }


}
