import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
 
public class TelasVideo extends JPanel {

    //#region Video

        //#region Paineis de Video
        JPanel 
        painelCriaVideo,
        painelListaVideo,
        painelEditaVideo,
        painelApagaVideo;
        //#endregion

        //#region Componentes de Video

            //#region Componentes de Criar Video
            JLabel 
            labelTitulo,
            labelTituloVideo,
            labelDt_Lancamento,
            labelQtd_likes,
            labelCbCanalDono;
            
            JTextField 
            textFieldTituloVideo,
            textFieldDt_Lancamento,
            textFieldQtd_likes;

            JComboBox<String>
            cbCanalDono;

            JButton 
            btnCriar;
            //#endregion
            
            //#region Componentes de Listar Video
            JTable
            tbl;

            JScrollPane
            scrollPane;
            //#endregion

            //#region Componentes de Editar Video
            JLabel
            labelId;

            JPanel
            painelDeEdicao,
            painelBotoes;

            Component 
            caixa;

            JTextField
            textFieldId;

            JButton
            btnSalvar,
            btnEditar;
            //#endregion

            //#region Componentes de Apagar Video
            JButton
            btnApagar;
            //#endregion

        //#endregion

    //#endregion

    public TelasVideo() {

        painelCriaVideo = new JPanel();
        painelListaVideo = new JPanel();
        painelEditaVideo = new JPanel();
        painelApagaVideo = new JPanel();


        //#region Inicializando componentes de Criar Video
        labelTitulo = new JLabel();
        labelTituloVideo = new JLabel();
        labelDt_Lancamento = new JLabel();
        labelQtd_likes = new JLabel();
        labelCbCanalDono = new JLabel();

        textFieldTituloVideo = new JTextField();
        textFieldDt_Lancamento = new JTextField();
        textFieldQtd_likes = new JTextField();

        cbCanalDono = new JComboBox<String>();

        btnCriar = new JButton();
        //#endregion

        //#region Inicializando componentes de Listar Video
        tbl = new JTable();

        scrollPane = new JScrollPane();
        //#endregion

        //#region Inicializando componentes de Editar Video
        labelId = new JLabel();

        painelDeEdicao = new JPanel();
        painelBotoes = new JPanel();
 
        caixa = Box.createRigidArea(new Dimension(0,400));

        textFieldId = new JTextField();

        btnSalvar = new JButton();
        btnEditar = new JButton();
        //#endregion

        //#region Inicializando componentes de Apagar Video
        btnApagar = new JButton();
        //#endregion
        
        botoesVideo();
    }

    public JPanel telaCriarVideo() {

        // Tela: Criar Video

        // Título
        labelTitulo.setText("Criar Vídeo");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulários
        labelTituloVideo.setText("Digite o título do vídeo:");


        textFieldTituloVideo.setColumns(20);
        textFieldTituloVideo.setText(null);


        labelDt_Lancamento.setText("Digite a data de lançamento do vídeo:");


        textFieldDt_Lancamento.setColumns(20);
        textFieldDt_Lancamento.setText(null);


        labelQtd_likes.setText("Digite a quantidade likes no vídeo:");


        textFieldQtd_likes.setColumns(20);
        textFieldQtd_likes.setText(null);


        labelCbCanalDono.setText("Escolha o dono do vídeo:");


        carregaComboBoxCanalDono();

        // Botões
        btnCriar.setText("Criar novo Vídeo");
        btnCriar.setBackground(Color.GREEN);


        // Adicionando componentes
        painelCriaVideo.setLayout(new BoxLayout(painelCriaVideo, BoxLayout.Y_AXIS));
        painelCriaVideo.add(labelTitulo);
        painelCriaVideo.add(labelTituloVideo);
        painelCriaVideo.add(textFieldTituloVideo);
        painelCriaVideo.add(labelDt_Lancamento);
        painelCriaVideo.add(textFieldDt_Lancamento);
        painelCriaVideo.add(labelQtd_likes);
        painelCriaVideo.add(textFieldQtd_likes);
        painelCriaVideo.add(labelCbCanalDono);
        painelCriaVideo.add(cbCanalDono);
        painelCriaVideo.add(btnCriar);

        return painelCriaVideo;
    }

    public JPanel telaListarVideo() {

        // Tela: Lista de Vídeos

        // Título
        labelTitulo.setText("Lista de Vídeos");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Adicionando componentes
        painelListaVideo.setLayout(new BorderLayout());
        painelListaVideo.add(labelTitulo, BorderLayout.NORTH);
        painelListaVideo.add(scrollPane, BorderLayout.CENTER);
        

        return painelListaVideo;
    }

