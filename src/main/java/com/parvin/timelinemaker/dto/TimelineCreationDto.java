package com.parvin.timelinemaker.dto;

import java.util.ArrayList;
import java.util.List;

public class TimelineCreationDto {
	private String name;
	private List<TimelineEventCreationDto> events;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TimelineEventCreationDto> getEvents() {
		return events;
	}

	public void setEvents(List<TimelineEventCreationDto> events) {
		if (events == null) {
			this.events = new ArrayList<>();
		}
		
		this.events = events;
	}
}
