package tableModels;

public enum TypeOfModel {
    CLIENT_TABLE,
    DEPOSITE_TABLE,
    CONTRACT_TABLE,
    CURRENCY_TABLE,
    USER_TABLE;

    public static TypeOfModel convert(String str) {
        for (TypeOfModel type : TypeOfModel.values()) {
            if (type.toString().equals(str)) {
                return type;
            }
        }
        return null;
    }
}
