package david.august.luan.servicos;

import static david.august.luan.utils.DataUtils.adicionarDias;

import java.util.Date;

import david.august.luan.entidades.*;

public class LocacaoServico {

	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 2);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar
		return locacao;
	}

	public static void main(String[] arsgs) {

		// Cenário
		LocacaoServico servico = new LocacaoServico();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 10.5);
		
		// acao
		Locacao locacao = servico.alugarFilme(usuario, filme);
		
		// verificacao
		System.out.println(locacao.getUsuario().getNome());
		System.out.println(locacao.getFilme().getNome());
		System.out.println(locacao.getValor());
		System.out.println(locacao.getDataLocacao());
		System.out.println(locacao.getDataRetorno());
	}
}
