package com.exampleportal.Entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId",nullable=false)
	private int id;
	
	@Column(name="username",nullable=false)
	@NotNull
	@NotBlank(message="Username Required")
	@Size(min=5, message="Username must be minimum of 5 characters")
	private String username;
	
	@NotEmpty(message="Password Required")
	@Size(min=5, message="Password must be min of 5 character.")
	
	@Column(name="password",nullable=false)
	private String password;
	
	@NotEmpty(message="First Name Required")
	@Size(min=5, max=10, message="First Name must be min of 3 character and maximum of 10 character")
	@Column(name="firstName",nullable=false)
	private String firstName;
	
	@NotEmpty(message="Last Name Required")
	@Size(min=5, max=10, message="Last Name must be min of 3 character and maximum of 10 character")
	
	private String lastName;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Request> requests;
	
	@NotEmpty(message="Email Required")
	private String email;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Score> scores;
	
	
	@OneToMany(mappedBy="user" ,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore()
	private List<MyOrder> myorder=new ArrayList<>();
	
	
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	@NotEmpty(message="Last Name Required")
	@Size(min=10,max=10, message="Phone Number must be 10 digit Long")
	@Column(nullable=false)
	private String phone;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", profile=" + profile
				+ ", userRoles=" + userRoles + ", enabled=" + enabled + "]";
	}
	private String profile;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	@JsonIgnore()
	private List<UserRole> userRoles=new ArrayList<>();
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	private boolean enabled=true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public User(int id, String username, String password, String firstName, String lastName, String email, String phone,
			String profile, boolean enabled,List<Score> scores) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.profile = profile;
		this.enabled = enabled;
		this.scores=scores;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		 List<Authority> authority=new ArrayList<>();
		 this.userRoles.forEach((userrole)->{
			authority.add(new Authority(userrole.getRole().getRoleName()));
		 });

		return authority;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	
	

}
