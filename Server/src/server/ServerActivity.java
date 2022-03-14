package server;

import Database.Database;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServerActivity {

    private BufferedReader in;
    private PrintWriter out;
    private Database database;

    public ServerActivity(BufferedReader in, PrintWriter out, Database database) {
        this.in = in;
        this.out = out;
        this.database = database;
    }

    public void getId(int idOperation) throws IOException, SQLException {
        switch (idOperation) {
            case 1:
                signingIn();
                break;
            case 2:
                registrationUser();
                break;
            case 3:
                fillDepositeList();
                break;
            case 4:
                fillPassportList();
                break;
            case 5:
                fillCurrencyList();
                break;
            case 6:
                outputContractTable();
                break;
            case 7:
                outputDepositeTable();
                break;
            case 8:
                outputClientTable();
                break;
            case 9:
                outputCurrencyTable();
                break;
            case 10:
                Delete();
                break;
            case 11:
                Update();
                break;
            case 12:
                Insert();
                break;
            case 13:
                filListForBarChart();
                break;
            case 14:
                dataForBarChart();
                break;
            case 15:
                dataForPieChart();
                break;
            case 16:
                outputUserTable();
                break;
            case 17:
                fillStatisticsList();
                break;
            case 18:
                selectPercent();
                break;
            case 19:
                dataForBarChartD();
                break;
        }
    }

    public void signingIn() throws IOException, SQLException {
        String login = in.readLine();
        String password = in.readLine();
        ResultSet rs = database.select("SELECT * FROM Пользователь WHERE Логин = '" + login + "' AND Пароль = '" + password + "'");
        if (rs.next()) {
            if (rs.getBoolean("Заблокирован")) {
                out.println("isBanned");
            } else {
                out.println(rs.getString("Админ"));
                String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                database.insert("INSERT INTO Статистика (Логин, Дата) VALUES ('" + login + "','" + date + "')");
            }
        } else {
            out.println("error");
        }
    }

    public void registrationUser() throws IOException, SQLException {
        String login = in.readLine();
        String password = in.readLine();
        String email = in.readLine();
        String status = in.readLine();

        ResultSet rs = database.select("SELECT * FROM Пользователь WHERE Логин = '" + login + "'");
        if (rs.next()) {
            out.println("error");
        } else {
            out.println("ok");
            String executeString = "INSERT INTO Пользователь (Логин, Пароль, Админ, Заблокирован, Почта) VALUES ('" + login + "','" + password + "', '" + status + "', FALSE, '" + email + "')";
            database.insert(executeString);
        }
    }

    public void fillDepositeList() throws SQLException, IOException {
        ResultSet result = database.select(in.readLine());
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select("SELECT * FROM Депозит");
        if (result.next()) {
            do {
                out.println(result.getInt("Код") + ":" + result.getString("Наименование") + ":" + result.getString("ВалютаВклада"));
            } while (result.next());
        }
    }

    public void fillPassportList() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("Клиент.НомерПаспорта") + ":" + result.getString("Фамилия") + ":" + result.getString("Имя") + ":" + result.getString("Отчество"));
            } while (result.next());
        }
    }

    public void fillStatisticsList() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getInt("Код") + " Логин : " + result.getString("Логин") + "    " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(result.getDate("Дата")));
            } while (result.next());
        }
    }

    public void filListForBarChart() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select("SELECT Наименование FROM Депозит GROUP BY Наименование");
        if (result.next()) {
            do {
                out.println(result.getString("Наименование"));
            } while (result.next());
        }
    }

    public void fillCurrencyList() throws SQLException, IOException {
        ResultSet result = database.select(in.readLine());
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select("SELECT * FROM Валюта");
        if (result.next()) {
            do {
                out.println(result.getString("Мнемокод") + ":" + result.getString("Наименование"));
            } while (result.next());
        }
    }

    private void outputCurrencyTable() throws SQLException, IOException {
        ResultSet result = database.select(in.readLine());
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select("SELECT * FROM Валюта");
        if (result.next()) {
            do {
                out.println(result.getString("Мнемокод") + ":" + result.getString("Наименование") + ":" + result.getDouble("Курс"));
            } while (result.next());
        }
    }

    private void outputClientTable() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("НомерПаспорта") + ":" + result.getString("Фамилия") + ":" + result.getString("Имя")
                        + ":" + result.getString("Отчество") + ":" + result.getDate("ДатаРождения") + ":" + result.getString("НомерТелефона"));
            } while (result.next());
        }
    }

    private void outputDepositeTable() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getInt("Код") + ":" + result.getString("Наименование") + ":" + result.getDouble("ПроцентнаяСтавка") + ":"
                        + result.getDouble("МинимальнаяСумма") + ":" + result.getString("ЧастичноеСнятие") + ":" + result.getString("ВалютаВклада"));
            } while (result.next());
        }
    }

    private void outputContractTable() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                String fio = result.getString("Фамилия") + ' ' + result.getString("Имя") + ' ' + result.getString("Отчество");
                out.println(result.getString("НомерДоговора") + ":" + fio + ":" + result.getString("НомерПаспорта") + ":" + result.getString("Наименование") + ":"
                        + result.getString("ВалютаВклада") + ":" + result.getDouble("СрокДействия") + ":"
                        + result.getString("Единица") + ":" + result.getString("ГодЗаключения") + ":" + result.getDouble("НачальнаяСумма"));
            } while (result.next());
        }
    }

    private void outputUserTable() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("Логин") + ":" + result.getString("Пароль") + ":" + result.getString("Админ") + ":"
                        + result.getBoolean("Заблокирован") + ":" + result.getString("Почта"));
            } while (result.next());
        }
    }

    private void Delete() throws IOException, SQLException {
        database.delete(in.readLine());
    }

    private void Update() throws IOException, SQLException {
        database.update(in.readLine());
    }

    private void Insert() throws IOException, SQLException {
        database.insert(in.readLine());
    }

    public void dataForBarChart() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("ГодЗаключения") + ":" + result.getString("Количество"));
            } while (result.next());
        }
    }

    public void dataForBarChartD() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("ВалютаВклада") + ":" + result.getString("Количество"));
            } while (result.next());
        }
    }

    public void dataForPieChart() throws SQLException, IOException {
        String executeStr = in.readLine();
        ResultSet result = database.select(executeStr);
        int count = 0;
        if (result.next()) {
            do {
                count++;
            } while (result.next());
        }
        out.println(Integer.toString(count));
        result = database.select(executeStr);
        if (result.next()) {
            do {
                out.println(result.getString("Наименование") + "(" + result.getString("ВалютаВклада") + ")" + ":" + result.getString("Количество"));
            } while (result.next());
        }
    }

    public void selectPercent() throws SQLException, IOException {
        ResultSet result = database.select(in.readLine());
        if (result.next()) {
            out.println(result.getString("ПроцентнаяСтавка"));
        }
    }
}
