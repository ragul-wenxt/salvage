package com.spring.salvage.AuctionParticipation.service;

import com.spring.salvage.AuctionParticipation.model.AuctionParticipation;
import com.spring.salvage.AuctionParticipation.repository.AuctionParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionParticipationService {

    private final AuctionParticipationRepository repository;

    @Autowired
    public AuctionParticipationService(AuctionParticipationRepository repository) {
        this.repository = repository;
    }

    public AuctionParticipation createParticipation(AuctionParticipation participation) {
        return repository.save(participation);
    }

    public AuctionParticipation getParticipationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participation not found with id: " + id));
    }

    public List<AuctionParticipation> getParticipationsByBiddingId(Long biddingId) {
        return repository.findByBiddingId(biddingId);
    }

    public AuctionParticipation updateApprovalStatus(Long id, AuctionParticipation.ApprovalStatus status) {
        AuctionParticipation participation = getParticipationById(id);
        participation.setApprovalStatus(status);
        participation.setApprovalDate(LocalDateTime.now());
        return repository.save(participation);
    }
}
