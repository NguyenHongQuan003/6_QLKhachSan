package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KiemTraPhongMoi;
import interfaces.I_KiemTraPhongMoi;

public class Dao_KiemTraPhongMoi implements I_KiemTraPhongMoi {
	public Dao_KiemTraPhongMoi() {

	}

	@Override
	public ArrayList<KiemTraPhongMoi> getALLKiemTraPhongMoi() {
		ArrayList<KiemTraPhongMoi> dsKTPM = new ArrayList<KiemTraPhongMoi>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * From KiemTraPhongMoi";
			Statement sta = con.createStatement();

			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("MAPHONG");
				String tenPhong = rs.getString("TENPHONG");
				String loaiPhong = rs.getString("LOAIPHONG");
				String tinhTrang = rs.getString("TINHTRANG");

				KiemTraPhongMoi ktpm = new KiemTraPhongMoi(maPhong, tenPhong, loaiPhong, tinhTrang);

				dsKTPM.add(ktpm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKTPM;
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoMaPhong(String maPhong) {
		ArrayList<KiemTraPhongMoi> ktpm = new ArrayList<KiemTraPhongMoi>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KiemTraPhongMoi where MaPhong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, maPhong);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maphong = rs.getString("MAPHONG");
				String tenphong = rs.getString("TENPHONG");
				String loaiphong = rs.getString("LOAIPHONG");
				String tinhtrang = rs.getString("TINHTRANG");

				KiemTraPhongMoi p = new KiemTraPhongMoi(maphong, tenphong, loaiphong, tinhtrang);
				ktpm.add(p);
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
		return ktpm;
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoTenPhong(String tenPhong) {
		ArrayList<KiemTraPhongMoi> ktpm = new ArrayList<KiemTraPhongMoi>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KiemTraPhongMoi where MaPhong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, tenPhong);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maphong = rs.getString("MAPHONG");
				String tenphong = rs.getString("TENPHONG");
				String loaiphong = rs.getString("LOAIPHONG");
				String tinhtrang = rs.getString("TINHTRANG");

				KiemTraPhongMoi p = new KiemTraPhongMoi(maphong, tenphong, loaiphong, tinhtrang);
				ktpm.add(p);
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
		return ktpm;
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoLoaiPhong(String loaiPhong) {
		ArrayList<KiemTraPhongMoi> ktpm = new ArrayList<KiemTraPhongMoi>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KiemTraPhongMoi where MaPhong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, loaiPhong);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maphong = rs.getString("MAPHONG");
				String tenphong = rs.getString("TENPHONG");
				String loaiphong = rs.getString("LOAIPHONG");
				String tinhtrang = rs.getString("TINHTRANG");

				KiemTraPhongMoi p = new KiemTraPhongMoi(maphong, tenphong, loaiphong, tinhtrang);
				ktpm.add(p);
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
		return ktpm;
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoTinhTrang(String tinhTrang) {
		ArrayList<KiemTraPhongMoi> ktpm = new ArrayList<KiemTraPhongMoi>();
		PreparedStatement sta = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KiemTraPhongMoi where MaPhong = ?";
			sta = con.prepareStatement(sql);
			sta.setString(1, tinhTrang);

			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				String maphong = rs.getString("MAPHONG");
				String tenphong = rs.getString("TENPHONG");
				String loaiphong = rs.getString("LOAIPHONG");
				String tinhtrang = rs.getString("TINHTRANG");

				KiemTraPhongMoi p = new KiemTraPhongMoi(maphong, tenphong, loaiphong, tinhtrang);
				ktpm.add(p);
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
		return ktpm;
	}
}
