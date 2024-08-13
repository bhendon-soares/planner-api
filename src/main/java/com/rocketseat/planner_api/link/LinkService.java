package com.rocketseat.planner_api.link;

import com.rocketseat.planner_api.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.title(), payload.url(), trip);

        this.linkRepository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

//    public List<LinkData> getAllLinksFromId(UUID tripId) {
//        return this.linkRepository.findByTripId(tripId).stream().map(activity
//                -> new ActivityData(activity.getId(), activity.getTitle(), activity.getOccursAt())).toList();
//    }
}
