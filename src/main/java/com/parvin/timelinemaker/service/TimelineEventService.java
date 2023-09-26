package com.parvin.timelinemaker.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parvin.timelinemaker.dto.IdDto;
import com.parvin.timelinemaker.dto.TimelineEventCreationDto;
import com.parvin.timelinemaker.entity.DatePrecision;
import com.parvin.timelinemaker.entity.Timeline;
import com.parvin.timelinemaker.entity.TimelineEvent;
import com.parvin.timelinemaker.repository.TimelineEventRepository;

@Service
public class TimelineEventService {
	@Autowired
	private TimelineEventRepository timelineEventRepository;

	public IdDto createTimelineEvent(Timeline timeline, TimelineEventCreationDto timelineEventCreationDto) {
		String timelineEventName = timelineEventCreationDto.getName();
		String timelineEventDescription = timelineEventCreationDto.getDescription();
		LocalDate timelineEventDate = timelineEventCreationDto.getDate();
		DatePrecision timelineEventDatePrecision = DatePrecision
				.fromShortName(timelineEventCreationDto.getDatePrecision());
		TimelineEvent timelineEvent = new TimelineEvent(timeline, timelineEventName, timelineEventDescription,
				timelineEventDate, timelineEventDatePrecision);
		TimelineEvent savedTimelineEvent = timelineEventRepository.save(timelineEvent);
		Long savedTimelineEventId = savedTimelineEvent.getId();
		return new IdDto(savedTimelineEventId);
	}
}
