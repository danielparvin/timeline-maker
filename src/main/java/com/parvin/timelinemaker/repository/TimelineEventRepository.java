package com.parvin.timelinemaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parvin.timelinemaker.entity.TimelineEvent;

public interface TimelineEventRepository extends JpaRepository<TimelineEvent, Long> {

}
