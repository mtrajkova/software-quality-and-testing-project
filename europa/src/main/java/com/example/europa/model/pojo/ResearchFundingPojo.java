package com.example.europa.model.pojo;

public class ResearchFundingPojo {
    private String personalId;
    private String researchId;
    private String funds;

    public ResearchFundingPojo() {
    }

    public ResearchFundingPojo(String personalId, String researchId, String funds) {
        this.personalId = personalId;
        this.researchId = researchId;
        this.funds = funds;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }
}
