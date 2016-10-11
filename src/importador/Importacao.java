package importador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import dao.ConnectionFactory;
import modelo.pessoa.Pessoa;
import util.Conversor;


@WebServlet("/Importacao")
public class Importacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private static Connection conn;
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE  = 1024 * 1024 * 3;//3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;//40MB
	private static final int MAX_REQUEST_SIZE  = 1024 * 1024 * 50;//50MB
	
    public Importacao() {
       
    }
    
    private static ArrayList<Pessoa> importarAluno(File storeFile) throws Exception {
        
        Path arquivo = storeFile.toPath();
    	
        String conteudo = new String(Files.readAllBytes(arquivo));
        
        //Quebra o arquivo em um array de linhas
        String[] linhas = conteudo.split("\n");
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        for (int i = 0; i < linhas.length; i++) {
            //Pula a primeira linha pois é o cabeçalho
            if (i == 0) {
                continue;
            }
            String coluna[] = linhas[i].split(";");
            //Processando uma linha
            Pessoa pessoa = new Pessoa();
            
            for (int f = 0; f < coluna.length; f++) {
                //Processando as colunas
                switch (f) {
                    case 0:
                        continue;
                    case 1:
                        continue;
                    case 2:
                        pessoa.setSituacao(coluna[f]);
                        //System.out.println(pessoa.getSituacao());
                        break;
                    case 3:
                    	pessoa.setCpf(coluna[f]);
                        break;
                    case 4:
                        String frase = coluna[f];
                        String[] array;
                        array = frase.split(" ");
                        pessoa.setNome(array[0]);
                        for(int x = 0; x < array.length; x++){
                        	if(array[x].equals(0)){
                        		continue;
                        	}
                        	pessoa.setSobrenome(array[x] + " ");
                        }
                        //System.out.println(pessoa.getNome() + " " + pessoa.getSobrenome());
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
                    	pessoa.setData_de_nascimento(Conversor.toDate(coluna[f]));
                        break;
                    
                    default:
            			break;
                }
            }
            pessoas.add(pessoa);
            //System.out.println("Pessoa adicionada: " + pessoa.getNome());
        }
        
        //System.out.println("Pessoas importadas: " + pessoas.size());
        return pessoas;
    }
    
	public static void importarPessoa(File storeFile) throws Exception{
    	
    	
        ArrayList<Pessoa> alunos = importarAluno(storeFile);
        
        for(Pessoa pessoa: alunos){
        	System.out.println(pessoa.getSituacao());
        	if (pessoa.getSituacao().equals("Aprovado")) {
   			
       		String query = "insert into pessoa(nome, sobrenome, data_de_nascimento, sexo, cpf, telefone, email) VALUES (?,?,?,?,?,?,?)";
           		conn = ConnectionFactory.abreConexao();
           		if(!conn.isClosed()){
         			System.out.println("Abriu conexão!!");
         		}
           		PreparedStatement pmt = conn.prepareStatement(query);
           		pmt.setString(1, pessoa.getNome());
           		pmt.setString(2, pessoa.getSobrenome());
           		pmt.setDate(3, Conversor.dateToSQLDate(pessoa.getData_de_nascimento()));
           		pmt.setString(4, pessoa.getSexo());
           		pmt.setString(5, pessoa.getCpf());
           		pmt.setString(6, pessoa.getTelefone());
           		pmt.setString(7, pessoa.getEmail());
           		
           		pmt.executeUpdate();
           		ConnectionFactory.fecha(conn, pmt);
           		if(conn.isClosed()){
         			System.out.println("Fechou conexão!!");
         		}
        	}else {
        		continue;
        	}
        }
    }

    /*
    private void processaRequisicao() throws Exception {
		String comando = request.getParameter("cmd");
		
		//Pegar o arquivo do request
		switch (comando) {
			case "importar":
				importarPessoa();
				break;
			default:
				break;
		}
		rd.forward(request, response);
	}
    */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		try {
			processaRequisicao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Verifica se o pedido contém realmente de upload de arquivos
		if(!ServletFileUpload.isMultipartContent(request)){
			PrintWriter writer = response.getWriter();
			writer.print("Pedido não contém dados de carregamento");
			writer.flush();
			return;
		}
		
		//Configura as configurações de upload
		DiskFileItemFactory factory = new  DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload  upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		//Constrói o caminho do diretório para upload de arquivo store
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		
		//Cria o diretório se ele não existir
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		
		try{
			
			//Analisa o conteúdo do pedido para extrair dados de arquivos
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();
			
			//Itera sobre os campos do formulário
			while(iter.hasNext()){
				FileItem item = (FileItem) iter.next();
				//Processa apenas os campos que não são campos de formulário
				if(!item.isFormField()){
					String fileName  = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File   storeFile = new File(filePath);
					
					importarPessoa(storeFile);
					
					
					//Salva o arquivo no disco
					//item.write(storeFile);
					//System.out.println(item.isInMemory());
					//System.out.println(item.getName());
					//System.out.println(item.getSize());
				}
				
			}
			
			//Inserir no banco a partir do arquivo (FILE)
			
			request.setAttribute("message", "Carregado com sucesso");
		}catch (Exception ex){
			request.setAttribute("message", "Houve um erro: " + ex.getMessage());
		}
		getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
	}
}
