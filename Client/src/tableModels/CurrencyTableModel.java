package tableModels;

import data.Currency;
import java.util.List;

public class CurrencyTableModel extends MyTableModels {

    private int colnum = 3;
    private int rownum;

    private List<Object> currency;

    public CurrencyTableModel(List<Object> currency) {
        this.currency = currency;
    }

    @Override
    public int getRowCount() {
        return currency.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Мнемокод";
            case 1:
                return "Наименование";
            case 2:
                return "Курс";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Currency data = (Currency) currency.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getCode();
            case 1:
                return data.getName();
            case 2:
                return data.getCourse();
        }
        return "";
    }

}
