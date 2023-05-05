package entity;

public class KiemTraPhongMoi {
	private String maPhong;
	private String tenPhong;
	private String loaiPhong;
	private String tinhTrang;

	public KiemTraPhongMoi(String maPhong, String tenPhong, String loaiPhong, String tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.tinhTrang = tinhTrang;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "KiemTranPhongMoi [maPhong = " + maPhong + ",tenPhong = " + tenPhong + ",loaiPhong = " + loaiPhong
				+ ",tinhTrang = " + tinhTrang + "]";
	}
}
