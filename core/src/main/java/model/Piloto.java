package model;

import exception.ExceptionPiloto;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.UUID;

public class Piloto {
    private UUID id;
    private String nombre;
    private String documento;
    private LocalDate fecha_nacimiento;

    public Piloto(UUID id, String nombre, String documento, LocalDate fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /*
    No puede existir dos Pilotos con el mismo documento
    Todos los atributos de Piloto son obligatorios
    El piloto no puede ser menor a 18 años
    El caso de uso debe devolver el ID asignado al Piloto creado exitosamente
     */
    public static Piloto InstancePiloto(UUID id,
                                        String nombre,
                                        String documento,
                                        LocalDate fecha_nacimiento) throws ExceptionPiloto {

        if (id == null || nombre == null || documento == null || fecha_nacimiento == null){
            throw new ExceptionPiloto("Error, los datos del piloto no pueden ser nulos o estar vacios");
        }

        if (fecha_nacimiento.isAfter(LocalDate.of(2006, 1, 1))){
            throw new ExceptionPiloto("Error, el piloto no puede ser menor de 18 años");
        }
        return new Piloto(id, nombre, documento, fecha_nacimiento);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
