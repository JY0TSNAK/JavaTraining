package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Applicant;
import com.example.demo.layer4.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
	
	
	@Autowired
	ApplicantService applicantService;
	
	public ApplicantController() {
		System.out.println("ApplicantController() constructor...");
	}
	
	@RequestMapping("/getApplicants") 
	public List<Applicant> getAllApplicants() {
		System.out.println("/getApplicants");
		return applicantService.getAllApplicantsService();
	}
	
	@RequestMapping("/getApplicant/{applno}") 
	public Applicant getAnApplicant(@PathVariable("applno") int applicantNumToSearch) {
		System.out.println("/getApplicant");
		
		Applicant applicantObject = applicantService.findApplicationService(applicantNumToSearch);
		
		if (applicantObject != null) {
			return applicantObject;
		}
		else {
			throw new RuntimeException("Applicant Not Found");
		}
	}
	
	@RequestMapping("/deleteApplicant/{applno}") 
	public String deleteAnApplicant(@PathVariable("applno") int applicantNumToRemove) {
		System.out.println("/deleteApplicant");
		
		Applicant applicantObject = applicantService.findApplicationService(applicantNumToRemove);
		
		if (applicantObject != null) {
			applicantService.removeApplicationService(applicantNumToRemove);
			return "Application deleted sucessfully : " + applicantNumToRemove;
		}
		else {
			return "Applicant Not Found";
		}
	}
	
	@RequestMapping("/updateAnApplicant") 
	public String updateAnApplicant(@RequestBody Applicant applicantObjectToModify) {
		System.out.println("/updateAnApplicant");
		
		Applicant applicantObject = applicantService.findApplicationService(applicantObjectToModify.getApplicantId());
		
		if (applicantObject != null) {
			applicantService.modifyApplicationService(applicantObject);
			return "Application updated sucessfully : " + applicantObjectToModify.getApplicantId();
		}
		else {
			return "Applicant Not Found";
		}
	}
	
	@RequestMapping("/addAnApplicant") 
	public String addAnApplicant(@RequestBody Applicant applicantObjectToAdd) {
		System.out.println("/addAnApplicant");
		
		Applicant applicantObject = applicantService.findApplicationService(applicantObjectToAdd.getApplicantId());
		
		if (applicantObject != null) {
			return "Applicant already exists Found";
		}
		else {
			applicantService.createApplicationService(applicantObject);
			return "Application created sucessfully : " + applicantObjectToAdd.getApplicantId();
		}
	}
	
	
}
