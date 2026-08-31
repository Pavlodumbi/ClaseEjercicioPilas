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