public class Smartphone {
    private String nome;
    private String senha;
    private Integer contador;
    private EstadoSmartphone estado;

    public Smartphone(String nome, String senha){
        this.estado = Bloqueado.getInstance(); //inicia no estado bloqueado e 0 tentativas de desbloqueio
        this.contador = 0;
        this.nome = nome;
        this.senha = senha;
    }

    public void setEstado(EstadoSmartphone estado){
        this.estado = estado;
    }

    public boolean bloquear(){
        return estado.bloquear(this);
    }

    public boolean desbloquear(){
        return estado.desbloquear(this);
    }
    public boolean travar(){
        return estado.travar(this);
    }
    public String getNomeEstado(){
        return estado.getEstado();
    }

    public EstadoSmartphone getEstado() {
        return estado;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public  String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean inserirSenha(String senha){
        return estado.inserirSenha(senha, this);
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public void incrementarTentativa(){
        contador++;
    }

    public void zerarTentativa(){
        this.contador = 0;
    }
}
