package py.com.misgruposv01.utils;

public enum RequestCode {

		ITEM_EDITAR_TARJETA(1, "Editar tarjeta del menu de MostrarTarjetaActivity"),
		ACT_LANZADA_CREAR_USUARIO(2, "Actividad lanzada Crear Grupo"),
		PETICION_EDITAR_USUARIO(3, "Peticion editar grupo");

		private int codigo;
		private String descripcion;

		RequestCode(int codigo, String descripcion) {
			this.codigo = codigo;
			this.descripcion = descripcion;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


	}


