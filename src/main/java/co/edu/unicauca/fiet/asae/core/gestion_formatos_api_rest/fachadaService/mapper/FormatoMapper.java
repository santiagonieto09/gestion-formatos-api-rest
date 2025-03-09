package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.mapper;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoPPEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoTIEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoPPDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.request.FormatoTIDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response.FormatoPPDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO.response.FormatoTIDTORespuesta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface FormatoMapper {
    FormatoMapper INSTANCE = Mappers.getMapper(FormatoMapper.class);

    // Método base para mapear FormatoEntity
    @SubclassMapping(source = FormatoPPEntity.class, target = FormatoPPDTORespuesta.class)
    @SubclassMapping(source = FormatoTIEntity.class, target = FormatoTIDTORespuesta.class)
    FormatoDTORespuesta toDTO(FormatoEntity entity);

    // Mapeo específico para PP
    FormatoPPDTORespuesta toPPDTO(FormatoPPEntity entity);

    // Mapeo específico para TI
    FormatoTIDTORespuesta toTIDTO(FormatoTIEntity entity);

    List<FormatoDTORespuesta> toDTOList(Collection<FormatoEntity> entities);

    @SubclassMapping(source = FormatoPPDTOPeticion.class, target = FormatoPPEntity.class)
    @SubclassMapping(source = FormatoTIDTOPeticion.class, target = FormatoTIEntity.class)
    FormatoEntity toEntity(FormatoDTOPeticion dto);

    // Mapeo específico para PP
    FormatoPPEntity toPPEntity(FormatoPPDTOPeticion dto);

    // Mapeo específico para TI
    FormatoTIEntity toTIEentity(FormatoTIDTOPeticion dto);
}