package br.com.api.projetoskill.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.projetoskill.Repositories.SkillRepository;
import br.com.api.projetoskill.Repositories.UsuarioRepository;
import br.com.api.projetoskill.Repositories.UsuarioSkillRepository;
import br.com.api.projetoskill.entities.Skill;
import br.com.api.projetoskill.entities.Usuario;
import br.com.api.projetoskill.entities.UsuarioSkill;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UsuarioSkillService {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private UsuarioSkillRepository usuarioSkillRepository;

	public void SalvarUsuarioSkill(Long userId, Long skillId, int level) {
		Usuario usuario = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));

		UsuarioSkill usuarioSkill = new UsuarioSkill();
		usuarioSkill.setUsuario(usuario);
		usuarioSkill.setSkill(skill);
		usuarioSkill.setLevel(level);

		usuarioSkillRepository.save(usuarioSkill);
	}

	public UsuarioSkill AtualizarAssociacaoSkill(Long id, Integer level, Long skillId) {
		UsuarioSkill usuarioSkill = usuarioSkillRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Não existe associação"));
		usuarioSkill.setLevel(level);
		return usuarioSkillRepository.save(usuarioSkill);
	}

	public void deleteAssociacao(Long id) {
		usuarioSkillRepository.deleteById(id);
	}

}
