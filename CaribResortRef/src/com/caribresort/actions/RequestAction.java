package com.caribresort.actions;

public interface RequestAction {
	//Bartender Actions
	String SERVE="SERVE";
	String OPEN="OPEN";
	
	//Customer Actions
	String MAKEORDER = "MAKEORDER";
	String ADDITEMTOORDER="ADDITEMTOORDER";
	
	//Manager Actions
	String GENERATEREPORT = "GENERATEREPORT";
    String ADDDRINK = "ADDDRINKR";
	String REMOVEDRINK = "REMOVEDRINK";
	String UPDATEDRINK = "UPDATEDRINK";
	
	//All User Actions
	String VIEWDRINKS = "VIEWDRINKS";
	String VIEWDRINKTYPES = "VIEWDRINKTYPES";
}
