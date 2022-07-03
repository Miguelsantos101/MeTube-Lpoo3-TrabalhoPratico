import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class TelasUsuario extends JPanel{

    //#region Usuário

        //#region Paineis de Usuário
        JPanel 
        painelCriaUsuario,
        painelListaUsuario,
        painelEditaUsuario,
        painelApagaUsuario;
        //#endregion

        //#region Componentes de Usuário

            //#region Componentes de Criar Usuário
            JLabel 
            labelTitulo,
            labelNome,
            labelDt_Nasc;
            
            JTextField 
            textFieldNome,
            textFieldDt_Nasc;

            JButton 
            btnCriar;
            //#endregion
            
            //#region Componentes de Listar Usuário
            JTable
            tbl;

            JScrollPane
            scrollPane;
            //#endregion

            //#region Componentes de Editar Usuário
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

            //#region Componentes de Apagar Usuário
            JButton
            btnApagar;
            //#endregion

        //#endregion

    //#endregion

    public TelasUsuario() {

        painelCriaUsuario = new JPanel();
        painelListaUsuario = new JPanel();
        painelEditaUsuario = new JPanel();
        painelApagaUsuario = new JPanel();


        //#region Inicializando componentes de Criar Usuário
        labelTitulo = new JLabel();
        labelNome = new JLabel();
        labelDt_Nasc = new JLabel();

        textFieldNome = new JTextField();
        textFieldDt_Nasc = new JTextField();

        btnCriar = new JButton();
        //#endregion

        //#region Inicializando componentes de Listar Usuário
        tbl = new JTable();

        scrollPane = new JScrollPane();
        //#endregion

        //#region Inicializando componentes de Editar Usuário
        labelId = new JLabel();

        painelDeEdicao = new JPanel();
        painelBotoes = new JPanel();
 
        caixa = Box.createRigidArea(new Dimension(0,400));

        textFieldId = new JTextField();

        btnSalvar = new JButton();
        btnEditar = new JButton();
        //#endregion

        //#region Componentes de Apagar Usuário
        btnApagar = new JButton();
        //#endregion
        
        
        botoesUsuario();
    }

    public JPanel telaCriarUsuario() {

        // Tela: Criar usuário

        // Título
        labelTitulo.setText("Criar usuário");
        labelTitulo.setFont(new Font("Inter", Font.BOLD, 36));
        labelTitulo.setAlignmentX(CENTER_ALIGNMENT);

        // Formulários
        labelNome.setText("Digite o nome do usuário:");
        labelNome.setAlignmentX(CENTER_ALIGNMENT);

        textFieldNome.setColumns(20);
        textFieldNome.setText(null);
        textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelDt_Nasc.setText("Digite a data de nascimento:");
        labelDt_Nasc.setAlignmentX(Component.CENTER_ALIGNMENT);

        textFieldDt_Nasc.setColumns(20);
        textFieldDt_Nasc.setText(null);
        textFieldDt_Nasc.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botões
        btnCriar.setText("Criar novo usuário");
        btnCriar.setBackground(Color.GREEN);
        btnCriar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando componentes
        painelCriaUsuario.setLayout(new BoxLayout(painelCriaUsuario, BoxLayout.Y_AXIS));
        painelCriaUsuario.setSize(500, 500);
        painelCriaUsuario.add(labelTitulo);
        painelCriaUsuario.add(labelNome);
        painelCriaUsuario.add(textFieldNome);
        painelCriaUsuario.add(labelDt_Nasc);
        painelCriaUsuario.add(textFieldDt_Nasc);
        painelCriaUsuario.add(btnCriar);

        return painelCriaUsuario;
    }

    public JPanel telaListarUsuario() {

        // Tela: Lista de usuários

        // Título
        labelTitulo.setText("Lista de usuários");
        labelTitulo.setFont(new Font("Inter", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Tabela
        carregaTabelaListaUsuario();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Adicionando componentes
        painelListaUsuario.setLayout(new BorderLayout());
        painelListaUsuario.add(labelTitulo, BorderLayout.NORTH);
        painelListaUsuario.add(scrollPane, BorderLayout.CENTER);
        

        return painelListaUsuario;
    }

    public JPanel telaEditarUsuario() {

        // Tela: Editar usuários

        // Título
        labelTitulo.setText("Editar usuários");
        labelTitulo.setFont(new Font("Inter", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulários
        labelId.setText("ID do usuário");

        textFieldId.setColumns(20);
        textFieldId.setText(null);
        textFieldId.setEditable(false);

        labelNome.setText("Nome do usuário");

        textFieldNome.setColumns(20);
        textFieldNome.setText(null);

        labelDt_Nasc.setText("Data de Nascimento");

        textFieldDt_Nasc.setColumns(20);
        textFieldDt_Nasc.setText(null);

        // Tabela
        carregaTabelaListaUsuario();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnSalvar.setText("Salvar");
        btnSalvar.setBackground(Color.GREEN);


        btnEditar.setText("Editar");
        btnEditar.setBackground(Color.BLUE);

        // Adicionando componentes
        painelEditaUsuario.setLayout(new BorderLayout());
        painelEditaUsuario.add(labelTitulo, BorderLayout.NORTH);
        painelDeEdicao.setLayout(new BoxLayout(painelDeEdicao, BoxLayout.Y_AXIS));
        painelDeEdicao.add(labelId);
        painelDeEdicao.add(textFieldId);
        painelDeEdicao.add(labelNome);
        painelDeEdicao.add(textFieldNome);
        painelDeEdicao.add(labelDt_Nasc);
        painelDeEdicao.add(textFieldDt_Nasc);
        painelDeEdicao.add(caixa);
        painelEditaUsuario.add(painelDeEdicao, BorderLayout.WEST);
        painelEditaUsuario.add(scrollPane, BorderLayout.CENTER);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelEditaUsuario.add(painelBotoes, BorderLayout.SOUTH);

        return painelEditaUsuario;
    }

    public JPanel telaApagarUsuario() {

        // Tela: Apagar usuários

        // Título
        labelTitulo.setText("Apagar usuários");
        labelTitulo.setFont(new Font("Inter", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Tabela
        carregaTabelaListaUsuario();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnApagar.setText("Apagar");
        btnApagar.setBackground(Color.RED);


        // Adicionando componentes
        painelApagaUsuario.setLayout(new BorderLayout());
        painelApagaUsuario.add(labelTitulo, BorderLayout.NORTH);
        painelApagaUsuario.add(scrollPane, BorderLayout.CENTER);
        painelApagaUsuario.add(btnApagar, BorderLayout.SOUTH);

        return painelApagaUsuario;
    }

    public void carregaTabelaListaUsuario() {
        DefaultTableModel modelo = new DefaultTableModel( new Object[]{"ID do usuário", "Nome", "Data de Nascimento"}, 0);
        
        for (int i = 0; i < _2MenuPrincipal.listaUsuarioMenu.size(); i++) {
            Object linha[] = new Object[]{  _2MenuPrincipal.listaUsuarioMenu.get(i).getId_usuario(),
                                            _2MenuPrincipal.listaUsuarioMenu.get(i).getNome(),
                                            _2MenuPrincipal.listaUsuarioMenu.get(i).getDt_nascimento()};
            modelo.addRow(linha);
        }
        tbl.setModel(modelo);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void botoesUsuario() {

        btnCriar.addActionListener(
            (event) -> {
                try {
                    _2MenuPrincipal.listaUsuarioMenu.add(new _3Usuario(textFieldNome.getText(), textFieldDt_Nasc.getText()));
                    _2MenuPrincipal.painelPrincipal.removeAll();
                    _2MenuPrincipal.painelPrincipal.revalidate();
                    _2MenuPrincipal.painelPrincipal.repaint();
                    _2MenuPrincipal.status.setText("Usuário criado com sucesso!");
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        );

        btnSalvar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaUsuarioMenu.size()) {
                    try {
                        _2MenuPrincipal.listaUsuarioMenu.get(index).setNome(textFieldNome.getText());
                        _2MenuPrincipal.listaUsuarioMenu.get(index).setDt_nascimento(textFieldDt_Nasc.getText());
    
                        telaEditarUsuario();
                        _2MenuPrincipal.status.setText("Usuário salvo com sucesso!");
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnEditar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaUsuarioMenu.size()) {
                    _3Usuario U = _2MenuPrincipal.listaUsuarioMenu.get(index);

                    textFieldId.setText(String.valueOf(U.getId_usuario()));
                    textFieldNome.setText(U.getNome());
                    textFieldDt_Nasc.setText(U.getDt_nascimento());

                    _2MenuPrincipal.status.setText("Editando usuário...");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnApagar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < _2MenuPrincipal.listaUsuarioMenu.size()) {
                    _2MenuPrincipal.listaUsuarioMenu.remove(index);
                    telaApagarUsuario();
                    _2MenuPrincipal.status.setText("Usuário deletado com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );
    }
    
}
