package maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {

	public static void main (String [] args) {
		
		System.out.println("Ordem Aleat�ria: ");
		Map<String,Livro> meusLivros = new HashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma breve Hist�ria do Tempo", 256));
			put("Duhigg, Charles", new Livro("O poder do h�bito", 408));
			put("Harari, Yuval Noah", new Livro("21 Li��es para o S�culo 21", 432));
		}}; 
		for(Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("\nOrdem de Inser��o: ");
		Map<String,Livro> meusLivros1 = new LinkedHashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma breve Hist�ria do Tempo", 256));
			put("Duhigg, Charles", new Livro("O poder do h�bito", 408));
			put("Harari, Yuval Noah", new Livro("21 Li��es para o S�culo 21", 432));
		}}; 
		for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("\nOrdem alfab�tica autores: ");
		Map<String,Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("\nOrdem alfab�tica nome dos livros: ");
		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		meusLivros3.addAll(meusLivros.entrySet());
		for(Map.Entry<String, Livro> livro : meusLivros3) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
	}
}

class Livro {
	private String nome;
	private Integer paginas;
	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}
	public Livro(String nome, Integer paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}
	public String getNome() {
		return nome;
	}
	public Integer getPaginas() {
		return paginas;
	}
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
	}
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
	}
	
}