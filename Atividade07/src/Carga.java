import java.util.Objects;

public final class Carga extends Veiculo implements Calcular {
	private int cargaMax;
	private int tara;

	public Carga() {
		
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	@Override
	public final String calcular() {
	    int somaAtributosNumericos = getQtdeRodas() + getMotor().getPotencia() + getMotor().getQtdpist() + getCargaMax() + getTara();
	    return "Soma dos valores em atributos numéricos: " + somaAtributosNumericos;
	}

	@Override
	public final float calcVel(float velocMax) {
		return velocMax * 100000;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carga other = (Carga) obj;
        return Objects.equals(getPlaca(), other.getPlaca());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaca());
    }
}
