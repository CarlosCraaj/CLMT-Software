package app;

import static spark.Spark.*;
import service.LoteService;
import service.ProductService;
import service.UsersService;


public class Aplicacao {
	
	private static LoteService loteService = new LoteService();
	private static ProductService productService = new ProductService();
	private static UsersService userService = new UsersService();
	
    public static void main(String[] args) {
        port(300);
        
        staticFiles.location("/public");
        
        post("/user/create", (request, response) -> userService.insert(request, response));

        get("/user/get/:username", (request, response) -> userService.get(request, response));

        post("/produto/insert", (request, response) -> productService.insert(request, response));

        get("/produto/:id", (request, response) -> productService.get(request, response));
        
        post("/produto/update/:id", (request, response) -> productService.update(request, response));
           
        get("/produto/delete/:id", (request, response) -> productService.remove(request, response));

    }
}