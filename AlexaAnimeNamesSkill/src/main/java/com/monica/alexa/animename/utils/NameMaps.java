package com.monica.alexa.animename.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.monica.alexa.animename.utils.SkillUtils;

public class NameMaps {
	
	// This class will build and store the mapping of alphabet letters to animae names.
	// Each letter potentially represents the initial of the name stated by the anime fan using this skill:
	//
	// Example: "L" initial for a first name maps to "Robo-" 
	//			"F" for middle name maps to "Soldier"
	//			"D" for last name maps to "Outlaw"
	// Thus "Lyle Frederick Douglass" would generate anime series name "Robo- Solider Outlaw".

	// These JSON files will be read from the JAR for the AWS Lambda function
	// For now, they are stored in the same directory as package "com.monica.alexa.animename.utils"
	// See ReadMe_for_Maps file in /src/main/resources folder for further explanation.
	private static final String FIRST_NAME_JSON_FILE = "FirstNameMap.json" ;
	private static final String MIDDLE_NAME_JSON_FILE = "MiddleNameMap.json" ;
	private static final String LAST_NAME_JSON_FILE = "LastNameMap.json" ;
		
	// Build the name mapping from above JSON files
	public static final HashMap<String, String> firstNameMap = buildNameMap(FIRST_NAME_JSON_FILE);
	public static final HashMap<String, String> middleNameMap = buildNameMap(MIDDLE_NAME_JSON_FILE);
	public static final HashMap<String, String> lastNameMap = buildNameMap(LAST_NAME_JSON_FILE);

	private static HashMap<String, String> buildNameMap(String JSONfile) {
	      try {
	    	 // Read JSON files to a String
	         SkillUtils skillUtils = new SkillUtils();
	         String jsonString = skillUtils.readFileInJAR(JSONfile);
	         
	         // Deserialize JSON stream from file to HashMap object
	         ObjectMapper mapper = new ObjectMapper();  
	         Map<String, String> jsonMap = new HashMap<String, String>();
	         jsonMap = mapper.readValue(jsonString, new TypeReference<Map<String, String>>(){});
	         
	         return (HashMap<String, String>) jsonMap;
	      } catch(IOException ie) {
	       ie.printStackTrace();  //Revisit error handling
	      }
	      return null; //??!! Revisit
	   }

}
