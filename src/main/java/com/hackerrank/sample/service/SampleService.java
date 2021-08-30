package com.hackerrank.sample.service;

import com.hackerrank.sample.dto.StringResponse;

public interface SampleService {
    StringResponse getStringResponseByMessage(String message);
    StringResponse create(StringResponse stringResponse);
}
