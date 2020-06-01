package co.edu.uco.notas.transversal.utilitario.catalogo.mensajes.codigo;

public class CodigoMensaje {
	
	
	private CodigoMensaje() {
		super();
	}
//---------------------------------------------------------------------------------------------------------------------
	public static class MensajesPaisDominioRegla{
		
		private MensajesPaisDominioRegla() {
			super();
		}
		
		public static final String muCodigoPaisDominioVacio = "ERROR_USUARIO_CODIGO_PAIS_DOMININO_VACIO";
		
	}
	
//------------------------------------------------------------------------------------------------------------------
	public static class MensajesPaisDTOEnsamblador{
		
		private MensajesPaisDTOEnsamblador() {
			super();
		}
		
		public static final String muPaisDtoDominioVacioONulo = "ERROR_USUARIO_PAIS_DTO_DOMININO_VACIO_NULO";
		public static final String mtPaisDtoDominioVacioONulo = "ERROR_TECNICO_PAIS_DTO_DOMININO_VACIO_NULO";
		public static final String muPaisDtoDTOVacioONulo = "ERROR_USUARIO_PAIS_DTO_DTO_VACIO_NULO";
		public static final String mtPaisDtoDTOVacioONulo = "ERROR_TECNICO_PAIS_DTO_DTO_VACIO_NULO";
		public static final String muPaisDtoTipoReglaVacioONulo = "ERROR_USUARIO_PAIS_DTO_TIPO_REGLA_VACIO_NULO";
		public static final String mtPaisDtoTipoReglaVacioONulo = "ERROR_TECNICO_PAIS_DTO_TIPO_REGLA_VACIO_NULO";
		
	}
	
//------------------------------------------------------------------------------------------------------------------	
	public static class MensajesPaisEntidadEnsamblador{
		
		private MensajesPaisEntidadEnsamblador() {
			super();
		}
		
		public static final String muPaisEntidadDominioVacioONulo = "ERROR_USUARIO_PAIS_ENTIDAD_DOMININO_VACIO_NULO";
		public static final String mtPaisEntidadDominioVacioONulo = "ERROR_TECNICO_PAIS_ENTIDAD_DOMININO_VACIO_NULO";
		public static final String muPaisEntidadEntidadVacioONulo = "ERROR_USUARIO_PAIS_ENTIDAD_ENTIDAD_VACIO_NULO";
		public static final String mtPaisEntidadEntidadVacioONulo = "ERROR_TECNICO_PAIS_ENTIDAD_ENTIDAD_VACIO_NULO";
		
	}	
	
//------------------------------------------------------------------------------------------------------------------
	public static class MensajesCatalogoParametros{
		
		private  MensajesCatalogoParametros() {
			super();
		}
		
		public static final String muParametroNoEncontrado = "ERROR_USUARIO_PARAMETRO_NO_ENCONTRADO_EN_CACHE_PARAMETROS";
		public static final String mtParametroNoEncontrado = "ERROR_TECNICO_PARAMETRO_NO_ENCONTRADO_EN_CACHE_PARAMETROS";
		public static final String muClaveParametroNoRecibida = "ERROR_USUARIO_CLAVE_PARAMETRO_NO_ENVIADO";
		public static final String mtClaveParametroNoRecibida = "ERROR_TECNICO_CLAVE_PARAMETRO_NO_ENVIADO";
		public static final String muProblemasConvirtiendoParametroAEntero = "ERROR_USUARIO_CONVIRTIENDO_VALOR_A_ENTERO";
		public static final String mtProblemasConvirtiendoParametroAEntero  = "ERROR_TECNICO_CONVIRTIENDO_VALOR_A_ENTERO";
		
	}
	
	
	
	
	
	
	
	
	
}
