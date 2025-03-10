/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.repository;


import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.EstadoEnumEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoPPEntity;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaAccesoADatos.models.FormatoTIEntity;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.*;

@Repository
public class FormatoARepositoryImpl implements IFormatoARepository{

    Map<String, FormatoEntity> mapaFormatos = new HashMap<>();

    FormatoARepositoryImpl(){
        inicializarFormatos();
    }

    private void inicializarFormatos() {
        FormatoPPEntity formato1 = new FormatoPPEntity();
        formato1.setId("1");
        formato1.setTipo("PP");
        formato1.setTitulo("Formato 1");
        formato1.setDescripcion("Descripción del Formato 1");
        formato1.setObjetivoGeneral("Objetivo General 1");
        formato1.setObjetivosEspecificos(Arrays.asList("Objetivo Específico 1.1", "Objetivo Específico 1.2"));
        formato1.setFechaCreacion(new Date());
        formato1.setEstado(EstadoEnumEntity.EN_EVALUACION);
        formato1.setAsesor("Asesor 1");
        formato1.setCarta("Carta 1");

        FormatoTIEntity formato2 = new FormatoTIEntity();
        formato2.setId("2");
        formato2.setTipo("TI");
        formato2.setTitulo("Formato 2");
        formato2.setDescripcion("Descripción del Formato 2");
        formato2.setObjetivoGeneral("Objetivo General 2");
        formato2.setObjetivosEspecificos(Arrays.asList("Objetivo Específico 2.1", "Objetivo Específico 2.2"));
        formato2.setFechaCreacion(new Date());
        formato2.setEstado(EstadoEnumEntity.APROBADO);
        formato2.setEstudiantes(Arrays.asList("Estudiante 2.1", "Estudiante 2.2"));

        FormatoTIEntity formato3 = new FormatoTIEntity();
        formato3.setId("3");
        formato3.setTipo("TI");
        formato3.setTitulo("Formato 3");
        formato3.setDescripcion("Descripción del Formato 3");
        formato3.setObjetivoGeneral("Objetivo General 3");
        formato3.setObjetivosEspecificos(Arrays.asList("Objetivo Específico 3.1", "Objetivo Específico 3.2"));
        formato3.setFechaCreacion(new Date());
        formato3.setEstado(EstadoEnumEntity.RECHAZADO);
        formato3.setEstudiantes(Arrays.asList("Estudiante 3.1", "Estudiante 3.2"));

        mapaFormatos.put(formato1.getId(), formato1);
        mapaFormatos.put(formato2.getId(), formato2);
        mapaFormatos.put(formato3.getId(), formato3);

        System.out.println("Formatos inicializados");
    }

    @Override
    public Optional<FormatoEntity> crearFormato(FormatoEntity formato) {
        String id = ""+(mapaFormatos.size()+1);
        formato.setId(id);
        mapaFormatos.put(id, formato);
        System.out.println("Formato creado: "+formato);
        return Optional.of(formato);
    }

    @Override
    public Optional<FormatoEntity> consultarFormato(String id) {
        return Optional.ofNullable(mapaFormatos.get(id));
    }

    @Override
    public Optional<Collection<FormatoEntity>> listarFormatos() {
        return Optional.of(mapaFormatos.values());
    }

    @Override
    public Optional<FormatoEntity> modificarFormato(String id, FormatoEntity formato) {
        FormatoEntity formatoActual = mapaFormatos.get(id);
        formato.setTipo(formatoActual.getTipo());
        formato.setId(formatoActual.getId());
        formato.setFechaCreacion(formatoActual.getFechaCreacion());
        formato.setEstado(formatoActual.getEstado());
        mapaFormatos.put(id, formato);
        return Optional.of(formato);
    }

    @Override
    public Optional<FormatoEntity> cambiarEstado(String id, int estado) {
        FormatoEntity formato = mapaFormatos.get(id);
        formato.setEstado(EstadoEnumEntity.values()[estado]);
        return Optional.of(formato);
    }
}
