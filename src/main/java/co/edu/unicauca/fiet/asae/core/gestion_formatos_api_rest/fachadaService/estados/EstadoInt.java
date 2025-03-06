package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;


public interface EstadoInt {
    
    Resultado enviarParaEvaluacion(FormatoA formato);
    Resultado aprobarFormatoA(FormatoA formato);
    Resultado fijarObservacionesFormatoA(FormatoA formato);
    Resultado noAprobarFormatoA(FormatoA formato);
    // Otros métodos de transición según sea necesario

}
