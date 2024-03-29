package com.yptask.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LatLng implements Serializable {

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("longitude")
	private String longitude;

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"LatLng{" + 
			"latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}