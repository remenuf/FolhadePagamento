package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Exception {

    private Scanner input = new Scanner(System.in);

    public int getInteger() {
        int newInteger;
        while(true) {
            try {
                newInteger = Integer.parseInt(input.nextLine());
                return newInteger;
            }
            catch(NumberFormatException e) {
                System.out.print("Não foi inserido um inteiro, tente novamente: ");
            }
        }
    }

    public double getDouble() {
        double newDouble;
        while(true) {
            try {
                newDouble = Double.parseDouble(input.nextLine());
                return newDouble;
            }
            catch(NumberFormatException e) {
                System.out.print("Entrada inválida, tente novamente: ");
            }
        }
    }

    public int getFuncId (int numeroDeCadastros, ArrayList<Funcionario> funcionarios){
        System.out.println("Digite o ID do funcionário");
        int id = getInteger();
        int aux;
        for (aux = 0; aux < numeroDeCadastros; aux++){
            if (id == funcionarios.get(aux).getId()) return aux;
        }
        System.out.println("ID inválido, digite novamente");
        return getFuncId(numeroDeCadastros, funcionarios);
    }

    public int getSindId (int numeroDeCadastros, ArrayList<Funcionario> funcionarios){
        System.out.println("Digite o ID sindical do funcionário");
        int id = getInteger();
        int aux;
        for (aux = 0; aux < numeroDeCadastros; aux++){
            if (id == funcionarios.get(aux).getTaxId()) return aux;
        }
        System.out.println("ID inválido, digite novamente");
        return getSindId(numeroDeCadastros, funcionarios);
    }

    private double testH(String[] aux, int i) {
        while (true){
            try{
                double aux1 = Double.parseDouble(aux[i]);
                return aux1;
            }
            catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    public double getHours (){
        System.out.println("Insira o horário atual");
        String horario = input.nextLine();
        String[] aux = horario.split(":");
        double aux1 = testH(aux, 0);
        double aux2 = testH(aux, 1);

        if (aux1 == -1 || aux2 == -1)
        {
            System.out.println("Entrada inválida, tente novamente");
            return getHours();
        }
        return aux1 + (aux2/60);
    }

}
