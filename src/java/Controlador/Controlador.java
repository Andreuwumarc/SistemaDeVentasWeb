
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();  
    
    int idc;
    int idp; 
    int ide;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");            
        String accion=request.getParameter("accion");
        if (menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")){
            switch (accion) {
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);                   
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtestado");
                    String user=request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);                    
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtestado");
                    String user1=request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")){
            /*switch (accion) {
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("clientes", lista);                   
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtDir");
                    String est=request.getParameter("txtestado");
                    
                    c.setDni(dni);
                    c.setNom(nom);
                    c.setDir(tel);
                    c.setEstado(est);
                    
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente e=cdao.listarId(idc);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);                    
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String Dir1=request.getParameter("txtDir");
                    String est1=request.getParameter("txtestado");
                    
                    c.setDni(dni1);
                    c.setNom(nom1);
                    c.setDir(Dir1);
                    c.setEstado(est1);
                    
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }*/
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")){
            /*switch (accion) {
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("producto", lista);                   
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    String prec=request.getParameter("txtPrec");
                    String sto=request.getParameter("txtSto");
                    String est=request.getParameter("txtEstado");
                    
                    p.setNom(nom);
                    p.setPrec(prec);
                    p.setStock(sto);
                    p.setEstado(est);
                    
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente e=cdao.listarId(idc);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);                    
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String Dir1=request.getParameter("txtDir");
                    String est1=request.getParameter("txtestado");
                    
                    c.setDni(dni1);
                    c.setNom(nom1);
                    c.setDir(Dir1);
                    c.setEstado(est1);
                    
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }*/
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("RegistrarVenta")){
            /*switch  (accion) {
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");
                    c.setDni(dni);
                    c=cdao.buscar(dni);
                    request.setAttribute("c", c );
                    break;
                default:
                    throw new AssertionError();
            }*/
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }                  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
