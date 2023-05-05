package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuYeuCauDoiPhong;
import interfaces.I_PhieuYeuCauDoiPhong;

public class Dao_PhieuYeuCauDoiPhong implements I_PhieuYeuCauDoiPhong {
	public Dao_PhieuYeuCauDoiPhong() {

	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getALLPhieuYeuCauDoiPhong() {
		ArrayList<PhieuYeuCauDoiPhong> dsPYCDP = new ArrayList<PhieuYeuCauDoiPhong>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * From PhieuYeuCauDoiPhong";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong pycdp = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, 0);
				dsPYCDP.add(pycdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPYCDP;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoHoTenKhachHang(String hoTenKhachHang) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where HoTenKhachHang = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, hoTenKhachHang);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoCCCD(String cCCD) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where CCCD = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, cCCD);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoSDT(String sDT) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where SDT = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, sDT);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongCu(String maPhongCu) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where MaPhongCu = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maPhongCu);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongMoi(String maPhongMoi) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where MaPhongMoi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maPhongMoi);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoChiTietLyDoDoi(String chiTietLyDoDoi) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where ChiTietLyDoDoi = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, chiTietLyDoDoi);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoPhiPhuThem(int phiPhuThem) {
		ArrayList<PhieuYeuCauDoiPhong> pycdp = new ArrayList<PhieuYeuCauDoiPhong>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhieuYeuCauDoiPhong where PhiPhuThem = ?";
			sta = con.prepareStatement(sql);
			sta.setInt(1, phiPhuThem);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String hotenkhachhang = rs.getString("HOTENKHACHHANG");
				String cccd = rs.getString("CCCD");
				String sdt = rs.getString("SDT");
				String maphongcu = rs.getString("MAPHONGCU");
				String maphongmoi = rs.getString("MAPHONGMOI");
				String chitietlydodoi = rs.getString("CHITIETLYDODOI");
				int phiphuthem = rs.getInt("PHIPHUTHEM");

				PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(hotenkhachhang, cccd, sdt, maphongcu, maphongmoi,
						chitietlydodoi, phiphuthem);
				pycdp.add(p);
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
		return pycdp;
	}

	public static boolean themPhieuYeuCauDoiPhong(PhieuYeuCauDoiPhong p) {
		// TODO Auto-generated method stub
		return false;
	}

}
