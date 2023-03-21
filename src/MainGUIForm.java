import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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

    /*private static final String NAME_COL = "name";
    private static final String LAST_NAME_COL = "lastname";
    private static final String SURNAME_COL = "surname";
    private static final String PASSPORT_NUMBER_COL = "passportnumber";
    private static final String PASSPORT_SERIAL_COL = "passportser";
    private static final String ADRESS_COL = "adress";
    private static final String BIRTH_COL = "birth";
    private static final String NUMBER_COL = "phonenum";
    private static final String NUM_COL = "num";
    private static final String REGISTRY_COL = "registry";
    private static final String ISTERM_COL = "isterm";*/

    private JTable mainTable;
    private JPanel mainPanel;
    private JButton showMenButton;
    private JButton showWomenButton;
    private JButton showSvidet_o_brakeButton;
    private JButton showSvidet_o_rozdMButton;
    private JButton showSvidet_o_rozd_WButton;

    MainGUIForm () {
        DefaultTableModel model;
        model = new DefaultTableModel(DBQuiery.getAllpersons(DBQuiery.GET_ALL_MAN_PREPARED_STATEMENT),new Vector<>(Arrays.asList(PERSONS_COL)));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getJMenuTable());
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

            }
        });
        showSvidet_o_rozd_WButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

// ---------------------------------------------------------------------------------------------


    }


    // ----------------------------- Верхняя менюшка --------------------------------
   private JMenu getJMenuTable(){
        JMenu table = new JMenu("Таблица");
        JMenuItem addMan = new JMenuItem("Добавить мужчину");
       JMenuItem addWoman = new JMenuItem("Добавить женщину");
       JMenuItem refreshTable = new JMenuItem("Обновить таблицу");

    table.add(addMan);
    table.addSeparator();
    table.add(addWoman);
       table.addSeparator();
       table.add(refreshTable);

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

       return table;
    }




}
