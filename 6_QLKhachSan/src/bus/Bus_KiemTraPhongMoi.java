package bus;

import java.util.ArrayList;
import dao.Dao_KiemTraPhongMoi;
import entity.KiemTraPhongMoi;
import interfaces.I_KiemTraPhongMoi;

public class Bus_KiemTraPhongMoi implements I_KiemTraPhongMoi {
	private Dao_KiemTraPhongMoi dao_kiemtraphongmoi = new Dao_KiemTraPhongMoi();

	@Override
	public ArrayList<KiemTraPhongMoi> getALLKiemTraPhongMoi() {
		return dao_kiemtraphongmoi.getALLKiemTraPhongMoi();
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoMaPhong(String maPhong) {
		return dao_kiemtraphongmoi.getTheoMaPhong(maPhong);
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoTenPhong(String tenPhong) {
		return dao_kiemtraphongmoi.getTheoTenPhong(tenPhong);
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoLoaiPhong(String loaiPhong) {
		return dao_kiemtraphongmoi.getTheoLoaiPhong(loaiPhong);
	}

	@Override
	public ArrayList<KiemTraPhongMoi> getTheoTinhTrang(String tinhTrang) {
		return dao_kiemtraphongmoi.getTheoTinhTrang(tinhTrang);
	}

}
