import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;


public class GameDatabase {
  private Connection conn;
  private Statement stmt;
  private ResultSet rs;

  public GameDatabase() {
    conn = null;
    stmt = null;
    rs = null;
  }

  public void connect() throws SQLException {
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8080/whack", "root", "");
    stmt = (Statement) conn.createStatement();
  }

  public void close() throws SQLException {
    if (rs != null) {
      rs.close();
    }
    if (stmt != null) {
      stmt.close();
    }
    if (conn != null) {
      conn.close();
    }
  }

  public String getLeaderboard() {
      String query = "SELECT * FROM leaderboard ORDER BY score DESC LIMIT 10";
      rs = stmt.executeQuery(query);
      String leaderboard = "Top 10 Players: ";
      int rank = 1;
      while (rs.next()) {
          String playerName = rs.getString("player_name");
          int score = rs.getInt("score");
          leaderboard += rank + ". " + playerName + " - " + score + "\n";
          rank++;
      }
      return leaderboard;
  }
}
