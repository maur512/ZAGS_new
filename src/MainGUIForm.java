import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class MainGUIForm extends JFrame{

    private static final String[] PERSONS_COL = {"id",
                                            "name",
                                            "lastname",
                                            "surname",
                                            "passportnumber",
                                            "passportser",
                                            "adress",
                                            "birth",
                                            "phonenum"};

    private static final String[] SOR_COL = {
                                                    "name",
                                                    "lastname",
                                                    "surname",
                                                    "passportnumber",
                                                    "passportser",
                                                    "adress",
                                                    "birth",
                                                    "phonenum",
                                                    "num",
                                                    "is_terminate",
                                                    "registry",
                                                    "id",
                                                    "vidano",
                                                    "descript"
                                                    };



    private JTable mainTable;
    private JPanel mainPanel;
    private JButton showMenButton;
    private JButton showWomenButton;
    private JButton showSvidet_o_brakeButton;
    private JButton showSvidet_o_rozdMButton;
    private JButton showSvidet_o_rozd_WButton;
    private JButton show_SODMButton;
    private JButton showSODWButton;

    MainGUIForm () {
        super("ЗАГС хелпер");
        ImageIcon img = new ImageIcon("C:/Projects/Java/ZAGS_new/src/icon.png");
        setIconImage(img.getImage());
        DefaultTableModel model;
        model = new DefaultTableModel(DBQuiery.getAllpersons(DBQuiery.GET_ALL_MAN_PREPARED_STATEMENT),new Vector<>(Arrays.asList(PERSONS_COL)));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getJMenuPersons());
        setJMenuBar(menuBar);
        mainTable.setModel(model);
        mainTable.repaint();
        setContentPane(mainPanel);
        setSize(1280,720);
        setVisible(true);


// ------------------------ Листенеры основной панели ---------------------------
        showMenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllpersons(DBQuiery.GET_ALL_MAN_PREPARED_STATEMENT),new Vector<>(Arrays.asList(PERSONS_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });
        showWomenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllpersons(DBQuiery.GET_ALL_WOMAN_PREPARED_STATEMENT),new Vector<>(Arrays.asList(PERSONS_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });
        showSvidet_o_brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showSvidet_o_rozdMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllSO(DBQuiery.GET_ALL_SORM_PREPARED_STATEMENT),new Vector<>(Arrays.asList(SOR_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });
        showSvidet_o_rozd_WButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllSO(DBQuiery.GET_ALL_SORW_PREPARED_STATEMENT),new Vector<>(Arrays.asList(SOR_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });
        show_SODMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllSO(DBQuiery.GET_ALL_SODM_PREPARED_STATEMENT),new Vector<>(Arrays.asList(SOR_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });
        showSODWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllSO(DBQuiery.GET_ALL_SODW_PREPARED_STATEMENT),new Vector<>(Arrays.asList(SOR_COL)));
                mainTable.setModel(model);
                mainTable.repaint();
            }
        });

// ---------------------------------------------------------------------------------------------



    }


    // ----------------------------- Верхняя менюшка --------------------------------
   private JMenu getJMenuPersons(){
        JMenu personsMenu = new JMenu("Люди");
        JMenuItem addMan = new JMenuItem("Добавить мужчину");
       JMenuItem addWoman = new JMenuItem("Добавить женщину");
       JMenuItem refreshTable = new JMenuItem("Обновить таблицу");

    personsMenu.add(addMan);
    personsMenu.addSeparator();
    personsMenu.add(addWoman);
       personsMenu.addSeparator();
       personsMenu.add(refreshTable);

       addMan.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            AddFrame addFrame = new AddFrame(true);
           }
       });
       addWoman.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               AddFrame addFrame = new AddFrame(false);
           }
       });
       refreshTable.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               DefaultTableModel  model = new DefaultTableModel(DBQuiery.getAllpersons(DBQuiery.GET_ALL_MAN_PREPARED_STATEMENT),new Vector<>(Arrays.asList(PERSONS_COL)));
               mainTable.setModel(model);
               mainTable.repaint();
           }
       });

       return personsMenu;
    }




}
