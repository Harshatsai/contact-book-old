package com.capgemini.contactbook.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;

import com.igate.contactbook.bean.EnquiryBean;
public class Client {
	//User Interface which display the operation menu to add an enquiry,search an enquiry.
	//Create object for service and execute the respective methods
	static Scanner scan=new Scanner(System.in);
	static ContactBookService contactbookService=null;
	static ContactBookServiceImpl contactbookServiceImpl=null;
	public static void main(String[] args) {

		EnquiryBean enquiryBean=null;
		int enqryId = 0;
		int option=0;
		while(true){
			
			System.out.println("*************Global Recruitments***************");
			System.out.println("Choose an operation");
			System.out.println("1.Enter Enquiry Details");
			System.out.println("2.View Enquiry Details on Id ");
			System.out.println("0.Exit");
			System.out.println("Please enter a choice:");
			try {
				option=scan.nextInt();
				switch (option) {
				case 1:
					while(enquiryBean==null){
						enquiryBean=populateEnquiryBean();
						
					}
					try {
						contactbookService=new ContactBookServiceImpl();
						enqryId=contactbookService.addEnquiry(enquiryBean);
						System.out.println("Thank You "+enquiryBean.getfName() +enquiryBean.getlName() +
								" Your Unique Id is "+enqryId+ "We will cintact you shortly" );
					} catch (ContactBookException sportsException) {
						System.out.println("error"+sportsException.getMessage());
						
					}
					
					finally{
						enqryId=(Integer) null;
						contactbookService=null;
						enquiryBean=null;
						
					}
					break;
				case 2:
					try {
						contactbookService=new ContactBookServiceImpl();
						System.out.println("Enter sports id:");
						System.out.println(contactbookService.getEnquiryDetails(scan.nextInt()));
						
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					break;
					
					
		    	case 3:
					System.out.println("Your out of the page please try again");
					System.exit(0);
					break;
				default:
					break;
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			       }
		}
		}
	
	private static EnquiryBean populateEnquiryBean(){
		EnquiryBean enquiryBean=new EnquiryBean();
		System.out.println("Enter First Name");
		 enquiryBean.setfName(scan.next());
		System.out.println("Enter Last Name");
		enquiryBean.setlName(scan.next());
		System.out.println("Enter Contact Number");
		enquiryBean.setContactNo(scan.next());
		System.out.println("Enter Preferred Domain");
		enquiryBean.setpDomain(scan.next());
		System.out.println("Enter Preferred Location");
		 enquiryBean.setpLocation(scan.next());
		return enquiryBean;
	
		
	}

}
