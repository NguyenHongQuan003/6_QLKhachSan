package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bus.Bus_KiemTraPhongMoi;
import entity.KiemTraPhongMoi;

public class FrmKiemTraPhongMoi extends JFrame implements ActionListener, WindowListener {
	public static JPanel contentPane;
	private JLabel lblTieuDe, lblMaPhong, lblLoaiPhong, lblTenPhong, lblTinhTrang;
	private JButton btnTroLai, btnPhieuYeuCauDoiPhong;
	private JTextField txtMaPhong, txtLoaiPhong, txtxTenPhong, txtTinhTrang, txtThongBao;
	private Bus_KiemTraPhongMoi kt = new Bus_KiemTraPhongMoi();

	public FrmKiemTraPhongMoi() {
		setTitle("Quản Lý Khách Sạn");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		createGui();
	}

	public void createGui() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(900, 600));
		add(pnBorder);

		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Kiểm Tra Phòng Mới");
		lblTieuDe.setForeground(Color.blue);
		Font fTieuDe = new Font("Arial", Font.BOLD, 25);
		lblTieuDe.setFont(fTieuDe);
		pnNorth.add(lblTieuDe);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// Phần Center
		JPanel pnCenter = new JPanel();
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		Box box = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		box.add(b1);
		box.add(Box.createVerticalStrut(5));
		box.add(b2);
		box.add(Box.createVerticalStrut(5));
		box.add(b3);
		box.add(Box.createVerticalStrut(5));
		box.add(b4);
		box.add(Box.createVerticalStrut(5));

		b1.add(lblMaPhong = new JLabel("Mã Phòng"));
		b1.add(txtMaPhong = new JTextField());
		b1.add(lblTenPhong = new JLabel("Tên Phòng"));
		b1.add(txtxTenPhong = new JTextField());

		b2.add(lblLoaiPhong = new JLabel("Loại Phòng"));
		b2.add(txtLoaiPhong = new JTextField());

		b3.add(lblTinhTrang = new JLabel("Tình Trạng"));
		b3.add(txtTinhTrang = new JTextField());

		b4.add(txtThongBao = new JTextField());
		txtThongBao.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setBorder(null);
		txtThongBao.setEditable(false);

		pnCenter.add(box);

		lblMaPhong.setPreferredSize(new Dimension(80, 5));
		lblTenPhong.setPreferredSize(new Dimension(80, 5));
		lblLoaiPhong.setPreferredSize(new Dimension(80, 5));
		lblTinhTrang.setPreferredSize(new Dimension(80, 5));

		// Tạo nút "Chuyển sang giao diện B"
		btnPhieuYeuCauDoiPhong = new JButton("Phiếu Yêu Cầu Đổi Phòng");
		btnPhieuYeuCauDoiPhong.setToolTipText("Nhấn vào đây để chuyển phiếu xác nhận");
		btnPhieuYeuCauDoiPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					switchToB();
				}
			}

			public boolean validateForm() {
				String maPhong = txtMaPhong.getText().trim();
				String tenPhong = txtxTenPhong.getText().trim();
				String loaiPhong = txtLoaiPhong.getText().trim();
				String tinhTrang = txtTinhTrang.getText().trim();

				// Kiểm tra dữ liệu nhập vào
				if (maPhong.isEmpty() || tenPhong.isEmpty() || loaiPhong.isEmpty() || tinhTrang.isEmpty()) {
					txtThongBao.setText("Vui lòng nhập đầy đủ thông tin!");
					return false;
				}
				// Kiểm tra định dạng dữ liệu
				if (!maPhong.matches("[a-zA-Z0-9]+")) {
					txtThongBao.setText("Mã phòng không hợp lệ!");
					return false;
				}
				if (!tenPhong.matches("[a-zA-Z0-9 ]+")) {
					txtThongBao.setText("Tên phòng không hợp lệ!");
					return false;
				}
				if (!loaiPhong.matches("[a-zA-Z0-9 ]+")) {
					txtThongBao.setText("Loại phòng không hợp lệ!");
					return false;
				}
				if (!tinhTrang.matches("[a-zA-Z0-9 ]+")) {
					txtThongBao.setText("Tình trạng không hợp lệ!");
					return false;
				}

				// Nếu thông tin hợp lệ, trả về true
				return true;
			}

		});

		btnTroLai = new JButton("Trở Lại");
		btnTroLai.setToolTipText("Nhấn vào đây để quay trở lại");
		btnTroLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToC();
			}
		});

		JPanel pn_bottom = new JPanel();
		pn_bottom.add(btnPhieuYeuCauDoiPhong);
		pn_bottom.add(btnTroLai);
		btnTroLai.setToolTipText("Nhấn vào đây để quay trở lại");
		this.add(pn_bottom, BorderLayout.SOUTH);

		btnPhieuYeuCauDoiPhong.addActionListener(this);
		btnTroLai.addActionListener(this);

		getContentPane().add(pnBorder);
		napDuLieuTuCSDL(kt.getALLKiemTraPhongMoi());
	}

	private void napDuLieuTuCSDL(ArrayList<KiemTraPhongMoi> allKiemTraPhongMoi) {
		// TODO Auto-generated method stub

	}

	// Phương thức để chuyển sang giao diện Phiếu yêu cầu đổi phòng
	private void switchToB() {
		FrmPhieuYeuCauDoiPhong frmPhieuYeuCauDoiPhong = new FrmPhieuYeuCauDoiPhong();
		frmPhieuYeuCauDoiPhong.setVisible(true);
		dispose();
	}

	// Phương thức để chuyển sang giao diện Đổi Phòng
	private void switchToC() {
		FrmDoiPhong frmDoiPhong = new FrmDoiPhong();
		frmDoiPhong.setVisible(true);
		dispose();
	}

	public static void main(String[] args) {
		new FrmKiemTraPhongMoi().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
