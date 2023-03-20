import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUIForm extends JFrame{


    private JTable mainTable;
    private JPanel mainPanel;
    private JButton showMenButton;
    private JButton showWomenButton;
    private JButton showSvidet_o_brakeButton;
    private JButton showSvidet_o_rozdButton;
    private JButton showSvidet_o_smertButton;

    MainGUIForm () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getJMenuTable());
        setJMenuBar(menuBar);
        getContentPane().add(mainPanel);
        setSize(1280,720);
        setVisible(true);


// ------------------------ Листенеры основной панели ---------------------------
        showMenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showWomenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showSvidet_o_brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showSvidet_o_rozdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showSvidet_o_smertButton.addActionListener(new ActionListener() {
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
       return table;
    }




}
