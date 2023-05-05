package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DoiPhong;
import interfaces.I_DoiPhong;

public class Dao_DoiPhong implements I_DoiPhong {
	public Dao_DoiPhong() {

	}

	@Override
	public ArrayList<DoiPhong> getALLDoiPhong() {
		ArrayList<DoiPhong> dsDP = new ArrayList<DoiPhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * From DoiPhong";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong dp = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi,
						chitietlydodoi);
				dsDP.add(dp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDP;

	}

	@Override
	public ArrayList<DoiPhong> getTheoHoThenKhachHang(String hoTenKhachHang) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where HoTenKhachHang = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, hoTenKhachHang);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoCCCD(String cCCD) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where CCCD = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, cCCD);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoDiaChi(String diaChi) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where DiaChi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, diaChi);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoSDT(String sDT) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where SDT = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, sDT);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoMaPhongCu(String maPhongCu) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where MaPhongCu = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maPhongCu);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoMaPhongMoi(String maPhongMoi) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where MaPhongMoi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maPhongMoi);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoLyDoDoi(String lyDoDoi) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where lyDoDoi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, lyDoDoi);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

	@Override
	public ArrayList<DoiPhong> getTheoChiTietLyDo(String chiTietLyDo) {
		ArrayList<DoiPhong> dp = new ArrayList<DoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DoiPhong where ChiTietLyDoDoi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, chiTietLyDo);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String diachi = rs.getString("DIACHI");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String lydodoi = rs.getString("LYDODOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");

				DoiPhong p = new DoiPhong(hotenkhachhang, cccd, diachi, maphongcu, maphongmoi, lydodoi, chitietlydodoi);
				dp.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dp;
	}

}
