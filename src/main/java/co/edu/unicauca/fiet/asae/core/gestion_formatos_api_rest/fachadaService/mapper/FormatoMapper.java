/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.mapper;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface FormatoMapper {
    FormatoMapper INSTANCE = Mappers.getMapper(FormatoMapper.class);

    FormatoDTORespuesta toDTO(FormatoEntity entity);

    List<FormatoDTORespuesta> toDTOList(Collection<FormatoEntity> entities);

}
