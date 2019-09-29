package com.example.europa.model;

import javax.persistence.*;

@Entity
@Table(name = "RESEARCH")
public class Research {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORGANIZATION")
    private String organization;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PICTURE")
    private byte[] picture;

    @Column(name = "DISCOVERED")
    private Long discovered;

    @Column(name = "CURRENT_BUDGET")
    private Long currentBudget;

    @Column(name = "TOTAL_BUDGET")
    private Long totalBudget;

    @Column(name = "BUDGETING_PERCENT")
    private Long budgetingPercent;

    public Research() {
    }

    public Research(String name, String organisation, String description, byte[] picture, Long discovered, Long currentBudget, Long totalBudget, Long budgetingPercent) {
        this.name = name;
        this.organization = organisation;
        this.description = description;
        this.picture = picture;
        this.discovered = discovered;
        this.currentBudget = currentBudget;
        this.totalBudget = totalBudget;
        this.budgetingPercent = budgetingPercent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Long getDiscovered() {
        return discovered;
    }

    public void setDiscovered(Long discovered) {
        this.discovered = discovered;
    }

    public Long getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(Long currentBudget) {
        this.currentBudget = currentBudget;
    }

    public Long getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Long totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Long getBudgetingPercent() {
        return budgetingPercent;
    }

    public void setBudgetingPercent(Long budgetingPercent) {
        this.budgetingPercent = budgetingPercent;
    }
}
