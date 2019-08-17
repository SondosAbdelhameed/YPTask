package com.yptask.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CityResponse implements Serializable {

	@SerializedName("lng")
	private String lng;

	@SerializedName("city")
	private String city;

	@SerializedName("lat")
	private String lat;

	public void setLng(String lng){
		this.lng = lng;
	}

	public String getLng(){
		return lng;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"CityResponse{" +
			"lng = '" + lng + '\'' + 
			",city = '" + city + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}