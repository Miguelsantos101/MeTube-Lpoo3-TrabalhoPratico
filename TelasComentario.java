import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
 
public class TelasComentario extends JPanel {

    //#region Comentario

        //#region Paineis de Comentario
        JPanel 
        painelCriaComentario,
        painelListaComentario,
        painelEditaComentario,
        painelApagaComentario;
        //#endregion

        //#region Componentes de Comentario

            //#region Componentes de Criar Comentario
            JLabel 
            labelTitulo,
            labelTextoComentario,
            labelQtd_likes,
            labelCbUsuarioDono,
            labelCbVideoDono;
            
            JTextField 
            textFieldTextoComentario,
            textFieldQtd_likes;

            JComboBox<String>
            cbUsuarioDono,
            cbVideoDono;

            JButton 
            btnCriar;
            //#endregion
            
            //#region Componentes de Listar Comentario
            JTable
            tbl;

            JScrollPane
            scrollPane;
            //#endregion

            //#region Componentes de Editar Comentario
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

            //#region Componentes de Apagar Comentario
            JButton
            btnApagar;
            //#endregion

        //#endregion

    //#endregion

    public TelasComentario() {

        painelCriaComentario = new JPanel();
        painelListaComentario = new JPanel();
        painelEditaComentario = new JPanel();
        painelApagaComentario = new JPanel();


        //#region Inicializando componentes de Criar Comentario
        labelTitulo = new JLabel();
        labelTextoComentario = new JLabel();
        labelQtd_likes = new JLabel();
        labelCbUsuarioDono = new JLabel();
        labelCbVideoDono = new JLabel();

        textFieldTextoComentario = new JTextField();
        textFieldQtd_likes = new JTextField();

        cbUsuarioDono = new JComboBox<String>();
        cbVideoDono = new JComboBox<String>();

        btnCriar = new JButton();
        //#endregion

        //#region Inicializando componentes de Listar Comentario
        tbl = new JTable();

        scrollPane = new JScrollPane();
        //#endregion

        //#region Inicializando componentes de Editar Comentario
        labelId = new JLabel();

        painelDeEdicao = new JPanel();
        painelBotoes = new JPanel();
 
        caixa = Box.createRigidArea(new Dimension(0,400));

        textFieldId = new JTextField();

        btnSalvar = new JButton();
        btnEditar = new JButton();
        //#endregion

        //#region Inicializando componentes de Apagar Comentario
        btnApagar = new JButton();
        //#endregion
        
        botoesComentario();
    }

    public JPanel telaCriarComentario() {

        // Tela: Criar Comentario

        // Título
        labelTitulo.setText("Criar Comentário");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setAlignmentX(CENTER_ALIGNMENT);

        // Formulários
        labelTextoComentario.setText("Digite o texto do comentário:");
        labelTextoComentario.setAlignmentX(CENTER_ALIGNMENT);

        textFieldTextoComentario.setColumns(20);
        textFieldTextoComentario.setText(null);
        textFieldTextoComentario.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelQtd_likes.setText("Digite a quantidade likes no comentário:");
        labelQtd_likes.setAlignmentX(Component.CENTER_ALIGNMENT);

        textFieldQtd_likes.setColumns(20);
        textFieldQtd_likes.setText(null);
        textFieldQtd_likes.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelCbUsuarioDono.setText("Escolha o usuário que vai comentar:");
        labelCbUsuarioDono.setAlignmentX(CENTER_ALIGNMENT);

        carregaComboBoxUsuarioDono();

        labelCbVideoDono.setText("Escolha o vídeo para comentar:");
        labelCbVideoDono.setAlignmentX(CENTER_ALIGNMENT);

        carregaComboBoxVideoDono();

        // Botões
        btnCriar.setText("Criar novo Comentário");
        btnCriar.setBackground(Color.GREEN);
        btnCriar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando componentes
        painelCriaComentario.setLayout(new BoxLayout(painelCriaComentario, BoxLayout.Y_AXIS));
        painelCriaComentario.setSize(500, 500);
        painelCriaComentario.add(labelTitulo);
        painelCriaComentario.add(labelTextoComentario);
        painelCriaComentario.add(textFieldTextoComentario);
        painelCriaComentario.add(labelQtd_likes);
        painelCriaComentario.add(textFieldQtd_likes);
        painelCriaComentario.add(labelCbUsuarioDono);
        painelCriaComentario.add(cbUsuarioDono);
        painelCriaComentario.add(labelCbVideoDono);
        painelCriaComentario.add(cbVideoDono);
        painelCriaComentario.add(btnCriar);

        return painelCriaComentario;
    }

