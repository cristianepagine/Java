import java.util.Objects;

public final class Passeio extends Veiculo implements Calcular {
	private int qtdPassageiros;

	public Passeio() {
		
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	
	@Override
	public final String calcular() {
        int totalCaracteres = 0;
        totalCaracteres += getPlaca().length();
        totalCaracteres += getMarca().length();
        totalCaracteres += getCor().length();
        totalCaracteres += getModelo().length();

        return "\nSoma de caracteres em atributos de String: " + totalCaracteres;
    }

	@Override
	public final	float calcVel(float velocMax) {
		return velocMax * 1000;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Passeio other = (Passeio) obj;
	        return Objects.equals(getPlaca(), other.getPlaca());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getPlaca());
	    }

}
