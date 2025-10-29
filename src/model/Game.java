package model;

import java.util.Objects;

public class Game {
	
	public int ranking;
	private String nombre;
	private enum Plataforma{PC,PS,XB,NI};
	private int anio;
	private enum Genero{ACCION, PUZZLE, SPORTS};
	private String editor;
	private double NA_Sales, EU_Sales, JP_Sales, Other_Sales, Global_sales;
	
	public Game() {}
	
	public Game(String nombre) {
		this.nombre = nombre;
	}
	
	public Game(int ranking, String nombre, int anio, String editor, double nA_Sales, double eU_Sales, double jP_Sales,
			double other_Sales, double global_sales) {
		super();
		this.ranking = ranking;
		this.nombre = nombre;
		this.anio = anio;
		this.editor = editor;
		NA_Sales = nA_Sales;
		EU_Sales = eU_Sales;
		JP_Sales = jP_Sales;
		Other_Sales = other_Sales;
		Global_sales = global_sales;
		
	}
	
	
	
	
	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public double getNA_Sales() {
		return NA_Sales;
	}
	public void setNA_Sales(double nA_Sales) {
		NA_Sales = nA_Sales;
	}
	public double getEU_Sales() {
		return EU_Sales;
	}
	public void setEU_Sales(double eU_Sales) {
		EU_Sales = eU_Sales;
	}
	public double getJP_Sales() {
		return JP_Sales;
	}
	public void setJP_Sales(double jP_Sales) {
		JP_Sales = jP_Sales;
	}
	public double getOther_Sales() {
		return Other_Sales;
	}
	public void setOther_Sales(double other_Sales) {
		Other_Sales = other_Sales;
	}
	public double getGlobal_sales() {
		return Global_sales;
	}
	public void setGlobal_sales(double global_sales) {
		Global_sales = global_sales;
	}

	@Override
	public String toString() {
		return "Game [ranking=" + ranking + ", nombre=" + nombre + ", anio=" + anio + ", editor=" + editor
				+ ", NA_Sales=" + NA_Sales + ", EU_Sales=" + EU_Sales + ", JP_Sales=" + JP_Sales + ", Other_Sales="
				+ Other_Sales + ", Global_sales=" + Global_sales + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(EU_Sales, Global_sales, JP_Sales, NA_Sales, Other_Sales, anio, editor, nombre, ranking);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Double.doubleToLongBits(EU_Sales) == Double.doubleToLongBits(other.EU_Sales)
				&& Double.doubleToLongBits(Global_sales) == Double.doubleToLongBits(other.Global_sales)
				&& Double.doubleToLongBits(JP_Sales) == Double.doubleToLongBits(other.JP_Sales)
				&& Double.doubleToLongBits(NA_Sales) == Double.doubleToLongBits(other.NA_Sales)
				&& Double.doubleToLongBits(Other_Sales) == Double.doubleToLongBits(other.Other_Sales)
				&& anio == other.anio && Objects.equals(editor, other.editor) && Objects.equals(nombre, other.nombre)
				&& ranking == other.ranking;
	}
	
	
	
	
	
}
