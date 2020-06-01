package co.edu.uco.mensajes.transversal.utilitario.catalogo.mensajes.codigo;

public class CodigoMensaje {
	
	
	private CodigoMensaje() {
		super();
	}
	
public static class MensajesCatalogoMensajes{
		
		private  MensajesCatalogoMensajes() {
			super();
		}
		
		public static final String mtProblemaAccesoCacheMensajes = "ERROR_TECNICO_ACCESO_CACHE_MENSAJES";
		public static final String muProblemaAccesoCacheMensajes = "ERROR_USUARIO_ACCESO_CACHE_MENSAJES";
		public static final String mtMensajeNoEncontradoEnCache = "ERROR_TECNICO_MENSAJE_NO_ENCONTRADO_EN_CAHE_MENSAJES";
		public static final String muMensajeNoEncontradoEnCache = "ERROR_USUARIO_MENSAJE_NO_ENCONTRADO_EN_CAHE_MENSAJES";
		public static final String mtCodigoMensajeNoRecibido = "ERROR_TECNICO_CODIGO_MENSAJE_NO_ENVIADO";
		public static final String muCodigoMensajeNoRecibido = "ERROR_USUARIO_CODIGO_MENSAJE_NO_ENVIADO";
		
	}
}
