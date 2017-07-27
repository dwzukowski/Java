package com.dave.review.models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.dave.review.models.User;

@Entity
@Table(name="rings")
public class Ring {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=2, max=100)
	private String name;
	private boolean pickedUp;
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")
	private User user;
	
	public Ring(){
	}
	public Ring(String name){
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date(); 
		this.setPickedUp(false);
	}
    @PrePersist
    protected void onCreate(){
            this.createdAt= new Date();
    }
    @PreUpdate
    protected void onUpdate(){
            this.updatedAt = new Date();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isPickedUp() {
		return pickedUp;
	}
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	
}
