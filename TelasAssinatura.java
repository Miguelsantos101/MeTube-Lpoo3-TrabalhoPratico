import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
 
public class TelasAssinatura extends JPanel {

    //#region Assinatura

        //#region Paineis de Assinatura
        JPanel 
        painelCriaAssinatura,
        painelListaAssinatura,
        painelEditaAssinatura,
        painelApagaAssinatura;
        //#endregion

        //#region Componentes de Assinatura

            //#region Componentes de Criar Assinatura
            JLabel 
            labelTitulo,
            labelNomeAssinatura,
            labelPreco;

            JTextField 
            textFieldNomeAssinatura,
            textFieldPreco;

            JButton 
            btnCriar;
            //#endregion
            
            //#region Componentes de Listar Assinatura
            JTable
            tbl;

            JScrollPane
            scrollPane;
            //#endregion

            //#region Componentes de Editar Assinatura
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

            //#region Componentes de Apagar Assinatura
            JButton
            btnApagar;
            //#endregion

        //#endregion

    //#endregion

    public TelasAssinatura() {

        painelCriaAssinatura = new JPanel();
        painelListaAssinatura = new JPanel();
        painelEditaAssinatura = new JPanel();
        painelApagaAssinatura = new JPanel();


        //#region Inicializando componentes de Criar Assinatura
        labelTitulo = new JLabel();
        labelNomeAssinatura = new JLabel();
        labelPreco = new JLabel();

        textFieldNomeAssinatura = new JTextField();
        textFieldPreco = new JTextField();

        btnCriar = new JButton();
        //#endregion

        //#region Inicializando componentes de Listar Assinatura
        tbl = new JTable();

        scrollPane = new JScrollPane();
        //#endregion

        //#region Inicializando componentes de Editar Assinatura
        labelId = new JLabel();

        painelDeEdicao = new JPanel();
        painelBotoes = new JPanel();
 
        caixa = Box.createRigidArea(new Dimension(0,400));

        textFieldId = new JTextField();

        btnSalvar = new JButton();
        btnEditar = new JButton();
        //#endregion

        //#region Inicializando componentes de Apagar Assinatura
        btnApagar = new JButton();
        //#endregion
        
        botoesAssinatura();
    }

    public JPanel telaCriarAssinatura() {

        // Tela: Criar Assinatura

        // Título
        labelTitulo.setText("Criar Assinatura");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulários
        labelNomeAssinatura.setText("Digite o nome da assinatura:");


        textFieldNomeAssinatura.setColumns(20);
        textFieldNomeAssinatura.setText(null);


        labelPreco.setText("Digite o preço da assinatura:");


        textFieldPreco.setColumns(20);
        textFieldPreco.setText(null);

        // Botões
        btnCriar.setText("Criar nova Assinatura");
        btnCriar.setBackground(Color.GREEN);


        // Adicionando componentes
        painelCriaAssinatura.setLayout(new BoxLayout(painelCriaAssinatura, BoxLayout.Y_AXIS));
        painelCriaAssinatura.add(labelTitulo);
        painelCriaAssinatura.add(labelNomeAssinatura);
        painelCriaAssinatura.add(textFieldNomeAssinatura);
        painelCriaAssinatura.add(labelPreco);
        painelCriaAssinatura.add(textFieldPreco);
        painelCriaAssinatura.add(btnCriar);

        return painelCriaAssinatura;
    }

    public JPanel telaListarAssinatura() {

        // Tela: Lista de Assinaturas

        // Título
        labelTitulo.setText("Lista de Assinaturas");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);


        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Adicionando componentes
        painelListaAssinatura.setLayout(new BorderLayout());
        painelListaAssinatura.add(labelTitulo, BorderLayout.NORTH);
        painelListaAssinatura.add(scrollPane, BorderLayout.CENTER);
        

