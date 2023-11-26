package com.example.demospringcloudstreamskafka.entities;

import lombok.*;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private Integer duration;
}
