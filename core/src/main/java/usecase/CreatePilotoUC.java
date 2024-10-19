package usecase;

import exception.ExceptionPiloto;
import input.CreatePilotoInput;
import model.Piloto;
import output.CreatePilotoOutPut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class CreatePilotoUC {
    private ArrayList<Piloto> pilotos;
    private CreatePilotoOutPut createPilotoOutPut;

    public CreatePilotoUC(CreatePilotoOutPut createPilotoOutPut) {
        this.createPilotoOutPut = createPilotoOutPut;
    }

    public UUID crearPiloto(String nombre, String documento, LocalDate fechaNacimiento) {
        if (createPilotoOutPut.existPiloto_documento(documento)) {
            throw new RuntimeException("El documento ya está registrado");
        }
        Piloto piloto = new Piloto(UUID.randomUUID(), nombre, documento, fechaNacimiento);
        createPilotoOutPut.crearPiloto(nombre, documento, fechaNacimiento);
        return piloto.getId();
    }

}
