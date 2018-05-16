package com.spring.jpa.starter.topic;

import org.springframework.data.repository.CrudRepository; // Spring Data JPA
import org.springframework.stereotype.Service;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
