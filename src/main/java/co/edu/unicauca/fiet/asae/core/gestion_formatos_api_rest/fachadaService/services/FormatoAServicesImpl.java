/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.services;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.EstadoEnumEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.repository.IFormatoARepository;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.EstadoEnum;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoPPDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoTIDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados.*;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.exceptions.FormatoException;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.mapper.FormatoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<FormatoDTORespuesta> listarFormatos(String tipo, String estado) {
        Collection<FormatoEntity> formatos = servicioAccesoBD.listarFormatos()
                .orElseThrow(() -> new FormatoException("No hay formatos creados."));
        
        Stream<FormatoEntity> stream = formatos.stream();
        
        if (tipo != null && !tipo.isEmpty()) {
            stream = stream.filter(f -> f.getTipo().equals(tipo));
        }
        
        if (estado != null && !estado.isEmpty()) {
            try {
                EstadoEnumEntity estadoEnum = EstadoEnumEntity.valueOf(estado);
                stream = stream.filter(f -> f.getEstado() == estadoEnum);
            } catch (IllegalArgumentException e) {
                throw new FormatoException("Estado no válido: " + estado);
            }
        }
        
        return stream
            .map(FormatoMapper.INSTANCE::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public FormatoDTORespuesta modificarFormato(String id, FormatoDTOPeticion formato) {
        FormatoEntity newFormato = servicioAccesoBD.modificarFormato(id, FormatoMapper.INSTANCE.toEntity(formato)).orElseThrow(() -> new FormatoException("Formato no encontrado."));
        return FormatoMapper.INSTANCE.toDTO(newFormato);
    }

    @Override
    public String cambiarEstado(String id, EstadoEnum estadoSolicitado) {
        FormatoEntity formatoEntity = servicioAccesoBD.consultarFormato(id)
                .orElseThrow(() -> new FormatoException("Formato no encontrado."));
        
        FormatoA formatoA = new FormatoA();
        formatoA.setEstado(obtenerEstadoActual(formatoEntity.getEstado()));
        
        Resultado resultado = procesarCambioEstado(formatoA, estadoSolicitado);
        
        if (resultado.cambioPermitido()) {
            formatoEntity.setEstado(EstadoEnumEntity.valueOf(estadoSolicitado.name()));
            servicioAccesoBD.modificarFormato(id, formatoEntity);
        }
        
        return resultado.mensaje();
    }

    private EstadoInt obtenerEstadoActual(EstadoEnumEntity estadoActual) {
        return switch (estadoActual) {
            case EN_FORMULACION -> new EstadoFormulado();
            case EN_EVALUACION -> new EstadoEnEvaluacion();
            case POR_CORREGIR -> new EstadoFormuladoConObservaciones();
            case APROBADO -> new EstadoAprobado();
            case RECHAZADO -> new EstadoNoAprobado();
        };
    }

    private Resultado procesarCambioEstado(FormatoA formatoA, EstadoEnum estadoSolicitado) {
        return switch (estadoSolicitado) {
            case EN_EVALUACION -> formatoA.enviarParaEvaluacion();
            case APROBADO -> formatoA.aprobar();
            case POR_CORREGIR -> formatoA.fijarObservaciones();
            case RECHAZADO -> formatoA.noAprobar();
            case EN_FORMULACION -> throw new FormatoException("No se puede cambiar directamente al estado EN FORMULACION");
        };
    }
}
