package bus;

import java.util.ArrayList;

import dao.Dao_DoiPhong;
import entity.DoiPhong;
import interfaces.I_DoiPhong;

public class Bus_DoiPhong implements I_DoiPhong {
	private Dao_DoiPhong dao_doiphong = new Dao_DoiPhong();

	@Override
	public ArrayList<DoiPhong> getALLDoiPhong() {
		return dao_doiphong.getALLDoiPhong();
	}

	@Override
	public ArrayList<DoiPhong> getTheoHoThenKhachHang(String hoTenKhachHang) {
		return dao_doiphong.getTheoHoThenKhachHang(hoTenKhachHang);
	}

	@Override
	public ArrayList<DoiPhong> getTheoCCCD(String cCCD) {
		return dao_doiphong.getTheoCCCD(cCCD);
	}

	@Override
	public ArrayList<DoiPhong> getTheoDiaChi(String diaChi) {
		return dao_doiphong.getTheoDiaChi(diaChi);
	}

	@Override
	public ArrayList<DoiPhong> getTheoSDT(String sDT) {
		return dao_doiphong.getTheoSDT(sDT);
	}

	@Override
	public ArrayList<DoiPhong> getTheoMaPhongCu(String maPhongCu) {
		return dao_doiphong.getTheoMaPhongCu(maPhongCu);
	}

	@Override
	public ArrayList<DoiPhong> getTheoMaPhongMoi(String maPhongMoi) {
		return dao_doiphong.getTheoMaPhongMoi(maPhongMoi);
	}

	@Override
	public ArrayList<DoiPhong> getTheoLyDoDoi(String lyDoDoi) {
		return dao_doiphong.getTheoLyDoDoi(lyDoDoi);
	}

	@Override
	public ArrayList<DoiPhong> getTheoChiTietLyDo(String chiTietLyDo) {
		return dao_doiphong.getTheoChiTietLyDo(chiTietLyDo);
	}

}
