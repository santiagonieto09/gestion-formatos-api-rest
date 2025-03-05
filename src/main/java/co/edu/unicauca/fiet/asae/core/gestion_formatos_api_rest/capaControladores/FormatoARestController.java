package co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.capaControladores;

import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.request.FormatoDTOPeticion;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.response.FormatoDTORespuesta;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.DTO.EstadoEnum;
import co.edu.unicauca.fiet.asae.core.gestion_formatos_api_rest.fachadaService.services.IFormatoAServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/formatos")
public class FormatoARestController {

    @Autowired
    private final IFormatoAServices formatoAServices;

    @PostMapping
    public ResponseEntity<FormatoDTORespuesta> crearFormato(@RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoAServices.crearFormato(formato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormatoDTORespuesta> consultarFormato(@PathVariable String id) {
        return ResponseEntity.ok(formatoAServices.consultarFormato(id));
    }

    @GetMapping
    public ResponseEntity<List<FormatoDTORespuesta>> listarFormatos() {
        return ResponseEntity.ok(formatoAServices.listarFormatos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormatoDTORespuesta> modificarFormato(@PathVariable String id, @RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoAServices.modificarFormato(id, formato));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<FormatoDTORespuesta> cambiarEstado(@PathVariable String id, @RequestBody EstadoEnum estado) {
        return ResponseEntity.ok(formatoAServices.cambiarEstado(id, estado));
    }
}