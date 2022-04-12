package com.sbi;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbi.layer2.Address;
import com.sbi.layer2.Applicant;
import com.sbi.layer2.ApplicationStatus;
import com.sbi.layer4.ApplicantService;
import com.sbi.layer4.ApplicantServiceImpl;

/**
 * Servlet implementation class ApplicantServlet
 */
@WebServlet("/applicant")
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicantService applService = new ApplicantServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantServlet() {
        super();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myspring.xml");
        System.out.println("ApplicantServlet() called with ctx : " + ctx);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String applAcctType = request.getParameter("actype");
		String applName = request.getParameter("appl_name");
		String applFatherName =request.getParameter("appl_father_name");
		String applDOB =request.getParameter("appl_dob");
		String applMobile =request.getParameter("appl_mobile");
		String applMaritalStatus =request.getParameter("appl_maritalstatus");
		String applOccupation =request.getParameter("appl_occupation");

		//Enter Permanent Address
		String applPermArea = request.getParameter("appl_perm_area");	
		String applPermStreet = request.getParameter("appl_perm_street");
		String applPermCity = request.getParameter("appl_perm_city");
		String applPermState = request.getParameter("appl_perm_state");
		String applPermCountry = request.getParameter("appl_perm_country");
		String applPermPincode = request.getParameter("appl_perm_pincode");	
		//Enter Permanent Address
		String applCorrArea = request.getParameter("appl_corr_area");
		String applCorrStreet = request.getParameter("appl_corr_street");
		String applCorrCity =request.getParameter("appl_corr_city");
		String applCorrState =request.getParameter("appl_corr_state");
		String applCorrCountry = request.getParameter("appl_corr_country");	
		String applCorrPincode =request.getParameter("appl_corr_pincode");
		
		String applAdhaar = request.getParameter("appl_adhaar");
		String applPanCard = request.getParameter("appl_pancard");	
		String applPhoto =request.getParameter("appl_photo");
		String applAnnualIncome =request.getParameter("appl_annual_income");
		
		Applicant applicant = new Applicant();
		applicant.setAccountType(applAcctType);
		applicant.setApplicantName(applName);
		applicant.setApplicantFatherName(applFatherName);
		
		LocalDate birthDate = LocalDate.parse(applDOB);
		applicant.setApplicantBirthDate(birthDate);
		
		Address addrPerm = new Address();
		addrPerm.setAddressType("Permanent");
		addrPerm.setArea(applPermArea);
		addrPerm.setStreet(applPermStreet);
		addrPerm.setCity(applPermCity);
		addrPerm.setState(applPermState);
		addrPerm.setCountry(applPermCountry);
		addrPerm.setPincode(Integer.parseInt(applPermPincode));
		addrPerm.setApplicant(applicant);
		
		Address addrCorr = new Address();
		addrCorr.setAddressType("Correspondance");
		addrCorr.setArea(applCorrArea);
		addrCorr.setStreet(applCorrStreet);
		addrCorr.setCity(applCorrCity);
		addrCorr.setState(applCorrState);
		addrCorr.setCountry(applCorrCountry);
		addrCorr.setPincode(Integer.parseInt(applCorrPincode));
		addrCorr.setApplicant(applicant);
		
		List<Address> addrList = new ArrayList<Address>();
		addrList.add(addrPerm);
		addrList.add(addrCorr);
		applicant.setAddressList(addrList);
		
		applicant.setMobileNumber(applMobile);
		applicant.setMarried(applMaritalStatus);
		applicant.setOccupation(applOccupation);
		
		applicant.setAdhaarNumber(applAdhaar);
		applicant.setPanCard(applPanCard);
		applicant.setPhoto(applPhoto);
		applicant.setAnnualIncome(Float.parseFloat(applAnnualIncome));
		applicant.setApplicationStatus(ApplicationStatus.APPLIED);
		
		applService.createApplicationSerice(applicant);
		
		PrintWriter pw = response.getWriter();
		pw.println("<h2>Welcome " + applName + ".</h2>");
		pw.println("<h2> Your application for account opening is successfully submitted.</h2>");
		pw.println("<a href='http://192.168.0.149:8080/MyBanking/'>Home</a>");
		System.out.println(applName + " has applied for Bank Account");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
