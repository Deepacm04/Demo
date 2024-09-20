package pojo;
//creating POJO class for the json

import java.util.List;

public class AddPlace {
private int accuracy;
private String name;
private String phone_number;
private String address;
private String language;
private String Website;
//since location has anothe sub json  as shown below, so have created another class and calling that class here
//"location": {
//"lat": -38.383494,
//"lng": 33.427362 },
//here type is Location class object
private Location location;
//type has an array as shown below, where we are passing list<retruntype>
//"types": [
//"shoe park",
//"shop"
//],
private List<String>types;

public int getAccuracy() {
	return accuracy;
}
public void setAccuracy(int accuracy) {
	this.accuracy = accuracy;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getWebsite() {
	return Website;
}
public void setWebsite(String website) {
	Website = website;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}
public List<String> getTypes() {
	return types;
}
public void setTypes(List<String> types) {
	this.types = types;
}




}
