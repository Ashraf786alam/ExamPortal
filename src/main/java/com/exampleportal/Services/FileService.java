package com.exampleportal.Services;

import org.springframework.web.multipart.MultipartFile;

import com.exampleportal.Entity.Attachment;

public interface FileService {

	Attachment saveFile(MultipartFile file) throws Exception;

	Attachment getAttachment(String fileId) throws Exception;

}
