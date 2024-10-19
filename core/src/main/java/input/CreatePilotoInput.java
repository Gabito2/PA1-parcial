package input;

import model.Piloto;

import java.time.LocalDate;
import java.util.UUID;

public interface CreatePilotoInput {
    UUID crearPiloto(String nombre, String documento, LocalDate fechaNacimiento);
    boolean existPiloto_documento(String documento);
}
