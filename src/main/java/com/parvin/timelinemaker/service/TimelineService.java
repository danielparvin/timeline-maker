package com.parvin.timelinemaker.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parvin.timelinemaker.dto.IdDto;
import com.parvin.timelinemaker.dto.TimelineCreationDto;
import com.parvin.timelinemaker.dto.TimelineDto;
import com.parvin.timelinemaker.dto.TimelineEventCreationDto;
import com.parvin.timelinemaker.entity.Timeline;
import com.parvin.timelinemaker.repository.TimelineRepository;

@Service
public class TimelineService {
	@Autowired
	private TimelineRepository timelineRepository;
	@Autowired
	private TimelineEventService timelineEventService;

	public IdDto createTimeline(TimelineCreationDto timelineCreationDto) {
		String timelineName = timelineCreationDto.getName();
		Timeline timeline = new Timeline(timelineName);
		timeline.setCreatedOn(LocalDateTime.now());
		Timeline savedTimeline = timelineRepository.save(timeline);
		for (TimelineEventCreationDto timelineEventCreationDto : timelineCreationDto.getEvents()) {
			timelineEventService.createTimelineEvent(savedTimeline, timelineEventCreationDto);
		}
		Long savedId = savedTimeline.getId();
		return new IdDto(savedId);
	}

	public Optional<TimelineDto> getTimelineById(long id) {
		Optional<Timeline> optionalTimeline = timelineRepository.findById(id);
		if (optionalTimeline.isPresent()) {
			Timeline timeline = optionalTimeline.get();
			TimelineDto timelineDto = TimelineDto.from(timeline);
			return Optional.of(timelineDto);
		} else {
			return Optional.empty();
		}
	}
}
