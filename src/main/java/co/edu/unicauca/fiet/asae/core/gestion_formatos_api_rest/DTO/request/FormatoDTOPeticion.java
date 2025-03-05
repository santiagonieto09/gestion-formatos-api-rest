/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FormatoPPDTOPeticion.class, name = "PP"),
        @JsonSubTypes.Type(value = FormatoTIDTOPeticion.class, name = "TI")
})
public class FormatoDTOPeticion {
    String tipo; //PP, TI
    String titulo;
    String descripcion;
    String objetivoGeneral;
    List<String> objetivosEspecificos;
}
