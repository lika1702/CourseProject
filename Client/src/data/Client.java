package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private String passport;
    private String surname;
    private String name;
    private String patronimyc;
    private String phone;
    private Date date;

    public Client(String passport, String surname, String name, String patronimyc, String date, String phone) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date parsingDate;
        try {
            parsingDate = ft.parse(date);
            this.setDate(parsingDate);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
        this.setPassport(passport);
        this.setSurname(surname);
        this.setName(name);
        this.setPatronimyc(patronimyc);
        this.setPhone(phone);
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronimyc(String patronimyc) {
        this.patronimyc = patronimyc;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronimyc() {
        return this.patronimyc;
    }

    public Date getDate() {
        return this.date;
    }

    public String getPhone() {
        return this.phone;
    }
}
