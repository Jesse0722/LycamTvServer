package tv.lycam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tv.lycam.domain.Message;
import tv.lycam.domain.MessageResponse;
import tv.lycam.domain.User;
import tv.lycam.services.MessageServiceImpl;


import java.util.List;

@RestController
public class MessageController {

	@Autowired 
	private MessageServiceImpl service;
	
	@RequestMapping(value="/rtm/messages",method=RequestMethod.POST)
	public MessageResponse sendMessage(Message message){
		return service.sendMessage(message);
	}
	@RequestMapping(value="/rtm/messages/subscribers/{streamId}",method = RequestMethod.GET)
	public List<User> getUserListByTopic(@PathVariable String streamId){
		return service.getUsersByTopic(streamId);
	}
//	}
}
