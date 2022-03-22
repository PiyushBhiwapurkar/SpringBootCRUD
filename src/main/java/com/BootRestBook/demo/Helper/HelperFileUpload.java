package com.BootRestBook.demo.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HelperFileUpload {

	//public final String FILE_DIR = "C:\\Work\\JAVA\\Projects\\Learning\\BootRestBook_withDB\\src\\main\\resources\\static\\Images";
	public final String FILE_DIR = new ClassPathResource("/static/Images").getFile().getAbsolutePath();
	
	public HelperFileUpload() throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile fileToUpload)
	{
		boolean status = false;
		
		try {
			
//			// Read Input file data
//			InputStream is = fileToUpload.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			//Write to LocalDirectory
//			FileOutputStream fos = new FileOutputStream(FILE_DIR+File.separator+fileToUpload.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			status = true;
			
			Files.copy(fileToUpload.getInputStream(),Paths.get(FILE_DIR+File.separator+fileToUpload.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		return status;
	}
	
}
