package app;

import static spark.Spark.*;
import service.LoteService;
import service.ProductService;
import service.UsersService;


public class Aplicacao {
	
	// private static ProdutoService produtoService = new ProdutoService();
	private static LoteService loteService = new LoteService();
	private static ProductService productService = new ProductService();
	private static UsersService userService = new UsersService();
	
    public static void main(String[] args) {
        port(5432);
        
        staticFiles.location("/public");
        
        post("/produto/insert", (request, response) -> produtoService.insert(request, response));

        get("/produto/:id", (request, response) -> produtoService.get(request, response));
        
        get("/produto/list/:orderby", (request, response) -> produtoService.getAll(request, response));

        get("/produto/update/:id", (request, response) -> produtoService.getToUpdate(request, response));
        
        post("/produto/update/:id", (request, response) -> produtoService.update(request, response));
           
        get("/produto/delete/:id", (request, response) -> produtoService.delete(request, response));

             
    }
}