package com.sahu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sahu.entity.MarriageSeekerInfo;
import com.sahu.model.MarriageSeeker;
import com.sahu.service.IMatrimonyMgmtService;

@Controller
public class MatrimonyOperationController {

	@Autowired
	private IMatrimonyMgmtService matrimonyMgmtService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private ServletContext context;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(@ModelAttribute("seeker") MarriageSeeker seeker) {
		return "register_profile";
	}

	@PostMapping("/register")
	public String registerMarriageSeeker(@ModelAttribute("seeker") MarriageSeeker seeker, Map<String, Object> map) throws Exception {
		//Get the folder location to store uploaded files 
		String location = environment.getProperty("upload.store");
		File locationStore = new File(location);
		//Crate Location folder if it is not already available
		if(!locationStore.exists())
			locationStore.mkdir();
		//Get original names of the uploaded files
		MultipartFile resumeFile = seeker.getResume();
		MultipartFile photoFile = seeker.getPhoto();
		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();
		//Create InputStreams representing the Uploaded files
		InputStream resumeIStream = resumeFile.getInputStream();
		InputStream photoIStream = photoFile.getInputStream();
		//Create OutputStreams pointing destination file o the server machine file system
		OutputStream resumeOStream = new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photoOStream = new FileOutputStream(location+"/"+photoFileName);
		//Complete copy operation among the streams
		IOUtils.copy(resumeIStream, resumeOStream);
		IOUtils.copy(photoIStream, photoOStream);
		//Close Streams
		resumeIStream.close(); resumeOStream.close();
		photoIStream.close(); photoOStream.close();
		//Create Entity class object
		MarriageSeekerInfo seekerInfo = new MarriageSeekerInfo();
		seekerInfo.setProfileName(seeker.getProfileName());
		seekerInfo.setGender(seeker.getGender());
		seekerInfo.setResumePath(location+"/"+resumeFileName);
		seekerInfo.setPhotoPath(location+"/"+photoFileName);
		//Use service
		String message = matrimonyMgmtService.registerProfile(seekerInfo);
		//Create model attributes
		map.put("resumeFile", resumeFileName);
		map.put("photoFile", photoFileName);
		map.put("resultMsg", message);
		//return LVN
		return "show_result";
	}
	
	@GetMapping("/display")
	public String displayProfile(Map<String, Object> map){
		Iterable<MarriageSeekerInfo> seekerList = matrimonyMgmtService.getAllProfiles();
		map.put("seekersInfo", seekerList);
		//return LVN
		return "show_profiles";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("file") String filePath, HttpServletResponse response) throws Exception {
		//create java.io.File object pointing to the file to be download
		File file = new File(filePath);
		//Get length of the file and make it as the response content length 
		response.setContentLengthLong(file.length());
		//Get the MIME type of the file to be download and make it as the response content type
		String mimeType = context.getMimeType(filePath);
		mimeType= mimeType!=null?mimeType:"application/octet-stream";
		response.setContentType(mimeType);
		//Create InputStream pointing to the file to be downloaded
		InputStream inputStream = new FileInputStream(filePath);
		//Create OutputStream pointing to the response object
		OutputStream outputStream=response.getOutputStream();
		//give instruction to browser to make the received content as the download file
		response.setHeader("content-Disposition", "attachment;fileName="+file.getName());
		//Copy file to be download content to response object.
		IOUtils.copy(inputStream, outputStream);
		//close the streams
		inputStream.close();
		outputStream.close();
		//This indicate  respose should go to browser directly with out taking the support of ViewResolver and View components.
		return null;
	}
	
}
