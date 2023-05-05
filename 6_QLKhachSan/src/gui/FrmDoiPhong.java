package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FrmDoiPhong extends JFrame implements ActionListener, WindowListener {
	private JLabel lblTieuDe, lblHoTen, lblCCCD, lblDiaChi, lblSDT, lblMaPhongCu, lblMaPhongMoi, lblLyDoDoi,
			lblChiTietLyDo;
	private JTextField txtHoTen, txtCCCD, txtDiaChi, txtSDT, txtMaPhongCu, txtMaPhongMoi, txtChiTietLyDo, txtThongBao;
	private JButton btnDoi, btnHuy;
	private JComboBox comBoLyDoDoi, comBoMaPhongCu;
//	private JComboBox comBoMaPhongMoi;

	private JPanel pnKiemTraPhongMoi, pnBorder;
	private FrmKiemTraPhongMoi frmKiemTraPhongMoi = new FrmKiemTraPhongMoi();

	public FrmDoiPhong() {
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
		JLabel lblTieuDe = new JLabel("Quản Lý Đổi Phòng Khách Sạn");
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
		Box b7 = Box.createHorizontalBox();

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
		box.add(b7);
		box.add(Box.createVerticalStrut(5));

		b1.add(lblHoTen = new JLabel("Họ Tên Khách Hàng "));
		b1.add(txtHoTen = new JTextField());
		b1.add(lblCCCD = new JLabel("CCCD "));
		b1.add(txtCCCD = new JTextField());

		b2.add(lblDiaChi = new JLabel("Địa Chỉ "));
		b2.add(txtDiaChi = new JTextField());
		b2.add(lblSDT = new JLabel("SĐT "));
		b2.add(txtSDT = new JTextField());

		b3.add(lblMaPhongCu = new JLabel("Mã Phòng Cũ "));
		b3.add(comBoMaPhongCu = new JComboBox());
		comBoMaPhongCu.addItem("100");
		comBoMaPhongCu.addItem("101");
		comBoMaPhongCu.addItem("200");
		comBoMaPhongCu.addItem("300");
		comBoMaPhongCu.addItem("301");

		b4.add(lblMaPhongMoi = new JLabel("Mã Phòng Mới "));
		b4.add(txtMaPhongMoi = new JTextField());
//		b4.add(comBoMaPhongMoi = new JComboBox());
//		comBoMaPhongMoi.addItem("100");
//		comBoMaPhongMoi.addItem("101");
//		comBoMaPhongMoi.addItem("200");
//		comBoMaPhongMoi.addItem("300");
//		comBoMaPhongMoi.addItem("301");

		b5.add(lblLyDoDoi = new JLabel("Lý Do Đổi "));
		b5.add(comBoLyDoDoi = new JComboBox());
		comBoLyDoDoi.addItem("Vấn đề về an ninh và an toàn");
		comBoLyDoDoi.addItem("Vấn đề về tiện nghi");
		comBoLyDoDoi.addItem("Vấn đề về sạch sẽ");
		comBoLyDoDoi.addItem("Vấn đề về tiếng ồn");
		comBoLyDoDoi.addItem("Sự cố về kỹ thuật");
		comBoLyDoDoi.addItem("Không hài lòng với phòng của mình");

		b6.add(lblChiTietLyDo = new JLabel("Chi Tiết Lý Do "));
		b6.add(txtChiTietLyDo = new JTextField());

		b7.add(txtThongBao = new JTextField());
		txtThongBao.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setBorder(null);
		txtThongBao.setEditable(false);

		pnCenter.add(box);

		lblHoTen.setPreferredSize(new Dimension(120, 5));
		lblCCCD.setPreferredSize(new Dimension(50, 5));
		lblDiaChi.setPreferredSize(new Dimension(120, 5));
		lblSDT.setPreferredSize(new Dimension(50, 5));
		lblMaPhongCu.setPreferredSize(new Dimension(120, 5));
		lblMaPhongMoi.setPreferredSize(new Dimension(120, 5));
		lblLyDoDoi.setPreferredSize(new Dimension(120, 5));
		lblChiTietLyDo.setPreferredSize(new Dimension(120, 5));

		// Tạo nút "Chuyển sang giao diện B"
		btnDoi = new JButton("Kiểm Tra Phòng Mới");
		btnDoi.setToolTipText("Nhấn vào đây để chuyển tiếp kiểm tra");
		btnDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					switchToB();
				}
			}
		});

		JPanel pn_bottom = new JPanel();
		pn_bottom.add(btnDoi);
		getContentPane().add(pnBorder);
		pn_bottom.add(btnHuy = new JButton("Hủy Thao Tác"));
		btnHuy.setToolTipText("Nhấn vào đây để hủy việc đổi phòng");
		this.add(pn_bottom, BorderLayout.SOUTH);

		addWindowListener(this);
		btnDoi.addActionListener(this);
		btnHuy.addActionListener(this);

	}

	// Phương thức để chuyển sang giao diện Kiểm tra phòng mới
	private void switchToB() {
		FrmKiemTraPhongMoi frmKiemTraPhongMoi = new FrmKiemTraPhongMoi();
		frmKiemTraPhongMoi.setVisible(true);
		dispose();
	}

	private boolean validateForm() {
		String hoTen = txtHoTen.getText();
		String cccd = txtCCCD.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String maPhongCu = (String) comBoMaPhongCu.getSelectedItem();
		String maPhongMoi = txtMaPhongMoi.getText();
		String lyDoDoi = (String) comBoLyDoDoi.getSelectedItem();
		String chiTietLyDo = txtChiTietLyDo.getText();

		// Validate hoTen, cccd, diaChi, sdt, maPhongCu, maPhongMoi, lyDoDoi, and
		// chiTietLyDo
		// Return true if all fields are valid, false otherwise

		// Example validation
		if (hoTen.isEmpty() || cccd.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || maPhongMoi.isEmpty()
				|| lyDoDoi.isEmpty() || chiTietLyDo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
			return false;
		}

		if (maPhongCu.equals(maPhongMoi)) {
			JOptionPane.showMessageDialog(this, "Mã phòng mới phải khác mã phòng cũ.");
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		new FrmDoiPhong().setVisible(true);
//		FrmDoiPhong frmDoiPhong = new FrmDoiPhong();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", "Xác nhận thoát",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnHuy)) {
			int tb = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy thao tác?", "Delete",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				System.exit(tb);
			}
		}

	}
}
