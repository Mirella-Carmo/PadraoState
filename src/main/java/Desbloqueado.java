public class Desbloqueado extends EstadoSmartphone{
    private Desbloqueado(){}
    private static Desbloqueado instance = new Desbloqueado();

    public static Desbloqueado getInstance(){
        return instance;
    }

    public String getEstado(){
        return "Desbloqueado";
    }

    public boolean bloquear (Smartphone smartphone){
        smartphone.setEstado(Bloqueado.getInstance());
        return true;
    }
}
