/*//////////////////////////////////////////////////////////////////
//
// Autor: Luiz Fernando Galati                                                    
//                                                               
//////////////////////////////////////////////////////////////////*/


import java.awt.Color;

public class Distribution {

    
    /* Recebe um inteiro N, um inteiro M, um inteiro L e uma matriz
    bidimensional freq. Simula o passeio de M Random Walkers pelo 
    grid de tamanho 2L. Cada um deles dá N passos.
       Preenche a matriz de modo que o valor de freq[i][j] seja o
    número de vezes em que o ponto (i - L, j - L) do grid foi
    visitado.                                                     */
    
    public static void frequencias (int N, int M, int L, int[][] freq)
    {
        int i, j, k, l;
        RandomWalker walker;
        
        for (k = 0; k < M; k++) {
            walker = new RandomWalker ();
            for (l = 0; l < N; l++) {
                walker.step ();
                if (walker.rx >= -L && walker.rx <= L && walker.ry >= -L && walker.ry <= L) {
                    i = walker.rx + L;
                    j = walker.ry + L;
                    freq[i][j]++;
                }
            }
        }
    }
    
    
    /* Recebe um inteiro N, um inteiro M, um inteiro L e uma matriz
    bidimensional freq. Desenha um quadrado de lado 1 centrado em
    cada ponto (x, y)  do grid de tamanho 2L, sendo x e y numeros 
    inteiros.
       Aos pontos (x, y) mais visitados correspondem quadrados
    vermelhos, enquanto aos pontos menos visitados correspondem 
    quadrados azuis.                                             */       
    
    public static void desenha (int N, int M, int L, int[][] freq) 
    {            
        int r, g, b, r1, b1, i, j, fatual;
        Color c;
        
        r = g = 0;
        b = 255;
    
        for (i = 0; i <= 2*L; i++) {
            for (j = 0; j <= 2*L; j++) {
                fatual = freq[i][j];
                if (fatual <= 255) {
                    r1 = r + fatual;
                    b1 = b - fatual;
                }
                else {
                    r1 = 255;
                    b1 = 0;
                }
                c = new Color (r1, g, b1);
                StdDraw.setPenColor (c);
                StdDraw.filledSquare (i - L, j - L, 0.5);
            }
        }   
    }
    
    
    /* Função principal da classe. Recebe, via linha de comando, um
    inteiro N (que representa a quantidade de passos a serem dados
    por cada Random Walker), um inteiro M (que representa a 
    quantidade de Random Walkers a serem simulados), e um inteiro L
    (que representa a metade do tamanho de um grid).              */

    public static void main (String[] args)
    {
        int N, M, L;
        int[][] freq;
        Color c;        
        
        N = Integer.parseInt (args[0]);
        M = Integer.parseInt (args[1]);
        L = Integer.parseInt (args[2]);
        freq = new int[2*L+1][2*L+1];
        
        StdDraw.setXscale (-L, L);
        StdDraw.setYscale (-L, L);        
        frequencias (N, M, L, freq);
        desenha (N, M, L, freq);        
    }
}
