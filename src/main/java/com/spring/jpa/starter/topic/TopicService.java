package com.spring.jpa.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring","framework","disc1"),
			new Topic("spring2","framework2","disc2"),
			new Topic("spring3","framework3","disc3")));
	
	public List<Topic> getAllTopics(){
		//	return topics;  // there will be only one copy as it is singleton
		
		List<Topic> topicList = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topicList::add); // "topicRepository.findAll()" this will connect to DB, runs a query, get result maps with Topic object
		return topicList;
	}
	
	public Topic getTopic(String id ) {
	
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		
		 for(int i = 0; i <  topics.size() ; i++) {
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic( String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
}
