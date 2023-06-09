package interfaces;

import java.util.ArrayList;

import entity.Tang;

public interface I_Tang {
	public ArrayList<Tang> getAllTang();

	public Tang getTangTheoMaTang(int id);
	
	public ArrayList<Tang> getTangTheoTenTang(String tenTang);

	public boolean them(Tang t);

	public boolean capNhat(Tang t);

	public boolean xoa(int id);
	
	public int count();
}
