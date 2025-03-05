/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.EstadoEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data // TODO: Eliminar - Anotacion temporal
public class FormatoEntity {
    String id;
    String titulo;
    String descripcion;
    String objetivoGeneral;
    List<String> objetivosEspecificos;
    LocalDateTime fechaCreacion;
    EstadoEnumEntity estado;
}
