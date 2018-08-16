package gui;

import java.awt.Color;

public class circulo {

	private int x = -1;
	private int y = -1;
	private String nombre;
	private Color color;
	
	public circulo(int x, int y, String nombre, Color c) {
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		color = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
