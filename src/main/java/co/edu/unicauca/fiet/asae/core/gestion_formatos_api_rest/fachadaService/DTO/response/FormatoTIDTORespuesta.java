/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FormatoTIDTORespuesta extends FormatoDTORespuesta{
    List<String> estudiantes;
}
