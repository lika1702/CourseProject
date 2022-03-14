package patterns;

import data.Client;
import java.util.List;
import tableModels.ClientTableModel;
import tableModels.ContractTableModel;
import tableModels.CurrencyTableModel;
import tableModels.DepositeTableModel;
import tableModels.MyTableModels;
import tableModels.TypeOfModel;
import tableModels.UserTableModel;

public class TableModelFactory {

    public MyTableModels createModel(TypeOfModel type, List<Object> list) {
        MyTableModels model = null;
        switch (type) {
            case CLIENT_TABLE:
                model = new ClientTableModel(list);
                break;
            case DEPOSITE_TABLE:
                model = new DepositeTableModel(list);
                break;
            case CONTRACT_TABLE:
                model = new ContractTableModel(list);
                break;
            case CURRENCY_TABLE:
                model = new CurrencyTableModel(list);
                break;
            case USER_TABLE:
                model = new UserTableModel(list);
                break;
        }
        return model;
    }
}
