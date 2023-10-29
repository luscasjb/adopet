package com.ljb.service;

import com.ljb.client.ClientHttpConfiguration;
import com.ljb.domain.Shelter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShelterServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private ShelterService shelterService = new ShelterService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Shelter shelter = new Shelter("Teste",
            "61981880392", "shelter_lucas@ljb.com");

    @Test
    public void verify_WhenHasShelter() throws IOException, InterruptedException {
        shelter.setId(0L);
        String expectedRegisteredShelter = "Abrigos cadastrados:";
        String expectedIdAndName = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{"+shelter.toString()+"}]");
        when(client.buildGetResponse(anyString())).thenReturn(response);

        shelterService.listShelter();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualRegisteredShelter = lines[0];
        String actualIdAndName = lines[1];

        assertEquals(expectedRegisteredShelter, actualRegisteredShelter);
        assertEquals(expectedIdAndName, actualIdAndName);
    }

    @Test
    public void verify_WhenHasNotShelter() throws IOException, InterruptedException {
        shelter.setId(0L);
        String expectedNotRegisteredShelter = "Não há abrigos cadastrados.";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]");
        when(client.buildGetResponse(anyString())).thenReturn(response);

        shelterService.listShelter();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualRegisteredShelter = lines[0];

        assertEquals(expectedNotRegisteredShelter, actualRegisteredShelter);
    }
}
