package com.healthify.api.entity;

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

/**
 * @author RAM
 *
 */
@Entity
@Table(name = "ward")
public class Ward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ward_id",nullable = false,unique = true)
	private long wardId;
	
	@Column(name = "name",nullable = false,unique = true)
	private String name;
	
	@Column(name = "ward_type",nullable = false)
	private String wardType; // 'General Ward,' 'Private Ward,' 'Intensive Care Unit,' 'Pediatric Ward,' 'Maternity Ward etc
	
	@Column(name = "capacity",nullable = false)
	private int capacity;
	
	@Column(name = "current_occupancy",nullable =  false,columnDefinition = "int DEFAULT 0")		
	private int currentOccupancy;
	
	@Column(name="is_available",nullable = false,columnDefinition = "boolean DEFAULT true")
	private boolean isAvailable;
	
	@Column(name = "discription")
	private String description;
	
	@OneToMany(mappedBy = "ward", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bed> beds;
	
	public Ward() {
	}

	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWardType() {
		return wardType;
	}

	public void setWardType(String wardType) {
		this.wardType = wardType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurrentOccupancy() {
		return currentOccupancy;
	}

	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
	
	

}
