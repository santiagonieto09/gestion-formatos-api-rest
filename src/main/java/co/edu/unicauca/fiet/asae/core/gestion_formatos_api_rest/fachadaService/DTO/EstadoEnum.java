package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.DTO;

public enum EstadoEnum {
    EN_FORMULACION("En Formulación"),
    EN_EVALUACION("En Evaluación"),
    POR_CORREGIR("Por Corregir"),
    RECHAZADO("Rechazado"),
    APROBADO("Aprobado");

    private final String displayName;

    EstadoEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}