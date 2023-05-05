public class Usuario {
    public static void main(String[] args) throws Exception {
        
        SmartTv smartTv = new SmartTv();
        

        System.out.println("TV Ligada? " + smartTv.ligada);
        System.out.println("Qual canal? " + smartTv.canal);
        System.out.println("Qual Volume? " + smartTv.volume);

        smartTv.ligar();
            System.out.println("TV Ligada? " + smartTv.ligada);

        smartTv.desligar();
            System.out.println("TV Ligada? " + smartTv.ligada);

        smartTv.aumentarVolume();
            System.out.println("Qual Volume aumentado? " + smartTv.volume);

        smartTv.diminuirVolume();
            System.out.println("Qual Volume diminuido? " + smartTv.volume);

        smartTv.aumentarCanal();
            System.out.println("Qual o novo canal aumentado? " + smartTv.canal);
        
        smartTv.diminuirCanal();
            System.out.println("Qual o novo canal diminuido? " + smartTv.canal);

        
        smartTv.trocarCanal(7);
            System.out.println("Qual o novo canal? " + smartTv.canal);

    }
    
}
