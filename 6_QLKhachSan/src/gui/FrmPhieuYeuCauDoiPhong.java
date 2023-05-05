package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Dao_PhieuYeuCauDoiPhong;
import entity.PhieuYeuCauDoiPhong;

public class FrmPhieuYeuCauDoiPhong extends JFrame implements ActionListener {
	public static JPanel contentPane;
	private JLabel lblTieuDe, lblTenKhachHang, lblCCCD, lblSDT, lblMaPhongCu, lblMaPhongMoi, lblChiTietLyDoDoi,
			lblPhiPhuThem;
	private JTextField txtThongBao, txtTenKhachHang, txtCCCD, txtSDT, txtMaPhongCu, txtMaPhongMoi, txtChiTietLyDoDoi,
			txtPhiPhuThem;
	private JButton btnXacNhanDoiPhong, btnHuyDoiPhong;

	public FrmPhieuYeuCauDoiPhong() {
		setTitle("Quản Lý Khách Sạn");
		setSize(700, 400);
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
		JLabel lblTieuDe = new JLabel("Phiếu Yêu Cầu Đổi Phòng");
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
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();

		box.add(b1);
		box.add(Box.createVerticalStrut(5));
		box.add(b2);
		box.add(Box.createVerticalStrut(5));
		box.add(b3);
		box.add(Box.createVerticalStrut(5));
		box.add(b4);
		box.add(Box.createVerticalStrut(5));
		box.add(b5);
		box.add(Box.createVerticalStrut(5));
		box.add(b6);
		box.add(Box.createVerticalStrut(5));

		b1.add(lblTenKhachHang = new JLabel("Họ Tên Khách Hàng"));
		b1.add(txtTenKhachHang = new JTextField());

		b2.add(lblCCCD = new JLabel("CCCD"));
		b2.add(txtCCCD = new JTextField());
		b2.add(lblSDT = new JLabel("SĐT"));
		b2.add(txtSDT = new JTextField());

		b3.add(lblMaPhongCu = new JLabel("Mã Phòng Cũ"));
		b3.add(txtMaPhongCu = new JTextField());
		b3.add(lblMaPhongMoi = new JLabel("Mã Phòng Mới"));
		b3.add(txtMaPhongMoi = new JTextField());

		b4.add(lblChiTietLyDoDoi = new JLabel("Chi Tiết Lý Do Đổi"));
		b4.add(txtChiTietLyDoDoi = new JTextField());

		b5.add(lblPhiPhuThem = new JLabel("Phí Phụ Thêm"));
		b5.add(txtPhiPhuThem = new JTextField());

		b6.add(txtThongBao = new JTextField());
		txtThongBao.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setBorder(null);
		txtThongBao.setEditable(false);

		pnBorder.add(box);

		lblTenKhachHang.setPreferredSize(new Dimension(120, 5));
		lblCCCD.setPreferredSize(new Dimension(120, 5));
		lblSDT.setPreferredSize(new Dimension(120, 5));
		lblMaPhongCu.setPreferredSize(new Dimension(120, 5));
		lblMaPhongMoi.setPreferredSize(new Dimension(120, 5));
		lblChiTietLyDoDoi.setPreferredSize(new Dimension(120, 5));
		lblPhiPhuThem.setPreferredSize(new Dimension(120, 5));

		JPanel pn_bottom = new JPanel();
		pn_bottom.add(btnXacNhanDoiPhong = new JButton("Xác Nhận Đổi Phòng"));
		btnXacNhanDoiPhong.setToolTipText("Nhấn vào đây để xác nhận đổi phòng");
		pn_bottom.add(btnHuyDoiPhong = new JButton("Hủy Đổi Phòng"));
		btnHuyDoiPhong.setToolTipText("Nhấn vào đây để hủy thao tác");
		this.add(pn_bottom, BorderLayout.SOUTH);

		btnXacNhanDoiPhong.addActionListener(this);
		btnHuyDoiPhong.addActionListener(this);

		getContentPane().add(pnBorder);
	}

	public static void main(String[] args) {
		new FrmPhieuYeuCauDoiPhong().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnHuyDoiPhong)) {
			int tb = JOptionPane.showConfirmDialog(this, "Xác nhận hủy đổi phòng?", "Delete",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				System.exit(tb);
			}
		} else if (e.getSource() == btnXacNhanDoiPhong) {
			String tenKH = txtTenKhachHang.getText();
			String cccd = txtCCCD.getText();
			String sdt = txtSDT.getText();
			String maPhongCu = txtMaPhongCu.getText();
			String maPhongMoi = txtMaPhongMoi.getText();
			String lyDoDoi = txtChiTietLyDoDoi.getText();
			String phiPhuThem = txtPhiPhuThem.getText();

			// kiểm tra thông tin nhập vào
			if (tenKH.equals("") || cccd.equals("") || sdt.equals("") || maPhongCu.equals("") || maPhongMoi.equals("")
					|| lyDoDoi.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int phi = 0;
			try {
				phi = (int) Double.parseDouble(phiPhuThem);
			} catch (NumberFormatException ex) {
				phi = 0;
			}

			// tạo phiếu yêu cầu đổi phòng mới
			PhieuYeuCauDoiPhong p = new PhieuYeuCauDoiPhong(tenKH, cccd, sdt, maPhongCu, maPhongMoi, lyDoDoi, phi);
			boolean result = Dao_PhieuYeuCauDoiPhong.themPhieuYeuCauDoiPhong(p);

			if (result) {
				JOptionPane.showMessageDialog(this, "Tạo phiếu yêu cầu đổi phòng thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				txtTenKhachHang.setText("");
				txtCCCD.setText("");
				txtSDT.setText("");
				txtMaPhongCu.setText("");
				txtMaPhongMoi.setText("");
				txtChiTietLyDoDoi.setText("");
				txtPhiPhuThem.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Lỗi khi tạo phiếu yêu cầu đổi phòng!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnHuyDoiPhong) {
			this.dispose();
		}

	}
}
