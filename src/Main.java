    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    private Pila pila = new Pila();
void main() {
    //Probando con un objeto random
    Pelota pelota = new Pelota("de futbol", "Cafe");
    Pelota pelota2 = new Pelota("La segunda y ahora primera", "verde");
    pila.push(pelota);
    pila.push(pelota2);
    System.out.println(pila.pop());
    System.out.println(pila.pop());


    //Probando con cadenas
    String cadena = "Hola";
    System.out.println(cadena);
    System.out.println(invierteCadena(cadena));

    //Probando el revisarSintaxis
    System.out.println("Ejemplo con cadena buena: {5(5x+6)9+4[45][6x+8]}");
    System.out.println(revisarSintaxis("{5(5x+6)9+4[45][6x+8]}"));

    System.out.println("Ejemplo con cadena mala: {)[()]()}");
    System.out.println(revisarSintaxis("{[()]()}"));

    int[] numeros = {1,2,3,4,0,-5,2,3};
    System.out.println(ordenarMenoraMayor(numeros));

}

public String invierteCadena(String cadena){
    int longitud = cadena.length();

    for (int i = 0; i < longitud; i++){
        pila.push(cadena.charAt(i));
    }

    String retorno = "";
    while(!pila.vacia()) retorno += pila.pop();
    return retorno;
}


public boolean revisarSintaxis(String cadena){
    for(int i =0; i < cadena.length(); i++){
        String aEnviar = cadena.charAt(i) + "";

       if (aEnviar.equalsIgnoreCase("(") ||  aEnviar.equalsIgnoreCase("[") || aEnviar.equalsIgnoreCase("{")){
           pila.push(aEnviar);
       }

       if (aEnviar.equalsIgnoreCase(")") ||  aEnviar.equalsIgnoreCase("]") || aEnviar.equalsIgnoreCase("}")){
            String sacado = (String) pila.pop();
            if (sacado == null) return false;
            if(esParentesis(aEnviar) && esParentesis(sacado)) {
                if(sonIguales(aEnviar,sacado)) return false;
            }

            if(esCorchete(aEnviar) && esCorchete(sacado)) {
                if(sonIguales(aEnviar,sacado)) return false;
            }

            if(esLLave(aEnviar) && esLLave(sacado)) {
                if(sonIguales(aEnviar,sacado)) return false;
            }

       }
    }
    return pila.vacia(); //Si la pila no esta vacia tambien retorna falso
}

public boolean esParentesis(String caracter){
    Boolean es = false;
    if(caracter.equals("(")) es = true;
    else if(caracter.equals(")")) es = true;
    return es;
}

public boolean esCorchete(String caracter){
    Boolean es = false;
    if(caracter.equals("[")) es = true;
    else if(caracter.equals("]")) es = true;
    return es;
}

public boolean esLLave(String caracter){
    Boolean es = false;
    if(caracter.equals("{")) es = true;
    else if(caracter.equals("}")) es = true;
    return es;
}

//Metodo que nos sirve para comparar todos
public boolean sonIguales(String caracter1, String caracter2){
    if (caracter1.equalsIgnoreCase(caracter2)) return true;
    return false;
}

//El metodo lo que hace es ordenar de menor a mayor mediante un vector de booleanos para saber si ya se usaron o no
public Pila ordenarMenoraMayor(int[] vector){
    Pila pila = new Pila();
    boolean[] usados = new boolean[vector.length];
    int valorInicial = 0;
    int posicionUsada = 0;
    for(int i = 0; i < vector.length; i++){

        //Primero agarrar valores no usados
        for(int k = 0; k < vector.length; k++) {
            if (usados[k]) continue;
            valorInicial = vector[k];
            break;
        }

        //Compararlos hasta encontrar al menor (ignrando los usados claro)
        for(int j = 0; j < vector.length; j++){
            if(usados[j]) continue;
            if(valorInicial < vector[j]) continue;
            valorInicial = vector[j];
            posicionUsada = j;
        }

        usados[posicionUsada] = true;
        pila.push(valorInicial);
    }
    return pila;
}

//Primer error de algoritmo lo guardo nomas
//public void ordenarMenoraMayor(int[] vector){
//    Pila deRetorno = new Pila();
//
//    int[] vector2 = new int[vector.length];
//    int contador = 0;
//
//    //Manejamos los 0s aparte para usarlos como null despues
//    for(int i = 0; i < vector.length; i++)
//        if(vector[i] == 0) {
//            vector2[contador] = 0;
//            contador++;
//        }
//
//
//    int valoraNulo;
//    int valorComparable;
//    //Lo que hace es con cada valor va a comparar cual es el menor de todos, y uso el 0 como si fuera un nulo osea no permitido
//    for(int i = 0; i < vector.length; i++){
//        valoraNulo = 0;
//        //Valor por valor
//        if(vector[i] == 0) continue; //Cuando encuentra valores 0 que los ignore
//
//        valorComparable = vector[i];
//
//        for(int j = 0; j< vector.length;j++){
//            if(vector[j] == 0) continue;
//            if(valorComparable > vector[j]){
//                valorComparable = vector[j];
//                valoraNulo = j;
//            }
//        }
//        vector2[contador] = valorComparable;
//        contador++;
//        vector[valoraNulo] = 0;
//
//    }
//
//
//}