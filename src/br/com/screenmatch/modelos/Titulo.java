package br.com.screenmatch.modelos;

import br.com.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

// classe = "modelo" para criar objetos
// definindo suas características (atributos) e
// comportamentos (métodos)
//public = pro br.com.screenmatch.principal.Principal pegar pq o Filme tá no package
public class Titulo implements Comparable<Titulo> {
    private String nome;

    @SerializedName("Year")
    private int anoDeLancamento;

    private boolean incluidoNoPlano;
    //o private não pode ninguém mexer de forma manual
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 4 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    //getters para que possam acessar, ver, os atributos setados
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    //get pra pegar o total de avaliacoes, pra permitir o acesso ao private
    //return pra retornar o que foi pego
    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    //setter inserido com alt + insert
    //setter permite que alguém coloque, set, uma informação
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    //metodo = void, maneira de fazer algo, maneira de exibir a ficha técnica
    public void exibeFichaTecnica(){
        System.out.println("Título do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMediaDasAvaliacoes(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome= " + nome +
                ", anoDeLancamento= " + anoDeLancamento + ", "+
                "duração= " + duracaoEmMinutos + ")";
    }
}
