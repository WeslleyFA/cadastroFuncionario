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
        boolean idValido;
        List<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Quantos funcionários serão cadastrados?");
            qtdFunciorios = scanner.nextInt();

            for (int i = 0; i < qtdFunciorios; i++) {
                Funcionario funcionario = new Funcionario();
                System.out.println("Digite o ID: ");
                idValido = false;
                while(!idValido){
                    long idDigitado = scanner.nextLong();

                    if(!funcionarios.stream().filter(x -> x.getId() == idDigitado).collect(Collectors.toList()).isEmpty()){
                        System.out.println("Já existe um funcionário com esse ID, insira um novo");
                    }else{
                        funcionario.setId(idDigitado);
                        idValido = true;
                    }
                }

                System.out.println("Digite o Nome: ");
                funcionario.setNome(scanner.next());

                System.out.println("Digite o Salário: ");
                funcionario.setSalario(scanner.nextDouble());

                funcionarios.add(funcionario);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ****************************************");
            }

            System.out.println("Qual funcionário vc gostaria de mostrar?");
            System.out.println("ID's cadastrados: ");
            for(Funcionario f : funcionarios){
                System.out.println(" - " +f.getId());
            }

            idValido = false;
            long guardaIdSelecionado = 0L;
            while(!idValido){
                long idSelecionado = scanner.nextLong();
                if(funcionarios.stream().filter(x -> x.getId() == idSelecionado).collect(Collectors.toList()).isEmpty() ){
                    System.out.println("Não existe um funcionário com esse ID, tente novamente");
                }else{
                    idValido = true;
                    guardaIdSelecionado = idSelecionado;
                }
            }

            long finalGuardaIdSelecionado = guardaIdSelecionado;
            System.out.println(funcionarios.stream().filter(x -> x.getId() == finalGuardaIdSelecionado).collect(Collectors.toList()));
            System.out.println("Encerrar? [s/n]");
            if(scanner.next().equalsIgnoreCase("s")){
                encerrar = true;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ****************************************");
        }while (!encerrar);
    }
}
