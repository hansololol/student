package com.student.student.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("studentVO")
public class StudentVO {
	private String id;
	private String pwd;
	private String name;
	private Date birth;
	private String email;
	private String imageFileName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageFileName() {
		try {
			if(imageFileName!=null && imageFileName.length()!=0) {
				imageFileName = URLDecoder.decode(imageFileName, "UTF-8");
			}
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		try {
			if(imageFileName!=null && imageFileName.length()!=0) {
				this.imageFileName = URLEncoder.encode(imageFileName, "UTF-8");
			}
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
