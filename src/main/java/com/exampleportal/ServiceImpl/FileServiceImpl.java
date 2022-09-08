package com.exampleportal.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.exampleportal.Entity.Attachment;
import com.exampleportal.Repository.FileRepository;
import com.exampleportal.Services.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileRepository fileRepo;

	@Override
	public Attachment saveFile(MultipartFile file) throws Exception {

       String filename=StringUtils.cleanPath(file.getOriginalFilename());
       try {
    	   
    	   Attachment attachment=new Attachment();
    	    attachment.setFileName(filename);
    	    attachment.setFileType(file.getContentType());
    	    attachment.setData(file.getBytes());
    	    
    	    return this.fileRepo.save(attachment);
    	   
       }
       
       catch(Exception e) {
    	   e.printStackTrace();
    	   
    	   throw new Exception("Could not save File" +filename);
       }
	}

	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		
		return this.fileRepo.findById(fileId).orElseThrow(()-> new Exception("File not ound with Id: "+fileId));
	}

}
