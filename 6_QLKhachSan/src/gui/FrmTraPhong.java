package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Table;

import com.toedter.calendar.JDateChooser;

import bus.Bus_ChiTietDatPhong;
import bus.Bus_ChiTietSuDungDichVu;
import bus.Bus_KhachHang;
import bus.Bus_Phong;
import bus.Bus_Tang;
import connectDB.ConnectDB;
import dao.Dao_Phong;
import entity.ChiTietDatPhong;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;

public class FrmTraPhong extends JFrame implements WindowListener,ActionListener,MouseListener,TableModelListener{
	private static final long serialVersionUID = 1L;
	private JLabel lblMaPH,lblTenPH,lblLoaiPH,lblMaTang,lblGhiChu,lblTimeNhan,lblTimeTra,lblTienDV,lblGiaPH,lblTienPH,lblChuyenPH,lblPhuThu,lblGiamTru,lblTongTien,lblDatcoc,lblKhachThanhToan,lblKhachNo;
	private JTextField txtMaPH,txtTenPH,txtGhiChu,txtTienDV,txtLoaiPhong,txtNgayNhan,txtNgayTra,txtMaTang,txtGiaPH,txtTienPH,txtChuyenPH,txtPhuThu,txtGiamTru,txtTongTien,txtDatcoc,txtKhachThanhToan,txtKhachNo;
	private JButton bnTraPhong,bnTraPhongvsIn,bnHuy;
	private JDateChooser dateNgayNhan,dateNgayTra;
	private JTable tableKhachHang;
	private DefaultTableModel modelKhachHang;
	private JTable tableDichVu;
	private DefaultTableModel modelDichVu;
	private static JPanel pnContent;
	private static final int NUM_ROOMS = 30;
	private Bus_Phong phong_bus = new Bus_Phong();
	private Bus_KhachHang khachHang_bus = new Bus_KhachHang();
	private Bus_ChiTietDatPhong chiTietDatPhong_bus = new Bus_ChiTietDatPhong();
	private Bus_ChiTietSuDungDichVu chiTietSuDungDichVu_bus = new Bus_ChiTietSuDungDichVu();
	private String maPH,tenPH,idDat,idTra;
	private Phong pThue = new Phong();
	private Bus_Tang tang_bus = new Bus_Tang();
	private KhachHang kh;
	private HoaDon hd;
	private ChiTietDatPhong ct = new ChiTietDatPhong();
	private String maPhongDeTimKhachHang;
	public FrmTraPhong() {
		setTitle("Trả Phòng");
		setSize(1050, 780);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		createGui();
		addWindowListener(this);
	}
	public FrmTraPhong(String maP) {
		super("Trả phòng" +maP);
		maPH = maP;
		setSize(1050, 780);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		createGui();
		addWindowListener(this);
		bnTraPhong.addActionListener(this);
		bnTraPhongvsIn.addActionListener(this);
		bnHuy.addActionListener(this);
	}
	public void createGui() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JLabel lblTieuDe = new JLabel("TRẢ PHÒNG");
		lblTieuDe.setForeground(Color.blue);
		Font fTieuDe = new Font("Arial", Font.BOLD, 25);
		lblTieuDe.setFont(fTieuDe);
		
		JPanel pnNorth = new JPanel(new BorderLayout());
		pnNorth.add(lblTieuDe, BorderLayout.NORTH);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnNorth.setPreferredSize(new Dimension(950, 400));
		
		//Thông tin phòng thuê
		JPanel pnPhongThue = new JPanel(new GridLayout(7,2,5,5));
		pnPhongThue.setBorder(BorderFactory.createTitledBorder("Thông tin phòng thuê"));

