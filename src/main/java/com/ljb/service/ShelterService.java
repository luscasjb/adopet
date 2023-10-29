package com.ljb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljb.client.ClientHttpConfiguration;
import com.ljb.domain.Shelter;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShelterService {

    private ClientHttpConfiguration client;

    public ShelterService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void listShelter() throws IOException, InterruptedException {
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.buildGetResponse(uri);
        String responseBody = response.body();
        Shelter[] shelters =  new ObjectMapper().readValue(responseBody, Shelter[].class);
        List<Shelter> shelterList = Arrays.stream(shelters).toList();
        if (shelterList.isEmpty()) {
            System.out.println("Não há abrigos cadastrados.");
        } else {
           showShelters(shelterList);
        }
    }

    public void registerShelter() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        Shelter shelter = new Shelter(name, phoneNumber, email);

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.buildPostResponse(uri, shelter);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }

    private void showShelters(List<Shelter> shelters) {
        System.out.println("Abrigos cadastrados:");
        for (Shelter shelter : shelters) {
            long id = shelter.getId();
            String name = shelter.getName();
            System.out.println(id + " - " +name);
        }
    }
}
