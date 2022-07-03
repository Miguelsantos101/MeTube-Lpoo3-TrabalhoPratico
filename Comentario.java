public class Comentario {
    private static int id_comentarios = 0;
    private int id_comentario;
    private String texto_comentario;
    private int qtd_likes;
    private Usuario usuario_dono;
    private Video video_dono;

    public Comentario(String texto_comentario, int qtd_likes, Usuario usuario_dono, Video video_dono) {
        setId_comentario(++id_comentarios);
        setTexto_comentario(texto_comentario);
        setQtd_likes(qtd_likes);
        setUsuario_dono(usuario_dono);
        setVideo_dono(video_dono);
    }


    // Setters e Getters

    //#region id_comentario
    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }
    
    public int getId_comentario() {
        return id_comentario;
    }
    //#endregion

    //#region texto_comentario
    public void setTexto_comentario(String texto_comentario) {
        this.texto_comentario = texto_comentario;
    }

    public String getTexto_comentario() {
        return texto_comentario;
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

    //#region usuario_dono
    public void setUsuario_dono(Usuario usuario_dono) {
        this.usuario_dono = usuario_dono;
    }

    public Usuario getUsuario_dono() {
        return usuario_dono;
    }
    //#endregion

    //#region video_dono
    public void setVideo_dono(Video video_dono) {
        this.video_dono = video_dono;
    }

    public Video getVideo_dono() {
        return video_dono;
    }
    //#endregion

    //#region id_comentarios
    public static int getId_comentarios() {
        return id_comentarios;
    }
    //#endregion
    
}
