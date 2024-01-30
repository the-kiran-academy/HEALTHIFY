package com.healthify.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "beds")
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bed_id")
    private Long id;

    @Column(name = "bed_number")
    private int bedNumber;

    // Other bed attributes and getters/setters

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToOne(mappedBy = "bed", fetch = FetchType.LAZY)
    private Admission admission;

   public Bed() {
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getBedNumber() {
	return bedNumber;
}

public void setBedNumber(int bedNumber) {
	this.bedNumber = bedNumber;
}

public Ward getWard() {
	return ward;
}

public void setWard(Ward ward) {
	this.ward = ward;
}

public Admission getAdmission() {
	return admission;
}

public void setAdmission(Admission admission) {
	this.admission = admission;
}
   
}

