import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Travado extends EstadoSmartphone {
    private Travado(){}
    private static Travado instance = new Travado();

    private static final ScheduledExecutorService temporizador = Executors.newSingleThreadScheduledExecutor();

    public static Travado getInstance(){
        return instance;
    }

    public String getEstado(){
        return "Travado";
    }

    public void iniciarTemporizador(Smartphone smartphone){
        temporizador.schedule(() -> {
            if (smartphone.getEstado() == this){
                smartphone.zerarTentativa();
                smartphone.setEstado(Bloqueado.getInstance());
            }
        }, 5, TimeUnit.SECONDS);
    }
}
