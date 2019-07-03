package com.company;

public class Assalariado extends Funcionario {

    private double salary;

    public Assalariado(String name, String address, String payday, double totalSalary, int payType, int id, int taxId, double sindicalTax, double salary) {
        super(name, address, payday, totalSalary, payType, id, taxId, sindicalTax);
        this.salary = salary;
    }

    public double getSalary (){
        return salary;
    }
    public void setSalary (double salary){
        this.salary = salary;
    }

}
