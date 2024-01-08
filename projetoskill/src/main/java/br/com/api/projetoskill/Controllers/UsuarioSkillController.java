package br.com.api.projetoskill.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projetoskill.Repositories.UsuarioSkillRepository;
import br.com.api.projetoskill.Service.UsuarioSkillService;
import br.com.api.projetoskill.dto.UsuarioSkillDTO;
import br.com.api.projetoskill.entities.UsuarioSkill;

@RestController
@RequestMapping("/usuarioskill")
public class UsuarioSkillController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	UsuarioSkillRepository repository;
	
	@Autowired
	private UsuarioSkillService usuarioSkillService;

	@PostMapping("/salvarUserSkill")
	public ResponseEntity<?> SalvarUsuarioSkill(@RequestParam Long userId, @RequestParam Long skillId,
			@RequestParam int level) {
		usuarioSkillService.SalvarUsuarioSkill(userId, skillId, level);
		return new ResponseEntity<>("User skill saved successfully", HttpStatus.OK);
	}

	@PutMapping("/atualizarUserSkill")
	public UsuarioSkillDTO AtualizarAssociacaoSkill(@RequestParam Long id, @RequestParam Long skillId, @RequestParam Integer level) {
	
		return mapper.map( usuarioSkillService.AtualizarAssociacaoSkill(id, level, skillId), UsuarioSkillDTO.class);
	}

	@DeleteMapping("/{id}/skills/{skillId}")
	public void deleteAssociation(@PathVariable Long id, @PathVariable Long skillId) {
		usuarioSkillService.deleteAssociacao(id);
	}
	
	@GetMapping("/listarPorUsuario/{usuarioId}")
	public ResponseEntity<List<UsuarioSkillDTO>> listarPorUsuario(@PathVariable Long usuarioId){
		List<UsuarioSkill> usuarioSkillList = repository.findByUsuarioId(usuarioId);
		List<UsuarioSkillDTO> usuarioSkillDTOList = new ArrayList<>();
		
		for(UsuarioSkill usuarioSkill : usuarioSkillList ) {
			usuarioSkillDTOList.add(mapper.map(usuarioSkill, UsuarioSkillDTO.class));
		}
		return ResponseEntity.ok(usuarioSkillDTOList);
	}
	
}
