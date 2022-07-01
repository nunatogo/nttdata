package com.nttdada.test.web;

import com.nttdada.test.model.domain.ClientDTO;
import com.nttdada.test.model.domain.TypeDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Test {@link ClientsREST}
 *
 * @author NToroG - Natalia Toro González
 * @version 1.0
 * @since Release 1
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientsRESTTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    private String URL;

    @PostConstruct
    void setUp() {
        URL = "http://localhost:" + port + "/";
    }

    @DisplayName("GET /client/ cuando el número de documento es  23445322")
    @Test
    void getClient() {
        // GIVEN
        ClientDTO dto = new ClientDTO();
        dto.setId("23445322");
        dto.setTypeDocument(TypeDocument.C);
        dto.setFirstName("DANIEL");
        dto.setSecondName("ARTURO");
        dto.setSurname("VELOSA");
        dto.setSecondSurname("TORO");
        dto.setTelephoneNumber(3472823);
        dto.setAddress("CALLE 22C # 29A - 47");
        dto.setResidenceCity("BOGOTÁ");
        // WHEN
        ResponseEntity<ClientDTO> response = rest.getForEntity(URL + "client/?typeDocument=C&id=23445322", ClientDTO.class);
        // THEN
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().equals(dto));
    }

    @DisplayName("GET /client/ cuando el tipo de documento es erróneo de documento es  23445322")
    @Test
    void getClientBadRequest() {
        // GIVEN
        ClientDTO dto = new ClientDTO();
        dto.setId("23445322");
        dto.setTypeDocument(TypeDocument.C);
        dto.setFirstName("DANIEL");
        dto.setSecondName("ARTURO");
        // WHEN
        // THEN
        assertThrows(RestClientException.class, () -> rest.getForEntity(URL + "/client/?typeDocument=Cedula&id=23445322",  ClientDTO.class));
    }
}
