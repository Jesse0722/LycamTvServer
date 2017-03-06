package tv.lycam.controllers;

import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tv.lycam.services.StreamServiceImpl;


@RestController
public class StreamController {
	private StreamServiceImpl service;
	
	@Autowired
	public void setService(StreamServiceImpl service){
		this.service=service;
	}
	
	/*
	 * 创建直播视频流
	 */
	@RequestMapping(value="/streams",method=RequestMethod.POST)
	public LycamplusStream createStream(LycamplusStream stream) {
		return service.createStream(stream);
	}

	/***
	 *  获取直播视频
	 * @param streamId
	 * @return LycamplusStream
	 */
	@RequestMapping(value="/streams/{streamId}",method=RequestMethod.GET)
	public LycamplusStream findStreamById(@PathVariable String streamId){
		return service.findStreamById(streamId);
	}
	
	/***
	 * 获取直播视频列表
	 * @param
	 * @return ObjectListing<LycamplusStream>
	 */
	@RequestMapping(value="/streams",method=RequestMethod.GET)
	public ObjectListing<LycamplusStream> listStreams(){
		return service.listStreams();
	}
	
	@RequestMapping(value="/streams/{streamId}",method=RequestMethod.PUT)
	public LycamplusStream updateStream(@PathVariable LycamplusStream stream){
		return service.updateStream(stream);
	}
	
	@RequestMapping(value="/streams/{streamId}",method=RequestMethod.DELETE)
	public boolean destroyStream(@PathVariable String streamId){
		return service.destroyStream(streamId);
	}
	
	
	
	
}
