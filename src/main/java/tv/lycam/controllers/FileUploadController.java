package tv.lycam.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tv.lycam.domain.FileUploadedResponse;
import tv.lycam.services.FileUploadServiceImpl;


/**
 * Created by jesse on 16/4/27.
 */

@RestController
public class FileUploadController {

    @Autowired 
    private FileUploadServiceImpl fileUploadService;

    @RequestMapping(value = "/upload/avatars",method = RequestMethod.POST)
    public @ResponseBody
    FileUploadedResponse handleAvatarUpload(@RequestParam("name") String name,
                                            @RequestParam("pic") MultipartFile file ){

        return fileUploadService.fileAvatarUpload(name, file);
    }
    
    @RequestMapping(value = "/upload/thumbnails",method = RequestMethod.POST)
    public @ResponseBody FileUploadedResponse handleThumbnailsUpload(@RequestParam("name") String name,
			@RequestParam("pic") MultipartFile file ){
    	return fileUploadService.fileThumbnailsUpload(name, file);
    }
}
