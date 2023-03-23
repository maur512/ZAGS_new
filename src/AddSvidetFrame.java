import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddSvidetFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel passportNumLabel;
    private JLabel passportSerLabel;
    private JLabel isTermLabel;
    private JLabel registryLabel;
    private JLabel vidanoLabel;
    private JLabel descriptLabel;
    private JTextField passNumField;
    private JTextField passSerField;
    private JTextField vidanoField;
    private JTextField descriptField;
    private JCheckBox isTermCheck;
    private JButton applyButton;
    private JButton exitButton;
    private JLabel mainDescriptLabel;
    private JComboBox yearBox;
    private JComboBox monthBox;
    private JComboBox dayBox;

    public static final String SORM = "Свидетельство о рождении М";
    public static final String SORW = "Свидетельство о рождении Ж";
    public static final String SODM = "Свидетельство о смерти М";
    public static final String SODW = "Свидетельство о смерти Ж";

    AddSvidetFrame(String mainLabel) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainDescriptLabel.setText(mainLabel);
        getContentPane().add(mainPanel);
        for (int i = 1900; i <= 2023; i++)
        yearBox.addItem(i);
        for (int i = 1; i <= 12; i++)
            monthBox.addItem(i);
        for (int i = 1; i <= 31; i++)
            dayBox.addItem(i);
        setSize(300,500);
        setResizable(false);
        setVisible(true);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean go_down = false;
                if(passSerField.getText().length() != 2 || passNumField.getText().length() != 7)
                    JOptionPane.showMessageDialog(null, "Проверьте значения! Неверный формат пасспорта!");
                else {
                    Date date1 = new Date((int) yearBox.getSelectedItem() - 1900, (int) monthBox.getSelectedItem(), (int) dayBox.getSelectedItem());

                    SOR so = new SOR(null,
                            null,
                            null,
                            Integer.valueOf(passNumField.getText()),
                            passSerField.getText(),
                            null,
                            null,
                            null,
                            0,
                            isTermCheck.isSelected(),
                            date1,
                            vidanoField.getText(),
                            descriptField.getText());
                    try {
                        DBUpdate.putSOR(so, mainLabel);
                    } catch(SQLException ex) {
                        ex.printStackTrace();
                        if (ex.getMessage().contains("Duplicate entry"))
                            JOptionPane.showMessageDialog(null, "У данного человека уже существует свидетельство о рождении");
                        else
                            JOptionPane.showMessageDialog(null, "Проверьте значения! Человек не найден.");
                        go_down = true;
                    }
                    if (go_down == false) dispose();
                }

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
