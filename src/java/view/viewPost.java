package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import model.Post;

/**
 *
 * @author DrAgOn
 */
public class viewPost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Post</title>");
            //
            //css
            //
            out.println("<style>"
                    + "body{"
                    + "margin:auto;\n"
                    + "width: 50%;"
                    + "}"
                    + ".post-box{"
                    + "border:1px black solid;\n"
                    + "display:inline;"
                    + "}"
                    + ".cmt-box {\n"
                    + "margin:auto;"
                    + "overflow-y: hidden;\n"
                    + " max-height: 1000px;\n"
                    + "transition: all 0.5s ease-in;"
                    + "padding-left:50px;"
                    + "border:1px solid black;"
                    + "}"
                    + ".cmt-box.closed {\n"
                    + "	max-height: 0;"
                    + "transition: all 0.5s ease-out;\n"
                    + "border:0px solid black;"
                    + "}"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            for (Post post : posts) {
                //
                //post
                //
                out.println("<div class=\"post-box\">");
                out.println(post.getContent());
                out.println("<input id=\"btntoggle_" + post.getId() + "\" type=\"button\" value=\"Show\" onclick=\"toggleComment(" + post.getId() + ")\" />");
                out.println("</div>");
                out.println("<br/>");
                //
                //comment
                //
                out.println("<div class=\"cmt-box closed\" id=\"cmtBox_" + post.getId() + "\">");
                for (Comment cmt : post.getComments()) {
                    out.println("<div>");
                    out.println(cmt.getContent());
                    out.println("</div>");
                }
                out.println("</div>");

            }
            //
            //script
            //
            out.println("<script>");
            out.println("function toggleComment(id){"
                    + "document.getElementById('cmtBox_'+id).classList.toggle('closed');"
                    + "if(document.getElementById('btntoggle_'+id).value==='Show'){"
                    + "document.getElementById('btntoggle_'+id).value = 'Hidden';"
                    + "}else{"
                    + "document.getElementById('btntoggle_'+id).value = 'Show';"
                    + "}"
                    + "}");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
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
