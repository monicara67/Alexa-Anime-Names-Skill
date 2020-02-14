package com.monica.alexa.animename.utils;

public class PersonNames {
	
	// This class does the following:
	//
	// - Obtain the initials of the name stated by the anime fan.
	// - Use the initials as key in name hashmaps to obtain the mapped anime first, middle and last name.
	// - Expose the anime names for the intent handlers via public getter method.
    
    private String animeFirstName;
    private String animeMiddleName;
    private String animeLastName;
	
    //For stated names with no middle name this will map to a default anime name.
    //middleNameMap has an entry for "NONE" in addition to the alphabet letters.
    private static final String NO_NAME= "NONE";  
    
	public PersonNames(String firstName,String lastName) {
	   	this.animeFirstName = NameMaps.firstNameMap.get(this.getInitial(firstName) );
	   	this.animeLastName = NameMaps.lastNameMap.get(this.getInitial(lastName));
	   	// There is an anime name mapped to key "NONE" in middleNameMap, for cases with no middle name
	   	// Chained constructor below will override middleName correctly, if middleName is in instantiation
	   	this.animeMiddleName = NameMaps.middleNameMap.get(NO_NAME);
	} 
	
	public PersonNames(String firstName, String middleName, String lastName ) {		
		// Override middle name from above chained constructor with the middleName passed in   	
		this(firstName, lastName); 
    	this.animeMiddleName = NameMaps.middleNameMap.get(this.getInitial(middleName));
	}
 
	private String getInitial(String myName) {
		if (!SkillUtils.isNullOrEmpty(myName)) 
			return myName.substring(0,1).toUpperCase();
		else
			return(NO_NAME);
	}
	
	public String getAnimeWholeName() {
		// remember that there is a default anime name for null middle name in middleNameMap
		return this.animeFirstName + " " + this.animeMiddleName + " " + this.animeLastName;
	}
}