    public JPanel telaListarComentario() {

        // Tela: Lista de Comentários

        // Título
        labelTitulo.setText("Lista de Comentários");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Adicionando componentes
        painelListaComentario.setLayout(new BorderLayout());
        painelListaComentario.add(labelTitulo, BorderLayout.NORTH);
        painelListaComentario.add(scrollPane, BorderLayout.CENTER);
        

        return painelListaComentario;
    }

    public JPanel telaEditarComentario() {

        // Tela: Editar Comentario

        // Título
        labelTitulo.setText("Editar Comentário");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulários
        labelId.setText("ID do Comentário");

        textFieldId.setColumns(20);
        textFieldId.setText(null);
        textFieldId.setEditable(false);

        labelTextoComentario.setText("Texto");

        textFieldTextoComentario.setColumns(20);
        textFieldTextoComentario.setText(null);

        labelQtd_likes.setText("Likes");

        textFieldQtd_likes.setColumns(20);
        textFieldQtd_likes.setText(null);
        
        labelCbUsuarioDono.setText("Dono do Comentário");
        
        labelCbVideoDono.setText("Vídeo comentado");

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
        painelEditaComentario.setLayout(new BorderLayout());
        painelEditaComentario.add(labelTitulo, BorderLayout.NORTH);
        painelDeEdicao.setLayout(new BoxLayout(painelDeEdicao, BoxLayout.Y_AXIS));
        painelDeEdicao.add(labelId);
        painelDeEdicao.add(textFieldId);
        painelDeEdicao.add(labelTextoComentario);
        painelDeEdicao.add(textFieldTextoComentario);
        painelDeEdicao.add(labelQtd_likes);
        painelDeEdicao.add(textFieldQtd_likes);
        painelDeEdicao.add(labelCbUsuarioDono);
        painelDeEdicao.add(cbUsuarioDono);
        painelDeEdicao.add(labelCbVideoDono);
        painelDeEdicao.add(cbVideoDono);
        painelDeEdicao.add(caixa);
        painelEditaComentario.add(painelDeEdicao, BorderLayout.WEST);
        painelEditaComentario.add(scrollPane, BorderLayout.CENTER);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelEditaComentario.add(painelBotoes, BorderLayout.EAST);

        return painelEditaComentario;
    }

    public JPanel telaApagarComentario() {

        // Tela: Apagar Comentario

        // Título
        labelTitulo.setText("Apagar Comentário");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnApagar.setText("Apagar");
        btnApagar.setBackground(Color.RED);


        // Adicionando componentes
        painelApagaComentario.setLayout(new BorderLayout());
        painelApagaComentario.add(labelTitulo, BorderLayout.NORTH);
        painelApagaComentario.add(scrollPane, BorderLayout.CENTER);
        painelApagaComentario.add(btnApagar, BorderLayout.SOUTH);

        return painelApagaComentario;
    }

