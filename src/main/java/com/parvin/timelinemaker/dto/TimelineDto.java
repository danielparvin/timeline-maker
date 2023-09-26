package com.parvin.timelinemaker.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.parvin.timelinemaker.entity.Timeline;
import com.parvin.timelinemaker.entity.TimelineEvent;

public class TimelineDto {
	private Long id;
	private String name;
	private LocalDateTime createdOn;
	private List<TimelineEventDto> events;

	public static TimelineDto from(Timeline timeline) {
		TimelineDto timelineDto = new TimelineDto();
		Long timelineId = timeline.getId();
		String timelineName = timeline.getName();
		timelineDto.setId(timelineId);
		timelineDto.setName(timelineName);
		timelineDto.setCreatedOn(timeline.getCreatedOn());
		List<TimelineEventDto> timelineEventDtos = new ArrayList<>();
		for (TimelineEvent timelineEvent : timeline.getTimelineEvents()) {
			TimelineEventDto timelineEventDto = TimelineEventDto.from(timelineEvent);
			timelineEventDtos.add(timelineEventDto);
		}
		timelineDto.setEvents(timelineEventDtos);
		return timelineDto;
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public List<TimelineEventDto> getEvents() {
		return events;
	}

	public void setEvents(List<TimelineEventDto> events) {
		this.events = events;
	}
}
