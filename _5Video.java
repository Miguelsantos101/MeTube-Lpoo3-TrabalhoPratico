import java.util.ArrayList;

public class _5Video {
    private static int id_videos = 0;
    private int id_video;
    private String titulo_video;
    private String dt_lancamento;
    private int qtd_likes;

    private _4Canal canal_dono;
    private ArrayList<_6Comentario> listaComentarios;

    public _5Video(String titulo_video, String dt_lancamento, int qtd_likes, _4Canal canal_dono) {
        setId_video(++id_videos);
        setTitulo_video(titulo_video);
        setDt_lancamento(dt_lancamento);
        setQtd_likes(qtd_likes);

        setCanal_dono(canal_dono);
        setListaComentarios(listaComentarios = new ArrayList<_6Comentario>());
    }


    // Setters e Getters

    //#region id_video
    public void setId_video(int id_video) {
        this.id_video = id_video;
    }
    
    public int getId_video() {
        return id_video;
    }
    //#endregion

    //#region titulo_video
    public void setTitulo_video(String titulo_video) {
        this.titulo_video = titulo_video;
    }

    public String getTitulo_video() {
        return titulo_video;
    }
    //#endregion
    
    //#region dt_lancamento
    public void setDt_lancamento(String dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
    }

    public String getDt_lancamento() {
        return dt_lancamento;
    }
    //#endregion

    //#region qtd_likes
    public void setQtd_likes(int qtd_likes) {
        this.qtd_likes = qtd_likes;
    }

    public int getQtd_likes() {
        return qtd_likes;
    }
    //#endregion

    //#region canal_dono
    public void setCanal_dono(_4Canal canal_dono) {
        this.canal_dono = canal_dono;
    }

    public _4Canal getCanal_dono() {
        return canal_dono;
    }
    //#endregion





    //#region listaComentarios
    public void setListaComentarios(ArrayList<_6Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<_6Comentario> getListaComentarios() {
        return listaComentarios;
    }
    //#endregion

    //#region id_videos
    public static int getId_videos() {
        return id_videos;
    }
    //#endregion
    
}
