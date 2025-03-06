package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;


public class EstadoAprobado implements EstadoInt {

    @Override
    public Resultado enviarParaEvaluacion(FormatoA formato) {
        return new Resultado(false, "Un formato aprobado no se puede enviar a evaluar");
    }

    @Override
    public Resultado aprobarFormatoA(FormatoA articulo) {
        return new Resultado(false, "Un formato aprobado no se puede volver a aprobar");
    }

    @Override
    public Resultado fijarObservacionesFormatoA(FormatoA articulo) {
        return new Resultado(false, "Un formato aprobado no  puede volver a tener observaciones");
    }

    @Override
    public Resultado noAprobarFormatoA(FormatoA articulo) {
        return new Resultado(false, "Un formato aprobado no puede no aprobarse");
    }

    @Override
    public String toString() {
        return "Aprobado";
    }

}
