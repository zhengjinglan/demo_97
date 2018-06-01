package com.aaa.demo.entity;

public class Emps {
	private Integer employeeID;
	private String lastName;
	private String title;
	private String birthDate;
	private Integer Age;
	private String hireDate;
	private Integer hireAge;
	private String address;
	private String pwd;
	private String homePhone;
	private String photo;
	private String notes;
	private Integer reportsTo;

	public Emps() {
		super();
	}

	public Emps(Integer employeeID, String lastName, String homePhone) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.homePhone = homePhone;
	}

	public Emps(String lastName, String birthDate, String hireDate,
			String address, String pwd, String homePhone) {
		super();
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.pwd = pwd;
		this.homePhone = homePhone;
	}

	public Emps(String lastName, String title, String birthDate,
			String hireDate, String address, String pwd, String homePhone,
			String photo, String notes, Integer reportsTo) {
		super();
		this.lastName = lastName;
		this.title = title;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.pwd = pwd;
		this.homePhone = homePhone;
		this.photo = photo;
		this.notes = notes;
		this.reportsTo = reportsTo;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public Integer getHireAge() {
		return hireAge;
	}

	public void setHireAge(Integer hireAge) {
		this.hireAge = hireAge;
	}

	@Override
	public String toString() {
		return "Emps [employeeID=" + employeeID + ", lastName=" + lastName
				+ ", title=" + title + ", birthDate=" + birthDate + ", Age="
				+ Age + ", hireDate=" + hireDate + ", hireAge=" + hireAge
				+ ", address=" + address + ", pwd=" + pwd + ", homePhone="
				+ homePhone + ", photo=" + photo + ", notes=" + notes
				+ ", reportsTo=" + reportsTo + "]";
	}

}
