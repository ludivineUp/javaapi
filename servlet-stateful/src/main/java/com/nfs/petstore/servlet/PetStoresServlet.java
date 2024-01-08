package com.nfs.petstore.servlet;

import com.nfs.petstore.entitties.PetStore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PetStoresServlet", urlPatterns = {"/petstores"})
public class PetStoresServlet extends HttpServlet {

    private List<PetStore> petStores = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        // je vais créer des fakes animaleries
        petStores.add(new PetStore(1, "Zoonimo"));
        petStores.add(new PetStore(2, "AnimosFact"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // pour communiquer avec la vue => session HTTP
        // session HTTP = espace mémoire partagée entre le serveur et le client
        request.getSession().setAttribute("petStores", petStores);
        // où envoyer l'utilisateur
        response.sendRedirect( request.getContextPath() + "/petstores.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer les info du form : response
        String name = request.getParameter("name");
        petStores.add(new PetStore(petStores.size(), name));
        request.getSession().setAttribute("petStores", petStores);
        // où envoyer l'utilisateur
        response.sendRedirect( request.getContextPath() + "/petstores.jsp");

    }
}
