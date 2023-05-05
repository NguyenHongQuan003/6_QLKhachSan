package bus;

import java.util.ArrayList;

import dao.Dao_PhieuYeuCauDoiPhong;
import entity.PhieuYeuCauDoiPhong;
import interfaces.I_PhieuYeuCauDoiPhong;

public class Bus_PhieuYeuCauDoiPhong implements I_PhieuYeuCauDoiPhong {
	private Dao_PhieuYeuCauDoiPhong dao_phieuyeucaudoiphong = new Dao_PhieuYeuCauDoiPhong();

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getALLPhieuYeuCauDoiPhong() {
		return dao_phieuyeucaudoiphong.getALLPhieuYeuCauDoiPhong();
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoHoTenKhachHang(String hoTenKhachHang) {
		return dao_phieuyeucaudoiphong.getTheoHoTenKhachHang(hoTenKhachHang);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoCCCD(String cCCD) {
		return dao_phieuyeucaudoiphong.getTheoCCCD(cCCD);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoSDT(String sDT) {
		return dao_phieuyeucaudoiphong.getTheoSDT(sDT);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongCu(String maPhongCu) {
		return dao_phieuyeucaudoiphong.getTheoMaPhongCu(maPhongCu);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoMaPhongMoi(String maPhongMoi) {
		return dao_phieuyeucaudoiphong.getTheoMaPhongMoi(maPhongMoi);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoChiTietLyDoDoi(String chiTietLyDoDoi) {
		return dao_phieuyeucaudoiphong.getTheoChiTietLyDoDoi(chiTietLyDoDoi);
	}

	@Override
	public ArrayList<PhieuYeuCauDoiPhong> getTheoPhiPhuThem(int phiPhuThem) {
		return dao_phieuyeucaudoiphong.getTheoPhiPhuThem(phiPhuThem);
	}

}
