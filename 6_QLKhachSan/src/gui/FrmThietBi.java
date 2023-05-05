package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bus.Bus_Phong;
import bus.Bus_ThietBi;
import entity.NhanVien;
import entity.Phong;
import entity.ThietBi;
import random.PhatSinhMa;

public class FrmThietBi extends JFrame implements ActionListener, MouseListener{
	public static JPanel contentPane;
	private JPanel pnCenter;
	private JLabel lblMaTB;
	private JLabel lblTenTB;
	private JLabel lblMoTa;
	private JLabel lblMaP;
	private JTextField txtMaTB;
	private JTextField txtTenTB;
	private JComboBox<String> cboMaP;
	private JTextField txtMoTa;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTimKiem;
	private JButton btnTim;
	private JButton btnReset;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnRanDom;
	private Bus_ThietBi thietBi_bus = new Bus_ThietBi();
	private Bus_Phong phong_bus = new Bus_Phong();
	private JTextField txtMess;
	private JButton btnLocTheoMaP;
	public FrmThietBi() {
		setTitle("Thông tin khách hàng");
		setSize(1050, 700);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
		btnRanDom.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnLocTheoMaP.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public void createGUI() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(900, 600));
		add(pnBorder);

		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("THÔNG TIN THIẾT BỊ");
		lblTieuDe.setForeground(Color.blue);
		Font fTieuDe = new Font("Arial", Font.BOLD, 25);
		lblTieuDe.setFont(fTieuDe);
		pnNorth.add(lblTieuDe);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();

