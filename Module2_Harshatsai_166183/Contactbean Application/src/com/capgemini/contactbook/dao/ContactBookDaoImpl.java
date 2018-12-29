package com.capgemini.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DBConnection;
import com.igate.contactbook.bean.EnquiryBean;
public class ContactBookDaoImpl implements ContactBookDao {

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		 int  enqryId=(Integer) null;
			try {
				Connection connection=DBConnection.getConnection() ;
				PreparedStatement p=null;
				ResultSet rs=null;
				Statement s = null;
			 
			
				     p = connection.prepareStatement("insert into enquiry values(enquiries_seq.nextval,?,?,?,?)");
				       p.setString(1, enqry.getfName());
				       p.setString(2, enqry.getlName());
				       p.setString(3, enqry.getContactNo());
				       p.setString(4, enqry.getpDomain());
				       p.setString(5, enqry.getpLocation());
				       p.executeUpdate();
				       s=connection.createStatement();
				       rs=s.executeQuery("select * from enquiry");
				       while(rs.next())
				       {
				    	   enqryId=rs.getInt(1);
				       }
				       return enqryId;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return enqryId;
	
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)throws Exception {
		Connection connection=DBConnection.getConnection();
		List<EnquiryBean>li=new ArrayList<>();
		try {
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery("select * from enquiry");
			while(rs.next()){
				EnquiryBean enquirybean=new EnquiryBean();
				enquirybean.setEnqryId(rs.getInt(1));
				enquirybean.setfName(rs.getString(2));
				enquirybean.setlName(rs.getString(3));
				enquirybean.setContactNo(rs.getString(4));
				enquirybean.setpDomain(rs.getString(5));
				enquirybean.setpLocation(rs.getString(6));
			li.add(enquirybean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return (EnquiryBean) li;
	}
   
	}


