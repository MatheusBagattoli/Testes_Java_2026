import Testes_01_09.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void usuarioRecemCriadoDeveTerEstadoInicialCorreto(){
        //Arrange + Act
        Usuario usuario = new Usuario("Matheus", "matheus@gmail.com");

        //Assert: todas as verificações devem ser executadas.
        assertAll(() -> assertEquals("Matheus", usuario.getNome()),
                () -> assertEquals("matheus@gmail.com", usuario.getEmail()),
                () -> assertNull(usuario.getTelefone()),
                () -> assertTrue(usuario.isAtivo()));
    }

    @Test
    void definirTelefoneDeveArmazenarValorInformado() {
        // Arrange
        Usuario usuario = new Usuario("Carlos", "carlos@email.com");
        // Act
        usuario.definirTelefone("(47) 96969-2000");
        // Assert
        assertAll(
                () -> assertNotNull(usuario.getTelefone()),
                () -> assertEquals("(47) 96969-2000", usuario.getTelefone()));
    }

    @Test
    void telefoneNuloDeveLancarExcecao() {Usuario usuario = new Usuario("Lara", "lara@email.com");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> usuario.definirTelefone(null));
            assertEquals("O telefone é obrigatório.", excecao.getMessage());
    }

    @Test
    void telefoneEmBrancoVaiLancarExcessao(){
        Usuario usuario = new Usuario("Gabriel", "gabriel@email.com");

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> usuario.definirTelefone(""));

        assertEquals("O telefone é obrigatório", excecao.getMessage());
    }

    @Test
    void desativarDeveAlterarEstadoParaInativo() {
        // Arrange
        Usuario usuario = new Usuario("Marlene", "marlene@email.com");
        // Act
        usuario.desativar();
        // Assert
        assertFalse(usuario.isAtivo());
    }
}

