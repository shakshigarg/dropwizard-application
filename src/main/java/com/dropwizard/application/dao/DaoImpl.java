package com.dropwizard.application.dao;

import com.dropwizard.application.db.InMemoryDb;
import com.dropwizard.application.models.Entity;

import java.util.List;

public class DaoImpl implements Dao {

    InMemoryDb inMemoryDb = InMemoryDb.getInstance();

    @Override
    public void startTracking(Integer entityId) {
        inMemoryDb.getEntityMap().get(entityId).setBeingTracked(true);
    }

    @Override
    public boolean isEntityExists(Integer entityId) {
        return inMemoryDb.getEntityMap().containsKey(entityId);
    }

    @Override
    public void addEntity(Entity entity) {
        inMemoryDb.getEntityMap().put(entity.getId(),entity);
    }

    @Override
    public void stopTracking(Integer entityId) {
        inMemoryDb.getEntityMap().get(entityId).setBeingTracked(false);
    }

    @Override
    public void addToTrie(List<String> tags) {
        inMemoryDb.getTrie().addToTrie(tags);
    }

    @Override
    public void removeFromTrie(List<String> tags) {
        inMemoryDb.getTrie().removeFromTrie(tags);
    }

    @Override
    public int getCount(List<String> tags) {
        return inMemoryDb.getTrie().getCount(tags);
    }

    @Override
    public Entity getEntity(Integer id) {
        return inMemoryDb.getEntityMap().get(id);
    }

    @Override
    public boolean isAlreadyTracked(Integer id) {
        return inMemoryDb.getEntityMap().get(id).isBeingTracked();
    }
}
