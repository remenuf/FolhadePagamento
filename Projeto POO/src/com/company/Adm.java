package com.company;
import java.util.ArrayList;
import java.util.Scanner;


public class Adm {

    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Scanner input = new Scanner(System.in);
    private int numeroDeCadastros = 0;
    private int lastId = 0;
    private Exception scan = new Exception();

    public void criarFuncionario () {
        String name;
        String address;
        double totalSalary;
        int payType;
        int id;
        int taxId;
        double sindicalTax;

        System.out.println(">>>ADICIONAR EMPREGADO<<<\n");
        System.out.println("Digite o nome");
        name = input.nextLine();

        System.out.println("Digite o endereço");
        address = input.nextLine();

        System.out.println("Digite o tipo de funcionário, 1 para horário, 2 para assalariado e 3 para comissionado");
        String type = input.nextLine();

        if (type.equals("1")) {
            System.out.println("Digite o pagamento por hora");
            double payForH = scan.getDouble();
            funcionarios.add(new Horista(name, address, "semanal 1 sexta", 0, 1, lastId, 0, 0, payForH));
        }
        else {
            System.out.println("Digite o salário do funcionário");
            double salary = scan.getDouble();
            if (type.equals("3")) {
                System.out.println("Informe a comissão por venda (em porcentagem)");
                double comission = scan.getDouble();
                funcionarios.add(new Comissionado(name, address, "semanal 2 sexta", 0, 3, lastId, 0, 0, salary, comission));
            }
            else {
                funcionarios.add(new Assalariado(name, address, "mensal $", 0, 2, lastId, 0, 0, salary));
            }
        }
        numeroDeCadastros += 1;
        lastId += 1;
        return;
    }

    public void removerFuncionario (){
        int id = scan.getFuncId(numeroDeCadastros, funcionarios);
        funcionarios.remove(id);
        System.out.println(">>>FUNCIONÁRIO REMOVIDO<<<\n");
        numeroDeCadastros -= 1;
        return;
    }

    public void cartaoPonto (){
        System.out.println(">>>REGISTRO DE PONTO<<<");
        int id = scan.getFuncId(numeroDeCadastros, funcionarios);
        if (funcionarios.get(id) instanceof  Horista) {
            Horista aux = (Horista)funcionarios.get(id);
            if (aux.getHours() == 0){
                double x = scan.getHours();
                aux.setHours(x);
                funcionarios.set(id, aux);
            }
            else {
                double y = scan.getHours();
                double x = y - aux.getHours();
                aux.setHours(0);
                double total;
                if (x > 8) total = aux.getTotalSalary() + (aux.getPayForH() * 8) + (aux.getPayForH() * 1.5 * (x - 8));
                else total = aux.getTotalSalary() + (aux.getPayForH() * x);
                aux.setTotalSalary(total);
                funcionarios.set(id, aux);
            }
            System.out.println(">>>PONTO REGISTRADO<<<\n");
        }
        else System.out.println("Funcionário não Horista selecionado, operação não utilizável");
        return;
    }

    public void resultVenda () {
        System.out.println(">>>REGISTRO DE VENDA<<<");
        int id = scan.getFuncId(numeroDeCadastros, funcionarios);
        if (funcionarios.get(id) instanceof  Comissionado){
            Comissionado aux = (Comissionado)funcionarios.get(id);
            double venda = scan.getDouble();
            aux.setTotalSalary(aux.getTotalSalary() + (venda * (aux.getComission()/100)));
            System.out.println(">>>VENDA REGISTRADA<<<\n");
        }
        else System.out.println("Funcionário não Comissionado selecionado, operação não utilizável");
        return;
    }

    public void taxaServico () {
        System.out.println(">>>LANÇAR TAXA DE SERVIÇO<<<");
        int id = scan.getSindId(numeroDeCadastros, funcionarios);
        System.out.println("Insira o valor a ser descontado");
        double taxa = scan.getDouble();
        funcionarios.get(id).setTotalSalary(funcionarios.get(id).getTotalSalary() - taxa);
        System.out.println(">>>ATUALIZAÇÃO CONCLUÍDA<<<\n");
        return;
    }

    public void modFuncionario () {
        System.out.println(">>>MODIFICAR FUNCIONÁRIO<<<");
        int id = scan.getFuncId(numeroDeCadastros, funcionarios);
        while (true){
            System.out.println("Insira o número da operação desejada\n" +
                    "[1] Alterar nome\n" +
                    "[2] Alterar endereço\n" +
                    "[3] Alterar tipo de pagamento\n" +
                    "[4] Alterar método de pagamento\n" +
                    "[5] Modificar registro sindical\n" +
                    "[6] Encerrar alterações");
            String indice = input.nextLine();
            if (indice.equals("1")){
                System.out.println("Insira o novo nome");
                funcionarios.get(id).setName(input.nextLine());
            }
            else if (indice.equals("2")){
                System.out.println("Insira o novo endereço");
                funcionarios.get(id).setAddress(input.nextLine());
            }
            else if (indice.equals("3")){
                System.out.println("Insira o novo tipo de pagamento, 1 para horário, 2 para assalariado e 3 para comissionado");
                int type = scan.getInteger();
                if (type == 1) {
                    System.out.println("Digite o pagamento por hora");
                    double payForH = scan.getDouble();
                    Horista aux = new Horista(funcionarios.get(id).getName(), funcionarios.get(id).getAddress(), funcionarios.get(id).getpayDay(), funcionarios.get(id).getTotalSalary(), 1, funcionarios.get(id).getId(), funcionarios.get(id).getTaxId(), funcionarios.get(id).getSindicalTax(), payForH);
                    funcionarios.set(id, aux);
                }
                else if (type == 2) {
                    System.out.println("Digite o salário do funcionário");
                    double salary = scan.getDouble();
                    Assalariado aux = new Assalariado(funcionarios.get(id).getName(), funcionarios.get(id).getAddress(), funcionarios.get(id).getpayDay(), funcionarios.get(id).getTotalSalary(), 2, funcionarios.get(id).getId(), funcionarios.get(id).getTaxId(), funcionarios.get(id).getSindicalTax(), salary);
                    funcionarios.set(id, aux);
                }
                else if (type == 3) {
                    System.out.println("Digite o salário do funcionário");
                    double salary = scan.getDouble();
                    System.out.println("Informe a comissão por venda (em porcentagem)");
                    double comission = scan.getDouble();
                    Comissionado aux = new Comissionado(funcionarios.get(id).getName(), funcionarios.get(id).getAddress(), funcionarios.get(id).getpayDay(), funcionarios.get(id).getTotalSalary(), 3, funcionarios.get(id).getId(), funcionarios.get(id).getTaxId(), funcionarios.get(id).getSindicalTax(), salary, comission);
                    funcionarios.set(id, aux);
                }
            }
            else if (indice.equals("4")){
                System.out.println("Insira o novo método de pagamento, 1 para depósito, 2 para cheque via correio e 3 para cheque em mãos");
                int x = scan.getInteger();
                if (0 > x && x < 4) funcionarios.get(id).setPayType(x);
                else System.out.println("Entrada inválida.");
            }
            else if (indice.equals("5")) {
                System.out.println("Insira a nova identificação dentro do sindicato");
                funcionarios.get(id).setTaxId(scan.getInteger());
                System.out.println("insira a nova taxa sindical");
                funcionarios.get(id).setSindicalTax(scan.getDouble());
            }
            else {
                System.out.println(">>>MODIFICAÇÃO CONCLUÍDA<<<");
                return;
            }
        }

    }


}
