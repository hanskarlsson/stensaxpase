package com.jayway.stensaxpase.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/test")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -8683180326475810029L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        out.println("Hello World!");
    }
}