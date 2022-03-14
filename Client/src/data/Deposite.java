package data;

public class Deposite {

    private int code;
    private String name;
    private double percent;
    private double minSum;
    private String partial;
    private String currencyCode;

    public Deposite(int code, String name, double percent, double minSum, String partial, String currencyCode) {
        this.setCode(code);
        this.setName(name);
        this.setPercent(percent);
        this.setMinSum(minSum);
        this.setPartial(partial);
        this.setCurrencyCode(currencyCode);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setMinSum(double minSum) {
        this.minSum = minSum;
    }

    public void setPartial(String partial) {
        this.partial = partial;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPercent() {
        return this.percent;
    }

    public double getMinSum() {
        return this.minSum;
    }

    public String getPartial() {
        return this.partial;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }
}
