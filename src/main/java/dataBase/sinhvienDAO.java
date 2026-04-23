package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.sinhvien;

public class sinhvienDAO implements DAOInterface<sinhvien>{

	@Override
	public ArrayList<sinhvien> selectAll() {
		ArrayList< sinhvien> arrayList = new ArrayList<sinhvien>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from sinhvien";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String diaChi= rs.getString("diaChi");
				String tenLop= rs.getString("tenLop");
				String namSinh= rs.getString("namSinh");
				sinhvien sinhvien = new sinhvien(id, name, diaChi, tenLop, namSinh);
				arrayList.add(sinhvien);

			}
			JDBCUtil.closeConnnection(con, pstm, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public sinhvien selectByID(int id) {
		sinhvien sinhvien=null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql="selct * from sinhvien where id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int id_ = rs.getInt("id");
				String name= rs.getString("name");
				String diaChi= rs.getString("diaChi");
				String tenLop= rs.getString("tenLop");
				String namSinh= rs.getString("namSinh");
				sinhvien = new sinhvien(id, name, diaChi, tenLop, namSinh);
				break;
			}
			JDBCUtil.closeConnnection(con, pstm, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sinhvien;
	}

	@Override
	public int inSert(sinhvien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(sinhvien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(sinhvien t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
