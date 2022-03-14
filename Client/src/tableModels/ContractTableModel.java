package tableModels;

import data.Contract;
import java.util.List;

public class ContractTableModel extends MyTableModels {

    private int colnum = 8;
    private int rownum;

    private List<Object> contract;

    public ContractTableModel(List<Object> contract) {
        this.contract = contract;
    }

    @Override
    public int getRowCount() {
        return contract.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Номер договора";
            case 1:
                return "ФИО";
            case 2:
                return "Номер паспорта";
            case 3:
                return "Наименование";
            case 4:
                return "Валюта";
            case 5:
                return "Стартовая сумма";
            case 6:
                return "Срок действия";
            case 7:
                return "Год заключения";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contract data = (Contract)contract.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getContractCode();
            case 1:
                return data.getName();
            case 2:
                return data.getPassport();
            case 3:
                return data.getTitle();
            case 4:
                return data.getCurrency();
            case 5:
                return data.getStartSum();
            case 6:
                return data.getTerm() + " " + data.getMeasurement();
            case 7:
                return data.getYear();
        }
        return "";
    }
}
