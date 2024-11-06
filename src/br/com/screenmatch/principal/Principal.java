package br.com.screenmatch.principal;

import br.com.screenmatch.calculos.CalculadoraDeTempo;
import br.com.screenmatch.calculos.FiltroRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

    // Objeto = instância da classe
    // uma "cópia" do modelo com valores específicos para seus atributos
    //criando/setando um filme
    Filme poderosoChefao = new Filme("O poderoso chefão", 1970);
    poderosoChefao.setDuracaoEmMinutos(180);
    System.out.println("Duração do Filme: " + poderosoChefao.getDuracaoEmMinutos());
    poderosoChefao.exibeFichaTecnica();
    poderosoChefao.avalia(8);
    poderosoChefao.avalia( 5);
    poderosoChefao.avalia( 10);
    System.out.println("Total de avaliações: " + poderosoChefao.getTotalDeAvaliacoes());
    System.out.println("Media das avaliações: " + poderosoChefao.pegaMediaDasAvaliacoes());

    Filme feios = new Filme("Feios", 2024);
    feios.setDuracaoEmMinutos(105);

    //criando/setando uma serie
    Serie lost = new Serie("Lost", 2002);
    lost.exibeFichaTecnica();
    lost.setTemporadas(7);
    lost.setEpisodiosPorTemporada(23);
    lost.setMinutosPorEpisodio(50);
    System.out.println("Duração para maratonar " + lost.getNome() + ": " + lost.getDuracaoEmMinutos() + " minutos");

    CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
    calculadora.inclui(feios);
    calculadora.inclui(poderosoChefao);
    calculadora.inclui(lost);
    System.out.println("Tempo total para assistir " + feios.getNome() + " e " + poderosoChefao.getNome() + ": " + calculadora.getTempoTotal() + " minutos");

    FiltroRecomendacao filtro = new FiltroRecomendacao();
    filtro.filtrar(poderosoChefao);

    Episodio episodio = new Episodio();
    episodio.setNumero(1);
    episodio.setSerie(lost);
    episodio.setTotalDeVisualizações(300);
    filtro.filtrar(episodio);

    Filme deadpoolTres = new Filme("Deadpool e Wolverine", 2024);
    deadpoolTres.setDuracaoEmMinutos(200);
    deadpoolTres.avalia(10);

    ArrayList<Filme> listaDeFilmes = new ArrayList<>();
    listaDeFilmes.add(deadpoolTres);
    listaDeFilmes.add(feios);
    listaDeFilmes.add(poderosoChefao);
    System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size());
    System.out.println("Primeiro filme da lista: " + listaDeFilmes.get(0).getNome());
    System.out.println(listaDeFilmes);
    System.out.println("toString do filme: " + listaDeFilmes.get(0).getNome());

    };
}