public class Bloqueado extends EstadoSmartphone{
    private Bloqueado(){};
    private static Bloqueado instance = new Bloqueado();

    public static Bloqueado getInstance(){
        return instance;
    }

    public String getEstado(){
        return  "Bloqueado";
    }

    public boolean inserirSenha(String senha, Smartphone smartphone){
        if (smartphone.getSenha().equals(senha)){
            smartphone.zerarTentativa();
            smartphone.setEstado(Desbloqueado.getInstance());

            return true;
        } else {
            smartphone.incrementarTentativa();

            if (smartphone.getContador() >= 3){
                smartphone.setEstado(Travado.getInstance());
                Travado.getInstance().iniciarTemporizador(smartphone);
            }
            return false;
        }
    }

    /*public boolean desbloquear(Smartphone smartphone){
            smartphone.setEstado(Desbloqueado.getInstance());
            return true;
    } - so sera desbloqueado depois da senha*/
}
