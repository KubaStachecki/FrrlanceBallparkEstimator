package com.example.kuba_10.frrelanceballparkestimator;


public class Numbers {

    private float rate = 0;
    private float hours = 0;
    private String currency;
    private float cost = 0;

    private float bonus = 0;
    private float discount = 0;
    private float taxes = 0;

    private float workCost = 0;
    private float workSum = 0;
    private float ballpark = 0;


    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public float getWorkCost() {
        return workCost;
    }

    public void setWorkCost(float workCost) {
        this.workCost = workCost;
    }

    public float getWorkSum() {
        return workSum;
    }

    public void setWorkSum(float workSum) {
        this.workSum = workSum;
    }

    public float getBallpark() {
        return ballpark;
    }

    public void setBallpark(float ballpark) {
        this.ballpark = ballpark;
    }

    public float workCost() {

        workCost = rate * hours;

        return workCost;

    }

    public float taxesCost() {

        workCost = rate * hours;

        return (workCost /100)*taxes;

    }

    public float bonusCost() {

        workCost = rate * hours;

        return (workCost /100)*bonus;

    }

    public float discountCost() {

        workCost = rate * hours;

        return workCost - (workCost /100)*discount;

    }




    public float costSum() {

        float workAmount = workCost();

        float taxAmount = (workAmount / 100) * taxes;
        float discountAmount = (workAmount / 100) * discount;
        float bonusAmount = (workAmount / 100) * bonus;


        workSum = ((workAmount + bonusAmount + cost) - discountAmount) + taxAmount;


        return workSum;
    }


    public float ballparkMin() {

        float sum = costSum();

        return sum - ((sum/100) *10);

    }


    public float ballparkMax() {

        float sum = costSum();

        return sum + ((sum/100) *50);

    }



}
