package tableModels;

import data.Deposite;
import java.util.List;

public class DepositeTableModel extends MyTableModels {

    private int colnum = 6;
    private int rownum;

    private List<Object> deposite;

    public DepositeTableModel(List<Object> deposite) {
        this.deposite = deposite;
    }

    @Override
    public int getRowCount() {
        return deposite.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Код";
            case 1:
                return "Наименование";
            case 2:
                return "Процентная ставка";
            case 3:
                return "Минимальная сумма";
            case 4:
                return "Частичное снятие";
            case 5:
                return "Валюта";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deposite data = (Deposite) deposite.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getCode();
            case 1:
                return data.getName();
            case 2:
                return data.getPercent();
            case 3:
                return data.getMinSum();
            case 4:
                return data.getPartial();
            case 5:
                return data.getCurrencyCode();
        }
        return "";
    }
}
