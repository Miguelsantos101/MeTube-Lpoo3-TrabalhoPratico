public class Assinatura {
    private static int id_assinaturas = 0;
    private int id_assinatura;
    private String nome_assinatura;
    private double preco;

    public Assinatura(String nome_assinatura, double preco) {
        setId_assinatura(++id_assinatura);
        setNome_assinatura(nome_assinatura);
        setPreco(preco);

    }

    // Setters e Getters

    //#region id_assinatura
    public void setId_assinatura(int id_assinatura) {
        this.id_assinatura = id_assinatura;
    }
    
    public int getId_assinatura() {
        return id_assinatura;
    }
    //#endregion

    //#region nome_assinatura
    public void setNome_assinatura(String nome_assinatura) {
        this.nome_assinatura = nome_assinatura;
    }

    public String getNome_assinatura() {
        return nome_assinatura;
    }
    //#endregion
    
    //#region preco
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
    //#endregion

    //#region id_assinaturas
    public static int getId_assinaturas() {
        return id_assinaturas;
    }
    //#endregion
    
}
