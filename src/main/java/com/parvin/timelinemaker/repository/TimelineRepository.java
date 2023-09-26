package com.parvin.timelinemaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parvin.timelinemaker.entity.Timeline;

public interface TimelineRepository extends JpaRepository<Timeline, Long> {

}
