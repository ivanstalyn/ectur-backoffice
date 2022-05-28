package com.ectur.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ectur.controlador.ProductoControlador;
import com.ectur.controlador.EmpresaControlador;
import com.ectur.controlador.impl.ProductoControladorImpl;
import com.ectur.controlador.impl.EmpresaControladorImpl;
import com.ectur.modelo.entidad.Producto;
import com.ectur.modelo.entidad.Empresa;

@ManagedBean
@ViewScoped
public class ProductoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductoControlador productocontrolador;
	private EmpresaControlador empresacontrolador;
	private Producto producto;
	private Empresa empresa;
	private List<Producto> listado = new ArrayList<Producto>();
	private List<Empresa> listadoEmpresas = new ArrayList<Empresa>();

	private int empresaId;

	@PostConstruct
	public void init() {
		productocontrolador = new ProductoControladorImpl();
		empresacontrolador = new EmpresaControladorImpl();
		producto = new Producto();
		empresa = new Empresa();
		listar();
		listarEmpresas();

	}

	public void crear() {
		producto = new Producto();
		empresa = new Empresa();
		PrimeFaces.current().ajax().update("formProducto:mensajes", "formProducto:dlgFormulario");
	}

	public void guardar() {

		producto.setEmpresa(empresacontrolador.buscarPorId(empresaId));
		if (producto.getId() > 0) {
			productocontrolador.actualizar(producto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto actualizado correctamente."));
		} else {
			producto.setFechaCreacion(new Date(System.currentTimeMillis()));
			productocontrolador.insertar(producto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto creado correctamente."));
		}

		listar();
		PrimeFaces.current().ajax().update("formProducto:mensajes", "formProducto:dt_productos");
	}

	public void eliminar() {
		try {
			productocontrolador.eliminar(producto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto eliminado correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Producto no se eliminó", null));
		}
		listar();
		PrimeFaces.current().ajax().update("formProducto:mensajes", "formProducto:dt_productos");
	}

	public void listar() {
		listado = productocontrolador.listar();
	}

	public void listarEmpresas() {
		listadoEmpresas = empresacontrolador.listar();
	}

	// -------------------------------------------------
	public ProductoControlador getProductocontrolador() {
		return productocontrolador;
	}

	public void setProductocontrolador(ProductoControlador productocontrolador) {
		this.productocontrolador = productocontrolador;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getListado() {
		return listado;
	}

	public void setListado(List<Producto> listado) {
		this.listado = listado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getListadoEmpresas() {
		return listadoEmpresas;
	}

	public void setListadoEmpresas(List<Empresa> listadoEmpresas) {
		this.listadoEmpresas = listadoEmpresas;
	}

	public EmpresaControlador getEmpresacontrolador() {
		return empresacontrolador;
	}

	public void setEmpresacontrolador(EmpresaControlador empresacontrolador) {
		this.empresacontrolador = empresacontrolador;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}

}
