package com.capgemini.contactbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;

import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl implements ContactBookService {
	ContactBookDao contactbookdao=new ContactBookDaoImpl();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		int enqrySeq;
		enqrySeq=contactbookdao.addEnquiry(enqry);
		return enqrySeq;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)throws ContactBookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry)throws ContactBookException {
		// TODO Auto-generated method stub
		 List<String> validationErrors =new ArrayList<String>();  
		 System.out.println("validation");
		 if(!(isValidateContactNo(enqry.getContactNo())))
			{
				validationErrors.add("\n The contact number should be 10 digits only \n");
			}
			if(!(isValidateFirstName(enqry.getfName())))
			{
				validationErrors.add("\n First Name should be in Alphabets and minimum 3 Characters long!\n");
			}

			if(!(isValidLastName(enqry.getlName())))
			{
				validationErrors.add("\n Donar Name should be in Alphabets and minimum 3 Characters long!\n");
			}

			

			if(!(isValidatePLocation(enqry.getpLocation())))
			{
				validationErrors.add("\n Location should be in Alphabets and minimum 3 Characters long!\n");
			}
			if(!(isValidatePDomain(enqry.getpDomain())))
			{
				validationErrors.add("\n Domain should be in Alphabets and minimum 3 Characters long!\n");
			}
			if(!validationErrors.isEmpty())throw new ContactBookException(validationErrors +"");
			return false;
			
			
			  }
	public boolean isValidateContactNo(String contactNo) {
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(contactNo);
		
		return phoneMatcher.matches();
	}
	public boolean isValidateFirstName(String getfName) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(getfName);
		return nameMatcher.matches();
	}
	public boolean isValidLastName(String getlName) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(getlName);
		return nameMatcher.matches();
	}
	public boolean isValidatePLocation(String getpLocation) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(getpLocation);
		return nameMatcher.matches();
	}

	public  boolean isValidatePDomain(String getpLocation) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(getpLocation);
		return nameMatcher.matches();
	}
		
}
