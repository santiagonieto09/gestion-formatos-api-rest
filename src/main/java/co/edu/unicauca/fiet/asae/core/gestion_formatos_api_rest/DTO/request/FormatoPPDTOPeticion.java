package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    String asesor;
    String carta;
}
