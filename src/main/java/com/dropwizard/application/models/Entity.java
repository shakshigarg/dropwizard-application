package com.dropwizard.application.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class Entity {
    Integer id;
    boolean isBeingTracked;
    List<String> herTags;
}
