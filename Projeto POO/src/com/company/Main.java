package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Exception scan = new Exception();
        Adm admin = new Adm();
        FolhaDePagamento payroll = new FolhaDePagamento();
        Agenda modAgenda = new Agenda();
        Calendar data = Calendar.getInstance();
        ArrayList<String> agenda = new ArrayList<String>();
        agenda.add("semanal 1 sexta");
        agenda.add("semanal 2 sexta");
        agenda.add("mensal $");

        int lastDay = modAgenda.diaUtil(data);
        int dayC = 0;

        while (true){
            while (true){
                if (dayC == 14) dayC = 0;
                if (data.get(Calendar.DAY_OF_MONTH) == 1) lastDay = modAgenda.diaUtil((data));
                System.out.printf("%02d/%02d/%d\n", data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH) + 1, data.get(Calendar.YEAR));
                System.out.println("SELECIONE A OPERAÇÃO DESEJADA\n\n" +
                        "[0]  Listar Funcionários\n" +
                        "[1]  Adicionar funcionário\n" +
                        "[2]  Remover funcionário\n" +
                        "[3]  Lançar cartão de ponto\n" +
                        "[4]  Lançar resultado de venda\n" +
                        "[5]  Lançar taxa de serviço\n" +
                        "[6]  Modificar dados de um funcionário\n" +
                        "[7]  Rodar folha de pagamento do dia\n" +
                        "[8]  Desfazer\n" +
                        "[9]  Refazer\n" +
                        "[10] Alterar agenda de pagamento\n" +
                        "[11] Criar nova agenda de pagamento\n" +
                        "[12] Encerrar o dia\n" +
                        "[13] Encerrar o programa");
                int index = scan.getInteger();
                if (index > 0 && index < 9){

                }
                switch (index) {
                    case 0:
                        for (int f = 0; f < admin.funcionarios.size(); f++)
                        {
                            System.out.printf("%d ................. %s\n", f, admin.funcionarios.get(f).getName());
                        }
                        break;
                    case 1:
                        admin.criarFuncionario();
                        break;
                    case 2:
                        admin.removerFuncionario();
                        break;
                    case 3:
                        admin.cartaoPonto();
                        break;
                    case 4:
                        admin.resultVenda();
                        break;
                    case 5:
                        admin.taxaServico();
                        break;
                    case 6:
                        admin.modFuncionario();
                        break;
                    case 7:
                        payroll.pay(admin.funcionarios, agenda, data, lastDay, dayC);
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        modAgenda.alterarAgenda(admin.funcionarios, agenda);
                        break;
                    case 11:
                        modAgenda.newAgenda(agenda);
                        break;
                    case 12:
                        data.add(Calendar.DAY_OF_MONTH, 1);
                        break;
                    case 13:
                        return;
                }
            }
        }
    }
}
