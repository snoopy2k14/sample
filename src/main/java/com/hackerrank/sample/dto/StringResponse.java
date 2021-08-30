package com.hackerrank.sample.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StringResponse {

    @Id
    private String message;
    private String echo;

    public StringResponse( ) {

    }

    public StringResponse(String message, String echo) {
        this.message = message;
        this.echo = echo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

}
