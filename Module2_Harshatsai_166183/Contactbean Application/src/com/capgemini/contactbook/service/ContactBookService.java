package com.capgemini.contactbook.service;

import com.capgemini.contactbook.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookService {
	
	public int addEnquiry(EnquiryBean enqry)throws ContactBookException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException;
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException;

}
