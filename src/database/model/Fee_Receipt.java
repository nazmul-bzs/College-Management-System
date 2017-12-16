package database.model;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author Nazmul
 */
public class  Fee_Receipt{
    public void insertData(ArrayList<String> list) {
        try
        {
            Connection con = new ConnectionUtil().getConnection();
            String sql = "insert into FEE_RECEIPT (FEE_ID,STD_ID,MONTH,PAID_STATUS) values(?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(list.get(0)));
             pst.setInt(2, Integer.parseInt(list.get(1)));
            pst.setString(3, list.get(2));
            pst.setInt(4, Integer.parseInt(list.get(3)));
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch (SQLException e)
        {
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
    }
    public List<List<String>> getAll()
    {
        String sql = "SELECT * FROM FEE";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new ConnectionUtil().getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("FEE_ID"));
                row.add(rs.getString("FEENAME"));
                row.add(rs.getString("FEEAMOUNT"));
                row.add(rs.getString("DUE_FINE_PERDAY"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            
        }
        return resultList;
    }
}
