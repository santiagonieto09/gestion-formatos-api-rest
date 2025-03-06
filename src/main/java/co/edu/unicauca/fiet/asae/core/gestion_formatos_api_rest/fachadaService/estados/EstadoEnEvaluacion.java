package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;

public class EstadoEnEvaluacion implements EstadoInt{
    
    @Override
    public Resultado enviarParaEvaluacion(FormatoA formato) {
        return new Resultado(false, "Un formato en evaluación, no se puede enviar a evaluación");
    }

    @Override
    public Resultado aprobarFormatoA(FormatoA formato) {
        EstadoAprobado objEstado= new EstadoAprobado();
        formato.setEstado(objEstado);
        return new Resultado(true,"Estado cambiado a aprobado de manera exitosa");
    }

    @Override
    public Resultado fijarObservacionesFormatoA(FormatoA formato) {
       EstadoFormuladoConObservaciones objEstado= new EstadoFormuladoConObservaciones();
       formato.setEstado(objEstado);
       return new Resultado(true, "Estado cambiado a formulado con observaciones de manera exitosa");
    }

    @Override
    public Resultado noAprobarFormatoA(FormatoA formato) {
        EstadoNoAprobado objEstado= new EstadoNoAprobado();
        formato.setEstado(objEstado);
        return new Resultado(true, "Estado cambiado a no aprobado");
    }
    
    @Override
    public String toString() {
        return "En evaluación";
    }
}

