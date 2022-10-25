package com.sahu.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sahu.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController {

	@Autowired
	private IWishMessageService messageService;

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	/*
	 * @RequestMapping("/wish") public ModelAndView showWishMessage() { //Use
	 * service String wishMessage = messageService.generateWishMessage(); //return
	 * ModelAndView object return new ModelAndView("display", "wishMsg",
	 * wishMessage); }
	 */

	// @RequestMapping("/wish")
	public String showWishMessage(BindingAwareModelMap map) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		map.addAttribute("wishMsg", wishMessage);
		// return LVN
		return "display";
	}

	// @RequestMapping("/wish")
	public String showWishMessage(ModelMap map) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		map.addAttribute("wishMsg", wishMessage);
		// return LVN
		return "display";
	}

	// @RequestMapping("/wish")
	public String showWishMessage(HashMap<String, Object> map) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		map.put("wishMsg", wishMessage);
		// return LVN
		return "display";
	}

	// @RequestMapping("/wish")
	public String showWishMessage(Map<String, Object> map) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		map.put("wishMsg", wishMessage);
		// return LVN
		return "display";
	}

	/*
	 * @RequestMapping("/wish") public String showWishMessage(Model model) { //Use
	 * service String wishMessage = messageService.generateWishMessage();
	 * model.addAttribute("wishMsg", wishMessage); //return LVN return "display"; }
	 */

	// @RequestMapping("/wish")
	public void showWishMessage(Model model) {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		model.addAttribute("wishMsg", wishMessage);
	}

	/*
	 * @RequestMapping("/wish") public Model showWishMessage() { //Use service
	 * String wishMessage = messageService.generateWishMessage(); Model model = new
	 * ExtendedModelMap(); model.addAttribute("wishMsg", wishMessage); return model;
	 * }
	 */

	// @RequestMapping("/wish")
	public Map<String, Object> showWishMessage() {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		Map<String, Object> map = new HashMap<>();
		map.put("wishMsg", wishMessage);
		return map;
	}

	@RequestMapping("/wish")
	public void showWishMessage(HttpServletResponse response) throws Exception {
		// Use service
		String wishMessage = messageService.generateWishMessage();
		//get PrintWriter pointing to response object
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<b>Wish message : </b>"+wishMessage);
		return;
	}

}
