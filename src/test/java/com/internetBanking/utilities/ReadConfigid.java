package com.internetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigid {

	Properties pro;

	
	public ReadConfigid()
	{
		File src = new File("./Configurations/configUserId.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	public String getid01()
	{
		String id01 = pro.getProperty("id1");
		return id01;
	}
	
	public String getid02()
	{
		String id02 = pro.getProperty("id2");
		return id02;
	}
	
	public String getid03()
	{
		String id03 = pro.getProperty("id3");
		return id03;
	}
	public String getid04()
	{
		String id04 = pro.getProperty("id4");
		return id04;
	}
	public String getid05()
	{
		String id05 = pro.getProperty("id5");
		return id05;
	}
	
	
}
