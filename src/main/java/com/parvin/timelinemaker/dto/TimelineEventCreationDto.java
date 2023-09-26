package com.parvin.timelinemaker.dto;

import java.time.LocalDate;

public class TimelineEventCreationDto {
	private String name;
	private String description;
	private LocalDate date;
	private String datePrecision;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDatePrecision() {
		return datePrecision;
	}
	public void setDatePrecision(String datePrecision) {
		this.datePrecision = datePrecision;
	}
}
