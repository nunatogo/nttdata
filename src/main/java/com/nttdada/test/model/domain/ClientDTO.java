package com.nttdada.test.model.domain;

import lombok.Data;

@Data
public class ClientDTO {

    private String id;

    private TypeDocument typeDocument;

    private String firstName;

    private String secondName;

    private String surname;

    private String secondSurname;

    private int telephoneNumber;

    private String address;

    private String residenceCity;

}
