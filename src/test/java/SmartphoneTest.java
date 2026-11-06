import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {
    private Smartphone smartphone;

    @BeforeEach
    public void setUp() {
        smartphone = new Smartphone("celular", "1234");
    }

    @Test
    public void deveIniciarBloqueado() {
        assertEquals("Bloqueado", smartphone.getNomeEstado());
        assertEquals(0, smartphone.getContador());
    }

    @Test
    public void naoDeveBloquearSmartphoneJaBloqueado() {
        assertFalse(smartphone.bloquear());
    }

    @Test
    public void deveDesbloquearComSenhaCorreta() {
        assertTrue(smartphone.inserirSenha("1234"));
        assertEquals("Desbloqueado", smartphone.getNomeEstado());
    }

    @Test
    public void naoDeveDesbloquearComSenhaIncorreta() {
        assertFalse(smartphone.inserirSenha("0000"));
        assertEquals("Bloqueado", smartphone.getNomeEstado());
        assertEquals(1, smartphone.getContador());
    }

    @Test
    public void deveTravarAposTresTentativasIncorretas() {
        smartphone.inserirSenha("0000");
        smartphone.inserirSenha("1111");
        smartphone.inserirSenha("2222");

        assertEquals("Travado", smartphone.getNomeEstado());
        assertEquals(3, smartphone.getContador());
    }

    @Test
    public void naoDevePermitirOperacoesEnquantoEstiverTravado() {
        smartphone.inserirSenha("0000");
        smartphone.inserirSenha("1111");
        smartphone.inserirSenha("2222");

        assertFalse(smartphone.inserirSenha("1234"));
        assertFalse(smartphone.bloquear());
        assertFalse(smartphone.desbloquear());

        assertEquals("Travado", smartphone.getNomeEstado());
    }

    @Test
    public void deveRetornarAoEstadoBloqueadoAposCincoSegundos()
            throws InterruptedException {

        smartphone.inserirSenha("0000");
        smartphone.inserirSenha("1111");
        smartphone.inserirSenha("2222");

        assertEquals("Travado", smartphone.getNomeEstado());

        Thread.sleep(5200);

        assertEquals("Bloqueado", smartphone.getNomeEstado());
        assertEquals(0, smartphone.getContador());
    }

    @Test
    public void devePermitirBloquearSmartphoneDesbloqueado() {
        smartphone.inserirSenha("1234");

        assertTrue(smartphone.bloquear());
        assertEquals("Bloqueado", smartphone.getNomeEstado());
    }
}