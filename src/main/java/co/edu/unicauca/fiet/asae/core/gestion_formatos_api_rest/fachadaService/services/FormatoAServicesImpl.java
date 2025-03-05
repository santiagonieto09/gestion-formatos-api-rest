/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.services;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.EstadoEnum;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoPPDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoTIDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.EstadoEnumEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.repository.IFormatoARepository;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.exceptions.FormatoException;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.mapper.FormatoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        FormatoEntity formatoEntity = initializeFormatoEntity(formato);
        return FormatoMapper.INSTANCE.toDTO(servicioAccesoBD.crearFormato(formatoEntity).orElseThrow(() -> new FormatoException("Error al crear el formato.")));
    }

    private FormatoEntity initializeFormatoEntity(FormatoDTOPeticion formato) {
        FormatoEntity formatoEntity = FormatoMapper.INSTANCE.toEntity(formato);
        formatoEntity.setEstado(EstadoEnumEntity.EN_FORMULACION);
        formatoEntity.setFechaCreacion(LocalDateTime.now());

        if(formato instanceof FormatoPPDTOPeticion){
            formatoEntity.setTipo("PP");}
        if(formato instanceof FormatoTIDTOPeticion){
            formatoEntity.setTipo("TI");}

        return formatoEntity;
    }

    @Override
    public FormatoDTORespuesta consultarFormato(String id) {
        return servicioAccesoBD.consultarFormato(id).map(FormatoMapper.INSTANCE::toDTO).orElseThrow(() -> new FormatoException("Formato no encontrado."));

    }

    @Override
    public List<FormatoDTORespuesta> listarFormatos() {
        Collection<FormatoEntity> formatos = servicioAccesoBD.listarFormatos().orElseThrow(() -> new FormatoException("No hay formatos creados."));
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
