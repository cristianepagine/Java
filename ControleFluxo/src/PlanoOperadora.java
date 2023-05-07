public class PlanoOperadora {
    public static void main(String[] args) {
		String plano = "M"; // M / T

		switch (plano) {
			case "T": {
				System.out.println("100 minutos de ligação, WhatsApp, Instagram grátis e 5Gb Youtube");
                break;
			}
			case "M": {
				System.out.println("100 minutos de ligação, WhatsApp e Instagram grátis");
                break;
			}
			case "B": {
				System.out.println("100 minutos de ligação");
                break;
			}
		}
	}
}
