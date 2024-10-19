package model;

import exception.ExceptionPiloto;
import input.CreatePilotoInput;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.CreatePilotoOutPut;
import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestPiloto {

    @Mock
    CreatePilotoOutPut createPilotoOutPut;

    @Test
    public void testPiloto() {
        Piloto piloto = Piloto.InstancePiloto(null, "Gabriel", "1233211", LocalDate.of(2002, 11, 25));
        createPilotoOutPut.existPiloto_documento("1233211");
        Assertions.assertNotNull(piloto);
    }

    @Test
    public void testCrearPiloto() {
        when(createPilotoOutPut.existPiloto_documento("12345678")).thenReturn(false);
        UUID uuid = createPilotoOutPut.crearPiloto("Juan Pérez", "12345678", LocalDate.of(2000, 1, 1));
        Assertions.assertNotNull(uuid);
        verify(createPilotoOutPut, times(1)).crearPiloto("Juan Pérez", "12345678", LocalDate.of(2000, 1, 1));
    }

    @Test
    public void testCrearPiloto_DocumentoDuplicado() {
        when(createPilotoOutPut.existPiloto_documento("12345678")).thenReturn(true);

        Assertions.assertThrows(RuntimeException.class, () ->
                createPilotoOutPut.crearPiloto("Juan Pérez", "12345678", LocalDate.of(2000, 1, 1))
        );
    }

    @Test
    public void testCrearPiloto_MenorDeEdad() {
        createPilotoOutPut.crearPiloto("Juan Pérez", "12345678", LocalDate.of(2014, 1, 1));
        when(createPilotoOutPut.existPiloto_documento("12345678")).thenReturn(false);
        Assertions.assertThrows(RuntimeException.class, () -> createPilotoOutPut.crearPiloto("Juan Pérez", "12345678", LocalDate.of(2010, 1, 1)));
    }
}
