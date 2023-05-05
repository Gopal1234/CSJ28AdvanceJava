package model;

import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Student_Table")
@NamedQuery(name = "updateQuery" ,query = "update Student s set s.phoneNumber=:p1,s.cityAddress=:p2 where s.studentId=:p4")
public class Student {
	@Id
	@GeneratedValue
	private int studentId;
	private String studentName;
	private String studentPassord;
	private long phoneNumber;
	private LocalDate dob;
	private String gender;
	private String courses;
	private String cityAddress;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPassord() {
		return studentPassord;
	}
	public void setStudentPassord(String studentPassord) {
		this.studentPassord = studentPassord;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String getCityAddress() {
		return cityAddress;
	}
	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}
	
	

}