    public void carregaTabela() {
        DefaultTableModel modelo = new DefaultTableModel( new Object[]{"ID do Comentário", "Texto", "Likes", "Dono do comentário", "Vídeo comentado"}, 0);
        
        for (int i = 0; i < _2MenuPrincipal.listaComentarioMenu.size(); i++) {
            Object linha[] = new Object[]{  _2MenuPrincipal.listaComentarioMenu.get(i).getId_comentario(),
                                            _2MenuPrincipal.listaComentarioMenu.get(i).getTexto_comentario(),
                                            _2MenuPrincipal.listaComentarioMenu.get(i).getQtd_likes(),
                                            _2MenuPrincipal.listaComentarioMenu.get(i).getUsuario_dono().getNome(),
                                            _2MenuPrincipal.listaComentarioMenu.get(i).getVideo_dono().getTitulo_video()};
            modelo.addRow(linha);
        }
        tbl.setModel(modelo);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void carregaComboBoxUsuarioDono() {
        cbUsuarioDono.removeAllItems();

        for (int i = 0; i < _2MenuPrincipal.listaUsuarioMenu.size(); i++) {
            cbUsuarioDono.addItem(_2MenuPrincipal.listaUsuarioMenu.get(i).getNome());
        }
    }

    public void carregaComboBoxVideoDono() {
        cbVideoDono.removeAllItems();

        for (int i = 0; i < _2MenuPrincipal.listaVideoMenu.size(); i++) {
            cbVideoDono.addItem(_2MenuPrincipal.listaVideoMenu.get(i).getTitulo_video());
        }
    }

    public void botoesComentario() {

        btnCriar.addActionListener(
            (event) -> {
                if(_2MenuPrincipal.listaCanalMenu.size() < 1) {
                    JOptionPane.showMessageDialog(null, "É necessário pelo menos um usuário e um vídeo criado para criar um comentário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    try {
                        _2MenuPrincipal.listaComentarioMenu.add(new _6Comentario(   textFieldTextoComentario.getText(), 
                                                                                    Integer.parseInt(textFieldQtd_likes.getText()), 
                                                                                    _2MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex()),
                                                                                    _2MenuPrincipal.listaVideoMenu.get(cbVideoDono.getSelectedIndex())));
                        _2MenuPrincipal.painelPrincipal.removeAll();
                        _2MenuPrincipal.painelPrincipal.revalidate();
                        _2MenuPrincipal.painelPrincipal.repaint();
                        _2MenuPrincipal.status.setText("Comentario criado com sucesso!");

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        );

        btnSalvar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaComentarioMenu.size()) {
                    try {
                        _2MenuPrincipal.listaComentarioMenu.get(index).setTexto_comentario(textFieldTextoComentario.getText());
                        _2MenuPrincipal.listaComentarioMenu.get(index).setQtd_likes(Integer.parseInt(textFieldQtd_likes.getText()));
                        _2MenuPrincipal.listaComentarioMenu.get(index).setUsuario_dono(_2MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex()));
                        _2MenuPrincipal.listaComentarioMenu.get(index).setVideo_dono(_2MenuPrincipal.listaVideoMenu.get(cbVideoDono.getSelectedIndex()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                    telaEditarComentario();
                    _2MenuPrincipal.status.setText("Comentario salvo com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um Comentario", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnEditar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaComentarioMenu.size()) {
                    _6Comentario C = _2MenuPrincipal.listaComentarioMenu.get(index);

                    textFieldId.setText(String.valueOf(C.getId_comentario()));
                    textFieldTextoComentario.setText(C.getTexto_comentario());
                    textFieldQtd_likes.setText(String.valueOf(C.getQtd_likes()));
                    cbUsuarioDono.setSelectedItem(C.getUsuario_dono().getNome());
                    cbVideoDono.setSelectedItem(C.getVideo_dono().getTitulo_video());

                    _2MenuPrincipal.status.setText("Editando Comentario...");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um comentário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnApagar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaComentarioMenu.size()) {
                    _2MenuPrincipal.listaComentarioMenu.remove(index);
                    telaApagarComentario();
                    _2MenuPrincipal.status.setText("Comentario deletado com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um comentário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );
    }
     
}
