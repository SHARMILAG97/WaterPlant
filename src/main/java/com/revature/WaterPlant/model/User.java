package com.revature.WaterPlant.model;

import java.time.LocalDate;

public class User {

	private  String Name;
	private  String Pwd;
	private  long Mobileno;
	private String Address;
	private  int Cans;
	private LocalDate date;
	private  int Id;
    private  int Reservecan;
	private  int RId;
	private int Ordercan;
	private int Addcan;
	private  int OId;
	private String Rstatus;
	
	public String getRstatus() {
		return Rstatus;
	}
	public void setRstatus(String rstatus) {
		Rstatus = rstatus;
	}
	public int getOId() {
		return OId;
	}
	public void setOId(int oId) {
		this.OId = oId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		this.Status = status;
	}
	private String Status;
	
	public int getAddcan() {
		return Addcan;
	}
	public void setAddcan(int addcan) {
		this.Addcan = addcan;
	}
	public int getOrdercan() {
		return Ordercan;
	}
	public void setOrdercan(int ordercan) {
		this.Ordercan = ordercan;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		this.Pwd = pwd;
	}
	public long getMobileno() {
		return Mobileno;
	}
	public void setMobileno(long mobileno) {
		this.Mobileno = mobileno;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public int getCans() {
		return Cans;
	}
	public void setCans(int cans) {
		this.Cans = cans;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public int getReservecan() {
		return Reservecan;
	}
	public void setReservecan(int reservecan) {
		this.Reservecan = reservecan;
	}
	public int getRId() {
		return RId;
	}
	public void setRId(int rId) {
		this.RId = rId;
	}
	
	

}
