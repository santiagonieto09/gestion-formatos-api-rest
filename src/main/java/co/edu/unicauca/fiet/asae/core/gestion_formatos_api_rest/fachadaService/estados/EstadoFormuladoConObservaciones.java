package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;


public class EstadoFormuladoConObservaciones implements EstadoInt{

    @Override
    public Resultado enviarParaEvaluacion(FormatoA formato) {
        EstadoEnEvaluacion objEstado= new EstadoEnEvaluacion();
        formato.setEstado(objEstado);
        return new Resultado(true, "Estado cambiado a evaluación de manera exitosa");
    }

    @Override
    public Resultado aprobarFormatoA(FormatoA formato) {         
         return new Resultado(false, "Un formato formulado con observaciones, no puede directamente aprobarse");
    }

    @Override
    public Resultado fijarObservacionesFormatoA(FormatoA formato) {
        return new Resultado(false, "A un formato formulado con observaciones, no se le pueden fijar observaciones,"
                + "solo se pueden plantear observaciones si esta en evaluación");  
    }

    @Override
    public Resultado noAprobarFormatoA(FormatoA formato) {
        return new Resultado(false, "Un formato formulado con observaciones, no puede directamente no aprobarse");
    }
    
    @Override
    public String toString() {
        return "Formulado con observaciones";
    }    
}
