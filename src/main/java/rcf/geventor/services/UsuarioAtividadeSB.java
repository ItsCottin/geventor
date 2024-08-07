package rcf.geventor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.etechoracio.common.business.BaseSB;
import rcf.geventor.data.UsuarioAtividadeDAO;
import rcf.geventor.data.UsuarioAtividade;

@Service
public class UsuarioAtividadeSB extends BaseSB {
	
	private UsuarioAtividadeDAO usuarioAtividadeDAO;
	
	protected void postConstructImpl() {
		usuarioAtividadeDAO = getDAO(UsuarioAtividadeDAO.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insert(UsuarioAtividade usuAtiv) {
		usuarioAtividadeDAO.save(usuAtiv);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findIncritosNoEventoByUsuarioLogado(Long idUsuario) {
		return usuarioAtividadeDAO.findIncritosNoEventoByUsuarioLogado(idUsuario);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findIncritosNoEventoByUsuarioLogadoV2(Long idUsuario) {
		return usuarioAtividadeDAO.findIncritosNoEventoByUsuarioLogadoV2(idUsuario);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findIncritosNoEventoByUsuarioLogadoByStatus(Long idUsuario, String status) {
		return usuarioAtividadeDAO.findIncritosNoEventoByUsuarioLogadoByStatus(idUsuario, status);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Optional<UsuarioAtividade> findSeEstaInscritoNaAtividade(Long idAtividade, Long idUsuario) {
		return usuarioAtividadeDAO.findSeEstaInscritoNaAtividade(idUsuario, idAtividade);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findMyInscricoes(Long idUsuario) {
		return usuarioAtividadeDAO.findMyInscricoes(idUsuario);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findMyInscricoesMenosStatus(Long idUsuario, String status) {
		return usuarioAtividadeDAO.findMyInscricoesMenosStatus(idUsuario, status);
	}
	
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findAllInscritosByIdAtividade(Long idAtiv) {
		return usuarioAtividadeDAO.findAllInscritosByIdAtividade(idAtiv);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UsuarioAtividade> findAllInscritosByIdAtividadeAndStatus(String status, Long idAtiv) {
		return usuarioAtividadeDAO.findAllInscritosByIdAtividadeAndStatus(status, idAtiv);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(UsuarioAtividade usuAtiv) {
		usuarioAtividadeDAO.delete(usuAtiv);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteByIdAtiv(long idAtiv) {
		usuarioAtividadeDAO.deleteByIdAtiv(idAtiv);
	}

	public Page<UsuarioAtividade> list(Pageable pageable) {
		return usuarioAtividadeDAO.findAll(pageable);
	}

	public Page<UsuarioAtividade> list(Pageable pageable, Specification<UsuarioAtividade> filter) {
		return usuarioAtividadeDAO.findAll(filter, pageable);
	}

}