		pnCenter.add(b);

		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));

		pnCenter.add(Box.createVerticalStrut(10));

		lblMaTB = new JLabel("Mã TB: ");
		lblTenTB = new JLabel("Tên TB: ");
		lblMaP = new JLabel("Mã Phòng: ");
		lblMoTa = new JLabel("Mô Tả: ");

		btnRanDom = new JButton("Random");
		txtMaTB = new JTextField();
		txtMaTB.setEditable(false);
		b1.add(lblMaTB);
		b1.add(txtMaTB);
		b1.add(btnRanDom);

		cboMaP = new JComboBox<String>();
		cboMaP.setPreferredSize(new Dimension(100, 25));
		txtTenTB = new JTextField();
		b2.add(lblTenTB);
		b2.add(txtTenTB);
		b2.add(lblMaP);
		b2.add(cboMaP);
		
		txtMoTa = new JTextField();
		b3.add(lblMoTa);
		b3.add(txtMoTa);
		
		txtMess = new JTextField();
		txtMess.setEditable(false);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		b4.add(txtMess);

		lblMaTB.setPreferredSize(lblMaP.getPreferredSize());
		lblTenTB.setPreferredSize(lblMaP.getPreferredSize());
		lblMoTa.setPreferredSize(lblMaP.getPreferredSize());
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(25);
		model.addColumn("Mã TB");
		model.addColumn("Tên TB");
		model.addColumn("Mã Phòng");
		model.addColumn("Mô tả");

		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(1000, 400));
		pnCenter.add(sp);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		
		JSplitPane split;
		pnBorder.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.SOUTH);
		split.setResizeWeight(0.5);

		JPanel pnTimKiem = new JPanel();
		JLabel lblTim = new JLabel("Thông tin tìm: ");
		txtTimKiem = new JTextField(15);
		txtTimKiem.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		pnTimKiem.add(lblTim);
		pnTimKiem.add(txtTimKiem);
		btnTim = new JButton("Tìm");
		pnTimKiem.add(btnTim);
		btnReset = new JButton("Reset");
		btnLocTheoMaP = new JButton("Lọc theo mã phòng");
		pnTimKiem.add(btnLocTheoMaP);
		pnTimKiem.add(btnReset);
		split.add(pnTimKiem);

		JPanel pnChucNang = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnXoaTrang = new JButton("Xóa trắng");
		btnSua = new JButton("Sửa");

		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnXoaTrang);
		pnChucNang.add(btnSua);
		split.add(pnChucNang);
		
		contentPane = new JPanel();
		contentPane.add(pnBorder);
		add(contentPane);
		
		napComboBox(phong_bus.getAllPhong());
		napDuLieuTuCSDL(thietBi_bus.getAllThietBi());
		
		
	}
	
	public void napComboBox(ArrayList<Phong> ds) {
		int n = ds.size();
		String items[] = new String[n];
		int i = 0;
		for (Phong p : ds) {
			items[i] = p.getMaPhong();
			i++;
		}
		cboMaP.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	public boolean valiDate() {
		String maTB = txtMaTB.getText().trim();
		String tenTB = txtTenTB.getText().trim();
		
		if(maTB.equals("")) {
			txtMess.setText("Mã TB trống!, Hãy nhấn random mã!");
			return false;
		}
		
		if(tenTB.equals("")) {
			txtMess.setText("Tên TB trống!");
			txtTenTB.requestFocus();
			return false;
		}
		return true;
	}
	
	public ThietBi revertThietBiFromFields() {
		String maTB = txtMaTB.getText().trim();
		String tenTB = txtTenTB.getText().trim();
		Phong P = new Phong(cboMaP.getSelectedItem().toString());
		String moTa = txtMoTa.getText().trim();
		if(moTa.equals("")) {
			moTa = "null";
		}
		ThietBi tb = new ThietBi(maTB, P, tenTB, moTa);
		return tb;
	}
	
	private void deleteRowSelected() {
		String listMaTB = "";
		String maTB = "";

		if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
		} else {

//			lay ra danh sach xoa tren GUI
			int[] listIndex = table.getSelectedRows();
			listMaTB += table.getValueAt(listIndex[0], 0);
			for (int i = 1; i < table.getSelectedRowCount(); i++) {
				listMaTB += ", " + table.getValueAt(listIndex[i], 0);
			}

//			Hien thi thong tin xoa
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Thiết bị " + listMaTB + " ?",
					"Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (table.getSelectedRowCount() > 0) {
						maTB = (String) table.getValueAt(table.getSelectedRow(), 0);
						if (!thietBi_bus.xoa(maTB)) {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, đã xảy ra lỗi");
							table.clearSelection();
						} else {
							model.removeRow(table.getSelectedRow());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		}
	}
	
	public void napDuLieuTuCSDL(ArrayList<ThietBi> ds) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		for (ThietBi tb : ds) {
			model.addRow(new Object[] {tb.getMaTB(), tb.getTenTB(), tb.getPhong().getMaPhong(), tb.getMoTa()});
		}
	}
	public void fillForm(int r) {
		txtMaTB.setText(table.getValueAt(r, 0).toString());
		txtTenTB.setText(table.getValueAt(r, 1).toString());
		txtMoTa.setText(table.getValueAt(r, 3).toString());
		cboMaP.setSelectedItem(table.getValueAt(r, 2));
	}

	public void sua() {
		int r = table.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa");
		} else {
			if (valiDate()) {
				ThietBi tbMoi = revertThietBiFromFields();
				if (!thietBi_bus.capNhat(tbMoi)) {
					JOptionPane.showMessageDialog(this, "Lỗi không thể cập nhật");
					table.clearSelection();
				} else {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					napDuLieuTuCSDL(thietBi_bus.getAllThietBi());
				}
			}
		}
	}
	
	public void timTheoMaTB() {
		String ma = txtTimKiem.getText().trim();
		ThietBi tb = thietBi_bus.getThietBiTheoMaTB(ma);
		if (tb != null) {
			DefaultTableModel dm = (DefaultTableModel) table.getModel();
			dm.getDataVector().removeAllElements();
			model.addRow(new Object[] {tb.getMaTB(), tb.getTenTB(), tb.getPhong().getMaPhong(), tb.getMoTa()});
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		}
	}
	
	public void timTheoMaPhong() {
		String maP = cboMaP.getSelectedItem().toString();

			ArrayList<ThietBi> tbList = thietBi_bus.getThietBiTheoMaPhong(maP);
			if (tbList.size() > 0) {
				napDuLieuTuCSDL(tbList);
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy thiết bị nào!");
			}
	}
	
	
	public static void main(String[] args) {
		new FrmThietBi().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnRanDom)) {
			PhatSinhMa ran = new PhatSinhMa();
			txtMaTB.setText("TB"+ran.randomMaTB());
		}
		if(o.equals(btnThem)) {
			if(valiDate()) {
				ThietBi tb = revertThietBiFromFields();
				if(!thietBi_bus.them(tb)) {
					JOptionPane.showMessageDialog(this, "Trùng mã!");
				}else {
					model.addRow(new Object[] {tb.getMaTB(), tb.getTenTB(), tb.getPhong().getMaPhong(), tb.getMoTa()});
				}
			}
		}
		if(o.equals(btnXoa)) {
			deleteRowSelected();
		}
		if(o.equals(btnXoaTrang)) {
			txtTenTB.setText("");
			txtMoTa.setText("");
			txtTenTB.requestFocus();
		}
		if(o.equals(btnSua)) {
			sua();
		}
		if(o.equals(btnTim)) {
			timTheoMaTB();
		}
		if(o.equals(btnReset)) {
			napDuLieuTuCSDL(thietBi_bus.getAllThietBi());
		}
		if(o.equals(btnLocTheoMaP)) {
			timTheoMaPhong();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		fillForm(r);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
