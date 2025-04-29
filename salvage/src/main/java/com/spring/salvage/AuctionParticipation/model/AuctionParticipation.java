package com.spring.salvage.AuctionParticipation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "auction_participation")
@Data
public class AuctionParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Bidding ID is required")
    @Column(name = "bidding_id", nullable = false)
    private Long biddingId;

    @NotBlank(message = "Bidder name is required")
    @Column(name = "bidder_name", nullable = false)
    private String bidderName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "bidder_email", nullable = false)
    private String bidderEmailId;

    @Column(name = "reason_for_participation")
    private String reasonForParticipation;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalStatus approvalStatus = ApprovalStatus.WAITINGFORAPPROVAL;

    @Column(name = "entry_date", nullable = false, updatable = false)
    private LocalDateTime entryDate = LocalDateTime.now();

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @PrePersist
    protected void onCreate() {
        entryDate = LocalDateTime.now();
    }

    public enum ApprovalStatus {
        APPROVED,
        NOTAPPROVED,
        WAITINGFORAPPROVAL
    }
}