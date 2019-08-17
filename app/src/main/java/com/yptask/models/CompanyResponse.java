package com.yptask.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CompanyResponse implements Serializable {

	@SerializedName("city")
	private String city;

	@SerializedName("companyName")
	private String companyName;

	@SerializedName("latLng")
	private LatLng latLng;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setLatLng(LatLng latLng){
		this.latLng = latLng;
	}

	public LatLng getLatLng(){
		return latLng;
	}

	@Override
 	public String toString(){
		return 
			"CompanyResponse{" + 
			"city = '" + city + '\'' + 
			",companyName = '" + companyName + '\'' + 
			",latLng = '" + latLng + '\'' + 
			"}";
		}
}