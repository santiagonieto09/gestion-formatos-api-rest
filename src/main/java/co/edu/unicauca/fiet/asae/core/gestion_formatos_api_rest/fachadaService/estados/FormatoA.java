package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.exceptions.FormatoException;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FormatoA {

    private Optional<EstadoInt> estado;
    
    public FormatoA() {
        this.estado = Optional.empty();  //multiplicidad 0..1
    }

    public void setEstado(EstadoInt estado) {
        this.estado = Optional.ofNullable(estado);
    }
    
    public Resultado enviarParaEvaluacion() {
        return estado.orElseThrow(() -> 
            new FormatoException("No se puede enviar a evaluación: El formato no tiene un estado definido"))
            .enviarParaEvaluacion(this);
    }
    
    public Resultado aprobar() {
        return estado.orElseThrow(() -> 
            new FormatoException("No se puede aprobar: El formato no tiene un estado definido"))
            .aprobarFormatoA(this);
    }
    
    public Resultado fijarObservaciones() {
        return estado.orElseThrow(() -> 
            new FormatoException("No se pueden fijar observaciones: El formato no tiene un estado definido"))
            .fijarObservacionesFormatoA(this);
    }
    
    public Resultado noAprobar() {
        return estado.orElseThrow(() -> 
            new FormatoException("No se puede no aprobar: El formato no tiene un estado definido"))
            .noAprobarFormatoA(this);
    }
    
    @Override
    public String toString() {
        return estado.map(EstadoInt::toString)
                    .orElse("Estado no definido");
    }
}