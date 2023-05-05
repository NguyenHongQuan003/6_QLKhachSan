package entity;

public class PhieuYeuCauDoiPhong {
	private String hoTenKhachHang, cCCD, sDT;
	private String maPhongCu, maPhongMoi;
	private String chiTietLyDoDoi;
	private int phiPhuThem;

	public PhieuYeuCauDoiPhong(String hoTenKhachHang, String cCCD, String sDT, String maPhongCu, String maPhongMoi,
			String chiTietLyDoDoi, int phiPhuThem) {
		super();
		this.hoTenKhachHang = hoTenKhachHang;
		this.cCCD = cCCD;
		this.sDT = sDT;
		this.maPhongCu = maPhongCu;
		this.maPhongMoi = maPhongMoi;
		this.chiTietLyDoDoi = chiTietLyDoDoi;
		this.phiPhuThem = phiPhuThem;
	}

	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getMaPhongCu() {
		return maPhongCu;
	}

	public void setMaPhongCu(String maPhongCu) {
		this.maPhongCu = maPhongCu;
	}

	public String getMaPhongMoi() {
		return maPhongMoi;
	}

	public void setMaPhongMoi(String maPhongMoi) {
		this.maPhongMoi = maPhongMoi;
	}

	public String getChiTietLyDoDoi() {
		return chiTietLyDoDoi;
	}

	public void setChiTietLyDoDoi(String chiTietLyDoDoi) {
		this.chiTietLyDoDoi = chiTietLyDoDoi;
	}

	public int getPhiPhuThem() {
		return phiPhuThem;
	}

	public void setPhiPhuThem(int phiPhuThem) {
		this.phiPhuThem = phiPhuThem;
	}

	@Override
	public String toString() {
		return "PhieuYeuCauDoiPhong [hoTenKhachHang = " + hoTenKhachHang + ",cCCD = " + cCCD + ",sDT = " + sDT
				+ ",maPhongCu = " + maPhongCu + ",maPhongMoi = " + maPhongMoi + ",chiTietLyDoDoi = " + chiTietLyDoDoi
				+ ",phiPhuThem = " + phiPhuThem + "]";
	}
}
