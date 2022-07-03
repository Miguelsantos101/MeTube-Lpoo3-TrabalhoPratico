import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class TelasCanal extends JPanel {

    //#region Canal

        //#region Paineis de Canal
        JPanel 
        painelCriaCanal,
        painelListaCanal,
        painelEditaCanal,
        painelApagaCanal;
        //#endregion

        //#region Componentes de Canal

            //#region Componentes de Criar Canal
            JLabel 
            labelTitulo,
            labelNomeCanal,
            labelDt_Criacao,
            labelCbUsuarioDono,
            labelAssinatura;
            
            JTextField 
            textFieldNomeCanal,
            textFieldDt_Criacao;

            JComboBox<String>
            cbUsuarioDono,
            cbAssinatura;

            JButton 
            btnCriar;
            //#endregion
            
            //#region Componentes de Listar Canal
            JTable
            tbl;

            JScrollPane
            scrollPane;
            //#endregion

            //#region Componentes de Editar Canal
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

            //#region Componentes de Apagar Canal
            JButton
            btnApagar;
            //#endregion

        //#endregion

    //#endregion

    public TelasCanal() {

        painelCriaCanal = new JPanel();
        painelListaCanal = new JPanel();
        painelEditaCanal = new JPanel();
        painelApagaCanal = new JPanel();


        //#region Inicializando componentes de Criar Canal
        labelTitulo = new JLabel();
        labelNomeCanal = new JLabel();
        labelDt_Criacao = new JLabel();
        labelCbUsuarioDono = new JLabel();
        labelAssinatura = new JLabel();

        textFieldNomeCanal = new JTextField();
        textFieldDt_Criacao = new JTextField();

        cbUsuarioDono = new JComboBox<String>();
        cbAssinatura = new JComboBox<String>();

        btnCriar = new JButton();
        //#endregion

        //#region Inicializando componentes de Listar Canal
        tbl = new JTable();

        scrollPane = new JScrollPane();
        //#endregion

        //#region Inicializando componentes de Editar Canal
        labelId = new JLabel();

        painelDeEdicao = new JPanel();
        painelBotoes = new JPanel();
 
        caixa = Box.createRigidArea(new Dimension(0,400));

        textFieldId = new JTextField();

        btnSalvar = new JButton();
        btnEditar = new JButton();
        //#endregion

        //#region Inicializando componentes de Apagar Canal
        btnApagar = new JButton();
        //#endregion
        
        botoesCanal();
    }

    public JPanel telaCriarCanal() {

        // Tela: Criar Canal

        // Título
        labelTitulo.setText("Criar Canal");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulários
        labelNomeCanal.setText("Digite o nome do canal:");


        textFieldNomeCanal.setColumns(20);
        textFieldNomeCanal.setText(null);


        labelDt_Criacao.setText("Digite a data de criação do canal:");


        textFieldDt_Criacao.setColumns(20);
        textFieldDt_Criacao.setText(null);


        labelCbUsuarioDono.setText("Escolha o dono do canal:");

        carregaComboBoxUsuarioDono();

        labelAssinatura.setText("Escolha uma assinatura: (opcional)");

        carregaComboBoxAssinatura();

        // Botões
        btnCriar.setText("Criar novo Canal");
        btnCriar.setBackground(Color.GREEN);

        // Adicionando componentes
        painelCriaCanal.setLayout(new BoxLayout(painelCriaCanal, BoxLayout.Y_AXIS));
        painelCriaCanal.add(labelTitulo);
        painelCriaCanal.add(labelNomeCanal);
        painelCriaCanal.add(textFieldNomeCanal);
        painelCriaCanal.add(labelDt_Criacao);
        painelCriaCanal.add(textFieldDt_Criacao);
        painelCriaCanal.add(labelCbUsuarioDono);
        painelCriaCanal.add(cbUsuarioDono);
        painelCriaCanal.add(labelAssinatura);
        painelCriaCanal.add(cbAssinatura);
        painelCriaCanal.add(btnCriar);

        return painelCriaCanal;
    }

    public JPanel telaListarCanal() {

        // Tela: Lista de Canais

        // Título
        labelTitulo.setText("Lista de Canais");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Adicionando componentes
        painelListaCanal.setLayout(new BorderLayout());
        painelListaCanal.add(labelTitulo, BorderLayout.NORTH);
        painelListaCanal.add(scrollPane, BorderLayout.CENTER);
        

        return painelListaCanal;
    }

    public JPanel telaEditarCanal() {

        // Tela: Editar Canal

        // Título
        labelTitulo.setText("Editar Canal");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Formulários
        labelId.setText("ID do canal");

        textFieldId.setColumns(20);
        textFieldId.setText(null);
        textFieldId.setEditable(false);

        labelNomeCanal.setText("Nome do canal");

        textFieldNomeCanal.setColumns(20);
        textFieldNomeCanal.setText(null);

        labelDt_Criacao.setText("Data de criação");

        textFieldDt_Criacao.setColumns(20);
        textFieldDt_Criacao.setText(null);

        labelCbUsuarioDono.setText("Usuário dono");
        
        carregaComboBoxUsuarioDono();

        labelAssinatura.setText("Assinatura");

        carregaComboBoxAssinatura();

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
        painelEditaCanal.setLayout(new BorderLayout());
        painelEditaCanal.add(labelTitulo, BorderLayout.NORTH);
        painelDeEdicao.setLayout(new BoxLayout(painelDeEdicao, BoxLayout.Y_AXIS));
        painelDeEdicao.add(labelId);
        painelDeEdicao.add(textFieldId);
        painelDeEdicao.add(labelNomeCanal);
        painelDeEdicao.add(textFieldNomeCanal);
        painelDeEdicao.add(labelDt_Criacao);
        painelDeEdicao.add(textFieldDt_Criacao);
        painelDeEdicao.add(labelCbUsuarioDono);
        painelDeEdicao.add(cbUsuarioDono);
        painelDeEdicao.add(labelAssinatura);
        painelDeEdicao.add(cbAssinatura);
        painelDeEdicao.add(caixa);
        painelEditaCanal.add(painelDeEdicao, BorderLayout.WEST);
        painelEditaCanal.add(scrollPane, BorderLayout.CENTER);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelEditaCanal.add(painelBotoes, BorderLayout.EAST);

        return painelEditaCanal;
    }

    public JPanel telaApagarCanal() {

        // Tela: Apagar Canal

        // Título
        labelTitulo.setText("Apagar Canal");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        

        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnApagar.setText("Apagar");
        btnApagar.setBackground(Color.RED);


        // Adicionando componentes
        painelApagaCanal.setLayout(new BorderLayout());
        painelApagaCanal.add(labelTitulo, BorderLayout.NORTH);
        painelApagaCanal.add(scrollPane, BorderLayout.CENTER);
        painelApagaCanal.add(btnApagar, BorderLayout.SOUTH);

        return painelApagaCanal;
    }

    public void carregaTabela() {
        DefaultTableModel modelo = new DefaultTableModel( new Object[]{"ID do canal", "Nome", "Data de Criação", "Dono do canal", "Assinatura"}, 0);
        
        try {
            for (int i = 0; i < MenuPrincipal.listaCanalMenu.size(); i++) {
                Object linha[] = new Object[]{  MenuPrincipal.listaCanalMenu.get(i).getId_canal(),
                                                MenuPrincipal.listaCanalMenu.get(i).getNome_canal(),
                                                MenuPrincipal.listaCanalMenu.get(i).getDt_criacao(),
                                                MenuPrincipal.listaCanalMenu.get(i).getUsuario_dono().getNome(),
                                                MenuPrincipal.listaCanalMenu.get(i).getAssinatura().getNome_assinatura()};
                modelo.addRow(linha);
            }
            tbl.setModel(modelo);
            tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        } catch (Exception e) {
            
        }

    }

    public void carregaComboBoxUsuarioDono() {
        cbUsuarioDono.removeAllItems();

        for (int i = 0; i < MenuPrincipal.listaUsuarioMenu.size(); i++) {
            cbUsuarioDono.addItem(MenuPrincipal.listaUsuarioMenu.get(i).getNome());
        }
    }

    public void carregaComboBoxAssinatura() {
        cbAssinatura.removeAllItems();
        cbAssinatura.addItem("Selecione");

        for (int i = 0; i < MenuPrincipal.listaAssinaturaMenu.size(); i++) {
            cbAssinatura.addItem(MenuPrincipal.listaAssinaturaMenu.get(i).getNome_assinatura());
        }
    }

    public void botoesCanal() {

        btnCriar.addActionListener(
            (event) -> {
                if(MenuPrincipal.listaUsuarioMenu.size() < 1) {
                    JOptionPane.showMessageDialog(null, "É necessário pelo menos um usuário criado para criar um canal", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    if (cbAssinatura.getSelectedIndex() == 0) {
                        try {
                            MenuPrincipal.listaCanalMenu.add(new Canal( textFieldNomeCanal.getText(), 
                                                                        textFieldDt_Criacao.getText(), 
                                                                        MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex())));
                            MenuPrincipal.painelPrincipal.removeAll();
                            MenuPrincipal.painelPrincipal.revalidate();
                            MenuPrincipal.painelPrincipal.repaint();
                            MenuPrincipal.status.setText("Canal criado com sucesso!");
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else {
                        try {
                            MenuPrincipal.listaCanalMenu.add(new Canal( textFieldNomeCanal.getText(), 
                                                                        textFieldDt_Criacao.getText(), 
                                                                        MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex()),
                                                                        MenuPrincipal.listaAssinaturaMenu.get(cbAssinatura.getSelectedIndex() - 1)));
                            MenuPrincipal.painelPrincipal.removeAll();
                            MenuPrincipal.painelPrincipal.revalidate();
                            MenuPrincipal.painelPrincipal.repaint();
                            MenuPrincipal.status.setText("Canal criado com sucesso!");
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                }
            }
        );

        btnSalvar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaCanalMenu.size()) {
                    if (cbAssinatura.getSelectedIndex() == 0) {
                        try {
                            MenuPrincipal.listaCanalMenu.get(index).setNome_canal(textFieldNomeCanal.getText());
                            MenuPrincipal.listaCanalMenu.get(index).setDt_criacao(textFieldDt_Criacao.getText());
                            MenuPrincipal.listaCanalMenu.get(index).setUsuario_dono(MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex()));
                            
        
                            telaEditarCanal();
                            MenuPrincipal.status.setText("Canal salvo com sucesso!");
                    
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    
                        }

                    }
                    else{
                        try {
                            MenuPrincipal.listaCanalMenu.get(index).setNome_canal(textFieldNomeCanal.getText());
                            MenuPrincipal.listaCanalMenu.get(index).setDt_criacao(textFieldDt_Criacao.getText());
                            MenuPrincipal.listaCanalMenu.get(index).setUsuario_dono(MenuPrincipal.listaUsuarioMenu.get(cbUsuarioDono.getSelectedIndex()));
                            MenuPrincipal.listaCanalMenu.get(index).setAssinatura(MenuPrincipal.listaAssinaturaMenu.get(cbAssinatura.getSelectedIndex() - 1));
        
                            telaEditarCanal();
                            MenuPrincipal.status.setText("Canal salvo com sucesso!");
                    
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um Canal", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnEditar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaCanalMenu.size()) {
                    Canal C = MenuPrincipal.listaCanalMenu.get(index);

                    textFieldId.setText(String.valueOf(C.getId_canal()));
                    textFieldNomeCanal.setText(C.getNome_canal());
                    textFieldDt_Criacao.setText(C.getDt_criacao());
                    cbUsuarioDono.setSelectedItem(C.getUsuario_dono().getNome());
                    cbAssinatura.setSelectedItem(C.getAssinatura().getNome_assinatura());


                    MenuPrincipal.status.setText("Editando Canal...");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um canal", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnApagar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaCanalMenu.size()) {
                    MenuPrincipal.listaCanalMenu.remove(index);
                    telaApagarCanal();
                    MenuPrincipal.status.setText("Canal deletado com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione um canal", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );
    }
    
}
