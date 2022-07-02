package service;

import model.Funcionario;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int qtdFunciorios;
        boolean encerrar = false;
        List<Funcionario> funcionarios = new ArrayList<>();
        Scanner sacnner = new Scanner(System.in);
        do {
            System.out.println("Quantos funcionários serão cadastrados?");
            qtdFunciorios = sacnner.nextInt();

            for (int i = 0; i < qtdFunciorios; i++) {
                Funcionario funcionario = new Funcionario();
                System.out.println("ID: ");
                funcionario.setId(sacnner.nextLong());

                System.out.println("Nome: ");
                funcionario.setNome(sacnner.next());

                System.out.println("Salario: ");
                funcionario.setSalario(sacnner.nextDouble());

                funcionarios.add(funcionario);
            }

            System.out.println("Qual funcionário vc gostaria de mostrar? (por id)");
            long idSelecionado = sacnner.nextLong();
            System.out.println(funcionarios.stream().filter(x -> x.getId() == idSelecionado).collect(Collectors.toList()));
            System.out.println("Encerrar? [s/n]");
            if(sacnner.next().equalsIgnoreCase("s")){
                encerrar = true;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n ****************************************");
        }while (!encerrar);
    }
}
