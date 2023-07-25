package com.dropwizard.application.dao;

import com.dropwizard.application.models.Entity;

import java.util.List;

public interface Dao {
    public void startTracking(Integer entityId);
    public boolean isEntityExists(Integer entityId);

    void addEntity(Entity entity);

    public void stopTracking(Integer entityId);
    public void addToTrie(List<String> tags);
    public void removeFromTrie(List<String> tags);
    public int getCount(List<String> tags);


    Entity getEntity(Integer id);

    boolean isAlreadyTracked(Integer id);
}
