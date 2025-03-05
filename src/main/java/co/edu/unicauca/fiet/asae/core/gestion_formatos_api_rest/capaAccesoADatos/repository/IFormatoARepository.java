package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.repository;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface IFormatoARepository {
    Optional<FormatoEntity> crearFormato(FormatoEntity formato);
    Optional<FormatoEntity> consultarFormato(String id);
    Optional<Collection<FormatoEntity>> listarFormatos();
    Optional<FormatoEntity> modificarFormato(String id, FormatoEntity formato);
    Optional<FormatoEntity> cambiarEstado(String id, int estado); //TODO: Revisar si se puede como int
}