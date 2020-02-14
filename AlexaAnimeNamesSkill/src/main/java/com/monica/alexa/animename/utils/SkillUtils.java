package com.monica.alexa.animename.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.monica.alexa.animename.utils.PersonNames;

public class SkillUtils {
   
    public static String generateYourName(String statedName) {
    	
     // This method is the entry point for the intent handler that generates the anime name
    	
   	 String yourName = "";    	 
   	 if (!isNullOrEmpty(statedName)) {
   		 // Parse out individual names
   		 ArrayList<String> statedNameList = getParsedNames(statedName);
   		 
   		 // Instantiate PersonNames to get mapped Anime Names
   		 // If more than three stated, only use first three.
   		 // Will call constructor for either two or three names, depending on what anime fan told Alexa
   		 if (statedNameList.size()==3) {
   			 String firstName = statedNameList.get(0);
   			 String middleName = statedNameList.get(1);
   			 String lastName = statedNameList.get(2);
   			 PersonNames personNames = new PersonNames (firstName, middleName, lastName);
   			 yourName = personNames.getAnimeWholeName();
   		 } else {
   			 String firstName = statedNameList.get(0);
   			 String lastName = statedNameList.get(1); 
   			 // If no middle name provided, PersonNames will default a phantom name!
   			 PersonNames personNames = new PersonNames (firstName, lastName);
   			 yourName = personNames.getAnimeWholeName();
   		 }
   	 }
   	 return yourName;  // yourName variable name chosen in honor of the anime award-winning film "Your Name" :-)
   }
	
    private static ArrayList<String> getParsedNames(String statedName) { 
 
    	// Separate out each individual name stated by the anime fan talking to Alexa.
    	// We are assuming that Alexa will only insert one space between each name uttered by anime fan.
    	String[] nameList = statedName.split(" ");

    	//  If more than three names were derived, then only use first three
    	ArrayList<String> cleansedNameList = new ArrayList<String>();
        for(int i=0; (i<nameList.length & i<3); i++){
        	cleansedNameList.add(nameList[i]);
        	}  	
    	return cleansedNameList;
    }
    
	static boolean isNullOrEmpty(String str) {
		if ((str != null) && !str.trim().isEmpty())
			return false;
		else
			return true;
	}
	
	String readFileInJAR(String filePath) throws IOException 
	{
		  // We included JSON files with the mappings of anime names to alphabet letters in the project JAR
		  // This method will read those files into a Stream, so they can be converted to HashMap by calling method
		  InputStream is = getClass().getResourceAsStream(filePath);
		  InputStreamReader isr = new InputStreamReader(is);
		  BufferedReader br = new BufferedReader(isr);
		  StringBuffer sb = new StringBuffer();
		  String line;
		  while ((line = br.readLine()) != null) 
		  {
		    sb.append(line);
		  }
		  br.close();
		  isr.close();
		  is.close();
		  return sb.toString();
	}
	
}
