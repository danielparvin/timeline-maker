package com.parvin.timelinemaker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parvin.timelinemaker.dto.IdDto;
import com.parvin.timelinemaker.dto.TimelineCreationDto;
import com.parvin.timelinemaker.dto.TimelineDto;
import com.parvin.timelinemaker.service.TimelineService;

@RestController
@RequestMapping("/timelines")
@CrossOrigin
public class TimelineController {
	@Autowired
	private TimelineService timelineService;
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<TimelineDto> byId(@PathVariable long id) {
		Optional<TimelineDto> optionalTimeline = timelineService.getTimelineById(id);
		if (optionalTimeline.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(optionalTimeline.get());
		}
	}

	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<IdDto> createNewTimeline(@RequestBody TimelineCreationDto timelineCreationDto) {
		IdDto timelineIdDto = timelineService.createTimeline(timelineCreationDto);
		return ResponseEntity.ok().body(timelineIdDto);
	}
}
