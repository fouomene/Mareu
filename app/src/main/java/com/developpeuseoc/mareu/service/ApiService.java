package com.developpeuseoc.mareu.service;

import com.developpeuseoc.mareu.model.CoWorker;

import java.util.List;

public interface ApiService {

    public List<CoWorker> getCoWorkers();

    public List<CoWorker> getCoWorkersToAdd();

    public void addCoWorkersToAdd(CoWorker coWorker);

    public void deleteCoWorkersToAdd(CoWorker coWorker);

    public void initCoWorkersToAdd();

}
