package interfaces;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;

import dtos.BusquedaHabitacionesDTO;
import dtos.HabitacionDTO;
import gestores.GestorHabitacion;

@SuppressWarnings("serial")
public class EstadoHabitaciones extends JPanel implements TableModelListener{
	@SuppressWarnings("serial")
	class ModeloTablaEstadoHabitaciones extends AbstractTableModel
	{
		private String[] nombreColumnas = {"Día", "Hab. Individual Estándar 1", "Hab. Individual Estándar 2", "Hab. Individual Estándar 3", "Hab. Individual Estándar 4", "Hab. Individual Estándar 5", "Hab. Individual Estándar 6","Hab. Individual Estándar 7","Hab. Individual Estándar 8","Hab. Individual Estándar 9","Hab. Individual Estándar 10",
				"Hab. Doble Estándar 11", "Hab. Doble Estándar 12","Hab. Doble Estándar 13","Hab. Doble Estándar 14","Hab. Doble Estándar 15","Hab. Doble Estándar 16","Hab. Doble Estándar 17","Hab. Doble Estándar 18","Hab. Doble Estándar 19","Hab. Doble Estándar 20","Hab. Doble Estándar 21","Hab. Doble Estándar 22","Hab. Doble Estándar 23","Hab. Doble Estándar 24","Hab. Doble Estándar 25",
				"Hab. Doble Estándar 26","Hab. Doble Estándar 27","Hab. Doble Estándar 28","Hab. Doble Superior 29","Hab. Doble Superior 30","Hab. Doble Superior 31","Hab. Doble Superior 32","Hab. Doble Superior 33","Hab. Doble Superior 34","Hab. Doble Superior 35","Hab. Doble Superior 36",
				"Hab. Superior Family Plan 37","Hab. Superior Family Plan 38","Hab. Superior Family Plan 39","Hab. Superior Family Plan 40","Hab. Superior Family Plan 41","Hab. Superior Family Plan 42","Hab. Superior Family Plan 43","Hab. Superior Family Plan 44","Hab. Superior Family Plan 45","Hab. Superior Family Plan 46",
				"Hab. Suite Doble 47","Hab. Suite Doble 48"};
		private Object[][] datos = { {"", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "",""}};
		
		
		public void setData(Object[][] datos) 			{ this.datos = datos; 					}
		public int getColumnCount() 					{ return nombreColumnas.length; 		}
		public int getRowCount() 						{ return datos.length; 					}
		public String getColumnName(int col) 			{ return nombreColumnas[col]; 			}
		public Object getValueAt(int row, int col) 		{ return datos[row][col]; 				}
		public Class getColumnClass(int c) 				{ return getValueAt(0, c).getClass(); 	}
		public boolean isCellEditable(int row, int col) { return true; 							}
		public void setValueAt(Object value, int row, int col) 	
		{
		    datos[row][col] = value;
		    fireTableCellUpdated(row, col);
		}
	}
	private JFrame ventana;
	private JPanel padre;
	private GestorHabitacion gestorHabitacion = GestorHabitacion.getInstance();
	private GridBagConstraints gbc;
	private JLabel lblFechaDesde, lblFechaHasta;
	private JDateChooser fechaDesde, fechaHasta;
	private JButton btnBuscar,btnLimpiar,btnSiguiente,btnCancelar;
	private JTable tabla;
	private ModeloTablaEstadoHabitaciones modeloTabla;
	private JScrollPane sp;
	Object[][] datos;
	
	public EstadoHabitaciones(JFrame ventana, JPanel padre) {
		this.ventana = ventana;
		this.padre = padre;
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.armarPanel();
	}

	private void armarPanel() {
		lblFechaDesde = new JLabel("Desde fecha (*):");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblFechaDesde, gbc);

		fechaDesde = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaDesde.getJCalendar().setMinSelectableDate(new Date());
		//gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(fechaDesde,gbc);
		//gbc.anchor = GridBagConstraints.CENTER;

		lblFechaHasta = new JLabel("Hasta fecha (*):");
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(lblFechaHasta, gbc);

