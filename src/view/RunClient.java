package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import logic.ConfigureIpParameters;
import logic.ConvertDescriptionModel;
import logic.RetrieveDescriptions;
import model.DescriptionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import export.ExportFactory;
import export.ExportToFile;
import export.FileType;
import export.WriteStatus;

public class RunClient {

	private JFrame frmModbusDecriptionClient;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtNode;
	private JTextField txtOffset;
	private JTextField txtLength;
	private JTable tblDescription;
	private JTextField txtFileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunClient window = new RunClient();
					window.frmModbusDecriptionClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RunClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModbusDecriptionClient = new JFrame();
		frmModbusDecriptionClient.setTitle("Modbus description client");
		frmModbusDecriptionClient.setBounds(100, 100, 795, 586);
		frmModbusDecriptionClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		frmModbusDecriptionClient.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane pnlTabbedSettings = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_pnlTabbedSettings = new GridBagConstraints();
		gbc_pnlTabbedSettings.fill = GridBagConstraints.BOTH;
		gbc_pnlTabbedSettings.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTabbedSettings.gridx = 0;
		gbc_pnlTabbedSettings.gridy = 0;
		frmModbusDecriptionClient.getContentPane().add(pnlTabbedSettings, gbc_pnlTabbedSettings);
		
		JPanel pnlTCP = new JPanel();
		pnlTabbedSettings.addTab("TCP", null, pnlTCP, null);
		GridBagLayout gbl_pnlTCP = new GridBagLayout();
		gbl_pnlTCP.columnWidths = new int[] {0, 0};
		gbl_pnlTCP.rowHeights = new int[] {0, 0};
		gbl_pnlTCP.columnWeights = new double[]{1.0, 1.0};
		gbl_pnlTCP.rowWeights = new double[]{1.0, 1.0};
		pnlTCP.setLayout(gbl_pnlTCP);
		
