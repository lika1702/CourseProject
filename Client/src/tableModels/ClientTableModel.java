package tableModels;

import data.Client;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends MyTableModels {

    private int colnum = 6;
    private int rownum;

    private List<Object> client;

    public ClientTableModel(List<Object> client) {
        this.client = client;
    }

    @Override
    public int getRowCount() {
        return client.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Номер паспорта";
            case 1:
                return "Фамилия";
            case 2:
                return "Имя";
            case 3:
                return "Отчество";
            case 4:
                return "Дата рождения";
            case 5:
                return "Номер телефона";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client data = (Client)client.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getPassport();
            case 1:
                return data.getSurname();
            case 2:
                return data.getName();
            case 3:
                return data.getPatronimyc();
            case 4:
                SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY");
                return ft.format(data.getDate());
            case 5:
                return data.getPhone();
        }
        return "";
    }
}
