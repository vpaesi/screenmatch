package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;
import br.com.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme poderosoChefao = new Filme("O poderoso chefão", 1970);
        poderosoChefao.avalia(9);
        Filme feios = new Filme("Feios", 2024);
        feios.avalia(6);
        Filme deadpoolTres = new Filme("Deadpool e Wolverine", 2024);
        deadpoolTres.avalia(10);
        Serie lost = new Serie("Lost", 2002);


        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(poderosoChefao);
        listaDeAssistidos.add(deadpoolTres);
        listaDeAssistidos.add(feios);
        listaDeAssistidos.add(lost);
        for (Titulo item: listaDeAssistidos){
            System.out.println(item.getNome());
            if (item instanceof Filme filme){
                System.out.println("Classificação: " + filme.getClassificacao());;
            }
        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Selena Gomez");
        buscaPorArtista.add("Demi Lovato");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação alfabética: " + buscaPorArtista);

        Collections.sort(listaDeAssistidos);
        System.out.println("Lista de Títulos ordenados por ordem alfabética: " + listaDeAssistidos);

        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano: " + listaDeAssistidos);
    }
}