		pnPhongThue.add(lblMaPH = new JLabel("Mã phòng"));
		pnPhongThue.add(txtMaPH = new JTextField(6));
		txtMaPH.setEditable(false);
		Phong pThue = phong_bus.getPhongTheoMaPhong(maPH);
		if(pThue != null) {
			txtMaPH.setText(pThue.getMaPhong());
		}
		pnPhongThue.add(lblTenPH = new JLabel("Tên Phòng"));
		pnPhongThue.add(txtTenPH = new JTextField());
		txtTenPH.setEditable(false);
		if(pThue != null) {
			txtTenPH.setText(pThue.getTenPhong());
		}
		pnPhongThue.add(lblLoaiPH = new JLabel("Loại Phòng"));
		pnPhongThue.add(txtLoaiPhong = new JTextField());
		txtLoaiPhong.setEditable(false);
		if(pThue != null) {
			txtLoaiPhong.setText(pThue.getLoaiPhong());
		}
		pnPhongThue.add(lblMaTang = new JLabel("Tầng"));
		pnPhongThue.add(txtMaTang= new JTextField());
		txtMaTang.setEditable(false);
		if(pThue != null) {
			txtMaTang.setText(pThue.getTang().getMaTang()+"");
		}
		pnPhongThue.add(lblTimeNhan = new JLabel("Ngày nhận phòng"));
		pnPhongThue.add(dateNgayNhan= new JDateChooser());
		dateNgayNhan.setDateFormatString("dd/MM/yyyy");
		dateNgayNhan.setDate(Calendar.getInstance().getTime());
		pnPhongThue.add(lblTimeTra = new JLabel("Ngày trả phòng"));
		pnPhongThue.add(dateNgayTra = new JDateChooser());
		dateNgayTra.setDateFormatString("dd/MM/YYYY");
		dateNgayTra.setDate(Calendar.getInstance().getTime());;
		pnPhongThue.add(lblGhiChu = new JLabel("Ghi chú"));
		pnPhongThue.add(txtGhiChu = new JTextField());
		pnPhongThue.setPreferredSize(new Dimension(550,400));
		pnNorth.add(pnPhongThue,BorderLayout.WEST);
		
		//Thông tin trả tiền
		JPanel pnTienTra = new JPanel(new GridLayout(7, 2, 7,7));
		pnTienTra.setBorder(BorderFactory.createTitledBorder("Chi phí thuê phòng"));
		pnTienTra.add(lblTienDV = new JLabel("Tiền dịch vụ"));
		pnTienTra.add(txtTienDV = new JTextField());
		pnTienTra.add(lblGiaPH = new JLabel("Giá phòng"));
		pnTienTra.add(txtGiaPH = new JTextField());
		txtGiaPH.setEditable(false);
		if(pThue !=null) {
			txtGiaPH.setText(pThue.getGia()+"");
		}
		pnTienTra.add(lblTienPH = new JLabel("Tiền phòng"));
		pnTienTra.add(txtTienPH = new JTextField());
		pnTienTra.add(lblPhuThu = new JLabel("Phụ thu"));
		pnTienTra.add(txtPhuThu = new JTextField());
		pnTienTra.add(lblTongTien = new JLabel("Tổng tiền"));
		pnTienTra.add(txtTongTien = new JTextField());
		pnTienTra.add(lblKhachThanhToan = new JLabel("Khách đưa"));
		pnTienTra.add(txtKhachThanhToan = new JTextField());
		pnTienTra.add(lblKhachNo = new JLabel("Tiền đưa lại"));
		pnTienTra.add(txtKhachNo = new JTextField());
		pnTienTra.setPreferredSize(new Dimension(400, 400));
		pnNorth.add(pnTienTra,BorderLayout.CENTER);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		//pnCenter
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnBorder.add(pnCenter,BorderLayout.CENTER);
		JSplitPane slitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		//Table KhachHang
		JPanel pnDSKhachHang = new JPanel();
		pnDSKhachHang.setLayout(new BorderLayout());
		pnDSKhachHang.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng đặt"));
		String colsKH[]= {"Mã HD","Mã Phòng","Tên khách hàng","Ngày đặt","Ngày trả","Số người","Ngày lập hóa đơn","Số lượng dịch vụ","Tên dịch vụ","Giá dịch vụ"};
		modelKhachHang = new DefaultTableModel(colsKH,0);
		tableKhachHang = new JTable(modelKhachHang);
		JScrollPane paneKH = new JScrollPane(tableKhachHang);
		paneKH.setPreferredSize(new Dimension(950,250));
		joinWithPhong();
		pnDSKhachHang.add(paneKH);
		slitpane.setTopComponent(pnDSKhachHang);
		//Table DichVu
		
