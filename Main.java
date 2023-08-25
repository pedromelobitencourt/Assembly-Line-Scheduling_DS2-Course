/*

Algoritmos gulosos não dão, necessariamente, a melhor resposta
Eles dão a melhor resposta "local", porém não "global"

*/

public class Main {
    public static void main(String args[]) {

        // Exemplo realizado nos slides

        int e1 = 2, e2 = 4; // Tempo entrada na linha 1 e na linha 2 respectivamente

        int a1[] = {0, 7, 9, 3, 4, 8, 4}; // tempo de processamento das estacoes da linha 1
        int a2[] = {0, 8, 5, 6, 4, 5, 7}; // tempo de processamento das estacoes da linha 2

        int t1[] = {0, 2, 3, 1, 3, 4}; // tempo de transferencia das estacoes da linha 1 para linha 2
        int t2[] = {0, 2, 1, 2, 2, 1}; // tempo de transferencia das estacoes da linha 2 para linha 1

        int x1 = 3; // tempo de saida a partir da linha 1
        int x2 = 2; // tempo de saida a partir da linha 2

        int n = 6; // numero de estacoes


        LinhasDeMontagem linhasDeMontagem = new LinhasDeMontagem(e1, e2, a1, a2, t1, t2, x1, x2, n);
        
        System.out.println("Usando algoritmo guloso");

        linhasDeMontagem.solucaoAlgoritmoGuloso();
        System.out.println(linhasDeMontagem + "\n");

        linhasDeMontagem.reset();

        System.out.println("Usando Programacao Dinamica");

        linhasDeMontagem.solucaoProgramacaoDinamica();
        System.out.println(linhasDeMontagem + "\n");






        // Caso 1
        a1 = new int[12]; a1[1] = 3; a1[2] = 5; a1[3] = 7; a1[4] = 10; a1[5] = 5; a1[6] = 9; a1[7] = 11; a1[8] = 9; a1[9] = 5; a1[10] = 2; a1[11] = 6;
        a2 = new int[12]; a2[1] = 2; a2[2] = 6; a2[3] = 3; a2[4] = 9; a2[5] = 11; a2[6] = 4; a2[7] = 9; a2[8] = 3; a2[9] = 12; a2[10] = 4; a2[11] = 5;

        t1 = new int[11]; t1[1] = 3; t1[2] = 5; t1[3] = 4; t1[4] = 2; t1[5] = 7; t1[6] = 5; t1[7] = 8; t1[8] = 1; t1[9] = Integer.MAX_VALUE; t1[10] = Integer.MAX_VALUE;
        t2 = new int[11]; t2[1] = 5; t2[2] = 3; t2[3] = 7; t2[4] = 5; t2[5] = 6; t2[6] = 2; t2[7] = 5; t2[8] = 2; t2[9] = Integer.MAX_VALUE; t2[10] = Integer.MAX_VALUE;
        n = 11;
    
        linhasDeMontagem = new LinhasDeMontagem(e1, e2, a1, a2, t1, t2, x1, x2, n);
        
        System.out.println("Usando algoritmo guloso no caso 1");

        linhasDeMontagem.solucaoAlgoritmoGuloso();
        System.out.println(linhasDeMontagem + "\n");

        linhasDeMontagem.reset();

        System.out.println("Usando Programacao Dinamica no caso 1");

        linhasDeMontagem.solucaoProgramacaoDinamica();
        System.out.println(linhasDeMontagem + "\n");





        // Caso 2
        //a1[0] = 0; a2[0] = 0; t1[0] = 0; t2[0] = 0

        a1 = new int[11]; a1[1] = 5; a1[2] = 10; a1[3] = 6; a1[4] = 3; a1[5] = 8; a1[6] = 5; a1[7] = 3; a1[8] = 7; a1[9] = 12; a1[10] = 8;
        a2 = new int[11]; a2[1] = 7; a2[2] = 3; a2[3] = 5; a2[4] = 3; a2[5] = 7; a2[6] = 6; a2[7] = 4; a2[8] = 9; a2[9] = 10; a2[10] = 9;

        t1 = new int[10]; t1[1] = 4; t1[2] = 2; t1[3] = 7; t1[4] = 2; t1[5] = 5; t1[6] = 8; t1[7] = 2; t1[8] = Integer.MAX_VALUE; t1[9] = Integer.MAX_VALUE;
        t2 = new int[10]; t2[1] = 6; t2[2] = 1; t2[3] = 7; t2[4] = 3; t2[5] = 6; t2[6] = 4; t2[7] = 5; t2[8] = Integer.MAX_VALUE; t2[9] = Integer.MAX_VALUE;
        n = 10;

        linhasDeMontagem = new LinhasDeMontagem(e1, e2, a1, a2, t1, t2, x1, x2, n);

        System.out.println("Usando o algoritmo guloso no caso 2");

        linhasDeMontagem.solucaoAlgoritmoGuloso();
        System.out.println(linhasDeMontagem + "\n");

        linhasDeMontagem.reset();

        System.out.println("Usando Programacao Dinamica no caso 2");

        linhasDeMontagem.solucaoProgramacaoDinamica();
        System.out.println(linhasDeMontagem + "\n");
    }
}
