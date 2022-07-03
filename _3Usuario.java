import java.util.ArrayList;

public class _3Usuario {
    private static int id_usuarios = 0;
    private int id_usuario;
    private String nome_usuario;
    private String dt_nascimento;

    private ArrayList<_4Canal> listaCanais;
    private ArrayList<_6Comentario> listaComentarios;

    public _3Usuario(String nome_usuario, String dt_nascimento) {
        setId_usuario(++id_usuarios);
        setNome(nome_usuario);
        setDt_nascimento(dt_nascimento);

        setListaCanais(listaCanais = new ArrayList<_4Canal>());
        setListaComentarios(listaComentarios = new ArrayList<_6Comentario>());
    }


    // Setters e Getters

    //#region id_usuario
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }
    //#endregion

    //#region nome_usuario
    public void setNome(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
    
    public String getNome() {
        return nome_usuario;
    }
    //#endregion

    //#region dt_nascimento
    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }
    //#endregion




    
    //#region listaCanais
    public void setListaCanais(ArrayList<_4Canal> listaCanais) {
        this.listaCanais = listaCanais;
    }

    public ArrayList<_4Canal> getListaCanais() {
        return listaCanais;
    }
    
    public void addCanal(_4Canal canal) {
        canal.setUsuario_dono(this);
        listaCanais.add(canal);
    }
    //#endregion

    //#region listaComentarios
    public void setListaComentarios(ArrayList<_6Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<_6Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void addComentario(_6Comentario comentario) {
        
        listaComentarios.add(comentario);
    }
    //#endregion

    //#region id_usuarios
    public static int getId_usuarios() {
        return id_usuarios;
    }
    //#endregion

}
