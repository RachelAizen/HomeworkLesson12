import java.io.IOException;
import java.sql.*;

public class HomeworkLesson12RachelAizen {

private static final String USER_NAME = "EDhtpG3YPW";
private static final String DATABASE_NAME = "EDhtpG3YPW";
private static final String PASSWORD = "rTrvlgpNAc";
private static final String PORT = "remotemysql.com";
private static final String SERVER = "3306";

public static void main(String[] args) throws IOException, SQLException {
Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);

//1
//createTable(con);
//
//2
//insertDog(con, "Lassie", 3, "Collie");
//insertDog(con, "Perdita", 2, "Fox Terrier");
//insertDog(con, "Pongo", 1, "Dalmatian");
//
//3
//updateAge(con, 2, "Snowy");
//
//4
//deleteDog(con, "Pongo");

getTableContent(con);

con.close();

}

private static void createTable(Connection con) throws SQLException
{String statementToExecute = "Create Table " + DATABASE_NAME +
". `Dogs`(`name` VARCHAR(40), `age` INT NOT NULL, `breed` VARCHAR(30) NOT NULL);";
con.createStatement().execute(statementToExecute);}

private static void insertDog(Connection con, String name, int age, String breed) throws SQLException
{String statementToExecute = "INSERT INTO " + DATABASE_NAME +
". `Dogs` (`name`, `age`,`breed`) VALUES ('" + name + "', '" + age + "', '" + breed + "');";
con.createStatement().execute(statementToExecute);}

private static void updateAge(Connection con, int age, String name) throws SQLException
{String statementToExecute = "UPDATE `" + DATABASE_NAME + "`.``Dogs` SET `age` = '" + age + "' WHERE `name` = '" + name + "';";
con.createStatement().executeUpdate(statementToExecute);}

private static void deleteDog(Connection con, String name) throws SQLException
{String statementToExecute = "DELETE FROM `" + DATABASE_NAME + "`.`Dogs` WHERE `name` = '" + name + "';";
con.createStatement().execute(statementToExecute);}

private static void getTableContent(Connection con) throws SQLException
{String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".Dogs;";
Statement st = con.createStatement();
ResultSet resultIs = st.executeQuery(statementToExecute);

while (resultIs.next()) {
String name = resultIs.getString("name");
int age = resultIs.getInt("age");
String breed = resultIs.getString("breed");

System.out.println("Name: " + name);
System.out.println(", Age: " + age);
System.out.println(", Breed: " + breed);}
resultIs.close();}

}



