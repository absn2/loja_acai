package Produtos;

import ExcecoesProduto.NumeroLimiteExcedido;
import ExcecoesProduto.ProdutoJaCadastrado;
import ExcecoesProduto.ProdutoNaoCadastrado;
import ExcecoesProduto.ProdutoNaoEncontrado;
import Produtos.ClasseProdutos;

public class RepositorioProdutoArray implements RepositorioProduto {
	private ClasseProdutos[] produtos;
	private int quantidadeProdutos;

	public RepositorioProdutoArray() {
		this.produtos = new ClasseProdutos[50];
		this.quantidadeProdutos = 0;
	}

	public void inserir(ClasseProdutos ContaProduto) throws NumeroLimiteExcedido, ProdutoJaCadastrado {
		boolean existe = this.existe(ContaProduto.getNome());
		if (existe = false) {
			boolean parar = false;
			for (int aux = 0; aux < this.produtos.length && parar == false; aux++) {
				if (aux == this.produtos.length) {
					throw new NumeroLimiteExcedido();
				} else {
					if (this.produtos[aux] != null) {
						continue;
					} else {
						this.produtos[aux] = ContaProduto;
						this.quantidadeProdutos = aux;
						parar = true;
					}
				}

			}

		} else {
			throw new ProdutoJaCadastrado();
		}

	}

	public void remover(String nomeProduto) throws ProdutoNaoCadastrado {
		boolean existe = this.existe(nomeProduto);
		if (existe = true) {
			boolean parar = false;
			for (int aux = 0; aux < this.produtos.length && parar == false; aux++) {
				if (this.produtos[aux].getNome().equals(nomeProduto)) {
					this.produtos[aux] = null;
					for (int j = aux + 1; j < this.produtos.length; j++) {
						this.produtos[aux] = this.produtos[j];
					}
					this.quantidadeProdutos -= 1;
					parar = true;
				}

			}

		} else {
			throw new ProdutoNaoCadastrado();
		}

	}

	public boolean existe(String nomeProduto) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (produtos[i] != null && this.produtos[i].getNome().equals(nomeProduto)) {
				return true;
			} else {
				continue;
			}
		}

		return false;
	}

	public ClasseProdutos procurar(String nomeProduto) throws ProdutoNaoEncontrado {
		boolean existe = this.existe(nomeProduto);
		if (existe == true) {
			boolean parar = false;
			ClasseProdutos procurar = null;
			for (int i = 0; i < this.produtos.length && parar == false; i++) {
				if (this.produtos[i].getNome().equals(nomeProduto)) {
					procurar = produtos[i];
					parar = true;
				}
			}
			return procurar;
		} else {
			throw new ProdutoNaoEncontrado();
		}

	}

	public void atualizar(ClasseProdutos ContaProduto) {
		boolean existe = this.existe(ContaProduto.getNome());
		if (existe == true) {
			boolean parar = false;
			for (int i = 0; i < this.produtos.length && parar == false; i++) {
				if (this.produtos[i].getNome().equals(ContaProduto.getNome())) {
					this.produtos[i] = ContaProduto;
					parar = true;
				}
			}
		}

	}

}
