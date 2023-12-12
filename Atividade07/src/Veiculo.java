
public abstract class Veiculo {
	String placa = ""; // Atributo literal inicializado com espaço em branco
	String marca = ""; // Atributo literal inicializado com espaço em branco
	String modelo = "";// Atributo literal inicializado com espaço em branco
	String cor = ""; // Atributo literal inicializado com espaço em branco
	Float velocMax = 0.0f; // Atributo numérico inicializado com zero
	int qtdeRodas = 0; // Atributo numérico inicializado com zero
	Motor motor = new Motor(); // Objeto Motor inicializado

	public Veiculo() {
	}

	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public Float getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(Float velocMax) {
		this.velocMax = velocMax;
	}

	public int getQtdeRodas() {
		return qtdeRodas;
	}

	public final void setQtdeRodas(int qtdeRodas) {
		this.qtdeRodas = qtdeRodas;
	}

	public final Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	abstract float calcVel(float velocMax);

}