		fechaHasta = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaHasta.getJCalendar().setMinSelectableDate(new Date());
		//gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(fechaHasta,gbc);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(
				e -> {
					if(fechaDesde.getDate() == null && fechaHasta.getDate() == null) {
						JOptionPane.showMessageDialog(this, "Los siguientes campos son obligatorios: 'Desde fecha' y 'Hasta fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else if(fechaDesde.getDate() == null && fechaHasta.getDate() != null) {
						JOptionPane.showMessageDialog(this,"El siguiente campo es obligatorio: 'Desde fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else if(fechaHasta.getDate() == null && fechaDesde.getDate() != null) {
						JOptionPane.showMessageDialog(this,"El siguiente campo es obligatorio: 'Hasta fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else if(fechaDesde.getDate().compareTo(fechaHasta.getDate()) > 0){
						JOptionPane.showMessageDialog(this,"La fecha 'Desde fecha' no puede ser mayor a la fecha 'Hasta fecha', ingrese nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						LocalDate fecha_desde = fechaDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						LocalDate fecha_hasta = fechaHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						BusquedaHabitacionesDTO dto = new BusquedaHabitacionesDTO(fecha_desde, fecha_hasta);
						List<HabitacionDTO> habitaciones = gestorHabitacion.buscarHabitacionesPorRangoFechas(dto);
						if(habitaciones == null) mostrarMensajeFechasInvalidas(dto);
						else {
							datos =	new Object[(int) ChronoUnit.DAYS.between(fecha_desde,fecha_hasta)+1][50];
							int diferenciaDias = (int) ChronoUnit.DAYS.between(fecha_desde,fecha_hasta);
							for(int i=0;i<diferenciaDias;i++) {
								datos[i][0] = fecha_desde.toString();
								fecha_desde = fecha_desde.plus(1, ChronoUnit.DAYS);
							}
							for(int i=0;i<=diferenciaDias;i++) {
								for(int j=1;j<=49;j++) {
									datos[i][j] = "exe";
								}
							}
						}
					}
				}
		);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnBuscar,gbc);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(
				e -> {
					fechaDesde.setCalendar(null);
					fechaHasta.setCalendar(null);
				}
		);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnLimpiar,gbc);
		
		modeloTabla = new ModeloTablaEstadoHabitaciones();
		tabla = new JTable(modeloTabla);
	    sp = new JScrollPane(tabla);
	    modeloTabla.setData(datos);
	    tabla.setPreferredScrollableViewportSize(new Dimension(600, 200));
	    resizeColumnWidth(tabla);
	    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		//gbc.weightx = 1.0;
		this.add(sp, gbc);

		btnSiguiente = new JButton("Siguiente");
		this.add(btnSiguiente);
		btnSiguiente.addActionListener(
				e -> {
					
				}
		);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnSiguiente,gbc);
		
		btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);
		btnCancelar.addActionListener(
				e -> {
					ventana.setTitle("Menú Principal");
					ventana.setContentPane(padre);
					ventana.pack();
					ventana.setVisible(true);
				}
		);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(btnCancelar,gbc);
	}

	private void mostrarMensajeFechasInvalidas(BusquedaHabitacionesDTO dto) {
		if(dto.getFechaDesde() == null && dto.getFechaHasta() == null) {
			JOptionPane.showMessageDialog(this, "Los siguientes campos son obligatorios: 'Desde fecha' y 'Hasta fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else if(dto.getFechaDesde() == null && dto.getFechaHasta() != null) {
			JOptionPane.showMessageDialog(this,"El siguiente campo es obligatorio: 'Desde fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else if(dto.getFechaDesde() == null && dto.getFechaHasta() != null) {
			JOptionPane.showMessageDialog(this,"El siguiente campo es obligatorio: 'Hasta fecha'", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else 
			JOptionPane.showMessageDialog(this,"La fecha 'Desde fecha' no puede ser mayor a la fecha 'Hasta fecha', ingrese nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	private void resizeColumnWidth(JTable table) {
	    //Se obtiene el modelo de la columna
	    TableColumnModel columnModel = table.getColumnModel();
	    //Se obtiene el total de las columnas
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        //Establecemos un valor minimo para el ancho de la columna
	        int width = 150; //Min Width
	        //Obtenemos el numero de filas de la tabla
	        for (int row = 0; row < table.getRowCount(); row++) {
	            //Obtenemos el renderizador de la tabla
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            //Creamos un objeto para preparar el renderer
	            Component comp = table.prepareRenderer(renderer, row, column);
	            //Establecemos el width segun el valor maximo del ancho de la columna
	            width = Math.max(comp.getPreferredSize().width + 1, width);

	        }
	        //Se establece una condicion para no sobrepasar el valor de 300
	        //Esto es Opcional
	        if (width > 300) {
	            width = 300;
	        }
	        //Se establece el ancho de la columna
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        System.out.println("Nuevo valor: " + data);
	}
}
