/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.estados;


public class EstadoNoAprobado implements EstadoInt {

    @Override
    public Resultado enviarParaEvaluacion(FormatoA formato) {
        return new Resultado(false, "Un formato no aprobado no se puede enviar a evaluar");
    }

    @Override
    public Resultado aprobarFormatoA(FormatoA formato) {
        return new Resultado(false, "Un formato no aprobado no se puede volver a aprobar");
    }

    @Override
    public Resultado fijarObservacionesFormatoA(FormatoA formato) {
        return new Resultado(false, "Un formato no aprobado no  puede volver a tener observaciones");
    }

    @Override
    public Resultado noAprobarFormatoA(FormatoA formato) {
        return new Resultado(false, "Un formato no aprobado no se puede volver a no aprobar");
    }

    @Override
    public String toString() {
        return "No Aprobado";
    }

}
