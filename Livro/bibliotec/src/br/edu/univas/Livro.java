package br.edu.univas;
import java.util.ArrayList;
import java.util.List;

class Livro {
    private final String titulo;
    private final boolean disponivel;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

}

class Autor {

    public Autor(String ignoredNome) {
    }

}

class Biblioteca {
    private final List<Livro> livros;
    private final List<Autor> autores;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public boolean verificarDisponibilidade(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro.isDisponivel();
            }
        }
        return false;
    }
}

class ExemploBiblioteca {
    public static void main(String[] args) {
        // Criar uma instância de Biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Criar objetos Livro e Autor
        Livro livro1 = new Livro("Aprendendo Java");
        Livro livro2 = new Livro("Programação em Python");
        Autor autor1 = new Autor("Autor A");
        Autor autor2 = new Autor("Autor B");

        // Adicionar os livros e autores à biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        // Verificar a disponibilidade de alguns livros na biblioteca
        String livroBuscado = "Aprendendo Java";
        boolean disponivel = biblioteca.verificarDisponibilidade(livroBuscado);

        // Exibir os resultados no console
        System.out.println("Biblioteca: " + biblioteca);
        System.out.println("Disponibilidade de '" + livroBuscado + "': " + (disponivel ? "Disponível" : "Indisponível"));
    }
}
