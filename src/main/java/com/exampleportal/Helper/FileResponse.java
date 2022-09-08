package com.exampleportal.Helper;


public class FileResponse {
	
	private String fileName;
	
	private String downloadUrl;
	
	private String fileType;
	
	private long fileSize;

	public FileResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileResponse(String fileName, String downloadUrl, String fileType, long fileSize) {
		super();
		this.fileName = fileName;
		this.downloadUrl = downloadUrl;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
