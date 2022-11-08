package Funcional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Profundidad {

    public static void main(String[] args) {
        LinkedList<ArrayList> listaLetrasOcultasd = new LinkedList<ArrayList>();
        ArrayList sd = new ArrayList();
        ArrayList ss = new ArrayList();
        listaLetrasOcultasd.add(ss);
        profundidadAux(listaLetrasOcultasd, sd);
    }

    public static Boolean profundidadAux(LinkedList<ArrayList> listaLetrasOcultas, ArrayList solucion1) {

        if (evaluaSolucion.test(listaLetrasOcultas.get(0), solucion1)) {
            System.out.println("Ruta: " + listaLetrasOcultas);
            return true;
        } else {
            List<List> posilesSoluciones = vecinos.apply(listaLetrasOcultas.get(0));
            System.out.println("Ruta alcanzada:" + posilesSoluciones);
        }
        return null;
    }

    static BiPredicate<ArrayList, ArrayList> evaluaSolucion = (listaLetras, listaSolucion)
            -> listaLetras.equals(listaSolucion);

    /*static BiFunction<LinkedList<ArrayList>, ArrayList, ArrayList> extender = (listaLetras, listaSolucion)
            -> {
        vecinos.apply(listaLetras.get(0), listaSolucion);
        return null;
    };*/
    static Function<ArrayList, List<List>> vecinos = listasLetras
            -> {
        List<List> sdf = new ArrayList();
        List<String> abecedario = IntStream.rangeClosed('a', 'z').mapToObj(letra -> "" + (char) letra)
                .filter(x -> !listasLetras.contains(x))
                .collect(Collectors.toList());
        int index = listasLetras.indexOf(" ");
        List sublista = listasLetras.subList(0, index);
        if (sublista.size() == (listasLetras.size() - 1)) {
            sdf = abecedario.stream()
                    .map(x -> {
                        List tempList = new ArrayList();
                        tempList.addAll(sublista);
                        tempList.add(x);
                        return tempList;
                    })
                    .collect(Collectors.toList());
        } else {
            List sublista2 = listasLetras.subList(index + 1, listasLetras.size());
            sdf = abecedario.stream()
                    .map(x -> {
                        List tempList = new ArrayList();
                        tempList.addAll(sublista);
                        tempList.add(x);
                        tempList.addAll(sublista2);
                        return tempList;
                    })
                    .collect(Collectors.toList());
        }
        return sdf;
    };
}