        return painelListaAssinatura;
    }

    public JPanel telaEditarAssinatura() {

        // Tela: Editar Assinatura

        // Título
        labelTitulo.setText("Editar Assinatura");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));


        // Formulários
        labelId.setText("ID da Assinatura");

        textFieldId.setColumns(20);
        textFieldId.setText(null);
        textFieldId.setEditable(false);

        labelNomeAssinatura.setText("Nome da Assinatura");

        textFieldNomeAssinatura.setColumns(20);
        textFieldNomeAssinatura.setText(null);

        labelPreco.setText("Preço");

        textFieldPreco.setColumns(20);
        textFieldPreco.setText(null);

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
        painelEditaAssinatura.setLayout(new BorderLayout());
        painelEditaAssinatura.add(labelTitulo, BorderLayout.NORTH);
        painelDeEdicao.setLayout(new BoxLayout(painelDeEdicao, BoxLayout.Y_AXIS));
        painelDeEdicao.add(labelId);
        painelDeEdicao.add(textFieldId);
        painelDeEdicao.add(labelNomeAssinatura);
        painelDeEdicao.add(textFieldNomeAssinatura);
        painelDeEdicao.add(labelPreco);
        painelDeEdicao.add(textFieldPreco);
        painelDeEdicao.add(caixa);
        painelEditaAssinatura.add(painelDeEdicao, BorderLayout.WEST);
        painelEditaAssinatura.add(scrollPane, BorderLayout.CENTER);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelEditaAssinatura.add(painelBotoes, BorderLayout.EAST);

        return painelEditaAssinatura;
    }

    public JPanel telaApagarAssinatura() {

        // Tela: Apagar Assinatura

        // Título
        labelTitulo.setText("Apagar Assinatura");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));


        // Tabela
        carregaTabela();
        scrollPane.setViewportView(tbl);
        tbl.setDefaultEditor(Object.class, null);

        // Botões
        btnApagar.setText("Apagar");
        btnApagar.setBackground(Color.RED);


        // Adicionando componentes
        painelApagaAssinatura.setLayout(new BorderLayout());
        painelApagaAssinatura.add(labelTitulo, BorderLayout.NORTH);
        painelApagaAssinatura.add(scrollPane, BorderLayout.CENTER);
        painelApagaAssinatura.add(btnApagar, BorderLayout.SOUTH);

        return painelApagaAssinatura;
    }

    public void carregaTabela() {
        DefaultTableModel modelo = new DefaultTableModel( new Object[]{"ID da Assinatura", "Nome da Assinatura", "Preço"}, 0);
        
        try {
            for (int i = 0; i < MenuPrincipal.listaAssinaturaMenu.size(); i++) {
                Object linha[] = new Object[]{  MenuPrincipal.listaAssinaturaMenu.get(i).getId_assinatura(),
                                                MenuPrincipal.listaAssinaturaMenu.get(i).getNome_assinatura(),
                                                MenuPrincipal.listaAssinaturaMenu.get(i).getPreco()};
                modelo.addRow(linha);
            }
    
            tbl.setModel(modelo);
            tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (Exception e) {

        }

    }

    public void botoesAssinatura() {

        btnCriar.addActionListener(
            (event) -> {

                try {
                    MenuPrincipal.listaAssinaturaMenu.add(new Assinatura(   textFieldNomeAssinatura.getText(), 
                                                                            Integer.parseInt(textFieldPreco.getText())));
                    MenuPrincipal.painelPrincipal.removeAll();
                    MenuPrincipal.painelPrincipal.revalidate();
                    MenuPrincipal.painelPrincipal.repaint();
                    MenuPrincipal.status.setText("Assinatura criado com sucesso!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnSalvar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaAssinaturaMenu.size()) {
                    try {
                        MenuPrincipal.listaAssinaturaMenu.get(index).setNome_assinatura(textFieldNomeAssinatura.getText());
                        MenuPrincipal.listaAssinaturaMenu.get(index).setPreco(Integer.parseInt(textFieldPreco.getText()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Informações inválidas", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }

                    telaEditarAssinatura();
                    MenuPrincipal.status.setText("Assinatura salva com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione uma Assinatura", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnEditar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaAssinaturaMenu.size()) {
                    Assinatura A = MenuPrincipal.listaAssinaturaMenu.get(index);

                    textFieldId.setText(String.valueOf(A.getId_assinatura()));
                    textFieldNomeAssinatura.setText(A.getNome_assinatura());
                    textFieldPreco.setText(String.valueOf(A.getPreco()));

                    MenuPrincipal.status.setText("Editando Assinatura...");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione uma assinatura", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );

        btnApagar.addActionListener(
            (event) -> {
                int index = tbl.getSelectedRow();

                if(index >= 0 && index < MenuPrincipal.listaAssinaturaMenu.size()) {
                    MenuPrincipal.listaAssinaturaMenu.remove(index);
                    telaApagarAssinatura();
                    MenuPrincipal.status.setText("Assinatura deletada com sucesso!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selecione uma assinatura", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        );
    }
     
}
