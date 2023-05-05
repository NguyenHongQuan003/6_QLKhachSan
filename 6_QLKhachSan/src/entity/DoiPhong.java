package entity;

public class DoiPhong {
	private String hoTenKhachHang, cCCD, diaChi;
	private String maPhongCu, maPhongMoi;
	private String lyDoDoi, chiTietLyDo;

	public DoiPhong(String hoTenKhachHang, String cCCD, String diaChi, String maPhongCu, String maPhongMoi,
			String lyDoDoi, String chiTietLyDo) {
		super();
		this.hoTenKhachHang = hoTenKhachHang;
		this.cCCD = cCCD;
		this.diaChi = diaChi;
		this.maPhongCu = maPhongCu;
		this.maPhongMoi = maPhongMoi;
		this.lyDoDoi = lyDoDoi;
		this.chiTietLyDo = chiTietLyDo;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public String getLyDoDoi() {
		return lyDoDoi;
	}

	public void setLyDoDoi(String lyDoDoi) {
		this.lyDoDoi = lyDoDoi;
	}

	public String getChiTietLyDo() {
		return chiTietLyDo;
	}

	public void setChiTietLyDo(String chiTietLyDo) {
		this.chiTietLyDo = chiTietLyDo;
	}

	@Override
	public String toString() {
		return "DoiPhong [hoTenKhachHang = " + hoTenKhachHang + ",cCDD = " + cCCD + ",diaChi = " + diaChi
				+ ",maPhongCu = " + maPhongCu + ",maPhongMoi = " + maPhongMoi + ",lyDoDoi = " + lyDoDoi
				+ ",chiTietLyDo = " + chiTietLyDo + "]";
	}
}
