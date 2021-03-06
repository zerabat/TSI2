package com.tsijee01.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contenido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(nullable = false)
	private Date fechaPublicado;
	
	@Column(length = 100, nullable = false)
	private String titulo;
	
	@Column(length = 512, nullable = false)
	private String descipcion;
	
	@ManyToMany
	@JoinTable(name = "categoria_contenido",
			joinColumns=@JoinColumn(name="categoria_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="contenido_id", referencedColumnName="id"))
	private List<Categoria> categorias;
	
	@ManyToMany
	@JoinTable(name = "director_contenido",
			joinColumns=@JoinColumn(name="contenido_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="director_id", referencedColumnName="id"))
	private List <Director> directores;
	
	@ManyToMany
	@JoinTable(name = "actor_contenido",
			joinColumns=@JoinColumn(name="contenido_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="actor_id", referencedColumnName="id"))
	private List <Actor> actores;
	
	@Column (nullable = false)
	private int ranking;
	
	@Column (nullable = false)
	private String fotoPortada;
	
	@Column (nullable = false)
	private String path;
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "id")
	@Fetch (FetchMode.SELECT)
	private List<Comentario> comentarios;
	
	// se contempla que la relación similar puede no ser simétrica
	@ManyToMany
	@JoinTable(name = "contenidos_similares",
			joinColumns=@JoinColumn(name="contenido_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="similar_contenido_id", referencedColumnName="id"))
	private List<Contenido> similares;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "proveedorId")
	ProveedorContenido proveedorContenido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPublicado() {
		return fechaPublicado;
	}

	public void setFechaPublicado(Date fechaPublicado) {
		this.fechaPublicado = fechaPublicado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public List<Director> getDirectores() {
		return directores;
	}

	public void setDirectores(List<Director> directores) {
		this.directores = directores;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public String getFotoPortada() {
		return fotoPortada;
	}

	public void setFotoPortada(String fotoPortada) {
		this.fotoPortada = fotoPortada;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Contenido> getSimilares() {
		return similares;
	}

	public void setSimilares(List<Contenido> similares) {
		this.similares = similares;
	}

	public ProveedorContenido getProveedorContenido() {
		return proveedorContenido;
	}

	public void setProveedorContenido(ProveedorContenido proveedorContenido) {
		this.proveedorContenido = proveedorContenido;
	}

	public void setId(long id) {
		this.id = id;
	}

}
