package com.pucrs.devsys.tf.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pucrs.devsys.tf.util.MySQLDumpUtils;


//import com.pucrs.devsys.tf.util.MySQLDumpUtils;

/**
 * Servlet implementation class Restore
 */
//@WebServlet("/Restore")
public class Restore extends HttpServlet {
	

		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Restore() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			MySQLDumpUtils mysq = new MySQLDumpUtils();
			mysq.restore();
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

	}
