package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.services;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.EstadoEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFormatoAServices {
    FormatoDTORespuesta crearFormato(FormatoDTOPeticion formato);
    FormatoDTORespuesta consultarFormato(String id);
    List<FormatoDTORespuesta> listarFormatos();
    FormatoDTORespuesta modificarFormato(String id, FormatoDTOPeticion formato);
    String cambiarEstado(String id, EstadoEnum estado);
}