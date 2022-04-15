package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Applicant;
import com.example.demo.layer3.ApplicantRepository;


@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepository appRepo;
	
	@Override
	public void createApplicationService(Applicant app) {
		
		appRepo.createApplication(app);
		System.out.println("ApplicantServiceImpl() : created the applicants data.....");

	}
	
	@Override
	public List<Applicant> getAllApplicantsService() {
		return appRepo.findAllApplicants();
	}

	@Override
	public void modifyApplicationService(Applicant applicant) {
		appRepo.modifyApplication(applicant);
	}

	@Override
	public void removeApplicationService(int applicantId) {
		appRepo.removeApplication(applicantId);
	}

	@Override
	public Applicant findApplicationService(int applicantId) {
		return appRepo.findApplication(applicantId);
	}

}
