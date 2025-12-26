package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"vendor_id", "invoiceNumber"})
)
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private String invoiceNumber;
    private Double amount;
    private LocalDate invoiceDate;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User uploadedBy;

    private LocalDateTime uploadedAt;

    @PrePersist
    public void prePersist() {
        uploadedAt = LocalDateTime.now();
    }

    // getters & setters
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public Vendor getVendor() { return vendor; }

    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }
    public User getUploadedBy() { return uploadedBy; }

    public void setCategory(Category category) { this.category = category; }
    public Category getCategory() { return category; }

    public void setAmount(Double amount) { this.amount = amount; }
    public Double getAmount() { return amount; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
}
