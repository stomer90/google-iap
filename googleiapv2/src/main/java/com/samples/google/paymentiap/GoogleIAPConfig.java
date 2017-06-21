package com.samples.google.paymentiap;

import java.io.Serializable;

public class GoogleIAPConfig implements Serializable{
	private static final long serialVersionUID = 1L;

	private String serviceAccount;
	
	private String pathFile;
	
	private String scopes = "https://www.googleapis.com/auth/androidpublisher";
	
	public GoogleIAPConfig(){}
	
	public GoogleIAPConfig(String serviceAccount, String pathFile){
		this.serviceAccount = serviceAccount;
		this.pathFile = pathFile;
	}
	
	public String getServiceAccount(){
		return serviceAccount == null ? "" : serviceAccount;
	}
	
	public String getPathFile(){
		return pathFile == null ? "" : pathFile;
	}
	
	public String getScopes(){
		return scopes == null ? "" : scopes;
	}

	public void setServiceAccount(String serviceAccount) {
		this.serviceAccount = serviceAccount;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}
}