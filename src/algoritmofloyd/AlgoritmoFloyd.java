/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmofloyd;

/**
 *
 * @author Personal
 */
public class AlgoritmoFloyd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long matrizA[][]=
        {
            {0,3,4,999999999},
            {999999999,0,999999999,5},
            {999999999,999999999,0,3},
            {8,999999999,999999999,0}
        };
        clsCaminosMinimos ruta = new clsCaminosMinimos();
        System.out.println(ruta.algoritmoFloyd(matrizA));
    }
    
}
