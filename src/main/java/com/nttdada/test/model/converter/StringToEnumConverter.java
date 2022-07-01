package com.nttdada.test.model.converter;

import com.nttdada.test.model.domain.TypeDocument;
import org.springframework.core.convert.converter.Converter;

/**
 * Clase utilitaria para la conversión de un String al enumerador
 *
 * @author NTOROG - Natalia Toro González
 * @version 1.0
 * @since Release 1
 */
public class StringToEnumConverter implements Converter<String, TypeDocument>{

    /**
     * Realiza la conversión de una cadena al enumerador del tipo de documento del cliente
     *
     * @param type the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return TypeDocument
     */
    @Override
    public TypeDocument convert(String type){
        try{
            return TypeDocument.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

            return null;
        }
    }
}
