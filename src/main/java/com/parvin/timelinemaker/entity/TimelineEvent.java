package com.parvin.timelinemaker.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "timeline_events")
public class TimelineEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timeline_event_id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "timeline_id")
	private Timeline timeline;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "date_precision")
	private DatePrecision datePrecision;

	public TimelineEvent() {}

	public TimelineEvent(Timeline timeline, String name, String description, LocalDate date,
			DatePrecision datePrecision) {
		this.timeline = timeline;
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

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
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

	public DatePrecision getDatePrecision() {
		return datePrecision;
	}

	public void setDatePrecision(DatePrecision datePrecision) {
		this.datePrecision = datePrecision;
	}
}