		pnCenter.add(slitpane);
		//pnChucNang
		JPanel pnBottom = new JPanel();
		pnBorder.add(pnBottom,BorderLayout.SOUTH);
		pnBottom.add(bnTraPhong = new JButton("Trả phòng"));
		Icon iconThoat = new ImageIcon("img/random.png");
		Image imgThoat = ((ImageIcon)iconThoat).getImage();
		Image newImgThoat = imgThoat.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		Icon newIconThoat = new ImageIcon(newImgThoat);
		bnTraPhong.setIcon(newIconThoat);
		pnBottom.add(bnTraPhongvsIn = new JButton("Trả phòng và In"));
		Icon iconIn = new ImageIcon("img/wrapper_report.png");
		Image imgIn=((ImageIcon)iconIn).getImage();
		Image newIn=imgIn.getScaledInstance(20, 20,java.awt.Image.SCALE_SMOOTH );
		Icon IconIn= new ImageIcon(newIn);
		bnTraPhongvsIn.setIcon(IconIn);
		pnBottom.add(bnHuy = new JButton("Hủy"));
		Icon iconHuy = new ImageIcon("img/exit.png");
		Image imaHuy=((ImageIcon)iconHuy).getImage();
		Image newIconHuy =imaHuy.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH);
		Icon newHuy=new ImageIcon(newIconHuy);
		bnHuy.setIcon(newHuy);
	
		bnTraPhong.addActionListener(this);
		bnTraPhongvsIn.addActionListener(this);
		bnHuy.addActionListener(this);
		
		pnContent = new JPanel();
		pnContent.add(pnBorder);
		add(pnContent);
		
	}
	public static void main(String[] args) {
		new FrmTraPhong().setVisible(true);
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public void joinWithPhong() {
	
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT c.MAHD, c.MAPHONG, kh.HOTEN, c.NGAYDAT, c.NGAYTRA, c.SONGUOI, h.NGAYLAPHD ,ct.SOLUONG ,dv.TENDV ,dv.GIA " +
                    "FROM ChiTietDatPhong AS c " +
                    "JOIN Phong AS p ON c.MAPHONG = p.MAPHONG " +
                    "JOIN HoaDon AS h ON c.MAHD=h.MAHD " +
                    "JOIN ChiTietSuDungDichVu ct ON h.MAHD=ct.MAHD " +
                    "JOIN KhachHang AS kh ON h.MAKH=kh.MAKH " +
					"JOIN DichVu AS dv ON ct.MADV=dv.MADV";
			Statement sta = con.createStatement();
			DefaultTableModel dm=(DefaultTableModel) tableKhachHang.getModel();
			int r =tableKhachHang.getSelectedRow();
			if (r >= 0 && r < tableKhachHang.getRowCount()) {
				tableKhachHang.getValueAt(r, 0).toString();
			}
			dm.getDataVector().removeAllElements();
			ResultSet rs = sta.executeQuery(sql);
			Object obj[]=new Object[15];
			while (rs.next()) {
				obj[0]=rs.getString(1);
				obj[1]=rs.getInt(2);
				obj[2]=rs.getString(3);
				obj[3]=rs.getDate(4);
				obj[4]=rs.getDate(5);
				obj[5]=rs.getInt(6);
				obj[6]=rs.getDate(7);
				obj[7]=rs.getInt(8);
				obj[8]=rs.getString(9);
				obj[9]=rs.getDouble(10);
//				obj[11]=rs.getDouble(9) * rs.getDouble(11); // tính tổng tiền dịch vụ
//		        obj[12]=rs.getDouble(7) + rs.getDouble(11) * rs.getDouble(9); // tính tổng tiền bao gồm phòng và dịch vụ
//				dm.addRow(obj);
		        modelKhachHang.addRow(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o.equals(bnHuy)) {
			int tb =JOptionPane.showConfirmDialog(this,"Bạn có muốn thoát?","Exit",JOptionPane.YES_NO_CANCEL_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				System.exit(tb);
			}
		}else if(o.equals(bnTraPhong)) {
			JOptionPane.showMessageDialog(this,"Trả phòng thành công");
			if(phong_bus.capNhatTrangThai(true, maPH)) {
				setVisible(false);
			}
		}else{
			JOptionPane.showMessageDialog(this,"Xuất hóa đơn thành công");
			if(phong_bus.capNhatTrangThai(true, maPH)) {
				setVisible(false);
			}
		}
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false);
		
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