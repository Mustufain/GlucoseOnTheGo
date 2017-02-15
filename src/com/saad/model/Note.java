package com.saad.model;

public class Note {
	private int id;
	private int feelingid;
	private String date;
	private String note;
	private String glucose;
	private String basal;
	private String bolus;
	private String carbohydrates;
	private String caloried;
	private String weight;
	private String ketones;
    private String number;
    private String Nurse_Num;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getfeelingId() {
		return feelingid;
	}

	public void setfeelingId(int feelingid) {
		this.feelingid = feelingid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGlucose() {
		return glucose;
	}

	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}

	public String getBasal() {
		return basal;
	}

	public void setBasal(String basal) {
		this.basal = basal;
	}

	public String getBolus() {
		return bolus;
	}

	public void setBolus(String bolus) {
		this.bolus = bolus;
	}

	public String getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String getCaloried() {
		return caloried;
	}

	public void setCaloried(String caloried) {
		this.caloried = caloried;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getKetones() {
		return ketones;
	}

	public void setKetones(String ketones) {
		this.ketones = ketones;
	}
	public void setNumber(String number)
	{
		this.number=number;
		
	}
	public String getNumber()
	{
		
		return number;
	}
	public void setNurse_num(String Nurse_Num)
	{
		this.Nurse_Num=Nurse_Num;
	}
	
	public String getNurse_Num()
	{
		return Nurse_Num;
	}
}