		JPanel pnlTargetSettings = new JPanel();
		FlowLayout fl_pnlTargetSettings = (FlowLayout) pnlTargetSettings.getLayout();
		fl_pnlTargetSettings.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_pnlTargetSettings = new GridBagConstraints();
		gbc_pnlTargetSettings.anchor = GridBagConstraints.WEST;
		gbc_pnlTargetSettings.fill = GridBagConstraints.BOTH;
		gbc_pnlTargetSettings.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTargetSettings.gridx = 0;
		gbc_pnlTargetSettings.gridy = 0;
		pnlTCP.add(pnlTargetSettings, gbc_pnlTargetSettings);
		pnlTargetSettings.setBorder(new TitledBorder(null, "Target Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnlHost = new JPanel();
		pnlTargetSettings.add(pnlHost);
		GridBagLayout gbl_pnlHost = new GridBagLayout();
		gbl_pnlHost.columnWidths = new int[]{120, 0};
		gbl_pnlHost.rowHeights = new int[]{20, 20, 0};
		gbl_pnlHost.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlHost.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlHost.setLayout(gbl_pnlHost);
		
		JLabel lblHost = new JLabel("Host:");
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.anchor = GridBagConstraints.WEST;
		gbc_lblHost.insets = new Insets(0, 0, 5, 0);
		gbc_lblHost.gridx = 0;
		gbc_lblHost.gridy = 0;
		pnlHost.add(lblHost, gbc_lblHost);
		
		txtHost = new JTextField();
		txtHost.setText("localhost");
		txtHost.setColumns(20);
		GridBagConstraints gbc_txtHost = new GridBagConstraints();
		gbc_txtHost.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtHost.gridx = 0;
		gbc_txtHost.gridy = 1;
		pnlHost.add(txtHost, gbc_txtHost);
		
		JPanel pnlPort = new JPanel();
		pnlTargetSettings.add(pnlPort);
		GridBagLayout gbl_pnlPort = new GridBagLayout();
		gbl_pnlPort.columnWidths = new int[]{50, 0};
		gbl_pnlPort.rowHeights = new int[]{20, 0, 0};
		gbl_pnlPort.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlPort.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlPort.setLayout(gbl_pnlPort);
		
		JLabel lblPort = new JLabel("Port:");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.WEST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 0);
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 0;
		pnlPort.add(lblPort, gbc_lblPort);
		
		txtPort = new JTextField();
		txtPort.setText("502");
		txtPort.setColumns(5);
		GridBagConstraints gbc_txtPort = new GridBagConstraints();
		gbc_txtPort.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPort.gridx = 0;
		gbc_txtPort.gridy = 1;
		pnlPort.add(txtPort, gbc_txtPort);
		
		JPanel pnlRequestSettings = new JPanel();
		FlowLayout fl_pnlRequestSettings = (FlowLayout) pnlRequestSettings.getLayout();
		fl_pnlRequestSettings.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_pnlRequestSettings = new GridBagConstraints();
		gbc_pnlRequestSettings.anchor = GridBagConstraints.EAST;
		gbc_pnlRequestSettings.fill = GridBagConstraints.BOTH;
		gbc_pnlRequestSettings.insets = new Insets(0, 0, 5, 0);
		gbc_pnlRequestSettings.gridx = 1;
		gbc_pnlRequestSettings.gridy = 0;
		pnlTCP.add(pnlRequestSettings, gbc_pnlRequestSettings);
		pnlRequestSettings.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Request Range", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel pnlNode = new JPanel();
		pnlRequestSettings.add(pnlNode);
		GridBagLayout gbl_pnlNode = new GridBagLayout();
		gbl_pnlNode.columnWidths = new int[]{86, 0};
		gbl_pnlNode.rowHeights = new int[]{20, 0, 0};
		gbl_pnlNode.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlNode.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlNode.setLayout(gbl_pnlNode);
		
		JLabel lblNode = new JLabel("Node:");
		GridBagConstraints gbc_lblNode = new GridBagConstraints();
		gbc_lblNode.anchor = GridBagConstraints.WEST;
		gbc_lblNode.insets = new Insets(0, 0, 5, 0);
		gbc_lblNode.gridx = 0;
		gbc_lblNode.gridy = 0;
		pnlNode.add(lblNode, gbc_lblNode);
		
		txtNode = new JTextField();
		txtNode.setText("1");
		txtNode.setColumns(10);
		GridBagConstraints gbc_txtNode = new GridBagConstraints();
		gbc_txtNode.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtNode.gridx = 0;
		gbc_txtNode.gridy = 1;
		pnlNode.add(txtNode, gbc_txtNode);
		
		JPanel pnlOffset = new JPanel();
		pnlRequestSettings.add(pnlOffset);
		GridBagLayout gbl_pnlOffset = new GridBagLayout();
		gbl_pnlOffset.columnWidths = new int[]{86, 0};
		gbl_pnlOffset.rowHeights = new int[]{20, 0, 0};
		gbl_pnlOffset.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlOffset.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlOffset.setLayout(gbl_pnlOffset);
		
		JLabel lblOffset = new JLabel("Offset:");
		GridBagConstraints gbc_lblOffset = new GridBagConstraints();
		gbc_lblOffset.anchor = GridBagConstraints.WEST;
		gbc_lblOffset.insets = new Insets(0, 0, 5, 0);
		gbc_lblOffset.gridx = 0;
		gbc_lblOffset.gridy = 0;
		pnlOffset.add(lblOffset, gbc_lblOffset);
		
		txtOffset = new JTextField();
		txtOffset.setText("1");
		txtOffset.setColumns(10);
		GridBagConstraints gbc_txtOffset = new GridBagConstraints();
		gbc_txtOffset.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtOffset.gridx = 0;
		gbc_txtOffset.gridy = 1;
		pnlOffset.add(txtOffset, gbc_txtOffset);
		
		JPanel pnlLength = new JPanel();
		pnlRequestSettings.add(pnlLength);
		GridBagLayout gbl_pnlLength = new GridBagLayout();
		gbl_pnlLength.columnWidths = new int[]{86, 0};
		gbl_pnlLength.rowHeights = new int[]{20, 0, 0};
		gbl_pnlLength.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlLength.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlLength.setLayout(gbl_pnlLength);
		
		JLabel lblLength = new JLabel("Length:");
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.anchor = GridBagConstraints.WEST;
		gbc_lblLength.insets = new Insets(0, 0, 5, 0);
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 0;
		pnlLength.add(lblLength, gbc_lblLength);
		
		txtLength = new JTextField();
		txtLength.setText("9999");
		txtLength.setColumns(10);
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtLength.gridx = 0;
		gbc_txtLength.gridy = 1;
		pnlLength.add(txtLength, gbc_txtLength);
		
		JPanel pnlSendRequest = new JPanel();
		GridBagConstraints gbc_pnlSendRequest = new GridBagConstraints();
		gbc_pnlSendRequest.gridwidth = 2;
		gbc_pnlSendRequest.fill = GridBagConstraints.BOTH;
		gbc_pnlSendRequest.gridx = 0;
		gbc_pnlSendRequest.gridy = 1;
		pnlTCP.add(pnlSendRequest, gbc_pnlSendRequest);
		
		JButton btnSendRequest = new JButton("Send request");
		btnSendRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Configure the IP settings.
				ConfigureIpParameters ipParameters = new ConfigureIpParameters(txtHost.getText(), Integer.parseInt(txtPort.getText()));
				RetrieveDescriptions retrieveDescriptions = new RetrieveDescriptions();

				// Make a list to store the results
				ArrayList<DescriptionModel> descriptionList= new ArrayList<>();

				// Attempt to get the descriptions.
				try {
					descriptionList = retrieveDescriptions.getDescriptions(
							ipParameters.getIpParameters(), 
							Integer.parseInt(txtNode.getText()), 
							Integer.parseInt(txtOffset.getText()), 
							Integer.parseInt(txtLength.getText()));
					
					if (descriptionList.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Failed to retrieve data, check request range", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Failed to establish connection, check IP Settings", "Error", JOptionPane.ERROR_MESSAGE);
				}


				// Get JTable model ask if table should be cleared.
				DefaultTableModel tableModel = (DefaultTableModel) tblDescription.getModel();
				// TODO: Popup asking if table should be cleared before new import.
				tableModel.setRowCount(0);
				
				
				// Send to table.
				for (DescriptionModel description : descriptionList) {
					tableModel.addRow(description.getAsObjectArray());
				}
				
				// Update the table.
				tableModel.fireTableDataChanged();
			}
		});
		pnlSendRequest.add(btnSendRequest);
		
		JPanel pnlSerial = new JPanel();
		pnlTabbedSettings.addTab("Serial", null, pnlSerial, null);
		
		JPanel pnlNavButtons = new JPanel();
		GridBagConstraints gbc_pnlNavButtons = new GridBagConstraints();
		gbc_pnlNavButtons.anchor = GridBagConstraints.WEST;
		gbc_pnlNavButtons.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNavButtons.fill = GridBagConstraints.VERTICAL;
		gbc_pnlNavButtons.gridx = 0;
		gbc_pnlNavButtons.gridy = 1;
		frmModbusDecriptionClient.getContentPane().add(pnlNavButtons, gbc_pnlNavButtons);
		
		JButton btnNewRow = new JButton("New row");
		btnNewRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Skapa ny tom rad i Jtable
				DefaultTableModel dtm = (DefaultTableModel) tblDescription.getModel();
				String[] row = new String[dtm.getColumnCount()];
				dtm.addRow(row);
				
			}
		});
		pnlNavButtons.add(btnNewRow);
		
		JButton btnTaBortRader = new JButton("Remove row(s)");
		btnTaBortRader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Remove all selected rows. In reverse not to change index of those below.
				DefaultTableModel dtm = (DefaultTableModel) tblDescription.getModel();
				for (int i = tblDescription.getSelectedRows().length -1; i>=0; i--) {
					dtm.removeRow(tblDescription.getSelectedRows()[i]);
				}
				
			}
		});
		pnlNavButtons.add(btnTaBortRader);
		
		JButton btnSelectAll = new JButton("Select all");
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tblDescription.selectAll();
				
			}
		});
		pnlNavButtons.add(btnSelectAll);
		
		JButton btnClearTable = new JButton("Clear table");
		btnClearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dtm = (DefaultTableModel) tblDescription.getModel();
				dtm.setRowCount(0);
				
			}
		});
		pnlNavButtons.add(btnClearTable);
		
		JScrollPane pnlTableScroll = new JScrollPane();
		GridBagConstraints gbc_pnlTableScroll = new GridBagConstraints();
		gbc_pnlTableScroll.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTableScroll.fill = GridBagConstraints.BOTH;
		gbc_pnlTableScroll.gridx = 0;
		gbc_pnlTableScroll.gridy = 2;
		frmModbusDecriptionClient.getContentPane().add(pnlTableScroll, gbc_pnlTableScroll);
		
		tblDescription = new JTable();
		tblDescription.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Function code", "Address", "Unit", "Format", "Scaling", "Tag-name", "Description", "Min.value", "Max.value", "Default value"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, Float.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblDescription.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblDescription.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblDescription.getColumnModel().getColumn(2).setPreferredWidth(30);
		tblDescription.getColumnModel().getColumn(3).setPreferredWidth(45);
		tblDescription.getColumnModel().getColumn(4).setPreferredWidth(45);
		tblDescription.getColumnModel().getColumn(7).setPreferredWidth(60);
		tblDescription.getColumnModel().getColumn(8).setPreferredWidth(60);
		tblDescription.setFillsViewportHeight(true);
		pnlTableScroll.setViewportView(tblDescription);
		
		JPanel pnlExport = new JPanel();
		pnlExport.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlExport = new GridBagConstraints();
		gbc_pnlExport.fill = GridBagConstraints.BOTH;
		gbc_pnlExport.gridx = 0;
		gbc_pnlExport.gridy = 3;
		frmModbusDecriptionClient.getContentPane().add(pnlExport, gbc_pnlExport);
		
		JPanel pnlFileName = new JPanel();
		pnlExport.add(pnlFileName);
		GridBagLayout gbl_pnlFileName = new GridBagLayout();
		gbl_pnlFileName.columnWidths = new int[]{120, 0};
		gbl_pnlFileName.rowHeights = new int[]{20, 20, 0};
		gbl_pnlFileName.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlFileName.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlFileName.setLayout(gbl_pnlFileName);
		
		JLabel lblFilename = new JLabel("Filename:");
		GridBagConstraints gbc_lblFilename = new GridBagConstraints();
		gbc_lblFilename.anchor = GridBagConstraints.WEST;
		gbc_lblFilename.insets = new Insets(0, 0, 5, 0);
		gbc_lblFilename.gridx = 0;
		gbc_lblFilename.gridy = 0;
		pnlFileName.add(lblFilename, gbc_lblFilename);
		
		txtFileName = new JTextField();
		txtFileName.setColumns(20);
		GridBagConstraints gbc_txtFileName = new GridBagConstraints();
		gbc_txtFileName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtFileName.gridx = 0;
		gbc_txtFileName.gridy = 1;
		pnlFileName.add(txtFileName, gbc_txtFileName);
		
		JPanel pnlFileType = new JPanel();
		pnlExport.add(pnlFileType);
		GridBagLayout gbl_pnlFileType = new GridBagLayout();
		gbl_pnlFileType.columnWidths = new int[] {192};
		gbl_pnlFileType.rowHeights = new int[] {20, 20};
		gbl_pnlFileType.columnWeights = new double[]{0.0};
		gbl_pnlFileType.rowWeights = new double[]{0.0, 0.0};
		pnlFileType.setLayout(gbl_pnlFileType);
		
		JComboBox cmbExportAs = new JComboBox();
		GridBagConstraints gbc_cmbExportAs = new GridBagConstraints();
		gbc_cmbExportAs.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbExportAs.insets = new Insets(0, 0, 0, 5);
		gbc_cmbExportAs.gridx = 0;
		gbc_cmbExportAs.gridy = 1;
		pnlFileType.add(cmbExportAs, gbc_cmbExportAs);
		cmbExportAs.setModel(new DefaultComboBoxModel(FileType.values()));
		
		JLabel lblFileType = new JLabel("File type:");
		GridBagConstraints gbc_lblFileType = new GridBagConstraints();
		gbc_lblFileType.anchor = GridBagConstraints.WEST;
		gbc_lblFileType.gridx = 0;
		gbc_lblFileType.gridy = 0;
		pnlFileType.add(lblFileType, gbc_lblFileType);
		
		JPanel pnlExportRow = new JPanel();
		pnlExport.add(pnlExportRow);
		GridBagLayout gbl_pnlExportRow = new GridBagLayout();
		gbl_pnlExportRow.columnWidths = new int[]{95, 0};
		gbl_pnlExportRow.rowHeights = new int[] {0, 20};
		gbl_pnlExportRow.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlExportRow.rowWeights = new double[]{0.0, 0.0};
		pnlExportRow.setLayout(gbl_pnlExportRow);
		
		JLabel lblExport = new JLabel(" ");
		GridBagConstraints gbc_lblExport = new GridBagConstraints();
		gbc_lblExport.insets = new Insets(0, 0, 5, 0);
		gbc_lblExport.gridx = 0;
		gbc_lblExport.gridy = 0;
		pnlExportRow.add(lblExport, gbc_lblExport);
		
		JButton btnExport = new JButton("Export to file");
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 1;
		pnlExportRow.add(btnExport, gbc_btnExport);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get the current table model, instantiate required classes
				DefaultTableModel dtm = (DefaultTableModel) tblDescription.getModel();
				ArrayList<DescriptionModel> descList = new ArrayList<>(); 
				ConvertDescriptionModel convDescMod = new ConvertDescriptionModel();
				
				// Convert and save all rows as DescriptionModel
				for (Object row : dtm.getDataVector()) {
					descList.add(convDescMod.createDescriptionModel((Vector) row));
				}
				
				
				// Get exporter and save to file.
				ExportToFile exporter = ExportFactory.getExporter((FileType) cmbExportAs.getSelectedItem());
				try {
					WriteStatus status = exporter.writeToFile(txtFileName.getText(), descList);
					JOptionPane.showMessageDialog(null, status.getLinesWritten() + " rows successfully written to filename " + status.getFileName(), "Process complete", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Failed to read data " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
