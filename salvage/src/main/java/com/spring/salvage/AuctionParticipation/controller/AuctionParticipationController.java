package com.spring.salvage.AuctionParticipation.controller;

import com.spring.salvage.AuctionParticipation.model.AuctionParticipation;
import com.spring.salvage.AuctionParticipation.service.AuctionParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin
public class AuctionParticipationController {
    private final AuctionParticipationService participationService;

    @Autowired
    public AuctionParticipationController(AuctionParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping("/auction-participation")
    public ResponseEntity<AuctionParticipation> createParticipation(
            @RequestBody AuctionParticipation participation) {
        AuctionParticipation created = participationService.createParticipation(participation);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/auction-participation/{id}")
    public ResponseEntity<AuctionParticipation> getParticipationById(@PathVariable Long id) {
        return ResponseEntity.ok(participationService.getParticipationById(id));
    }

    @GetMapping("/auction-participation/bidding/{biddingId}")
    public ResponseEntity<List<AuctionParticipation>> getParticipationsByBiddingId(
            @PathVariable Long biddingId) {
        return ResponseEntity.ok(participationService.getParticipationsByBiddingId(biddingId));
    }

    @PatchMapping("/auction-participation/{id}/approval")
    public ResponseEntity<AuctionParticipation> updateApprovalStatus(
            @PathVariable Long id,
            @RequestParam AuctionParticipation.ApprovalStatus status) {
        return ResponseEntity.ok(participationService.updateApprovalStatus(id, status));
    }
}
