package com.sahu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahu.entity.Tourist;

@Controller
public class TouristOperationsConsumerController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/list_tourist")
	public String displayTouristReport(Map<String, Object> map) throws Exception {
		//Consume Spring Rest service method/ operation
		/*
		 * URL/URI : http://localhost:3035/BootRestProj10-MiniProject01-CURDOperations/tourist/findAll
		 * Method : GET
		 * Response Content Type : application/json (default)
		 * No Path variables/ No Query String
		 */
		String serviceURL = "http://localhost:3035/BootRestProj10-MiniProject01-CURDOperations/tourist/findAll";
		ResponseEntity<String> response =template.exchange(serviceURL, HttpMethod.GET, null, String.class);
		String jsonBody = response.getBody();
		//Convert String jsonBody to List<Tourist>
		ObjectMapper mapper = new ObjectMapper();
		List<Tourist> touristList = mapper.readValue(jsonBody, new TypeReference<List<Tourist>>() {});
		//Keep results in map collection
		map.put("touristList", touristList);
		return "tourist_report";
	}
	
	//To Launch Form page
	@GetMapping("/add")
	public String show_registerTouristForm(@ModelAttribute("tst") Tourist tourist) {
		return "add_tourist";
	}
	
	@PostMapping("/add")
	public String registerTourist(RedirectAttributes attributes, @ModelAttribute("tst") Tourist tourist) throws Exception {
		//Convert object to JSON data using Jackson API
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		//invoke Spring Rest Service
		String serviceURL = "http://localhost:3035/BootRestProj10-MiniProject01-CURDOperations/tourist/register";
		//Prepare HttpEntity object (header+body)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> response =template.exchange(serviceURL, HttpMethod.POST, entity, String.class);
		String result = response.getBody();
		attributes.addFlashAttribute("resultMsg", result);
		return "redirect:list_tourist";
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id") Integer tid, @ModelAttribute("tst") Tourist tourist) throws Exception {
		//Invoke rest service
		String serviceURL = "http://localhost:3035/BootRestProj10-MiniProject01-CURDOperations/tourist/find/{id}";
		ResponseEntity<String> response =template.exchange(serviceURL, HttpMethod.GET, null, String.class, tid);
		//get JSON body from response
		String jsonBody = response.getBody();
		//Convert jsonBody to tourist object using ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Tourist tourist1 = mapper.readValue(jsonBody, Tourist.class);
		BeanUtils.copyProperties(tourist1, tourist);
		return "edit_tourist";
	}
	
	@PostMapping("/edit")
	public String editTourist(RedirectAttributes attributes,  @ModelAttribute("tst") Tourist tourist) throws Exception {
		//Convert object to JSON data using Jackson API
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		//invoke Spring Rest Service
		String serviceURL = "http://localhost:3035/BootRestProj10-MiniProject01-CURDOperations/tourist/modify";
		//Prepare HttpEntity object (header+body)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> response =template.exchange(serviceURL, HttpMethod.PUT, entity, String.class);
		String result = response.getBody();
		attributes.addFlashAttribute("resultMsg", result);
		return "redirect:list_tourist";
	}
	
}
