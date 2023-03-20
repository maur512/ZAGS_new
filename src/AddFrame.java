import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField lastnameField;
    private JLabel nameLabel;
    private JLabel lastnameLabel;
    private JLabel surnameLabel;
    private JTextField surnameField;
    private JLabel pass_serialLabel;
    private JTextField pass_serialField;
    private JLabel pass_numberLabel;
    private JTextField pass_numberField;
    private JLabel numberLabel;
    private JTextField numberField;
    private JLabel adressLabel;
    private JTextField adressField;
    private JButton addPersonButton;
    private JButton exitButton;
    private JTextField birthYearField;
    private JTextField birthMonthField;
    private JTextField birthDayField;
    private JLabel birthYearLabel;
    private JLabel monthBirthLabel;
    private JLabel birthDayLabel;


    AddFrame(boolean isMan) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(mainPanel);
        setSize(900,150);
        setResizable(false);
        setVisible(true);
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String last_name = lastnameField.getText();
                String surname = surnameField.getText();
                int passport_number = Integer.valueOf(pass_numberField.getText());
                String passport_serial = pass_serialField.getText();
                String adress = adressField.getText();
                Date birth;
                String number = numberField.getText();
                String birthS = birthYearField.getText()+"-"+birthMonthField.getText()+"-"+ birthDayField.getText();
                try {

                    birth = java.sql.Date.valueOf(birthS);
                    if (isMan == true)
                        DBUpdate.putMan(new Person(name,last_name,surname,passport_number,passport_serial,adress,birth,number));
                    else DBUpdate.putWoman(new Person(name,last_name,surname,passport_number,passport_serial,adress,birth,number));
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
                dispose();

            }
        });



    }
    }

