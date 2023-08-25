public class LinhasDeMontagem {
    private int e1, e2;
    private int a1[], a2[];
    private int numeroEstacoes;
    private int t1[], t2[];
    private int x1, x2;


    private int line[][];
    private int tempoResposta[][];

    private int tempoRespostaFinal;
    private int linhaRespostaFinal;

    private boolean ehProgramacaoDinam;

    static int min(int v1, int v2) {
        return (v1 < v2) ? v1 : v2;
    }

    LinhasDeMontagem(int e1, int e2, int a1[], int a2[], int t1[], int t2[], int x1, int x2, int numeroEstacoes) {
        this.e1 = e1;
        this.e2 = e2;
        this.x1 = x1;
        this.x2 = x2;
        this.numeroEstacoes = numeroEstacoes;

        this.a1 = new int[this.numeroEstacoes + 1]; // sem indice nulo
        this.a2 = new int[this.numeroEstacoes + 1]; // sem indice nulo

        this.t1 = new int[this.numeroEstacoes]; // sem indice nulo
        this.t2 = new int[this.numeroEstacoes]; // sem indice nulo

        for(int i = 1; i < this.numeroEstacoes; i++) {
            this.a1[i] = a1[i];
            this.a2[i] = a2[i];

            this.t1[i] = t1[i];
            this.t2[i] = t2[i];
        }

        this.a1[this.numeroEstacoes] = a1[this.numeroEstacoes];
        this.a2[this.numeroEstacoes] = a2[this.numeroEstacoes];

        this.line = new int[2][this.numeroEstacoes + 1];

        this.tempoResposta = new int[2][this.numeroEstacoes +1];
    }


    void solucaoProgramacaoDinamica() {
        this.tempoResposta[0][1] = this.e1 + this.a1[1];
        this.tempoResposta[1][1] = this.e2 + this.a2[1];

        for(int i = 2; i < this.numeroEstacoes + 1; i++) {
            int firstPath = this.tempoResposta[0][i-1] + this.a1[i];
            int secondPath = this.tempoResposta[1][i-1] + this.a1[i] + this.t2[i-1];

            if(this.t2[i-1] == Integer.MAX_VALUE)
                secondPath = firstPath + 1;

            if(firstPath <= secondPath) {
                this.tempoResposta[0][i] = firstPath;
                this.line[0][i] = 1;
            }
            else {
                this.tempoResposta[0][i] = secondPath;
                this.line[0][i] = 2;
            }

            firstPath = this.tempoResposta[1][i-1] + this.a2[i];
            secondPath = this.tempoResposta[0][i-1] + this.t1[i-1] + this.a2[i];

            if(this.t1[i-1] == Integer.MAX_VALUE)
                secondPath = firstPath + 1;

            if(firstPath <= secondPath) {
                this.tempoResposta[1][i] = firstPath;
                this.line[1][i] = 2;
            }
            else {
                this.tempoResposta[1][i] = secondPath;
                this.line[1][i] = 1;
            }
        }

        

        int resposta1 = this.tempoResposta[0][this.numeroEstacoes] + this.x1;
        int resposta2 = this.tempoResposta[1][this.numeroEstacoes] + this.x2;

        if(resposta1 <= resposta2) {
            this.tempoRespostaFinal = resposta1;
            this.linhaRespostaFinal = 1;
        }
        else {
            this.tempoRespostaFinal = resposta2;
            this.linhaRespostaFinal = 2;
        }

        this.ehProgramacaoDinam = true;
    }

    public void solucaoAlgoritmoGuloso() {
        this.tempoResposta[0][1] = this.e1 + this.a1[1];
        this.tempoResposta[1][1] = this.e2 + this.a2[1];

        int menorCaminho = (tempoResposta[0][1] <= tempoResposta[1][1]) ? 0 : 1;

        this.line[menorCaminho][1] = menorCaminho + 1;

        for(int i = 2; i < this.numeroEstacoes + 1; i++) {
            if(menorCaminho == 0) {
                if(this.a1[i] <= this.a2[i] + this.t1[i-1] || this.t1[i-1] == Integer.MAX_VALUE) {
                    this.tempoResposta[menorCaminho][i] = this.a1[i] + this.tempoResposta[menorCaminho][i-1];
                    menorCaminho = 0;
                    this.line[menorCaminho][i] = 1;
                }
                else {
                    this.tempoResposta[1][i] = this.a2[i] + this.tempoResposta[menorCaminho][i-1] + this.t1[i-1];
                    menorCaminho = 1;
                    this.line[1][i] = 2;
                }
            }
            else {
                if(this.a2[i] <= this.a1[i] + this.t2[i-1] || this.t2[i-1] == Integer.MAX_VALUE) {
                    this.tempoResposta[menorCaminho][i] = this.a2[i] + this.tempoResposta[menorCaminho][i-1];
                    menorCaminho = 1;
                    this.line[menorCaminho][i] = 2;
                }
                else {
                    this.tempoResposta[0][i] = this.a1[i] + this.t2[i-1] + this.tempoResposta[menorCaminho][i-1];
                    menorCaminho = 0;
                    this.line[0][i] = 1;
                }
            }
        }

        if(this.tempoResposta[0][this.numeroEstacoes] == 0) {
            this.tempoRespostaFinal = this.tempoResposta[1][this.numeroEstacoes] + this.x2;
            this.linhaRespostaFinal = 2;
        }
        else if(this.tempoResposta[1][this.numeroEstacoes] == 0){
            this.tempoRespostaFinal = this.tempoResposta[0][this.numeroEstacoes] + this.x1;
            this.linhaRespostaFinal = 1;
        }

        this.ehProgramacaoDinam = false;
    }

    public void reset() {
        for(int i = 0; i < this.numeroEstacoes + 1; i++) {
            this.tempoResposta[0][i] = 0;
            this.tempoResposta[1][i] = 0;

            this.line[0][i] = 0;
            this.line[1][i] = 0;
        }

        this.tempoRespostaFinal = 0;
        this.linhaRespostaFinal = 0;
    }

    public int getTempoRespostaFinal() {
        return this.tempoRespostaFinal;
    }

    public int getLinhaRespostaFinal() {
        return this.linhaRespostaFinal;
    }

    @Override
    public String toString() {
        int temp[] = new int[this.numeroEstacoes + 1];
        int temporario = linhaRespostaFinal;

        String s = "O tempo minimo para esse caso eh: " + Integer.toString(this.getTempoRespostaFinal()) + "\n\n";
        s += "O caminho eh: \n";

        if(this.ehProgramacaoDinam){
            for(int i = 1; i < this.numeroEstacoes + 1; i++) {
                if(temporario == 1) {
                    temp[this.numeroEstacoes -i + 1] = 1;
                    temporario = this.line[0][this.numeroEstacoes -i + 1];// this.line1[this.numeroEstacoes -i + 1];
                }
                else {
                    temp[this.numeroEstacoes -i + 1] = 2;
                    temporario = this.line[1][this.numeroEstacoes - i + 1]; //this.line2[this.numeroEstacoes -i + 1];
                }
            }

            for(int i = 1; i < this.numeroEstacoes + 1; i++) {
                s += "Vai para a estacao " + Integer.toString(i) + " pela linha " + Integer.toString(temp[i]) + "\n";
            }
        }
        else {
            for(int i = 1; i < this.numeroEstacoes + 1; i++) {
                if(this.line[0][i] == 1) 
                    s += "Vai para a estacao " + Integer.toString(i) + " pela linha 1\n";
                else
                    s += "Vai para a estacao " + Integer.toString(i) + " pela linha 2\n";
            }
        }

        s += "E chega na saida pela linha " + Integer.toString(linhaRespostaFinal) + "\n";

        return s;
    }

    String printLinha1() {
        String s = "";

        for(int v : this.line[0]) {
            s += Integer.toString(v) + " ";
        }
        s += "\n";

        return s;
    }

    String printLinha2() {
        String s = "";

        for(int v : this.line[1]) {
            s += Integer.toString(v) + " ";
        }

        s += "\n";

        return s;
    }
}
