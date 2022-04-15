package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Applicant;


@Service
public interface ApplicantService {
	void createApplicationService(Applicant app);
	List<Applicant> getAllApplicantsService();
	void modifyApplicationService(Applicant applicant);
	void removeApplicationService(int applicantId);
	Applicant findApplicationService(int applicantId);
}