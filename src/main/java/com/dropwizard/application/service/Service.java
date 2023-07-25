package com.dropwizard.application.service;

import com.dropwizard.application.dao.Dao;
import com.dropwizard.application.dao.DaoImpl;
import com.dropwizard.application.exception.ServiceException;
import com.dropwizard.application.models.Entity;

import java.util.List;

public class Service {
    Dao dao;

    public Service() {
        this.dao = new DaoImpl();
    }

    public void startTracking(Integer id, List<String> herTags) {
        if (dao.isEntityExists(id)) {
            if(!dao.isAlreadyTracked(id)){
                dao.addToTrie(herTags);
            }
            dao.startTracking(id);
        } else {
            dao.addEntity(Entity.builder().id(id).herTags(herTags).isBeingTracked(true).build());
            dao.addToTrie(herTags);
        }
    }

    public void stopTracking(Integer id) throws ServiceException {
        if (!dao.isEntityExists(id)) {
            throw new ServiceException("Entity dont exists!", "404");
        }
        dao.stopTracking(id);
        Entity entity = dao.getEntity(id);
        dao.removeFromTrie(entity.getHerTags());

    }

    public int getCount(List<String> tags){
        if(tags.size()==0){
            return 0;
        }
        return dao.getCount(tags);
    }

}
