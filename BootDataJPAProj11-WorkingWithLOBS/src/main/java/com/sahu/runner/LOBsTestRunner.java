package com.sahu.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.entity.MarriageSeeker;
import com.sahu.service.IMatrimonyServiceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner {
	
	@Autowired
	private IMatrimonyServiceMgmt matrimonyServiceMgmt;
	
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Person Name : ");
		String name  = scanner.next();
		System.out.print("Enter Person Address : ");
		String address  = scanner.next();			
		System.out.print("Is Person Indian : ");
		boolean indian  = scanner.nextBoolean();	
		System.out.print("Enter Person Photo file complete Path  : ");
		String photoPath  = scanner.next();
		System.out.print("Enter Person Bio-Data file complete Path  : ");
		String biodataPath  = scanner.next();
		//Prepare byte[] representing photo file
		InputStream is = new FileInputStream(photoPath);
		byte[] photoData = is.readAllBytes();
		//Prepare char[] representing biodata file
		File file = new File(biodataPath);
		Reader reader = new FileReader(file);
		char[] biodataContent = new char[(int)file.length()];
		reader.read(biodataContent);
		//Prepare Entity class object
		MarriageSeeker marriageSeeker = new MarriageSeeker(name, address,
				LocalDateTime.of(1990, 11, 23, 12, 45),
				indian, photoData, biodataContent);
		System.out.println(matrimonyServiceMgmt.registerMarriageSeeker(marriageSeeker));
		
		Optional<MarriageSeeker> optional = matrimonyServiceMgmt.searchMarriageSeekerById(4l);
		if (optional.isPresent()) {
			MarriageSeeker seeker = optional.get();
			System.out.println(seeker.getId()+" "+seeker.getName()+" "+seeker.getAddress()+" "+seeker.getIndian());
			OutputStream os = new FileOutputStream("retrieve_photo.png");
			os.write(seeker.getPhoto());
			os.flush();
			os.close();
			Writer writer = new FileWriter("retrieve_biodata.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			writer.close();
			System.out.println("LOBs are retrieved");
		} 
		else {
			System.out.println("Record is not found");
		}
	}

}
