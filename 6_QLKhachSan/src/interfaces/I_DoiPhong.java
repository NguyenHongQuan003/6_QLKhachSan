package interfaces;

import java.util.ArrayList;

import entity.DoiPhong;

public interface I_DoiPhong {
	public ArrayList<DoiPhong> getALLDoiPhong();

	public ArrayList<DoiPhong> getTheoHoThenKhachHang(String hoTenKhachHang);

	public ArrayList<DoiPhong> getTheoCCCD(String cCCD);

	public ArrayList<DoiPhong> getTheoDiaChi(String diaChi);

	public ArrayList<DoiPhong> getTheoSDT(String sDT);

	public ArrayList<DoiPhong> getTheoMaPhongCu(String maPhongCu);

	public ArrayList<DoiPhong> getTheoMaPhongMoi(String maPhongMoi);

	public ArrayList<DoiPhong> getTheoLyDoDoi(String lyDoDoi);

	public ArrayList<DoiPhong> getTheoChiTietLyDo(String chiTietLyDo);
}
