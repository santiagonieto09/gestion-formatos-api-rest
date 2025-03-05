package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    String asesor;
    String carta;
}
