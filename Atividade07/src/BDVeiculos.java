import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BDVeiculos {
    // Listas para armazenar veículos de passeio e carga
    private List<Passeio> veiculosPasseio = new ArrayList<Passeio>();
    private List<Carga> veiculosCarga = new ArrayList<Carga>();

    // Construtor da classe BDVeiculos
	public BDVeiculos() {
		super();
	}

	public List<Passeio> getVeiculosPasseios() {
		return veiculosPasseio;
	}

	public void setVeiculosPasseios(List<Passeio> veiculosPasseios) {
		this.veiculosPasseio = veiculosPasseios;
	}

	public List<Carga> getVeiculosCargas() {
		return veiculosCarga;
	}

	public void setVeiculosCargas(List<Carga> veiculosCargas) {
		this.veiculosCarga = veiculosCargas;
	}

    // Método para cadastrar veículos de passeio
	public void cadastrarVeiculosPasseio() {
        // Loop para permitir o cadastro de vários veículos de passeio
		do {
				Passeio veiculoPasseio = new Passeio();

				System.out.println("<<<Cadastro de veículos de passeio>>>");
				String placa = Leitura.entDados("Informe a placa do veículo: ");

				// Verifica se a placa já está cadastrada
				if (placaJaCadastrada(veiculosPasseio, veiculosCarga, placa)) {
					try {
						throw new VeicExistException("Já existe um veículo cadastrado com a mesma placa.");
					} catch (VeicExistException e) {
						System.out.println(e.getMessage());
					}
					return;
				}

				veiculoPasseio.setPlaca(placa);
				veiculoPasseio.setMarca(Leitura.entDados("Informe a marca do veiculo: "));
				veiculoPasseio.setModelo(Leitura.entDados("Informe o modelo do veiculo: "));
				veiculoPasseio.setCor(Leitura.entDados("Informe a cor do veiculo: "));
				float velocMax = Float.parseFloat(Leitura.entDados("Informe a Velocidade Máxima do veiculo: "));

				try {
					// Verifica se a velocidade máxima está dentro dos limites brasileiros (80 a 110
					// km/h)
					if (velocMax < 80 || velocMax > 110) {
						throw new VelocException("A velocidade máxima está fora dos limites brasileiros.");
					}

					// Se a velocidade está dentro dos limites, atribua-a ao veículo
					veiculoPasseio.setVelocMax(velocMax);
				} catch (VelocException e) {
					System.out.println(e.getMessage());

					// Se a exceção foi lançada, defina a velocidade para 100 km/h
					veiculoPasseio.setVelocMax(100.0f);
				}
				veiculoPasseio
						.setQtdeRodas(Integer.parseInt(Leitura.entDados("Informe a Quantidade de Rodas do veiculo: ")));
				veiculoPasseio.getMotor()
						.setQtdpist(Integer.parseInt(Leitura.entDados("Informe a Potencia do Motor: ")));
				veiculoPasseio.getMotor()
						.setPotencia(Integer.parseInt(Leitura.entDados("Informe a Quantidade de Pistões do Motor: ")));
				veiculoPasseio.setQtdPassageiros(
						Integer.parseInt(Leitura.entDados("Informe a Quantidade de Passageiros do veiculo: ")));

				// Armazena o objeto Veiculo no array de veículos
                veiculosPasseio.add(veiculoPasseio);

				String resposta = Leitura.entDados("\nDeseja cadastrar mais um veículo do mesmo tipo (Passeio) (S/N)?");
	            // Verificação se deseja cadastrar mais veículos
				if (!resposta.equalsIgnoreCase("S")) {
					break; // Sai do loop se a resposta não for "S"
				}
			
		} while (true); // Loop continuará até que o usuário não queira mais cadastrar
	}

	public void cadastrarVeiculosCarga() {
		do {
				Carga veiculoCarga = new Carga();
				System.out.println("<<<Cadastro de veículos de carga>>>");
				String placa = Leitura.entDados("Informe a placa do veículo: ");

				// Verifica se a placa já está cadastrada
				if (placaJaCadastrada(veiculosPasseio, veiculosCarga, placa)) {
					try {
						throw new VeicExistException("Já existe um veículo cadastrado com a mesma placa.");
					} catch (VeicExistException e) {
						System.out.println(e.getMessage());
					}
					return;

				}
				veiculoCarga.setPlaca(placa);
				veiculoCarga.setMarca(Leitura.entDados("Informe a marca do veiculo: "));
				veiculoCarga.setModelo(Leitura.entDados("Informe o modelo do veiculo: "));
				veiculoCarga.setCor(Leitura.entDados("Informe a cor do veiculo: "));
				float velocMax = Float.parseFloat(Leitura.entDados("Informe a Velocidade Máxima do veiculo: "));

				try {
					// Verifica se a velocidade máxima está dentro dos limites brasileiros (80 a 110
					// km/h)
					if (velocMax < 80 || velocMax > 110) {
						throw new VelocException("A velocidade máxima está fora dos limites brasileiros.");
					}

					// Se a velocidade está dentro dos limites, atribua-a ao veículo
					veiculoCarga.setVelocMax(velocMax);
				} catch (VelocException e) {
					System.out.println(e.getMessage());

					// Se a exceção foi lançada, defina a velocidade para 100 km/h
					veiculoCarga.setVelocMax(90.0f);
				}

				veiculoCarga
						.setQtdeRodas(Integer.parseInt(Leitura.entDados("Informe a Quantidade de Rodas do veiculo: ")));
				veiculoCarga.getMotor().setQtdpist(Integer.parseInt(Leitura.entDados("Informe a Potencia do Motor: ")));
				veiculoCarga.getMotor()
						.setPotencia(Integer.parseInt(Leitura.entDados("Informe a Quantidade de Pistões do Motor: ")));
				veiculoCarga.setCargaMax(Integer.parseInt(Leitura.entDados("Informe a Carga Máxima do veiculo: ")));
				veiculoCarga.setTara(Integer.parseInt(Leitura.entDados("Informe a Tara do Veículo: ")));

				// Armazena o objeto Veiculo no array de veículos
				veiculosCarga.add(veiculoCarga);
				String resposta = Leitura.entDados("\nDeseja cadastrar mais um veículo do mesmo tipo (Carga) (S/N)?");
				if (resposta.equalsIgnoreCase("N")) {
					return;
				}
			
		} while (true); // Loop continuará até que o usuário não queira mais cadastrar
	}

	public List<Passeio> imprimirVeiculosPasseio() {
	    System.out.println("\n===========Veiculos de Passeio===========");
	    
	    for (Passeio passeio : veiculosPasseio) {
	        imprimirDetalhesVeiculoPasseio(passeio);
	    }

	    String resposta = Leitura.entDados("\nDeseja voltar ao Menu Inicial (S/N)? ");
	    if (!resposta.equalsIgnoreCase("S")) {
	        System.out.println("\nSaindo da lista de veículos de passeio...");
	    }

	    return veiculosPasseio; // Retorna a lista de veículos no final.
	}
	
	private void imprimirDetalhesVeiculoPasseio(Passeio passeio) {
	    StringBuilder mensagem = new StringBuilder();
	    mensagem.append("\nPlaca := ").append(passeio.getPlaca())
	            .append("\nMarca := ").append(passeio.getMarca())
	            .append("\nModelo := ").append(passeio.getModelo())
	            .append("\nCor := ").append(passeio.getCor())
	            .append("\nVelocidade Máxima (m/h) := ").append(passeio.calcVel(passeio.getVelocMax()))
	            .append("\nQuantidade de Rodas := ").append(passeio.getQtdeRodas())
	            .append("\nQuantidade de Pistões := ").append(passeio.getMotor().getQtdpist())
	            .append("\nPotência := ").append(passeio.getMotor().getPotencia())
	            .append("\nQuantidade de Passageiros := ").append(passeio.getQtdPassageiros())
	            .append(passeio.calcular())
	            .append("\n");

	    System.out.println(mensagem.toString());
	}
	public List<Carga> imprimirVeiculosCarga() {
	    System.out.println("\n===========Veiculos de Carga===========");
	    
	    for (Carga carga : veiculosCarga) {
	        imprimirDetalhesVeiculoCarga(carga);
	    }

	    String resposta = Leitura.entDados("\nDeseja voltar ao Menu Inicial (S/N)? ");
	    if (!resposta.equalsIgnoreCase("S")) {
	        System.out.println("\nSaindo da lista de veículos de carga...");
	    }

	    return veiculosCarga; // Retorna a lista de veículos no final.
	}
	private void imprimirDetalhesVeiculoCarga(Carga carga) {
		StringBuilder mensagem = new StringBuilder();
	    mensagem.append("\nPlaca := ").append(carga.getPlaca())
	    		.append( "\nMarca := ").append(carga.getMarca())
	    		.append("\nModelo :=").append(carga.getModelo())
	    		.append("\nCor := ").append(carga.getCor())
	    		.append("\nVelocidade Máxima (m/h) := ").append(carga.calcVel(carga.getVelocMax()))
	    		.append("\nQuantidade de Rodas := ").append(carga.getQtdeRodas())
	    		.append("\nQuantidade de Pistões := ").append(carga.getMotor().getQtdpist())
	    		.append("\nPotência := ").append(carga.getMotor().getPotencia())
	    		.append("\nCarga :=").append(carga.getCargaMax())
	    		.append("\nTara :=").append(carga.getTara())
	    		.append(carga.calcular())
	            .append("\n");
	    System.out.println(mensagem.toString());

		}
	
	public void placaParaBusca(String tipoVeiculo) {
        String placaParaBusca = Leitura.entDados("\nInforme a placa do veículo: ");
        boolean veiculoEncontrado = false;

        if (tipoVeiculo.equalsIgnoreCase("Passeio")) {
            for (Passeio passeio : veiculosPasseio) {
                if (passeio != null && placaParaBusca.equals(passeio.getPlaca())) {
                    System.out.println("\nVeículo de passeio cadastrado.");
                    imprimirDetalhesVeiculoPasseio(passeio);
                    veiculoEncontrado = true;
                    break;
                }
            }
        } else if (tipoVeiculo.equalsIgnoreCase("Carga")) {
            for (Carga carga : veiculosCarga) {
                if (carga != null && placaParaBusca.equals(carga.getPlaca())) {
                    System.out.println("\nVeículo de carga cadastrado.");
                    imprimirDetalhesVeiculoCarga(carga);
                    veiculoEncontrado = true;
                    break;
                }
            }
        }

        if (!veiculoEncontrado) {
            try {
                throw new VeicExistException("\nVeículo não cadastrado.");
            } catch (VeicExistException e) {
                System.out.println(e.getMessage());
            }
        }

        String resposta = Leitura.entDados("\nDeseja voltar ao Menu Inicial (S/N)? ");
        if (!resposta.equalsIgnoreCase("S")) {
            System.out.println("\nSaindo da busca de veículos...\n");
        }
    }

	public static boolean placaJaCadastrada(List<Passeio> veiculosPasseios, List<Carga> veiculosCarga, String placa) {
		Passeio veiculoPasseioProcurado = new Passeio();
	    veiculoPasseioProcurado.setPlaca(placa);

	    Carga veiculoCargaProcurado = new Carga();
	    veiculoCargaProcurado.setPlaca(placa);

	    return veiculosPasseios.contains(veiculoPasseioProcurado) || veiculosCarga.contains(veiculoCargaProcurado);
	}

		

	public void excluirVeiculoPasseio() {
        String placaParaExcluir = Leitura.entDados("\nInforme a placa do veículo de passeio a ser excluído: ");
        boolean veiculoEncontrado = false;

        for (int i = 0; i < veiculosPasseio.size(); i++) {
            Passeio passeio = veiculosPasseio.get(i);
            if (passeio != null && placaParaExcluir.equals(passeio.getPlaca())) {
                veiculosPasseio.remove(i);
                System.out.println("\nVeículo de passeio removido com sucesso.");
                veiculoEncontrado = true;
                break;
            }
        }

        if (!veiculoEncontrado) {
            System.out.println("\nVeículo de passeio não encontrado.");
        }

        String resposta = Leitura.entDados("\nDeseja voltar ao Menu Inicial (S/N)? ");
        if (!resposta.equalsIgnoreCase("S")) {
            System.out.println("\nSaindo da exclusão de veículos de passeio...\n");
        }
    }


	public void excluirVeiculoCarga() {
	    String placaParaExcluir = Leitura.entDados("\nInforme a placa do veículo de carga a ser excluído: ");
	    boolean veiculoEncontrado = false;

	    for (int i = 0; i < veiculosCarga.size(); i++) {
	        Carga carga = veiculosCarga.get(i);
	        if (carga != null && placaParaExcluir.equals(carga.getPlaca())) {
	            veiculosCarga.remove(i);
	            System.out.println("\nVeículo de carga removido com sucesso.");
	            veiculoEncontrado = true;
	            break;
	        }
	    }

	    if (!veiculoEncontrado) {
	        System.out.println("\nVeículo de carga não encontrado.");
	    }

	    String resposta = Leitura.entDados("\nDeseja voltar ao Menu Inicial (S/N)? ");
	    if (!resposta.equalsIgnoreCase("S")) {
	        System.out.println("\nSaindo da exclusão de veículos de carga...\n");
	    }
	}

}
