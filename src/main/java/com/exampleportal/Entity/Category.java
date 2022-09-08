package com.exampleportal.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;
	
	private String title;
	
	private String description;
	
	
	
    @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
    @JsonIgnore
	private List<Quiz> quizes=new ArrayList<>();
	public List<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