    public JPanel telaEditarVideo() {

        // Tela: Editar Video

        // Título
        labelTitulo.setText("Editar Vídeo");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Formulários
        labelId.setText("ID do Vídeo");

        textFieldId.setColumns(20);
        textFieldId.setText(null);
        textFieldId.setEditable(false);

        labelTituloVideo.setText("Título");

        textFieldTituloVideo.setColumns(20);
        textFieldTituloVideo.setText(null);

        labelDt_Lancamento.setText("Data de lançamento");

        textFieldDt_Lancamento.setColumns(20);
        textFieldDt_Lancamento.setText(null);

        labelQtd_likes.setText("Likes");

        textFieldQtd_likes.setColumns(20);
        textFieldQtd_likes.setText(null);

        labelCbCanalDono.setText("Dono do Vídeo");

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnSalvar.setText("Salvar");
        btnSalvar.setBackground(Color.GREEN);


        btnEditar.setText("Editar");
        btnEditar.setBackground(Color.BLUE);

        // Adicionando componentes
        painelEditaVideo.setLayout(new BorderLayout());
        painelEditaVideo.add(labelTitulo, BorderLayout.NORTH);
        painelDeEdicao.setLayout(new BoxLayout(painelDeEdicao, BoxLayout.Y_AXIS));
        painelDeEdicao.add(labelId);
        painelDeEdicao.add(textFieldId);
        painelDeEdicao.add(labelTituloVideo);
        painelDeEdicao.add(textFieldTituloVideo);
        painelDeEdicao.add(labelDt_Lancamento);
        painelDeEdicao.add(textFieldDt_Lancamento);
        painelDeEdicao.add(labelQtd_likes);
        painelDeEdicao.add(textFieldQtd_likes);
        painelDeEdicao.add(labelCbCanalDono);
        painelDeEdicao.add(cbCanalDono);
        painelDeEdicao.add(caixa);
        painelEditaVideo.add(painelDeEdicao, BorderLayout.WEST);
        painelEditaVideo.add(scrollPane, BorderLayout.CENTER);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelEditaVideo.add(painelBotoes, BorderLayout.EAST);

        return painelEditaVideo;
    }

    public JPanel telaApagarVideo() {

        // Tela: Apagar Video

        // Título
        labelTitulo.setText("Apagar Vídeo");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnApagar.setText("Apagar");
        btnApagar.setBackground(Color.RED);


        // Adicionando componentes
        painelApagaVideo.setLayout(new BorderLayout());
        painelApagaVideo.add(labelTitulo, BorderLayout.NORTH);
        painelApagaVideo.add(scrollPane, BorderLayout.CENTER);
        painelApagaVideo.add(btnApagar, BorderLayout.SOUTH);

        return painelApagaVideo;
    }

    public void carregaTabela() {
        DefaultTableModel modelo = new DefaultTableModel( new Object[]{"ID do Vídeo", "Título", "Data de lançamento", "Likes", "Dono do vídeo"}, 0);
        
        for (int i = 0; i < MenuPrincipal.listaVideoMenu.size(); i++) {
            Object linha[] = new Object[]{  MenuPrincipal.listaVideoMenu.get(i).getId_video(),
                                            MenuPrincipal.listaVideoMenu.get(i).getTitulo_video(),
                                            MenuPrincipal.listaVideoMenu.get(i).getDt_lancamento(),
                                            MenuPrincipal.listaVideoMenu.get(i).getQtd_likes(),
                                            MenuPrincipal.listaVideoMenu.get(i).getCanal_dono().getNome_canal()};
            modelo.addRow(linha);
        }
        tbl.setModel(modelo);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void carregaComboBoxCanalDono() {
        cbCanalDono.removeAllItems();

        for (int i = 0; i < MenuPrincipal.listaCanalMenu.size(); i++) {
            cbCanalDono.addItem(MenuPrincipal.listaCanalMenu.get(i).getNome_canal());
        }
    }

    public void botoesVideo() {

        btnCriar.addActionListener(
            (event) -> {
                if(MenuPrincipal.listaCanalMenu.size() < 1) {
                    JOptionPane.showMessageDialog(null, "É necessário pelo menos um canal criado para criar um vídeo", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    try {
                        MenuPrincipal.listaVideoMenu.add(new Video( textFieldTituloVideo.getText(), 
                                                                        textFieldDt_Lancamento.getText(), 
                                                                        Integer.parseInt(textFieldQtd_likes.getText()), 
                                                                        MenuPrincipal.listaCanalMenu.get(cbCanalDono.getSelectedIndex())));
                        MenuPrincipal.painelPrincipal.removeAll();
                        MenuPrincipal.painelPrincipal.revalidate();
                        MenuPrincipal.painelPrincipal.repaint();
                        MenuPrincipal.status.setText("Video criado com sucesso!");

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        );

        btnSalvar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaVideoMenu.size()) {
                    try {
                        MenuPrincipal.listaVideoMenu.get(index).setTitulo_video(textFieldTituloVideo.getText());
                        MenuPrincipal.listaVideoMenu.get(index).setDt_lancamento(textFieldDt_Lancamento.getText());
                        MenuPrincipal.listaVideoMenu.get(index).setQtd_likes(Integer.parseInt(textFieldQtd_likes.getText()));
                        MenuPrincipal.listaVideoMenu.get(index).setCanal_dono(MenuPrincipal.listaCanalMenu.get(cbCanalDono.getSelectedIndex()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                    telaEditarVideo();
                    MenuPrincipal.status.setText("Video salvo com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um Video", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnEditar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaVideoMenu.size()) {
                    Video V = MenuPrincipal.listaVideoMenu.get(index);

                    textFieldId.setText(String.valueOf(V.getId_video()));
                    textFieldTituloVideo.setText(V.getTitulo_video());
                    textFieldDt_Lancamento.setText(V.getDt_lancamento());
                    textFieldQtd_likes.setText(String.valueOf(V.getQtd_likes()));
                    cbCanalDono.setSelectedItem(V.getCanal_dono().getNome_canal());

                    MenuPrincipal.status.setText("Editando Video...");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um vídeo", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnApagar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaVideoMenu.size()) {
                    MenuPrincipal.listaVideoMenu.remove(index);
                    telaApagarVideo();
                    MenuPrincipal.status.setText("Video deletado com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um vídeo", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );
    }
     
}
