package interfaces;

import java.util.ArrayList;

import entity.KiemTraPhongMoi;

public interface I_KiemTraPhongMoi {
	public ArrayList<KiemTraPhongMoi> getALLKiemTraPhongMoi();

	public ArrayList<KiemTraPhongMoi> getTheoMaPhong(String maPhong);

	public ArrayList<KiemTraPhongMoi> getTheoTenPhong(String tenPhong);

	public ArrayList<KiemTraPhongMoi> getTheoLoaiPhong(String loaiPhong);

	public ArrayList<KiemTraPhongMoi> getTheoTinhTrang(String tinhTrang);
}
