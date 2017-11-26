package com.mgmt.cust;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class FirstTest
{
	WebDriver driver;

	public static void main(String[] args)
	{
		FirstTest firstTest = new FirstTest();
		firstTest.driver = new HtmlUnitDriver(true);
		Properties prop = new Properties();
		FileInputStream input = null;
		String strUrl = "";
		String strSubmitBtn = "";

		try
		{

			input = new FileInputStream("config.properties");

//			strUrl = "http://localhost:8090/CustomerManagement/Customer%20Management_1.html";
			// load a properties file
			prop.load(input);
			
			// get the properties value
			strUrl = prop.getProperty("URL1.1");
			strSubmitBtn = prop.getProperty("SubmitBtn1.1");
			firstTest.runSubmitTest(strUrl, strSubmitBtn);
			
			strUrl = prop.getProperty("URL1.1");
			String strfieldName1 = prop.getProperty("FieldName2.1");
			String strfieldVal1 = prop.getProperty("FieldVal2.1");
			String strfieldName2 = prop.getProperty("FieldName2.2");
			String strfieldVal2 = prop.getProperty("FieldVal2.2");
			strSubmitBtn = prop.getProperty("SubmitBtn2.1");
			firstTest.runDataentryAndSubmitTest(strfieldName1, strfieldVal1, strfieldName2, strfieldVal2, strSubmitBtn);

			strfieldVal1 = prop.getProperty("FieldVal3.1");
			strfieldVal2 = prop.getProperty("FieldVal3.2");
			firstTest.runFindEnteredDataTest(strfieldVal1, strfieldVal2);
		} catch (IOException io)
		{
			io.printStackTrace();
		} finally
		{
			if (input != null)
			{
				try
				{
					input.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}


		firstTest.driver.quit();
	}

	protected void runSubmitTest(String strUrl, String strSubmitBtn)
	{
		try
		{
			write("The URL got is " + strUrl);
			driver.get(strUrl);
			String strPgTitle = driver.getTitle();
			write("Current page Title = " + strPgTitle);

			write("Going to submit this page using submit button");
			WebElement btnSubmit = driver.findElement(By.name(strSubmitBtn));
			btnSubmit.submit();

			String strPgTitle1 = driver.getTitle();
			write("New page Title = " + strPgTitle1);

		} catch (ElementNotFoundException e)
		{
			System.out.println("The searched element is not found");
		}
	}

	/*
	 * protected void runSubmitTest(String strUrl, String strText1, String
	 * strText2, String strSubmitBtn) // protected void runSubmitTest(String
	 * strUrl, "firstName", "lastName", "q") { try { write("The URL got is " +
	 * strUrl); driver.get(strUrl); String strPgTitle = driver.getTitle();
	 * System.out.println("strPgTitle = " + strPgTitle); //
	 * System.out.println("URL = " + driver.getCurrentUrl());
	 * 
	 * WebElement txtFName = driver.findElement(By.id("firstName"));
	 * txtFName.sendKeys("TestFName"); WebElement txtLName =
	 * driver.findElement(By.id("lastName")); txtLName.sendKeys("TestLName");
	 * 
	 * WebElement btnSubmit = driver.findElement(By.name("q"));
	 * btnSubmit.submit();
	 * 
	 * String strPgTitle1 = driver.getTitle();
	 * System.out.println("strPgTitle1 = " + strPgTitle1);
	 * 
	 * driver.quit(); } catch (ElementNotFoundException e) {
	 * System.out.println("The searched element is not found"); } }
	 */

	protected void runDataentryAndSubmitTest(String strfieldName1,
	        String strfieldVal1, String strfieldName2, String strfieldVal2,
	        String strSubmitBtn)
	{
		try
		{
			// write("The URL got is " + strUrl);
			// driver.get(strUrl);
			String strPgTitle = driver.getTitle();
			write("Current page Title = " + strPgTitle);
			// System.out.println("URL = " + driver.getCurrentUrl());

			// Going to put the element values into the respective elements
			write("Going to put the element value '" + strfieldVal1
			        + "' into element '" + strfieldName1 + "'");
			WebElement field1 = driver.findElement(By.id(strfieldName1));
			field1.sendKeys(strfieldVal1);
			write("Going to put the element value '" + strfieldVal2
			        + "' into element '" + strfieldName2 + "'");
			WebElement field2 = driver.findElement(By.id(strfieldName2));
			field2.sendKeys(strfieldVal2);

			write("Going to submit this page using submit button");
			WebElement btnSubmit = driver.findElement(By.name(strSubmitBtn));
			btnSubmit.submit();

			String strPgTitle1 = driver.getTitle();
			write("New page Title = " + strPgTitle1);
		} catch (ElementNotFoundException e)
		{
			System.out.println("The searched element is not found");
		}
	}

	protected void runDataentryAndSubmitTest(String strUrl,
	        String strfieldName1, String strfieldVal1, String strfieldName2,
	        String strfieldVal2, String strSubmitBtn)
	{
		try
		{
			write("The URL got is " + strUrl);
			driver.get(strUrl);
			String strPgTitle = driver.getTitle();
			write("Current page Title = " + strPgTitle);
			// System.out.println("URL = " + driver.getCurrentUrl());

			WebElement field1 = driver.findElement(By.id(strfieldName1));
			field1.sendKeys(strfieldVal1);
			WebElement field2 = driver.findElement(By.id(strfieldName2));
			field2.sendKeys(strfieldVal1);

			write("Going to submit this page using submit button");
			WebElement btnSubmit = driver.findElement(By.name(strSubmitBtn));
			btnSubmit.submit();

			String strPgTitle1 = driver.getTitle();
			write("New page Title = " + strPgTitle1);
		} catch (ElementNotFoundException e)
		{
			System.out.println("The searched element is not found");
		}
	}

	protected void runFindEnteredDataTest(String strfieldVal1,
	        String strfieldVal2)
	{
		try
		{
			// write("The URL got is " + strUrl);
			// driver.get(strUrl);
			String strPgTitle = driver.getTitle();
			write("Current page Title = " + strPgTitle);
			// System.out.println("URL = " + driver.getCurrentUrl());

			WebElement field1 = driver.findElement(By.xpath(strfieldVal1));
			WebElement field2 = driver.findElement(By.xpath(strfieldVal2));
			field2.sendKeys(strfieldVal1);

			String strPgTitle1 = driver.getTitle();
			write("New page Title = " + strPgTitle1);
		} catch (ElementNotFoundException e)
		{
			System.out.println("The searched element is not found");
		}
	}

	protected void runFindEnteredDataTest(String strUrl, String strfieldVal1,
	        String strfieldVal2)
	{
		try
		{
			write("The URL got is " + strUrl);
			driver.get(strUrl);
			String strPgTitle = driver.getTitle();
			write("Current page Title = " + strPgTitle);
			// System.out.println("URL = " + driver.getCurrentUrl());

			WebElement field1 = driver.findElement(By.id(strfieldVal1));
			WebElement field2 = driver.findElement(By.id(strfieldVal2));
			field2.sendKeys(strfieldVal1);

			String strPgTitle1 = driver.getTitle();
			write("New page Title = " + strPgTitle1);
		} catch (ElementNotFoundException e)
		{
			System.out.println("The searched element is not found");
		}
	}

	private static void write(String s)
	{
		System.out.println(s);
	}
}
