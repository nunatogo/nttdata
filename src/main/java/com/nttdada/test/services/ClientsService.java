package com.nttdada.test.services;

import com.nttdada.test.model.domain.ClientDTO;
import com.nttdada.test.model.domain.TypeDocument;

/**
 * Servicios que se ofrecen dentro de la aplicación
 *
 * @author NTOROG - Natalia Toro González
 * @version 1.0
 * @since Release 1
 */
public interface ClientsService {

    /**
     * Servicio que retorna la información del cliente según su tipo y número de documento
     *
     * @param type, TypeDocument con el tipo de documento del cliente a buscar
     * @param id, String con el número de documento del cliente a buscar
     * @return ClientDTO
     * @throws IllegalArgumentException
     */
    public ClientDTO getClient(TypeDocument type, String id) throws IllegalArgumentException;
}
