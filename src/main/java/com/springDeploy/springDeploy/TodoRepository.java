package com.springDeploy.springDeploy;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springDeploy.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
