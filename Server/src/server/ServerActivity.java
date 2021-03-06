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
        ResultSet rs = database.select("SELECT * FROM ???????????????????????? WHERE ?????????? = '" + login + "' AND ???????????? = '" + password + "'");
        if (rs.next()) {
            if (rs.getBoolean("????????????????????????")) {
                out.println("isBanned");
            } else {
                out.println(rs.getString("??????????"));
                String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                database.insert("INSERT INTO ???????????????????? (??????????, ????????) VALUES ('" + login + "','" + date + "')");
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

        ResultSet rs = database.select("SELECT * FROM ???????????????????????? WHERE ?????????? = '" + login + "'");
        if (rs.next()) {
            out.println("error");
        } else {
            out.println("ok");
            String executeString = "INSERT INTO ???????????????????????? (??????????, ????????????, ??????????, ????????????????????????, ??????????) VALUES ('" + login + "','" + password + "', '" + status + "', FALSE, '" + email + "')";
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
        result = database.select("SELECT * FROM ??????????????");
        if (result.next()) {
            do {
                out.println(result.getInt("??????") + ":" + result.getString("????????????????????????") + ":" + result.getString("????????????????????????"));
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
                out.println(result.getString("????????????.??????????????????????????") + ":" + result.getString("??????????????") + ":" + result.getString("??????") + ":" + result.getString("????????????????"));
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
                out.println(result.getInt("??????") + " ?????????? : " + result.getString("??????????") + "    " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(result.getDate("????????")));
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
        result = database.select("SELECT ???????????????????????? FROM ?????????????? GROUP BY ????????????????????????");
        if (result.next()) {
            do {
                out.println(result.getString("????????????????????????"));
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
        result = database.select("SELECT * FROM ????????????");
        if (result.next()) {
            do {
                out.println(result.getString("????????????????") + ":" + result.getString("????????????????????????"));
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
        result = database.select("SELECT * FROM ????????????");
        if (result.next()) {
            do {
                out.println(result.getString("????????????????") + ":" + result.getString("????????????????????????") + ":" + result.getDouble("????????"));
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
                out.println(result.getString("??????????????????????????") + ":" + result.getString("??????????????") + ":" + result.getString("??????")
                        + ":" + result.getString("????????????????") + ":" + result.getDate("????????????????????????") + ":" + result.getString("??????????????????????????"));
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
                out.println(result.getInt("??????") + ":" + result.getString("????????????????????????") + ":" + result.getDouble("????????????????????????????????") + ":"
                        + result.getDouble("????????????????????????????????") + ":" + result.getString("??????????????????????????????") + ":" + result.getString("????????????????????????"));
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
                String fio = result.getString("??????????????") + ' ' + result.getString("??????") + ' ' + result.getString("????????????????");
                out.println(result.getString("??????????????????????????") + ":" + fio + ":" + result.getString("??????????????????????????") + ":" + result.getString("????????????????????????") + ":"
                        + result.getString("????????????????????????") + ":" + result.getDouble("????????????????????????") + ":"
                        + result.getString("??????????????") + ":" + result.getString("??????????????????????????") + ":" + result.getDouble("????????????????????????????"));
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
                out.println(result.getString("??????????") + ":" + result.getString("????????????") + ":" + result.getString("??????????") + ":"
                        + result.getBoolean("????????????????????????") + ":" + result.getString("??????????"));
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
                out.println(result.getString("??????????????????????????") + ":" + result.getString("????????????????????"));
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
                out.println(result.getString("????????????????????????") + ":" + result.getString("????????????????????"));
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
                out.println(result.getString("????????????????????????") + "(" + result.getString("????????????????????????") + ")" + ":" + result.getString("????????????????????"));
            } while (result.next());
        }
    }

    public void selectPercent() throws SQLException, IOException {
        ResultSet result = database.select(in.readLine());
        if (result.next()) {
            out.println(result.getString("????????????????????????????????"));
        }
    }
}
