package tv.lycam.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tv.lycam.domain.Gift;
import tv.lycam.domain.MessageBody;
import tv.lycam.domain.User;
import tv.lycam.repositories.GiftRepository;


@Service
public class GiftServiceImpl implements GiftService{
	
	@Autowired
	private GiftRepository repository;

	@Autowired
	private UserServiceImpl userService;

	@Override
	public List<Gift> getAllGift() {
		return repository.findAll();
	}

	@Override
	public MessageBody sendGift(String senderId, String receiverId, String giftId, MessageBody messageBody) {
		User sender=userService.getUserById(senderId);//送礼物用户
		User receiver = userService.getUserById(receiverId);//接,受者
		Gift gift = getGiftById(giftId);

		if(sender!=null&&receiver!=null&&gift!=null) {

			int giftPrice = gift.getPrice();

			int senderBalance = sender.getBalance();

			if (senderBalance >= giftPrice) {//如果用户余额大于礼物价格
				sender.setBalance(senderBalance - giftPrice);//扣除金额
				sender.setExperience(sender.getExperience() + giftPrice * 10);//增加经验
				sender.setContribution(sender.getContribution() + giftPrice);//增加贡献值

				receiver.setPopularity(receiver.getPopularity() + giftPrice);//主播怎么加人气
				receiver.setBalance(receiver.getBalance() + giftPrice);
				receiver.setExperience(receiver.getExperience() + giftPrice * 10);

				List<User> userList = new ArrayList<User>();
				userList.add(sender);
				userList.add(receiver);

				userService.updateUserList(userList);

				messageBody.setSenderBalance(sender.getBalance());
				messageBody.setAnchorPopularity(receiver.getPopularity());
			}
		}
		return messageBody;
	}

	@Override
	public Gift getGiftById(String id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}
	
}
