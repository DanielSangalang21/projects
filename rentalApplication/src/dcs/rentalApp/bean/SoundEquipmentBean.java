package dcs.rentalApp.bean;

import org.springframework.web.multipart.MultipartFile;

public class SoundEquipmentBean {
	
	
	private String equipmentId;
	private String brand;
	private String model;
	private String available;
	private String ratePerDay;
	private String picturePath;
	
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRatePerDay() {
		return ratePerDay;
	}
	public void setRatePerDay(String ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

}
