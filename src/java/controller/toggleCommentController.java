/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class toggleCommentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        List<Comment> comments_2 = new ArrayList<>();
        
        comments.add(new Comment("1", "qua chuan"));
        comments.add(new Comment("2", "tui cung nghi the"));
        comments.add(new Comment("3", "hahahaha"));
        
        comments_2.add(new Comment("4", ":) mưa rồi"));
        comments_2.add(new Comment("5", ":D really"));
        comments_2.add(new Comment("6", "Yup"));
        
        posts.add(new Post("1", "hom nay troi dep qua", comments));
        posts.add(new Post("2", "Troi hom nay het dep roi ahuhu", comments_2));
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/viewPost").forward(request, response);
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
