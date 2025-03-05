/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FormatoTIEntity extends FormatoEntity{
    List<String> estudiantes;
}
