package tv.lycam.controllers;

import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tv.lycam.services.SearchServiceImpl;


@RestController
public class SearchController {

	@Autowired
	private SearchServiceImpl searchService;
	/*
	 * 获取视频列表
	 */
	@RequestMapping(value="/streams/since",method=RequestMethod.GET)
	public ObjectListing<LycamplusStream> listStreams(){
		return searchService.sinceQuery();
	}

}
