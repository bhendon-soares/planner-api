package com.rocketseat.planner_api.activities;

import com.rocketseat.planner_api.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.activityRepository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }
}