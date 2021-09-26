import java.util.Scanner;

public class Impedimento {
    private int numAtacantes;
    private int numDefensores;
    private int[] distancia_Atacantes; public int[] getDistancia_Atacantes() {return distancia_Atacantes;}
    private int[] distancia_Defensores; public int[] getDistancia_Defensores() {return distancia_Defensores;}
    private int ultimo_def; public int getUltimo_def() {return ultimo_def;}
    private Integer penultimo_def;public int getPenultimo_def() {return penultimo_def;}
    private int atacante; public int getAtacante() {return atacante;}

    public boolean setAtacantesDefesores(){
        Scanner in = new Scanner(System.in);
        do {
            int A = in.nextInt();
            if (A >= 2) {
                numAtacantes = A;
                break;
            } else {
                System.out.println("Numero de Atacantes de ser maior ou igual a dois, digite novamente");
            }
        } while (true);
        do {
            int B = in.nextInt();
            if (B<=11 && B > 0) {
                numDefensores = B;
                break;
            } else {
                System.out.println("Numero de Atacantes tem que ser menor ou igual a dois, digite novamente");
            }
        } while (true);
        return true;
    }
    public void setDistancias(){
        Scanner in = new Scanner(System.in);
        distancia_Atacantes = new int[numAtacantes];
        distancia_Defensores = new int[numDefensores];

        for (int i = 0; i < numAtacantes; i++) {
            int aux = in.nextInt();
            if (aux>=0) {
                distancia_Atacantes[i] = aux;
            } else {
                i--;
            }
        }
        for (int i = 0; i < numDefensores; i++) {
            int aux = in.nextInt();
            if (aux >= 0) {
                distancia_Defensores[i] = aux;
            } else {
                i--;
            }
        }
    }

    private void calcD() {
        ultimo_def = distancia_Defensores[0];
        penultimo_def = null;

        for (int i = 1; i < numDefensores; i++) {
            if (distancia_Defensores[i] < ultimo_def) {
                penultimo_def = ultimo_def;
                ultimo_def = distancia_Defensores[i];
            } else if(penultimo_def == null || distancia_Defensores[i] < penultimo_def) {
                penultimo_def = distancia_Defensores[i];
            }
        }
    }

    private void calcA() {
        atacante = distancia_Atacantes[0];
        for (int i = 1; i < numAtacantes; i++) {
            if (distancia_Atacantes[i] < atacante) atacante = distancia_Atacantes[i];
        }
    }

    public boolean resultado() {
        calcD(); calcA();
        if (penultimo_def == null) return true;
        else if (atacante >= penultimo_def) return false;
        else return true;
    }

}
