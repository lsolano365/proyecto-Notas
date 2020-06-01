package co.edu.uco.notas.negocio.negocio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.notas.datos.dao.PaisDAO;
import co.edu.uco.notas.entidad.PaisEntidad;
import co.edu.uco.notas.negocio.dominio.PaisDominio;
import co.edu.uco.notas.negocio.dominio.reglas.enumeracion.TipoReglaEnum;
import co.edu.uco.notas.negocio.ensamblador.entidad.implementacion.PaisEntidadEnsamblador;
import co.edu.uco.notas.negocio.negocio.PaisNegocio;
import co.edu.uco.notas.transversal.exception.NotasExcepcion;
import co.edu.uco.transversal.enumerador.LugarEnum;
import co.edu.uco.transversal.utilitario.UtilObjeto;
import co.edu.uco.transversal.utilitario.UtilTexto;

@Service
public class PaisNegocioImpl implements PaisNegocio{
	
	@Autowired 
	private PaisDAO paisDao;

	@Override
	public void crear(PaisDominio dominio) {
		
		//1. No exista un pais por su codigo 
		PaisDominio paisDominioConsulta = PaisDominio.crear(dominio.getCodigo(), UtilTexto.VACIO,TipoReglaEnum.CONSULTAR);
		List<PaisDominio> paisesResultado = consultar(paisDominioConsulta);
		
		if (!paisesResultado.isEmpty()) {
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, "Ya existe un país creado con el código " + dominio.getCodigo());
		}
		
		//2. No exista un pais con el mismo nombre
		paisDominioConsulta = PaisDominio.crear(UtilTexto.VACIO, dominio.getNombre(), TipoReglaEnum.CONSULTAR);
		paisesResultado = consultar(paisDominioConsulta);
		
		if (!paisesResultado.isEmpty()) {
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, "Ya existe un país creado con el nombre " + dominio.getNombre());
		}
		paisDao.insert(PaisEntidadEnsamblador.obtenerInstancia().ensamblarEntidad(dominio));
		
	}

	@Override
	public void actualizar(PaisDominio dominio) {
		//1. Debe existir un pais con el codigo enviado
		PaisDominio paisDominioConsulta = PaisDominio.crear(dominio.getCodigo(), UtilTexto.VACIO, TipoReglaEnum.CONSULTAR);
		List<PaisDominio> paisesResultado = consultar(paisDominioConsulta);
		
		if (paisesResultado.isEmpty()) {
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, "No existe un país para modificar con el código " + dominio.getCodigo());
		}
			//2. no debe existir otro pais (con otro codigo diferente)con el mismo nombre
		paisDominioConsulta = PaisDominio.crear(UtilTexto.VACIO, dominio.getNombre(), TipoReglaEnum.CONSULTAR);
		paisesResultado = consultar(paisDominioConsulta);
		if (paisesResultado.isEmpty()) {
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, "No existe un país para modificar con el nombre " + dominio.getNombre());
		}
		paisDao.save(PaisEntidadEnsamblador.obtenerInstancia().ensamblarEntidad(dominio));
		
	}

	@Override
	public void eliminar(PaisDominio dominio) {
		//1. Debe existir el codigo del pais a eliminar 
		PaisDominio paisDominioConsulta = PaisDominio.crear(dominio.getCodigo(), UtilTexto.VACIO,TipoReglaEnum.CONSULTAR);
		List<PaisDominio> paisesResultado = consultar(paisDominioConsulta);
		
		if (paisesResultado.isEmpty()) {
			throw NotasExcepcion.crear(LugarEnum.NEGOCIO, "No existe un país para eliminar con el código" + dominio.getCodigo());
		}
		
		paisDao.delete(PaisEntidadEnsamblador.obtenerInstancia().ensamblarEntidad(dominio));
		
	}

	@Override
	public List<PaisDominio> consultar(PaisDominio dominio) {
		// Falta implementar los filtros de consulta:
		//Por nombre
		//Por codigo
		List<PaisEntidad> listaEntidades = paisDao.findAll();
		return PaisEntidadEnsamblador.obtenerInstancia().ensamblarListaDominios(listaEntidades);
	}

	
	
	
	
	
	
	
	
	
	
}
