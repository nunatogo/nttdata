package com.nttdada.test.web;

import com.nttdada.test.model.domain.ClientDTO;
import com.nttdada.test.model.domain.TypeDocument;
import com.nttdada.test.services.ClientsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador del servicio REST para la consulta de clientes
 *
 * @author NTOROG - Natalia Toro González
 * @version 1.0
 * @since Release 1
 */
@RestController
@RequestMapping("/")
@Slf4j
public class ClientsREST {

    @Autowired
    private ClientsService service;

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param typeDocument, String con el tipo de documento del cliente a buscar
     * @param id, String con el número de documento del cliente a buscar
     * @return ClientDTO
     */
    @RequestMapping(method = RequestMethod.GET, value = "/clientEnum", params = {"typeDocument", "id"})
    public ResponseEntity<ClientDTO> getClientEnum(@PathVariable("typeDocument") TypeDocument typeDocument, @RequestParam String id) {
        try{
            ClientDTO dto = service.getClient(typeDocument, id);

            return ResponseEntity.ok(dto);
        }catch (IllegalArgumentException e){
            log.error("El tipo de documento no es correcto." + e.getMessage());

            return new ResponseEntity("El tipo de documento no es válido", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param typeDocument, String con el tipo de documento del cliente a buscar
     * @param id, String con el número de documento del cliente a buscar
     * @return ClientDTO
     */
    @RequestMapping(method = RequestMethod.GET, value = "/client", params = {"typeDocument", "id"})
    public ResponseEntity<ClientDTO> getClient(@RequestParam("typeDocument") String typeDocument, @RequestParam("id") String id) {
        try{
            TypeDocument type = TypeDocument.valueOf(typeDocument);
            ClientDTO dto = service.getClient(type, id);

            return ResponseEntity.ok(dto);
        }catch (IllegalArgumentException e){
            log.error("El tipo de documento:" + typeDocument + " no es correcto." + e.getMessage());

            return new ResponseEntity("El tipo de documento no es válido", HttpStatus.BAD_REQUEST);
        }
    }
}
