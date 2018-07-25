import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDemo {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "select * from sort";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ArrayList<Sort> arr = new ArrayList<>();
        while (rs.next()) {
            arr.add(new Sort(rs.getInt("sid"), rs.getString("sname"),
                    rs.getDouble("sprice"), rs.getString("sdesc")));

        }
        JDBCUtils.close(con, pst, rs);


        for (Sort s : arr) {

            System.out.println(s.toString());
        }
    }
}
