package data;

public class Contract {

    private String name;
    private String passport;
    private String contractCode;
    private String title;
    private String currency;
    private String measurement;
    private double term;
    private int year;
    private double startSum;

    public Contract() {
        this.name = "";
        this.contractCode = "";
        this.title = "";
        this.passport = "";
        this.currency = "";
        this.term = 0.0;
        this.measurement = "";
        this.year = 0;
        this.startSum = 0.0;
    }
    
    public Contract(String contractCode, String name, String passport, String title, String currency, double term, String measurement, int year, double startSum) {
        this.name = name;
        this.contractCode = contractCode;
        this.title = title;
        this.passport = passport;
        this.currency = currency;
        this.term = term;
        this.measurement = measurement;
        this.year = year;
        this.startSum = startSum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStartSum(double sum) {
        this.startSum = sum;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCurrency() {
        return this.currency;
    }

    public double getTerm() {
        return this.term;
    }

    public String getMeasurement() {
        return this.measurement;
    }

    public int getYear() {
        return this.year;
    }

    public double getStartSum() {
        return this.startSum;
    }

    public static class Builder {
        private Contract newContract;
 
        public Builder() {
            newContract = new Contract();
        }
 
        public Builder withName(String name){
            newContract.name = name;
            return this;
        }
 
        public Builder withPassport(String passport){
            newContract.passport = passport;
            return this;
        }
 
        public Builder withContractCode(String contractCode){
            newContract.contractCode = contractCode;
            return this;
        }
 
        public Builder withTitle(String title){
            newContract.title = title;
            return this;
        }
 
        public Builder withCurrency(String currency){
            newContract.currency = currency;
            return this;
        }
 
        public Builder withMeasurement(String measurement){
            newContract.measurement = measurement;
            return this;
        }
        
        public Builder withTerm(double term){
            newContract.term = term;
            return this;
        }
        
        public Builder withYear(int year){
            newContract.year = year;
            return this;
        }
        
        public Builder withStartSum(double startSum){
            newContract.startSum = startSum;
            return this;
        }
 
        public Contract build(){
            return newContract;
        }
    }

}
