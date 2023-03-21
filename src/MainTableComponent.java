import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Vector;


/*Создам объект в конструкторе в MainGuiForm
Вызываю метод геттер для получения экземпляра объекта таблицы
обновляю таблицу
PROffit!!*/






public class MainTableComponent extends JTable {


    MainTableComponent(Vector<Vector<String>> Persons,Vector<String> column_names) {
        super(Persons,column_names);
        setVisible(true);
        DefaultTableModel model = new DefaultTableModel(Persons,column_names);
    }


}
