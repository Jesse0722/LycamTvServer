package tv.lycam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tv.lycam.domain.Gift;
import tv.lycam.services.GiftServiceImpl;


@RestController
public class GiftController {
	
	@Autowired
	private GiftServiceImpl giftService;
	
	@RequestMapping(value="/gifts",method=RequestMethod.GET)
	public List<Gift> getGiftList(){
		return giftService.getAllGift();
	}
	
	@RequestMapping(value="/gifts/{objectId}",method=RequestMethod.GET)
	public Gift getGiftById(@PathVariable String objectId){
		return giftService.getGiftById(objectId);
	}

}
