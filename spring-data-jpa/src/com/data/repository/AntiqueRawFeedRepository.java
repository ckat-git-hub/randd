package com.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.data.entity.AntiqueRawFeed;

public interface AntiqueRawFeedRepository<P> extends CrudRepository<AntiqueRawFeed, String>, QueryByExampleExecutor<AntiqueRawFeed> {

}
