package com.customer.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.customer.entity.DummyApiClass;

@RestController
public class DummyTestController {

	@Value("${external.api.url}")
	private String dummyExternalApi;

	@RequestMapping("/")
	public LocalDate getdate() {
		System.out.println("today's date " + LocalDate.now());
		return LocalDate.now();
	}

	@RequestMapping("/home")
	public ModelAndView homePage() {
		System.out.println("Home page called....");
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@GetMapping("/api")
	public ResponseEntity<DummyApiClass[]> dummyApi() {
		RestTemplate restTemplate = new RestTemplate();
		DummyApiClass[] response = restTemplate.getForObject(dummyExternalApi, DummyApiClass[].class);
		/* return restTemplate.getForObject(dummyApi, DummyApiClass.class); */
		/* DummyApiClass[] employees = response.getBody(); */
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/api-jsp")
	public ModelAndView dummyApiJspView() {
		ModelAndView mav = new ModelAndView("dummyData");
		RestTemplate restTemplate = new RestTemplate();
		DummyApiClass[] response = restTemplate.getForObject(dummyExternalApi, DummyApiClass[].class);
		mav.addObject("dummydata", response);
		return mav;
	}

}
