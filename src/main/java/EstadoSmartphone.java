public abstract class EstadoSmartphone {
    public abstract String getEstado();

    public boolean bloquear(Smartphone smartphone){
        return false;
    }

    public boolean desbloquear(Smartphone smartphone) {
        return false;
    }

    public boolean travar(Smartphone smartphone) {
        return false;
    }

    public boolean inserirSenha(String senha, Smartphone smartphone){
        return false;
    }
}
