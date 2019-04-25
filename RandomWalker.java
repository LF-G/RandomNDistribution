/*/////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati   
//                                                                      
/////////////////////////////////////////////////////////////////*/


public class RandomWalker {

    public int rx, ry;
    
    public RandomWalker ()
    {
        rx = 0;
        ry = 0;
    }
    
    public void step ()
    {
        int r;
        double a;
        
        a = Math.random ();
        r = (int) (a*4 + 1);
        
        if (r == 1)
            rx = rx + 1;
        else if (r == 2)
            ry = ry + 1;
        else if (r == 3)
            rx = rx - 1;
        else
            ry = ry - 1;
    }
    
    
    public double distance ()
    {
        double d, x, y;
        
        x = rx;
        y = ry;        
        d = Math.sqrt (x*x + y*y);
        return d;
    }
    
    
    /* Função principal da classe. Recebe, via linha de comando, um 
    inteiro N que representa a quantidade de passos a serem dados por 
    um random walker. Calcula e imprime a média das distâncias até a
    origem de 100 walkers que deram, cada um, N passos no plano.   */           
    
    public static void main (String[] args)
    {
        int i, j, N;
        double d, soma;
        RandomWalker walker;
        
        walker = new RandomWalker ();
        N = Integer.parseInt (args[0]);        
        soma = 0.0;
        
        for (i = 0; i < 100; i++) {
            for (j = 0; j < N; j++)
                walker.step ();
            d = walker.distance ();
            soma += d;
            walker = new RandomWalker ();
        }
        StdOut.printf ("A media das distancias ate a origem e %f.\n", soma/100);
    }
}
