package com.test.monica.alexa.animename;

import com.monica.alexa.animename.utils.SkillUtils;

public class TestClass {
	
	private static void testgenerateYourName() {
			
		String statedName1 = "Crist Maria Alexander";
		System.out.println(statedName1 + " = " + SkillUtils.generateYourName(statedName1));
		
		String statedName2 = "Crist Maria Alexander Diva";
		System.out.println(statedName2 + " = " + SkillUtils.generateYourName(statedName2));
		
		String statedName3 = "Monica Renneke";
		System.out.println(statedName3 + " = " + SkillUtils.generateYourName(statedName3));
		
		String statedName4 = "Monica Lynn Renneke";
		System.out.println(statedName4 + " = " + SkillUtils.generateYourName(statedName4));
		
		String statedName5 = "James T Kirk";
		System.out.println(statedName5 + " = " + SkillUtils.generateYourName(statedName5));
		
		// !! Need to expand validation to handle this situation with one name.
		//    Decide if we want to default a generated name, as we did with "phantom" for middle name
		//	  , or do we tell the anime fan that they must at least state first and last  name?
		/*
		String statedName5 = "Monica";
		System.out.println(statedName5 + " = " + SkillUtils.generateYourName(statedName5));
		*/
	}

	public static void main(String[] args) {

		testgenerateYourName();

	}

}
