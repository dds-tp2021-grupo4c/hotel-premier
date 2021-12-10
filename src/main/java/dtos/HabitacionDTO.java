package dtos;

import java.util.ArrayList;
import java.util.List;

public class HabitacionDTO {
	private int idHabitacion;
	private int numeroHabitacion;
	private String tipoHabitacion;
	private List<String> estados = new ArrayList<String>();

	public int getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public List<String> getEstados() {
		return estados;
	}
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public void addEstado(String estado) {
		this.estados.add(estado);
	}
}
