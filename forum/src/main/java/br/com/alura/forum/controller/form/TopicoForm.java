package br.com.alura.forum.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TopicoForm {

	@NotNull @NotBlank @Size(min = 5)
	private String titulo;
	@NotNull @NotBlank @Size(min = 10)
	private String mensagem;
	@NotNull @NotBlank
	private String nomeCurso;

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository) {
		// TODO Auto-generated method stub
			Curso curso = cursoRepository.findByNome(nomeCurso);
			return new Topico(titulo, mensagem, curso);
		}
}
