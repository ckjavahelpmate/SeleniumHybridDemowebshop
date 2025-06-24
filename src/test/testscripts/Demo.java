package com.demowebshop.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import genericlibrary.DataUtility;

public class Demo {

	@Test(dataProvider = "data")
	public void name(JsonNode data) {
		System.out.println("Test started");
		System.out.println( data.get("fullName"));
	}

	@DataProvider
	public JsonNode[] data() throws IOException {
		DataUtility dataUtility = new DataUtility();
		return dataUtility.jsonTree("TC1");
	}

}
