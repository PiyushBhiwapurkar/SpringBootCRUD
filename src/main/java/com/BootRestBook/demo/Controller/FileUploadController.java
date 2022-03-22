package com.BootRestBook.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BootRestBook.demo.Helper.HelperFileUpload;

@RestController
public class FileUploadController {

	@Autowired
	private HelperFileUpload helperFileUpload;

	@PostMapping("/fileUpload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile fileToUpload)
	{
//		System.out.println(fileToUpload.getName());
//		System.out.println(fileToUpload.getOriginalFilename());
//		System.out.println(fileToUpload.getSize());
//		System.out.println(fileToUpload.getContentType());
//		System.out.println(fileToUpload.isEmpty());
		
		
		if(fileToUpload.isEmpty())
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Size should be more than 1 KB");
		
		if(!fileToUpload.getContentType().equals("image/jpeg"))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG format are allowed");
		
		boolean uploadFileStatus = helperFileUpload.uploadFile(fileToUpload);
		System.out.println(uploadFileStatus);
		if(uploadFileStatus)
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Images/").path(fileToUpload.getOriginalFilename()).toUriString());
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}
