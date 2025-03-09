/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.EstadoEnum;

@Data // TODO: Eliminar - Anotacion temporal
@ToString
public class FormatoEntity {
    String id;
    String tipo; //PP, TI
    String titulo;
    String descripcion;
    String objetivoGeneral;
    List<String> objetivosEspecificos;
    LocalDateTime fechaCreacion;
    EstadoEnumEntity estado;
}
