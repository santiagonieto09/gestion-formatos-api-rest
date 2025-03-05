/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.services;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.EstadoEnum;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.repository.IFormatoARepository;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.mapper.FormatoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormatoAServicesImpl implements IFormatoAServices{

    @Autowired
    private final IFormatoARepository servicioAccesoBD;

    @Override
    public FormatoDTORespuesta crearFormato(FormatoDTOPeticion formato) {
        return null;
    }

    @Override
    public FormatoDTORespuesta consultarFormato(String id) {
        return servicioAccesoBD.consultarFormato(id).map(FormatoMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public List<FormatoDTORespuesta> listarFormatos() {
        Collection<FormatoEntity> formatos = servicioAccesoBD.listarFormatos().orElseThrow(() -> new RuntimeException("No hay formatos creados."));
        return FormatoMapper.INSTANCE.toDTOList(formatos);
    }

    @Override
    public FormatoDTORespuesta modificarFormato(String id, FormatoDTOPeticion formato) {
        return null;
    }

    @Override
    public FormatoDTORespuesta cambiarEstado(String id, EstadoEnum estado) {
        return null;
    }
}
