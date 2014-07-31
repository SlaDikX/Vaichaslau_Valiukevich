package by.epam.training.entity;

public enum CoffeeState {
	// state of coffee with its density
	BEAN(30), MILLED(40), INSTANTE(20);

	private int density;

	private CoffeeState(int density) {
		this.setDensity(density);
	}

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}

}