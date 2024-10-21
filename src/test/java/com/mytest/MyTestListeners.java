package com.mytest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListeners implements ITestListener {


	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Pass :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test execution Failed :" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test execution Started :" + result.getName());
	}

}
