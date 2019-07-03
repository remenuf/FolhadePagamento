package com.company;

public class Funcionario {
    private String name;
    private String address;
    private String payday;
    private double totalSalary;
    private int payType;
    private int id;
    private int taxId;
    private double sindicalTax;

    int check = 1;

    public Funcionario (String name, String address, String payday, double totalSalary, int payType, int id, int taxId, double sindicalTax){
        this.name = name;
        this.address = address;
        this.payday = payday;
        this.totalSalary = totalSalary;
        this. payType = payType;
        this.id = id;
        this.taxId = id;
        this.sindicalTax = sindicalTax;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getpayDay(){
        return payday;
    }
    public double getTotalSalary(){
        return totalSalary;
    }
    public int getPayType(){
        return payType;
    }
    public int getId(){
        return id;
    }
    public int getTaxId(){
        return taxId;
    }
    public double getSindicalTax(){
        return sindicalTax;
    }
    public int getCheck () {
        return check;
    }

    public void setName (String name){
        this.name = name;
    }
    public void setAddress (String address){
        this.address = address;
    }
    public void setPayday (String payday){
        this.payday = payday;
    }
    public void setTaxId (int taxId){
        this.taxId = taxId;
    }
    public void setSindicalTax (double sindicalTax){
        this.sindicalTax = sindicalTax;
    }
    public void setPayType (int payType) {
        this.payType = payType;
    }
    public void setTotalSalary (double totalSalary) {
        this.totalSalary = totalSalary;
    }
    public void setCheck (int check) {
        this.check = check;
    }

}
