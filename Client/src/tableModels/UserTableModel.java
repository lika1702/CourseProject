package tableModels;

import data.User;
import java.util.List;

public class UserTableModel extends MyTableModels {

    private int colnum = 5;
    private int rownum;

    private List<Object> user;

    public UserTableModel(List<Object> user) {
        this.user = user;
    }

    @Override
    public int getRowCount() {
        return user.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Логин";
            case 1:
                return "Пароль";
            case 2:
                return "Администратор";
            case 3:
                return "Заблокирован";
            case 4:
                return "Почта";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            case 4:
                return String.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User data = (User) user.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getLogin();
            case 1:
                return data.getPassword();
            case 2:
                return data.getAdmin();
            case 3:
                return data.isBanned();
            case 4:
                return data.getEmail();
        }
        return "";
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        User data = (User) user.get(rowIndex);
        switch (columnIndex) {
            case 0:
                data.setLogin((String) value);
                break;
            case 1:
                data.setPassword((String) value);
                break;
            case 2:
                data.setAdmin((String) value);
                break;
            case 3:
                data.setBanned((boolean) value);
                fireTableCellUpdated(rowIndex, columnIndex);
                break;
            case 4:
                data.setEmail((String) value);
                break;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            return true;
        }
        return false;
    }
}
