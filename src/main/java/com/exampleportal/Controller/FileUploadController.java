package com.exampleportal.Controller;

import java.security.Principal;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.exampleportal.Entity.Attachment;
import com.exampleportal.Entity.User;
import com.exampleportal.Helper.FileResponse;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.FileService;

@RestController
@CrossOrigin("*")
public class FileUploadController {
	
	
	@Autowired
	private FileService FileserviceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/file-upload")
	public ResponseEntity<?> FileUpload(@RequestParam("file")  MultipartFile file,Principal principal) throws Exception{
		//System.out.println(file.getOriginalFilename());
		
		//--------------Fetch the current user which is logged In------------------
		User user=this.userRepo.findByUsername(principal.getName());
		user.setProfile(file.getOriginalFilename());
		this.userRepo.save(user);
		
		// ------update the user profile and save the user---------------------------
		String fileFormat=file.getContentType();
		if(!(fileFormat.equals("image/jpg") || fileFormat.equals("image/png") || fileFormat.equals("image/jpeg") || fileFormat.equals("image/pdf"))) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supported File Format :JPG,JPEG,PNG,PDF");
			
		}
		else {
		    String downloadUrl=null;
			Attachment attachment=null;
			attachment=this.FileserviceImpl.saveFile(file);
			downloadUrl=ServletUriComponentsBuilder.fromCurrentContextPath().fromCurrentContextPath()
					.path("/download/")
					.path(attachment.getId()).toUriString();
		     
			FileResponse fileresponse=new FileResponse();
			fileresponse.setFileName(attachment.getFileName());
			fileresponse.setFileSize(file.getSize());
			fileresponse.setDownloadUrl(downloadUrl);
			fileresponse.setFileType(file.getContentType());
			return new  ResponseEntity<>(fileresponse,HttpStatus.OK);
	}
}
	
	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception{
		
	Attachment attachment=null;
	attachment=this.FileserviceImpl.getAttachment(fileId);
	return ResponseEntity.ok()
			.contentType(MediaType.parseMediaType(attachment.getFileType()))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename\""+attachment.getFileName()+"\"")
			.body(new ByteArrayResource(attachment.getData()));
	}
}
