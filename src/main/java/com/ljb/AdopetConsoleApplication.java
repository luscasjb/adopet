package com.ljb;

import com.ljb.command.CommandExecutor;
import com.ljb.command.pets.ImportPetsCommand;
import com.ljb.command.pets.ListPetsCommand;
import com.ljb.command.shelter.ListShelterCommand;
import com.ljb.command.shelter.RegisterShelterCommand;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

        CommandExecutor executor = new CommandExecutor();

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int chosenOption = 0;
            while (chosenOption != 5) {
                showMenu();

                String textoDigitado = new Scanner(System.in).nextLine();
                chosenOption = Integer.parseInt(textoDigitado);

                switch (chosenOption) {
                    case 1 -> executor.executeCommand(new ListShelterCommand());
                    case 2 -> executor.executeCommand(new RegisterShelterCommand());
                    case 3 -> executor.executeCommand(new ListPetsCommand());
                    case 4 -> executor.executeCommand(new ImportPetsCommand());
                    case 5 -> System.exit(0);
                    default -> chosenOption = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
        System.out.println("1 -> Listar abrigos cadastrados");
        System.out.println("2 -> Cadastrar novo abrigo");
        System.out.println("3 -> Listar pets do abrigo");
        System.out.println("4 -> Importar pets do abrigo");
        System.out.println("5 -> Sair");
    }
}
