package com.indeed.server.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.indeed.server.model.PostModal;

public interface PostDao extends MongoRepository<PostModal, String> {
}
