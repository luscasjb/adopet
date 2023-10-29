package com.ljb.command.pets;

import com.ljb.client.ClientHttpConfiguration;
import com.ljb.command.Command;
import com.ljb.service.PetService;

import java.io.IOException;

public class ImportPetsCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            PetService petService = new PetService(client);

            petService.importPets();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
