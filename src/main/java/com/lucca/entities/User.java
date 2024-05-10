package com.lucca.entities;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "_User")
public class User {	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;

 	@Column(unique=true)
	private String username;

	private String password;

	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String city;
	private String country;
	private String startDate;

	@Transient
	private Integer holidayCountDays;

	@Column(nullable = true)
	private Integer managerId;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="note_user",joinColumns = @JoinColumn(name="user_id") ,
			inverseJoinColumns = @JoinColumn(name="note_id"))
	private List<Note> notes = new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
			   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne
	@JoinColumn(name = "note_id")
	private Note note;

	@OneToMany(mappedBy = "user")
	private List<Request> requests = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Interview> interviews = new ArrayList<>();

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getHolidayCountDays() {
		if (this.getStartDate() != null){

			return 2* Period.between(LocalDate.parse(this.getStartDate()), LocalDate.now()).getMonths();
		}
		return 0;
	}

	public void setHolidayCountDays(Integer holidayCountDays) {
		this.holidayCountDays = holidayCountDays;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	private int monthsBetween(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("Both startDate and endDate must be provided");
		}

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		int startDateTotalMonths = 12 * startCalendar.get(Calendar.YEAR)
				+ startCalendar.get(Calendar.MONTH);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		int endDateTotalMonths = 12 * endCalendar.get(Calendar.YEAR)
				+ endCalendar.get(Calendar.MONTH);

		return endDateTotalMonths - startDateTotalMonths;
	}
}
