package com.pac2;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;



public class CreateorgTest  extends BaseClass{
	

	@Test(groups="regressionTest")
	public void createorgtest() {
		System.out.println("execute createorgtest  & Verify");
	}

	@Test(groups="smokeTest")
	public void CreateOrgwithIndustry() {
		System.out.println("execute createContactWithDate   & Verify");
	}


}
