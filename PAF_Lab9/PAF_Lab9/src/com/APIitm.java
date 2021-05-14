package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class APIitm
 */
@WebServlet("/APIitm")
public class APIitm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIitm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 String output = itemObj.insertGrantApplication(request.getParameter("Grant_Application_ID"), 
			request.getParameter("Title"), 
			request.getParameter("Full_Name"), 
			request.getParameter("Email"), 
			request.getParameter("Phone"), 
			request.getParameter("Research_category"), 
			request.getParameter("Budget"),  
			request.getParameter("Introduction")); 
			
			response.getWriter().write(output);
			
			
			}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 Map paras = getParasMap(request); 
			 
			 String output = itemObj.updateGrants(paras.get("hidGrant_Application_IDSave").toString(), 
			 paras.get("Grant_Application_ID").toString(), 
			 paras.get("Title").toString(), 
			 paras.get("Full_Name").toString(),
			 paras.get("Email").toString(), 
			 paras.get("Phone").toString(), 
			 paras.get("Research_category").toString(), 
			 paras.get("Budget").toString(),
			 paras.get("Introduction").toString()); 
			
			 
			 response.getWriter().write(output); 
			} 
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 Map paras = getParasMap(request); 
			 
			 String output = itemObj.deleteGrants(paras.get("Grant_Application_ID").toString()); 
			response.getWriter().write(output); 
			
			}
	 
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 
}
	}
