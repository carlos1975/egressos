package util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Iterator;
import java.util.TreeSet;

import modelo.pessoa.Pessoa;

public class ImportadorCSV {

    public static void main(String args[]) throws IOException, ParseException, Exception {
    	
    }
    
    public static HashSet<Pessoa> importarAluno(String url) throws Exception {
        
        Path caminho = Paths.get(url);
        String conteudo = new String(Files.readAllBytes(caminho));
        System.out.println(conteudo);

        String[] linhas = conteudo.split("\n");
        
        HashSet<Pessoa> hashSetPessoa = new HashSet<Pessoa>();
        
        Pessoa pessoa;
        
          for (int i = 0; i < linhas.length; i++) {
            //Pula a primeira linha pois é o cabeçalho
            if (i == 0) {
                continue;
            }
            String coluna[] = linhas[i].split(";");
            //Processando uma linha
            pessoa = new Pessoa();
            
            for (int f = 0; f < coluna.length; f++) {
                //Processando as colunas
                switch (f) {
                    case 0:
                        continue;
                    case 1:
                        continue;
                    case 2:
                        pessoa.setSituacao(coluna[f]);
                        System.out.println(pessoa.getSituacao());
                        break;
                    case 3:
                    	pessoa.setCpf(coluna[f]);
                        break;
                    case 4:
                        String frase = coluna[f];
                        String[] array;
                        array = frase.split(" ");
                        pessoa.setNome(array[0]);
                        for(int x = 1; x < array.length; x++){
                        	pessoa.setSobrenome(array[x] + " ");
                        }
                        break;
                    case 5:
                        pessoa.setEmail(coluna[f]);
                        break;
                    case 6:
                        continue;
                    case 7:
                    	pessoa.setTelefone(coluna[f]);
                        break;
                    case 8:
                        continue;
                    case 9:
                        pessoa.setSexo(coluna[f]);
                        break;
                    case 10:
                    	pessoa.setData_de_nascimento(util.Conversor.toDate(coluna[f]));
                        break;
                }
            }
            if (!hashSetPessoa.contains(pessoa)) {
                hashSetPessoa.add(pessoa);              
            }
        }
        return hashSetPessoa;
    }

}
