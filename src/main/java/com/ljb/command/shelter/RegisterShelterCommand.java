package com.ljb.command.shelter;

import com.ljb.client.ClientHttpConfiguration;
import com.ljb.command.Command;
import com.ljb.service.ShelterService;

import java.io.IOException;

public class RegisterShelterCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            ShelterService shelterService = new ShelterService(client);

            shelterService.registerShelter();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
