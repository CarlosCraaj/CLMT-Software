package service;

public class UsersService {
    private UsersDAO UsersDAO;
	
	public UsersService()  {
	
			UsersDAO = new AdocaoDAO();
			
}
	public Object add(Request request, Response response) {
		
		UsersDAO.conectar();
		
	
	    String[] a=request.body().split("&");
	    for(String i: a) {
	    	System.out.println(i);
	    }
		String nome = a[0].split("=")[1];
		String email1= a[4].split("=")[1];
		int id = UsersDAO.getMaxId() + 1;
		String email= "";
        for(int i =0 ; i<email1.length();i++) {
        	if(email1.charAt(i)=='%' && email1.charAt(i+1)=='4' && email1.charAt(i+2)=='0') {
        		email+='@';
        	}else {
        		email+=email1.charAt(i);
        	}
        }
        
		User users = new User(id, nome, email, password);

		UsersDAO.inserirUsuario(users);

		response.status(201); // 201 Created
		UsersDAO.close();
		return id;
		
	}

	public Object get(Request request, Response response) {
		UsersDAO.conectar();
		int id = Integer.parseInt(request.params(":id"));
		
		User User = (User) UsersDAO.get(id);
		
		if (User != null) {
    	    response.header("Content-Type", "application/xml");
    	    response.header("Content-Encoding", "UTF-8");
    	    UsersDAO.close();
            return "<users>\n" + 
            		"\t<is> " + User.getID() + "</id>\n" +
            		"\t<nome> " + User.getName() + "</nome>\n" 
            		"\t<email> " + User.getEmail() + "</email>\n" +
            		"</users>\n";
        } else {
            response.status(404); // 404 Not found
            UsersDAO.close();
            return "Produto " + id + " n�o encontrado.";
        }

	}

	public Object update(Request request, Response response) {
		UsersDAO.conectar();
        int id = Integer.parseInt(request.params(":id"));
        
		User users = (User) UsersDAO.getID(id);

        if (users != null) {
        	users.setNome(request.queryParams("username"));
        	users.setEmail(request.queryParams("email"));      
        	 UsersDAO.close();
            return id;
        } else {
            response.status(404); // 404 Not found
            UsersDAO.close();
            return "Usuario nao encontrado";
        }

	}

	public Object remove(Request request, Response response) {
		UsersDAO.conectar();
		 int id = Integer.parseInt(request.params(":id"));
	        
			User users = (User) UsersDAO.get(id);

        if (users != null) {
 
            

            response.status(200); // success
            UsersDAO.close();
        	return id;
        } else {
            response.status(404); // 404 Not found
            UsersDAO.close();
            return "Usuario n�o encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		UsersDAO.conectar();
		StringBuffer returnValue = new StringBuffer("<users type=\"array\">");
		for (User users : UsersDAO.getUsername()) {
			
			returnValue.append("\n<users>\n" + 
					"\t<id> " + users.getID() + "</id>\n" +
            		"\t<nome> " + users.getName() + "</nome>\n" +
            		"\t<email> " + users.getEmail() + "</email>\n" +
            		"</users>\n");
		}
		returnValue.append("</users>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
	    UsersDAO.close();
		return returnValue.toString();

	}

}
