import java.util.ArrayList;

public class _4Canal {
    private static int id_canais = 0;
    private int id_canal;
    private String nome_canal;
    private String dt_criacao;

    private _3Usuario usuario_dono;
    private ArrayList<_5Video> listaVideos;
    private ArrayList<_7Assinatura> listaAssinaturas;
    
    public _4Canal(String nome_canal, String dt_criacao, _3Usuario usuario_dono) {
        setId_canal(++id_canais);
        setNome_canal(nome_canal);
        setDt_criacao(dt_criacao);

        setUsuario_dono(usuario_dono);
        setListaVideos(listaVideos = new ArrayList<_5Video>());
        setListaAssinaturas(listaAssinaturas = new ArrayList<_7Assinatura>());
    }

    
    // Setters e Getters

    //#region id_canal
    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }

    public int getId_canal() {
        return id_canal;
    }
    //#endregion

    //#region nome_canal
    public void setNome_canal(String nome_canal) {
        this.nome_canal = nome_canal;
    }

    public String getNome_canal() {
        return nome_canal;
    }
    //#endregion

    //#region dt_criacao
    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }
    //#endregion

    //#region usuario_dono
    protected void setUsuario_dono(_3Usuario usuario_dono) {
        this.usuario_dono = usuario_dono;
    }

    public _3Usuario getUsuario_dono() {
        return usuario_dono;
    }
    //#endregion





    //#region listaVideos
    public void setListaVideos(ArrayList<_5Video> listaVideos) {
        this.listaVideos = listaVideos;
    }

    public ArrayList<_5Video> getListaVideos() {
        return listaVideos;
    }

    public void addVideo(_5Video video) {
        //video.setCanal_dono(this);
        listaVideos.add(video);
    }
    //#endregion

    //#region listaAssinaturas
    public void setListaAssinaturas(ArrayList<_7Assinatura> listaAssinaturas) {
        this.listaAssinaturas = listaAssinaturas;
    }

    public ArrayList<_7Assinatura> getListaAssinaturas() {
        return listaAssinaturas;
    }
    //#endregion

    //#region id_canais
    public static int getId_canais() {
        return id_canais;
    }
    //endregion

}
