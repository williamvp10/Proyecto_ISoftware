package Controlador;
 
import BD.Obra_de_ArteDAO;
import MOdelo.Artista;
import MOdelo.Obra_de_Arte;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        
        String nombre = request.getParameter("nombre");
        String des= request.getParameter("descripcion");
        String estilo =request.getParameter("estilo");
        double valor =Integer.parseInt(request.getParameter("valor"));
        String artista = request.getParameter("user");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        Obra_de_ArteDAO dao = new Obra_de_ArteDAO();
        Artista a=dao.buscar_artista(artista);
        
        
        if (a == null) {
            request.setAttribute("Mensaje", "no se encontro el usuario ");
        } else {
           Obra_de_Arte obra = new Obra_de_Arte(nombre,des, estilo, valor, a);
            boolean agrego = dao.agregar_Obra(obra);
            if (agrego) {
                request.setAttribute("Mensaje", "Se agrego correctamente ");
            } else {
                request.setAttribute("Mensaje", " error no se pudo agragar");
            }
        }
        RequestDispatcher dispacher = request.getRequestDispatcher("agregarObra.jsp");
        dispacher.forward(request, response);
        }
}
