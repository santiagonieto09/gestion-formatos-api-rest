/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response;

import lombok.Data;

import java.util.Date;    
import java.util.List;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.EstadoEnum;

@Data
public class FormatoDTORespuesta {
    String id;
    String tipo; //PP, TI
    String titulo;
    String descripcion;
    String objetivoGeneral;
    List<String> objetivosEspecificos;
    Date fechaCreacion;
    EstadoEnum estado;
}
