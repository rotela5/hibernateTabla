package es.hibernateClientes;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
	
	
    public Cliente() {
		
	}
    
	public Cliente(String nombre, String apellido, String direccion) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
	private Detalles_cliente detalleCliente;

	public Detalles_cliente getDetalleCliente() {
		return detalleCliente;
	} 

	public void setDetalleCliente(Detalles_cliente detalleCliente) {
		this.detalleCliente = detalleCliente;
	}
	

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
    @Column(name="nombre")
	private String nombre;
    @Column(name="apellido")
	private String apellido;
    @Column(name="direccion")
	private String direccion;
}
