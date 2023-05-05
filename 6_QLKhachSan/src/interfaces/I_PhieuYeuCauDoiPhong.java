package interfaces;

import java.util.ArrayList;

import entity.PhieuYeuCauDoiPhong;

public interface I_PhieuYeuCauDoiPhong {
	public ArrayList<PhieuYeuCauDoiPhong> getALLPhieuYeuCauDoiPhong();

	public ArrayList<PhieuYeuCauDoiPhong> getTheoHoTenKhachHang(String hoTenKhachHang);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoCCCD(String cCCD);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoSDT(String sDT);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongCu(String maPhongCu);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongMoi(String maPhongMoi);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoChiTietLyDoDoi(String chiTietLyDoDoi);

	public ArrayList<PhieuYeuCauDoiPhong> getTheoPhiPhuThem(int phiPhuThem);
}
