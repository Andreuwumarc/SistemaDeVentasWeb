
package Controlador;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validar extends HttpServlet {

    EmpleadoDAO edao=new EmpleadoDAO();
    Empleado em=new Empleado();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            em=edao.validar(user, pass);
            if(em.getUser() !=null){
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                              
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        }
        else{
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
