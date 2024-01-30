package com.healthify.api.entity;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.healthify.api.annotations.NotBeforeCurrentDate;
/**
 * @author RAM
 *
 */
@Entity
public class DoctorsTimeOff {

	@Id
	@Column(unique = true, nullable = false)
	private long timeoffId;
	
	@Column(nullable = false)
	private String doctorUserame;
	
	@Column(nullable = false)
	private boolean dayOff;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotBeforeCurrentDate
	private Date timeOffDate;
	
	@Column(length = 255)
	private String description ;

    @OneToMany(mappedBy = "doctorTimeOff", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<Slots> unavailableTimeSlots;

	public DoctorsTimeOff() {
	}

	public long getTimeoffId() {
		return timeoffId;
	}

	public void setTimeoffId(long timeoffId) {
		this.timeoffId = timeoffId;
	}

	public String getDoctorUserame() {
		return doctorUserame;
	}

	public void setDoctorUserame(String doctorUserame) {
		this.doctorUserame = doctorUserame;
	}

	public Date getTimeOffDate() {
		return timeOffDate;
	}

	public void setTimeOffDate(Date timeOffDate) {
		this.timeOffDate = timeOffDate;
	}

	public boolean getDayOff() {
		return dayOff;
	}

	public void setDayOff(boolean dayOff) {
		this.dayOff = dayOff;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Slots> getUnavailableTimeSlots() {
		return unavailableTimeSlots;
	}

	public void setUnavailableTimeSlots(Set<Slots> unavailableTimeSlots) {
		this.unavailableTimeSlots = unavailableTimeSlots;
	}

	
	

	
}
