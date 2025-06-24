package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

public class DataUtility {
	public String getDataFromProperties(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("./TestData/DemoWebShop.properties"));
		return prop.getProperty(key);
	}

	public String getDataFromExcel(String sheetName, int rowIndex, int cellIndex)
			throws FileNotFoundException, IOException {
		return WorkbookFactory.create(new FileInputStream("./TestData/Book1.xlsx")).getSheet(sheetName).getRow(rowIndex)
				.getCell(cellIndex).toString();
	}

	public Object[][] getAllDataFromExcel(String sheetName)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Sheet sheet = WorkbookFactory.create(new FileInputStream("./TestData/Book1.xlsx")).getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		Object[][] data = new Object[rowCount - 1][];
		for (int i = 1; i < rowCount; i++) {
			int cellCount = sheet.getRow(i).getPhysicalNumberOfCells();
			data[i - 1] = new Object[cellCount];
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	
	public  JsonNode[] jsonTree(String testCasename) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode dataNode = mapper.readTree(new File("./TestData/userdata.json")).get(testCasename);
		
		JsonNode[] data = new JsonNode[dataNode.size()];
		int index = 0 ;
		for (JsonNode jsonNode : dataNode) {
			data[index++] = jsonNode ;
		}
		return data ;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) throws IOException {
		System.out.println("Hi");
//		jsonTree("TC1");
	}

	public static String jsonPath() throws IOException {
		String json = new String(Files.readAllBytes(Paths.get("./TestData/userdata.json")));
		
		Object fullName = JsonPath.read(json, "$.TC1");

		System.out.println( fullName);
		return "" ;
	}

	
	@SuppressWarnings("unchecked")
	public static void getDataFromJson() throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> dataList = null;
		dataList = mapper.readValue(new File("./TestData/userdata.json"), new TypeReference<Map<String, Object>>() {
		});

		Map<String, String> map = (Map<String, String>) dataList.get("TC1");
		System.out.println(map);
		System.out.println("==========================");

		String email = map.get("email");
		System.out.println(email);

	}

}
