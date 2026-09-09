import Testes_01_09.Lampada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LampadaTest {

    @Test
    void ligarDeveAlterarOEstadoEAIntensidade() {
        // Arrange
        Lampada lampada = new Lampada("Sala");

        // Act
        lampada.ligar();

        // Assert
        assertAll(() -> assertTrue(lampada.isLigada()), () -> assertEquals(100, lampada.getIntensidade()));
    }

    @Test
    void lampadaRecemLigadaDeveEstarDesligadaComItensidadeZero(){
        //Arrange + Act
        Lampada lampada = new Lampada("Quarto");

        //Assert
        assertAll(() -> assertFalse(lampada.isLigada()), () -> assertEquals(0, lampada.getIntensidade()));
    }

    @Test
    void desligarDeveRestaurarAoEstadoInicial() {
        // Arrange
        Lampada lampada = new Lampada("Banheiro");
        lampada.ligar();
        // Act
        lampada.desligar();
        // Assert
        assertAll(() -> assertFalse(lampada.isLigada()), () -> assertEquals(0, lampada.getIntensidade()));
    }
}

