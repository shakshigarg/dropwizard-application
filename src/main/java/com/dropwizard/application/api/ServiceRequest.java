package com.dropwizard.application.api;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ServiceRequest {
    Integer id;
    List<String> herTags;


}
