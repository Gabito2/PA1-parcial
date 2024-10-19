package output;

import java.time.LocalDate;
import java.util.UUID;

public interface CreatePilotoOutPut {
    UUID crearPiloto(String nombre, String documento, LocalDate fechaNacimiento);
    boolean existPiloto_documento(String documento);
}
