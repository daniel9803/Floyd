
package algoritmofloyd;

/**
 *
 * @author Personal
 */
public class clsCaminosMinimos {
    //Metodo para determinar todos los caminos
    public  String algoritmoFloyd(long [][] mAdy){
        int vertices= mAdy.length;
        long matrizAdyacencia[][]= mAdy;
        String caminos[][]= new String [vertices][vertices];
        String caminosAuxiliares[][]= new String [vertices][vertices];
        String caminoRecorrido = "",cadena="", caminitos="";
        int i,j,k;
        float temporal1,temporal2,temporal3,temporal4,minimo;
        // inicializando las matrices caminos y caminosAux
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j]="";
                caminosAuxiliares[i][j]="";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j <vertices; j++) {
                    temporal1=matrizAdyacencia[i][j];
                    temporal2=matrizAdyacencia[i][k];
                    temporal3=matrizAdyacencia[k][j];
                    temporal4=temporal2+temporal3;
                    //encontrando al minimo;
                    minimo=Math.min(temporal1,temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido ="";
                            caminosAuxiliares[i][j]= k+"";
                            caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+(k+1);
                        }
                    }
                    matrizAdyacencia[i][j]= (long)minimo;
                }
                
            }
        }
        // agregando el camino a cadena
        for (i = 0; i < vertices; i++) {
            for ( j = 0; j < vertices; j++) {
                cadena=cadena+"["+matrizAdyacencia[i][j]+"]";
            }
            cadena=cadena + "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j]!= 1000000000 ){
                    if (i!=j) {
                        if (caminos [i][j].equals("")) {
                            caminitos += "De ("+(i+1)+"-->"+(j+1)+") Irse por...("+(i+1)+","+(j+1)+")"+"\n";
                        }else{
                            caminitos+= "De ("+(i+1)+"-->"+(j+1)+") Irse por...("+(i+1)+","+caminos[i][j]+","+(j+1)+")"+"\n";
                        }
                    }
                }
            }
            
        }
        return " La matriz de caminos mas cortos entre los diferentes vertices"
                +"es: \n"+cadena+"\n Los diferentes caminos mas cortos "
                +"entre vertices son: \n"+caminitos;
    }
    public String caminosR(int i, int k, String[][] caminosAuxiliares,String caminoRecorrido){
        if (caminosAuxiliares[i][k].equals("")) {
            return"";
        }else{
            //Aplicando recursividad
            caminoRecorrido+=caminosR(i,Integer.parseInt(caminosAuxiliares[i][k].toString()),
                    caminosAuxiliares,
                    caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString())+1+".");
            return caminoRecorrido;
        }
    }
}
