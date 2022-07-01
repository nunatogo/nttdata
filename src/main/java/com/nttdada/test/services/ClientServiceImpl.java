package com.nttdada.test.services;

import com.nttdada.test.model.converter.StringToEnumConverter;
import com.nttdada.test.model.domain.ClientDTO;
import com.nttdada.test.model.domain.TypeDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de los servicios que ofrece la aplicación
 *
 * @author NTOROG - Natalia Toro González
 *  * @version 1.0
 *  * @since Release 1
 */
@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientsService{

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param type
     * @param id
     * @return ClientDTO
     */
    @Override
    public ClientDTO getClient(TypeDocument type, String id) throws IllegalArgumentException {
        final String ID_CLIENT = "23445322";

        ClientDTO dto = new ClientDTO();

        switch (id){
            case ID_CLIENT:
                dto.setTypeDocument(type);
                dto.setId(id);
                if(TypeDocument.C.equals(type)){
                    dto.setFirstName("DANIEL");
                    dto.setSecondName("ARTURO");
                    dto.setSurname("VELOSA");
                    dto.setSecondSurname("TORO");
                    dto.setTelephoneNumber(3472823);
                    dto.setAddress("CALLE 22C # 29A - 47");
                    dto.setResidenceCity("BOGOTÁ");
                } else {
                    dto.setFirstName("CARLOS");
                    dto.setSecondName("ARTURO");
                    dto.setSurname("TORO");
                    dto.setSecondSurname("GIL");
                    dto.setTelephoneNumber(4156614);
                    dto.setAddress("CALLE 5 # 21 - 13");
                    dto.setResidenceCity("TURBACO");
                }
                log.info("El cliente se ha consultado correctamente");
                break;

            default:
                log.warn("El número de documento: " +  id + " no es correcto.");

                dto = null;
                break;
        }

        return dto;
    }
}
