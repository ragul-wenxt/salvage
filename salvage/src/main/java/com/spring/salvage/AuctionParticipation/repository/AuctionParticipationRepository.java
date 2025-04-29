package com.spring.salvage.AuctionParticipation.repository;



import com.spring.salvage.AuctionParticipation.model.AuctionParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuctionParticipationRepository extends JpaRepository<AuctionParticipation, Long> {
    List<AuctionParticipation> findByBiddingId(Long biddingId);
    List<AuctionParticipation> findByBidderEmailId(String bidderEmailId);
    List<AuctionParticipation> findByApprovalStatus(AuctionParticipation.ApprovalStatus approvalStatus);
}