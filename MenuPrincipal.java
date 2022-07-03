import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame{

    //#region Barra de Menus
    static JMenuBar menuBar;
    //#endregion

    //#region Menus
    JMenu 
    menuUsuario, 
    menuCanal, 
    menuVideo, 
    menuComentario, 
    menuAssinatura;
    //#endregion

    //#region Itens de Menu

        //#region Itens do menu Usuário
        JMenuItem 
        menuItemCriaUsuario, 
        menuItemListaUsuario,
        menuItemEditaUsuario,
        menuItemApagaUsuario;
        //#endregion
        
        //#region Itens do menu Canal
        JMenuItem
        menuItemCriaCanal,
        menuItemListaCanal,
        menuItemEditaCanal,
        menuItemApagaCanal;
        //#endregion
        
        //#region Itens do menu Video
        JMenuItem 
        menuItemCriaVideo,
        menuItemListaVideo,
        menuItemEditaVideo,
        menuItemApagaVideo;
        //#endregion

        //#region Itens do menu Comentário
        JMenuItem
        menuItemCriaComentario,
        menuItemListaComentario,
        menuItemEditaComentario,
        menuItemApagaComentario;
        //#endregion

        //#region Itens do menu Assinatura
        JMenuItem 
        menuItemCriaAssinatura,
        menuItemListaAssinatura,
        menuItemEditaAssinatura,
        menuItemApagaAssinatura;
        //#endregion


    //#endregion

    //#region Telas
    static JPanel
    painelPrincipal;

    TelasUsuario
    telasUsuario;

    TelasCanal
    telasCanal;

    TelasVideo
    telasVideo;

    TelasComentario
    telasComentario;

    TelasAssinatura
    telasAssinatura;
    //#endregion

    //#region Listas
    static ArrayList<Usuario> listaUsuarioMenu;
    static ArrayList<Canal> listaCanalMenu;
    static ArrayList<Video> listaVideoMenu;
    static ArrayList<Comentario> listaComentarioMenu;
    static ArrayList<Assinatura> listaAssinaturaMenu;
    //#endregion

    //#region Label de Status
    static JLabel status;
    //#endregion

    public MenuPrincipal() {
        super("MeTube!");

        listaUsuarioMenu = new ArrayList<Usuario>();
        listaCanalMenu = new ArrayList<Canal>();
        listaVideoMenu = new ArrayList<Video>();
        listaComentarioMenu = new ArrayList<Comentario>();
        listaAssinaturaMenu = new ArrayList<Assinatura>();

        prepararJanela();

        organizarComponentes();

        organizarEventos();

        finalizar();
    }



    private void prepararJanela() {
        this.setSize(1280,720);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void organizarComponentes() {

        janelaPrincipal();

        //#region Adicionando itens do menu Usuário
        menuUsuario.add(menuItemCriaUsuario = new JMenuItem("Criar novo usuário"));
        menuUsuario.add(menuItemListaUsuario = new JMenuItem("Listar usuários"));
        menuUsuario.add(menuItemEditaUsuario = new JMenuItem("Editar usuário"));
        menuUsuario.add(menuItemApagaUsuario = new JMenuItem("Apagar usuário"));
        //#endregion

        //#region Adicionando itens do menu Canal
        menuCanal.add(menuItemCriaCanal = new JMenuItem("Criar novo canal"));
        menuCanal.add(menuItemListaCanal = new JMenuItem("Listar canais"));
        menuCanal.add(menuItemEditaCanal = new JMenuItem("Editar canal"));
        menuCanal.add(menuItemApagaCanal = new JMenuItem("Apagar canal"));
        //#endregion

        //#region Adicionando itens do menu Vídeo
        menuVideo.add(menuItemCriaVideo = new JMenuItem("Criar novo vídeo"));
        menuVideo.add(menuItemListaVideo = new JMenuItem("Listar vídeos"));
        menuVideo.add(menuItemEditaVideo = new JMenuItem("Editar vídeo"));
        menuVideo.add(menuItemApagaVideo = new JMenuItem("Apagar vídeo"));
        //#endregion

        //#region Adicionando itens do menu Comentário
        menuComentario.add(menuItemCriaComentario = new JMenuItem("Criar novo comentário"));
        menuComentario.add(menuItemListaComentario = new JMenuItem("Listar comentários"));
        menuComentario.add(menuItemEditaComentario = new JMenuItem("Editar comentário"));
        menuComentario.add(menuItemApagaComentario = new JMenuItem("Apagar comentário"));
        //#endregion
 
        //#region Adicionando itens do menu Assinatura
        menuAssinatura.add(menuItemCriaAssinatura = new JMenuItem("Criar nova assinatura"));
        menuAssinatura.add(menuItemListaAssinatura = new JMenuItem("Listar assinaturas"));
        menuAssinatura.add(menuItemEditaAssinatura = new JMenuItem("Editar assinatura"));
        menuAssinatura.add(menuItemApagaAssinatura = new JMenuItem("Apagar assinatura"));
        //#endregion

    }

    private void organizarEventos() {
        eventosMenuUsuario();
        eventosMenuCanal();
        eventosMenuVideo();
        eventosMenuComentario();
        eventosMenuAssinatura();
    }

    private void finalizar() {
        setVisible(true);
    }
    
    private void janelaPrincipal() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        menuUsuario = new JMenu("Usuário");
        menuCanal = new JMenu("Canal");
        menuVideo = new JMenu("Vídeo");
        menuComentario = new JMenu("Comentário");
        menuAssinatura = new JMenu("Assinatura");
        
        menuBar.add(menuUsuario);
        menuBar.add(menuCanal);
        menuBar.add(menuVideo);
        menuBar.add(menuComentario);
        menuBar.add(menuAssinatura);

        painelPrincipal = new JPanel();
        this.add(painelPrincipal);

        telasUsuario = new TelasUsuario();
        telasCanal = new TelasCanal();
        telasVideo = new TelasVideo();
        telasComentario = new TelasComentario();
        telasAssinatura = new TelasAssinatura();

        status = new JLabel("Status");
        this.add(status, BorderLayout.SOUTH);
    }



    private void eventosMenuUsuario() {

        menuItemCriaUsuario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasUsuario.telaCriarUsuario());
                this.revalidate();
                this.repaint();
                status.setText("Criando novo usuário");
            }
        );

        menuItemListaUsuario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasUsuario.telaListarUsuario());
                this.revalidate();
                this.repaint();
                status.setText("Listando usuários");
            }
        );

        menuItemEditaUsuario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasUsuario.telaEditarUsuario());
                this.revalidate();
                this.repaint();
                status.setText("Editando usuário");
            }
        );

        menuItemApagaUsuario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasUsuario.telaApagarUsuario());
                this.revalidate();
                this.repaint();
                status.setText("Apagando usuário");
            }
        );

    }
    
    private void eventosMenuCanal() {
        menuItemCriaCanal.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasCanal.telaCriarCanal());
                this.revalidate();
                this.repaint();
                status.setText("Criando novo canal");
            }
        );

        menuItemListaCanal.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasCanal.telaListarCanal());
                this.revalidate();
                this.repaint();
                status.setText("Listando canais");
            }
        );

        menuItemEditaCanal.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasCanal.telaEditarCanal());
                this.revalidate();
                this.repaint();
                status.setText("Editando canal");
            }
        );

        menuItemApagaCanal.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasCanal.telaApagarCanal());
                this.revalidate();
                this.repaint();
                status.setText("Apagando canal");
            }
        );
    }
 
    private void eventosMenuVideo() {
        menuItemCriaVideo.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasVideo.telaCriarVideo());
                this.revalidate();
                this.repaint();
                status.setText("Criando novo vídeo");
            }
        );

        menuItemListaVideo.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasVideo.telaListarVideo());
                this.revalidate();
                this.repaint();
                status.setText("Listando vídeos");
            }
        );

        menuItemEditaVideo.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasVideo.telaEditarVideo());
                this.revalidate();
                this.repaint();
                status.setText("Editando vídeo");
            }
        );

        menuItemApagaVideo.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasVideo.telaApagarVideo());
                this.revalidate();
                this.repaint();
                status.setText("Apagando vídeo");
            }
        );
    }

    private void eventosMenuComentario() {
        menuItemCriaComentario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasComentario.telaCriarComentario());
                this.revalidate();
                this.repaint();
                status.setText("Criando novo comentário");
            }
        );

        menuItemListaComentario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasComentario.telaListarComentario());
                this.revalidate();
                this.repaint();
                status.setText("Listando comentários");
            }
        );

        menuItemEditaComentario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasComentario.telaEditarComentario());
                this.revalidate();
                this.repaint();
                status.setText("Editando comentário");
            }
        );

        menuItemApagaComentario.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasComentario.telaApagarComentario());
                this.revalidate();
                this.repaint();
                status.setText("Apagando comentário");
            }
        );
    }

    private void eventosMenuAssinatura() {
        menuItemCriaAssinatura.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasAssinatura.telaCriarAssinatura());
                this.revalidate();
                this.repaint();
                status.setText("Criando nova assinatura");
            }
        );

        menuItemListaAssinatura.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasAssinatura.telaListarAssinatura());
                this.revalidate();
                this.repaint();
                status.setText("Listando assinaturas");
            }
        );

        menuItemEditaAssinatura.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasAssinatura.telaEditarAssinatura());
                this.revalidate();
                this.repaint();
                status.setText("Editando assinatura");
            }
        );

        menuItemApagaAssinatura.addActionListener(
            (event) -> {
                painelPrincipal.removeAll();
                painelPrincipal.add(telasAssinatura.telaApagarAssinatura());
                this.revalidate();
                this.repaint();
                status.setText("Apagando assinatura");
            }
        );
    }

}
