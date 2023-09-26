package com.parvin.timelinemaker.dto;

import java.time.LocalDate;

import com.parvin.timelinemaker.entity.TimelineEvent;

public class TimelineEventDto {
	Long id;
	String name;
	String description;
	LocalDate date;
	String datePrecision;

	public static TimelineEventDto from(TimelineEvent timelineEvent) {
		Long timelineEventId = timelineEvent.getId();
		String timelineEventName = timelineEvent.getName();
		String timelineEventDescription = timelineEvent.getDescription();
		LocalDate timelineEventDate = timelineEvent.getDate();
		String timelineEventDatePrecision = timelineEvent.getDatePrecision().toString();
		return new TimelineEventDto(timelineEventId, timelineEventName, timelineEventDescription, timelineEventDate,
				timelineEventDatePrecision);
	}

	public TimelineEventDto() {}

	public TimelineEventDto(Long id, String name, String description, LocalDate date, String datePrecision) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.datePrecision = datePrecision;
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
