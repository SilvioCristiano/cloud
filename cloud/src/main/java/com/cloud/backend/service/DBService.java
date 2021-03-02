package com.cloud.backend.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.backend.domain.Categoria;
import com.cloud.backend.domain.Cidade;
import com.cloud.backend.domain.Cliente;
import com.cloud.backend.domain.Endereco;
import com.cloud.backend.domain.Estado;
import com.cloud.backend.domain.Iac;
import com.cloud.backend.domain.ItemPedido;
import com.cloud.backend.domain.Pagamento;
import com.cloud.backend.domain.PagamentoComBoleto;
import com.cloud.backend.domain.PagamentoComCartao;
import com.cloud.backend.domain.Pedido;
import com.cloud.backend.domain.enums.EstadoPagamento;
import com.cloud.backend.domain.enums.Perfil;
import com.cloud.backend.domain.enums.TipoCliente;
import com.cloud.backend.repositories.CategoriaRepository;
import com.cloud.backend.repositories.CidadeRepository;
import com.cloud.backend.repositories.ClienteRepository;
import com.cloud.backend.repositories.EnderecoRepository;
import com.cloud.backend.repositories.EstadoRepository;
import com.cloud.backend.repositories.IacRepository;
import com.cloud.backend.repositories.ItemPedidoRepository;
import com.cloud.backend.repositories.PagamentoRepository;
import com.cloud.backend.repositories.PedidoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private IacRepository iacRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Direito de Família");
		Categoria cat2 = new Categoria(null, "Direito de Sucessões");
		Categoria cat3 = new Categoria(null, "Direito Imobiliário");
		Categoria cat4 = new Categoria(null, "Direito Trabalhista");
		Categoria cat5 = new Categoria(null, "Direito Tributário e Fiscal");
		Categoria cat6 = new Categoria(null, "Direito Previdenciário");
		Categoria cat7 = new Categoria(null, "Direito do Consumidor e Responsabilidade Civil");
		
		Iac p1 = new Iac(null, "Computador", 2000.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p2 = new Iac(null, "Impressora", 800.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p3 = new Iac(null, "Mouse", 80.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p4 = new Iac(null, "Mesa de escritório", 300.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p5 = new Iac(null, "Toalha", 50.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p6 = new Iac(null, "Colcha", 200.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p7 = new Iac(null, "TV true color", 1200.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p8 = new Iac(null, "Roçadeira", 800.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p9 = new Iac(null, "Abajour", 100.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p10 = new Iac(null, "Pendente", 180.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p11 = new Iac(null, "Shampoo", 90.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		
		Iac p12 = new Iac(null, "Iac 12", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p13 = new Iac(null, "Iac 13", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p14 = new Iac(null, "Iac 14", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p15 = new Iac(null, "Iac 15", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p16 = new Iac(null, "Iac 16", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p17 = new Iac(null, "Iac 17", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p18 = new Iac(null, "Iac 18", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p19 = new Iac(null, "Iac 19", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p20 = new Iac(null, "Iac 20", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p21 = new Iac(null, "Iac 21", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p22 = new Iac(null, "Iac 22", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p23 = new Iac(null, "Iac 23", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p24 = new Iac(null, "Iac 24", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p25 = new Iac(null, "Iac 25", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p26 = new Iac(null, "Iac 26", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p27 = new Iac(null, "Iac 27", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p28 = new Iac(null, "Iac 28", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p29 = new Iac(null, "Iac 29", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p30 = new Iac(null, "Iac 30", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p31 = new Iac(null, "Iac 31", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p32 = new Iac(null, "Iac 32", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p33 = new Iac(null, "Iac 33", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p34 = new Iac(null, "Iac 34", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p35 = new Iac(null, "Iac 35", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p36 = new Iac(null, "Iac 36", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p37 = new Iac(null, "Iac 37", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p38 = new Iac(null, "Iac 38", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p39 = new Iac(null, "Iac 39", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p40 = new Iac(null, "Iac 40", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p41 = new Iac(null, "Iac 41", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p42 = new Iac(null, "Iac 42", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p43 = new Iac(null, "Iac 43", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p44 = new Iac(null, "Iac 44", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p45 = new Iac(null, "Iac 45", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p46 = new Iac(null, "Iac 46", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p47 = new Iac(null, "Iac 47", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p48 = new Iac(null, "Iac 48", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p49 = new Iac(null, "Iac 49", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		Iac p50 = new Iac(null, "Iac 50", 10.00, "1234", "1111", "sivu@gmail.com", "71377991083");
		
		cat1.getIacs().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);		
		
		cat1.getIacs().addAll(Arrays.asList(p1, p2, p3));
		cat2.getIacs().addAll(Arrays.asList(p2, p4));
		cat3.getIacs().addAll(Arrays.asList(p5, p6));
		cat4.getIacs().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getIacs().addAll(Arrays.asList(p8));
		cat6.getIacs().addAll(Arrays.asList(p9, p10));
		cat7.getIacs().addAll(Arrays.asList(p11));	
	
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
				
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		iacRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		iacRepository.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Silvio Cristiano da Silva", "nelio.cursos@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Cliente cli2 = new Cliente(null, "Ana Costa", "nelio.iftm@gmail.com", "31628382740", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", c1, cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2, cli1);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", c2, cli2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));		
	}
}