package com.company;
import java.util.Calendar;
import java.util.Scanner;

import java.util.ArrayList;

public class Agenda {

    private Scanner input = new Scanner(System.in);
    private Exception scan = new Exception();

    public void newAgenda (ArrayList<String> agenda){
        System.out.println(">>>CRIAR NOVA AGENDA<<<");
        System.out.println("Digite a agenda que deseja criar");
        agenda.add(input.nextLine());
        System.out.println(">>>NOVA AGENDA ADICIONADA<<<\n");
        return;
    }

    public void alterarAgenda (ArrayList<Funcionario> funcionarios, ArrayList<String> agenda){
        System.out.println(">>>ALTERAR AGENDA<<<");
        System.out.println("Digite o número da agenda desejada");
        int id = scan.getFuncId(funcionarios.size() ,funcionarios);
        int i;
        for (i = 0; i < agenda.size() ; i++){
            System.out.println("[" + i + "] " + agenda.get(i));
        }
        funcionarios.get(id).setPayday(agenda.get(scan.getInteger()));
        return;
    }

    public int diaUtil (Calendar data){
        int j = 0;
        int aux = -1;
        while (true){
            if (data.get(Calendar.DAY_OF_MONTH) == 1 && j != 0){
                data.add(Calendar.DAY_OF_MONTH, -1);
                if (data.get(Calendar.DAY_OF_WEEK) == 1){
                    aux = data.get(Calendar.DAY_OF_MONTH) - 2;
                }
                else if (data.get(Calendar.DAY_OF_WEEK) == 7){
                    aux = data.get(Calendar.DAY_OF_MONTH) - 1;
                }
                else aux = data.get(Calendar.DAY_OF_MONTH);

                data.add(Calendar.DAY_OF_MONTH, -(j - 1));
                break;
            }
            data.add(Calendar.DAY_OF_MONTH, 1);
            j+= 1;
        }
        return aux;
    }
}
