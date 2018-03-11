package com.dvalpha.core.controller;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvalpha.core.dao.IGenericDAO;
import com.dvalpha.core.entity.MstArticulo;
import com.dvalpha.core.entity.MstClient;
import com.dvalpha.core.entity.MstComponente;
import com.dvalpha.core.entity.MstMateriales;
import com.dvalpha.core.entity.MstModelo;
import com.dvalpha.core.entity.MstUrl;
import com.dvalpha.core.entity.Testxx;


@Controller
public class MainController extends CoreController {
	private static final Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	IGenericDAO dao;
	
	@RequestMapping(value = { "/home" })
	public ModelAndView home(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("home");
	}
	
	@RequestMapping(value = { "/test-f" })
	public void test(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		List<MstComponente> lista1 = (List<MstComponente>)dao.findAll(new MstComponente());
		System.out.println("Listamos componentes "+lista1.size());
		List<MstComponente> lista2 =new ArrayList();
		List<MstMateriales> listaMateriales =new ArrayList();
		int cs=0;
		for(MstComponente m:lista1) {
			
			
			String sql="SELECT * from temp where componente_id="+m.getCodigo()+" group by material_id";
			List<Testxx> lista = (List<Testxx>)dao.find_By_SQL_Generic(sql, Testxx.class);
			
			System.out.println("La lista de test tiene "+lista.size());
			System.out.println("Obtenemos los materiales de cada uni de los codigos de la lista");
			listaMateriales =new ArrayList();
			for(Testxx t:lista) {
				System.out.println("El codigo del material que se ñadaira a las lista es "+t.getIdmaterial());
				String sql2="select * from mst_materiales where codigo='"+t.getIdmaterial()+"'";
				
				List<MstMateriales> co =(List<MstMateriales>)dao.find_By_SQL_Generic(sql2,MstMateriales.class);
				if(co.size()>0) {
				listaMateriales.add(co.get(0));
				System.out.println("Lista añadida "+listaMateriales.size());
				
				}
			}

			cs++;

			}
		
		
		
		
	}
	@RequestMapping(value = { "/main-menu-usuario" })
	public ModelAndView mainUsers(HttpServletResponse response, HttpServletRequest request) throws IOException {
	

    return new ModelAndView("user-main");
	}
	
	
	@RequestMapping(value = { "/main-menu-rol" })
	public ModelAndView mainRoles(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("roles-main");
	}
	
	@RequestMapping(value = { "/main-menu-url" })
	public ModelAndView mainUrl(HttpServletResponse response, HttpServletRequest request) throws IOException {
	return new ModelAndView("/url-main");
	}
	
	@RequestMapping(value = { "/main-menu-libro" })
	public ModelAndView mainLibro(HttpServletResponse response, HttpServletRequest request) throws IOException {
    return new ModelAndView("/libro-main");
	}
}
