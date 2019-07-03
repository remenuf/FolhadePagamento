package com.company;

public class Horista extends Funcionario{

    private double hours;
    private double payForH;

    public Horista(String name, String address, String payday, double totalSalary, int payType, int id, int taxId, double sindicalTax, double payForH){
        super(name, address, payday, totalSalary, payType, id, taxId, sindicalTax);
        this.payForH = payForH;
        this.hours = 0;
    }

    public double getPayForH (){
        return payForH;
    }
    public double getHours (){
        return hours;
    }

    public void setPayForH (double payForH){
        this.payForH = payForH;
    }
    public void setHours (double hours){
        this.hours = hours;
    }

}
