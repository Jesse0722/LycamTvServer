package tv.lycam.services;

import tv.lycam.domain.Gift;
import tv.lycam.domain.MessageBody;

import java.util.List;



public interface GiftService {
	
	public Gift getGiftById(String id);

	public List<Gift> getAllGift();

	public MessageBody sendGift(String senderId,String receiverId,String giftId,MessageBody messageBody);
}
