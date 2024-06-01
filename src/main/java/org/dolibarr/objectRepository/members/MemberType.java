package org.dolibarr.objectRepository.members;

public class MemberType {
    private String label;
    private String selectStatus;
    private String natureOfMember;
    private String subscriptionStatus;
    private String amount;
    private String anyAmount;
    private String vote;
    private String durationValue;
    private String durationType;
    private String comment;
    private String welcomeMail;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(String selectStatus) {
        this.selectStatus = selectStatus;
    }

    public String getNatureOfMember() {
        return natureOfMember;
    }

    public void setNatureOfMember(String natureOfMember) {
        this.natureOfMember = natureOfMember;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAnyAmount() {
        return anyAmount;
    }

    public void setAnyAmount(String anyAmount) {
        this.anyAmount = anyAmount;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(String durationValue) {
        this.durationValue = durationValue;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWelcomeMail() {
        return welcomeMail;
    }

    public void setWelcomeMail(String welcomeMail) {
        this.welcomeMail = welcomeMail;
    }
}
