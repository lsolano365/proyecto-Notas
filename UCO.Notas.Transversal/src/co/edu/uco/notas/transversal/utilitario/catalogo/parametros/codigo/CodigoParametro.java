package co.edu.uco.notas.transversal.utilitario.catalogo.parametros.codigo;

import co.edu.uco.notas.transversal.utilitario.catalogo.parametros.CatalogoParametros;

public class CodigoParametro {

	private CodigoParametro() {
		super();
	}

	public static final class ClavesCatalogoParametro {

		private ClavesCatalogoParametro() {
			super();
		}

		public static final String endPointServicioParametros = "ENDPOINT_SERVICIO_PARAMETROS";
	}
	
	
	public static final class ClavesPaisEntidad {

		private ClavesPaisEntidad() {
			super();
		}

		public static final String documentoPaisEntidad = CatalogoParametros.obtenerParametroComoTexto("DOCUMENTO_PAIS_ENTIDAD");
	}
	
	
	public static final class ClavesPaisDominioRegla {

		private ClavesPaisDominioRegla() {
			super();
		}

		public static final String longitudMinimaCodigo = "LONGITUD_MINIMA_CODIGO_PAIS";
		public static final String longitudMaximaCodigo = "LONGITUD_MAXIMA_CODIGO_PAIS";
	}
}
