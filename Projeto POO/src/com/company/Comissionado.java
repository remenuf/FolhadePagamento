package com.company;

public class Comissionado extends Assalariado {

    private double comission;

    public Comissionado(String name, String address, String payday, double totalSalary, int payType, int id, int taxId, double sindicalTax, double salary, double comission) {
        super(name, address, payday, totalSalary, payType, id, taxId, sindicalTax, salary);
        this.comission = comission;
    }

    public double getComission () {return comission;}
    public void setComission (double comission) {this.comission = comission;}
}
