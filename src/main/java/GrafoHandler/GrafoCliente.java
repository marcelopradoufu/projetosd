/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import GrafoThrift.Aresta;
import GrafoThrift.GrafoHandler;
import GrafoThrift.NotFoundEx;
import GrafoThrift.Vertice;
import TesteConcorrencia.ThreadComandos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarceloPrado, Rhaniel Cristhian
 * 
 *         Nessa classe deve ser feito o menu com as operações do grafo de
 *         adicionar, remover, buscar e excluir vértices e arestas (OBS: essas
 *         operações estão implementadas na classe Handler do pacote
 *         GrafoHandler)
 */
public class GrafoCliente {
	public static void main(String[] args) {
		try {
                        Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);
                        TTransport transport;
                        
                        String ip = "";
                        int porta = 9999;
                        
                        if(args.length == 0){
                            System.out.println("Informe o endereço IP do servidor:");
                            ip = scan.nextLine();
                            
                            System.out.println("Informe o número da porta:");
                            porta = scan.nextInt();
                            scan.nextLine();
                            transport = new TSocket(ip, porta);
                        }
                        else
                            transport = new TSocket(args[0], Integer.parseInt(args[1]));
                            
			
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			GrafoHandler.Client client = new GrafoHandler.Client(protocol);
                        
                        //Ainda não tá funcionando...
                        //client.getInputProtocol().writeString("Thread Main conectada com sucesso!");

			int menu = 1;
			
			// Menu do usuário
			while (menu != 0) {
				System.out.println("######################################################");
				System.out.println("#      Bem vindo ao sistema de criação de Grafo!!    #");
				System.out.println("#           GSI028 - Sistemas Distribuídos           #");
				System.out.println("#         Marcelo Prado e Rhaniel Cristhian          #");
				System.out.println("######################################################");

				System.out.println();
				
				System.out.println("Escolha a operação desejada:");
				// Operações relacionadas as Arestas
				System.out.println("1) Adicionar Aresta");
				System.out.println("2) Busca Aresta");
				System.out.println("3) Atualiza Aresta");
				System.out.println("4) Lista Arestas");
				System.out.println("5) Excluir Aresta");
				System.out.println("6) Listar Arestas de um vértice");

				// Operações relacionadas aos Vértices
				System.out.println("7) Adicionar Vértice");
				System.out.println("8) Busca Vértice");
				System.out.println("9) Atualiza Vértice");
				System.out.println("10) Exclui Vértice");
				System.out.println("11) Lista Vértices");
				System.out.println("12) Lista os vizinhos de um vértice");
				System.out.println("13) Macro p/ verificar controle de concorrência");
                                System.out.println("14) Macro p/ executar todas as operações");

				// Sair
				System.out.println("0) Sair");

				menu = scan.nextInt();
				scan.nextLine();

				int identificador;
				int identificador1;
				int cor;
				String descricao;
				int direcionada;
				double peso;
				Vertice v1;
				Vertice v2;
				Aresta a;
				Vertice v;
				switch (menu) {
				case 1:
					int menuAresta = 0;
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Adicionar Aresta          #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");

					System.out.println();
					// Obriga a escolher uma operação
					while (menuAresta != 3) {
						System.out.println("###########################################################");
						System.out.println("#     1) Criar Aresta apartir de vértices existentes      #");
						System.out.println("#     2) Criar Aresta apartir de vértices novos           #");
						System.out.println("#     3) Sair                                             #");
						menuAresta = scan.nextInt();
						scan.nextLine();
						System.out.println("#                                                         #");
						System.out.println("###########################################################");

						System.out.println();

						// Tipo de criação de arestas
						switch (menuAresta) {
						// criar a partir de vértices existentes
						case 1:
							try {
								System.out.println("###########################################################");
								System.out.println("#       Criar Aresta apartir de vértices existentes       #");
								System.out.print("#  Informe o identificador do primeiro vértice: ");
								identificador = scan.nextInt();
								scan.nextLine();
								v1 = client.buscaVertice(identificador);
								System.out.println("#  O vértice v1 eh: " + v1.toString());
								System.out.print("#  Informe o identificador do segundo vértice: ");
								identificador1 = scan.nextInt();
								scan.nextLine();
								v2 = client.buscaVertice(identificador1);
								System.out.println("#  O vértice v2 eh: " + v2.toString());
								System.out.println("###########################################################");
								System.out.println("#              Dados complementares da Aresta             #");

								System.out.print("#  Informe o peso da Aresta: ");
								peso = scan.nextDouble();
								scan.nextLine();

								System.out.print("#  A aresta é direcionada? (1- Sim / 2- Não): ");
								direcionada = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a descrição da aresta: ");
								descricao = scan.nextLine();

								if (direcionada == 1) {
									a = new Aresta(v1, v2, peso, true, descricao);

								} else {
									a = new Aresta(v1, v2, peso, false, descricao);
								}
								if (client.addAresta(a)) {
									System.out.println("#                Aresta criada com Sucesso                #");
									System.out.println("###########################################################");
								} else {
									System.out.println("#                  Falha ao criar aresta                  #");
									System.out.println("###########################################################");
								}
								menuAresta = 3;
							} catch (NotFoundEx e) {
								System.out.println("#             		Vértice não encontrado                #");
								System.out.println("###########################################################");
							} catch (InputMismatchException e) {
								System.out.println("#              Parâmetro informado errado                #");
								System.out.println("##########################################################");
							}
							System.out.println();
							break;

						// Criar a partir de vértices novos
						case 2:
							try {
								System.out.println("###########################################################");
								System.out.println("#               Criação do Primeiro Vértice               #");
								System.out.print("#  Informe o identificador do primeiro vértice: ");
								identificador = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a cor do primeiro vértice: ");
								cor = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a descrição do primeiro vértice: ");
								descricao = scan.nextLine();

								System.out.print("#  Informe o peso do primeiro vértice: ");
								peso = scan.nextDouble();
								scan.nextLine();

								System.out.println("#               Fim Criação Primeiro Vértice              #");
								System.out.println("###########################################################");

								v1 = new Vertice(identificador, cor, descricao, peso);

								System.out.println();

								System.out.println("###########################################################");
								System.out.println("#                Criação do Segundo Vértice               #");
								System.out.print("#  Informe o identificador do segundo vértice: ");
								identificador = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a cor do segundo vértice: ");
								cor = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a descrição do segundo vértice: ");
								descricao = scan.nextLine();

								System.out.print("#  Informe o peso do segundo vértice: ");
								peso = scan.nextDouble();
								scan.nextLine();

								System.out.println("#               Fim Criação Segundo Vértice               #");
								System.out.println("###########################################################");

								v2 = new Vertice(identificador, cor, descricao, peso);
								client.addVertice(v2);
								client.addVertice(v1);

								System.out.println();

								System.out.println("###########################################################");
								System.out.println("#              Dados complementares da Aresta             #");

								System.out.print("#  Informe o peso da Aresta: ");
								peso = scan.nextDouble();
								scan.nextLine();

								System.out.print("#  A aresta é direcionada? (1- Sim / 2- Não): ");
								direcionada = scan.nextInt();
								scan.nextLine();

								System.out.print("#  Informe a descrição da aresta: ");
								descricao = scan.nextLine();
								if (direcionada == 1) {
									a = new Aresta(v1, v2, peso, true, descricao);

								} else {
									a = new Aresta(v1, v2, peso, false, descricao);
								}
								if (client.addAresta(a)) {
									System.out.println("#                Aresta criada com Sucesso                #");
									System.out.println("###########################################################");
								} else {
									System.out.println("#                  Falha ao criar aresta                  #");
									System.out.println("###########################################################");
								}
								System.out.println();
								menuAresta = 3;
							} catch (InputMismatchException e) {
								System.out.println("#              Parâmetro informado errado                #");
								System.out.println("##########################################################");
							}
							break;
						case 3:
							break;
						default:
							break;
						}
					}
					break;
				case 2:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Buscar Aresta             #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe os identificadores da aresta: ");
						identificador = scan.nextInt();
						identificador1 = scan.nextInt();
						scan.nextLine();

						a = client.buscaAresta(identificador, identificador1);
						if (a != null) {
							System.out.println(a.toString());
						}
					} catch (NotFoundEx nfe) {
						System.out.println("#                 Aresta não encontrado                  #");
						System.out.println("##########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 3:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Atualizar Aresta          #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();

					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe os identificadores da aresta: ");
						identificador = scan.nextInt();
						identificador1 = scan.nextInt();
						scan.nextLine();

						a = client.buscaAresta(identificador, identificador1);

						if (a != null) {
							System.out.print("#  Informe o novo peso da aresta: ");
							peso = scan.nextDouble();
							scan.nextLine();

							System.out.print("#  Informe a nova descrição da aresta: ");
							descricao = scan.nextLine();

							a.setDescricao(descricao);
							a.setPeso(peso);

							if (client.atualizaAresta(a)) {
								System.out.println("#             Aresta atualizado com sucesso               #");
								System.out.println("###########################################################");
							} else {
								System.out.println("#               Falha ao atualizar Aresta                 #");
								System.out.println("###########################################################");
							}
							System.out.println();
						}
					} catch (NotFoundEx nfe) {
						System.out.println("#                 Aresta não encontrado                   #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;

				case 4:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Listar arestas            #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();

					try {
						ArrayList<Aresta> arestas = (ArrayList<Aresta>) client.listarArestas();
						for (Aresta at : arestas)
							System.out.println(at.toString());

						System.out.println();
					} catch (NotFoundEx nfe) {
						System.out.println("#             Não existem arestas cadastradas             #");
						System.out.println("###########################################################");
					}
					break;
				case 5:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Excluir Aresta            #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe os identificadores da aresta: ");
						identificador = scan.nextInt();
						identificador1 = scan.nextInt();
						scan.nextLine();

						if (!client.excluiAresta(identificador, identificador1)) {
							System.out.println("#            Não foi possível excluir a aresta            #");
							System.out.println("###########################################################");
						} else {
							System.out.println("#              Aresta excluída com sucesso                #");
							System.out.println("###########################################################");
						}

					} catch (NotFoundEx nfe) {
						System.out.println("#                 Vértice não encontrado                  #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 6:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#   Opção selecionada --> Listar arestas de um Vértice    #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					System.out.print("#  Informe o identificador do vértice: ");
					identificador = scan.nextInt();
					scan.nextLine();
					try {
						ArrayList<Aresta> arestasV = (ArrayList<Aresta>) client.arestasDoVertice(identificador);
						for (Aresta ares : arestasV)
							System.out.println(ares.toString());

						System.out.println();
					} catch (NotFoundEx nfe) {
						System.out.println("#     Não existem arestas pertencentes a esse vértice     #");
						System.out.println("###########################################################");
					} catch (Exception e) {
						System.out.println("#         Ocorreu alguma falha durante a operação         #");
						System.out.println("###########################################################");
					}
					break;

				case 7:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Adicionar Vértice         #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe o identificador do vértice: ");
						identificador = scan.nextInt();
						scan.nextLine();

						System.out.print("#  Informe a cor do vértice: ");
						cor = scan.nextInt();
						scan.nextLine();

						System.out.print("#  Informe o peso do vértice: ");
						peso = scan.nextDouble();
						scan.nextLine();

						System.out.print("#  Informe a descrição do vértice: ");
						descricao = scan.nextLine();

						v = new Vertice(identificador, cor, descricao, peso);

						if (client.addVertice(v)) {
							System.out.println("#                Vértice criado com sucesso               #");
							System.out.println("###########################################################");
						} else {
							System.out.println("#                 Falha ao criar Vértice                  #");
							System.out.println("###########################################################");
						}
						System.out.println();
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 8:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Buscar Vértice            #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe o identificador do vértice: ");
						identificador = scan.nextInt();
						scan.nextLine();

						v = client.buscaVertice(identificador);

						if (v != null) {
							System.out.println(v.toString());
						}
					} catch (NotFoundEx nfe) {
						System.out.println("#                 Vértice não encontrado                  #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}

					break;
				case 9:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Atualizar Vértice         #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();

					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe o identificador do vértice: ");
						identificador = scan.nextInt();
						scan.nextLine();
						
                                                client.buscaVertice(identificador);
                                                
                                                System.out.print("#  Informe a nova cor do vértice: ");
                                                cor = scan.nextInt();
                                                scan.nextLine();

                                                System.out.print("#  Informe o novo peso do vértice: ");
                                                peso = scan.nextDouble();
                                                scan.nextLine();

                                                System.out.print("#  Informe a nova descrição do vértice: ");
                                                descricao = scan.nextLine();
                                                Vertice vet1 = new Vertice(identificador, cor, descricao, peso);
                                                
                                                if (client.atualizaVertice(vet1)) {
                                                        System.out.println("#             Vértice atualizado com sucesso              #");
                                                        System.out.println("###########################################################");
                                                } else {
                                                        System.out.println("#               Falha ao atualizar Vértice                #");
                                                        System.out.println("###########################################################");
                                                }
                                                System.out.println();

					} catch (NotFoundEx nfe) {
						System.out.println("#                 Vértice não encontrado                  #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 10:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Excluir Vértice           #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					try {
						System.out.println("###########################################################");
						System.out.print("#  Informe o identificador do vértice: ");
						identificador = scan.nextInt();
						scan.nextLine();

						if (!client.excluiVertice(identificador)) {
							System.out.println("#            Não foi possível excluir o vértice           #");
							System.out.println("###########################################################");
						} else {
							System.out.println("#              Vértice excluído com sucesso               #");
							System.out.println("###########################################################");
						}

					} catch (NotFoundEx nfe) {
						System.out.println("#                 Vértice não encontrado                  #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 11:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#         Opção selecionada --> Listar vértices           #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();

					try {
						ArrayList<Vertice> vertices = (ArrayList<Vertice>) client.listarVertices();
						for (Vertice vt : vertices)
							System.out.println(vt.toString());

						System.out.println();
					} catch (NotFoundEx nfe) {
						System.out.println("#             Não existem vértices cadastrados            #");
						System.out.println("###########################################################");
					} catch (InputMismatchException e) {
						System.out.println("#              Parâmetro informado errado                #");
						System.out.println("##########################################################");
					}
					break;
				case 12:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#  Opção selecionada --> Listar os vizinhos de um vértice #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();

					System.out.println("###########################################################");
					System.out.print("#  Informe o identificador do vértice: ");
					identificador = scan.nextInt();
					scan.nextLine();

					try {
						ArrayList<Vertice> vts = (ArrayList<Vertice>) client.vizinhos(identificador);
						for (Vertice vs : vts)
							System.out.println(vs.toString());

						System.out.println();
					} catch (NotFoundEx nfe) {
						System.out.println("#          Vértice informado não possui vizinhos          #");
						System.out.println("###########################################################");
					} catch (Exception e) {
						System.out.println("#         Ocorreu alguma falha durante a operação         #");
						System.out.println("###########################################################");
					}
					break;
                                        
				case 13:
                                    System.out.println("###########################################################");
                                    System.out.println("#                                                         #");
                                    System.out.println("# Opção selecionada --> Macro p/ Controle de Concorrência #");
                                    System.out.println("#                                                         #");
                                    System.out.println("###########################################################");
                                    System.out.println();                                    
                                    
                                    ThreadComandos t1 = new ThreadComandos(ip, porta,"Um");                                    
                                    ThreadComandos t2 = new ThreadComandos(ip, porta,"Dois");
                                    ThreadComandos t3 = new ThreadComandos(ip, porta,"Três");
                                    ThreadComandos t4 = new ThreadComandos(ip, porta,"Quatro");
                                    ThreadComandos t5 = new ThreadComandos(ip, porta,"Cinco");
                                                                    
                                    try {                                                                           
                                        t1.start();
                                        t2.start();
                                        t3.start();
                                        t4.start(); 
                                        t5.start(); 
                                        
                                        t1.join();
                                        t2.join();
                                        t3.join();
                                        t4.join();  
                                        t5.join();  
                                        
                                    } catch (InterruptedException ex) {
                                        System.out.println("Erro no Cliente: Falha ao rodar as threads");
                                    }
                                    
                                    break;                                    
                                case 14:
					System.out.println("###########################################################");
					System.out.println("#                                                         #");
					System.out.println("#        Opção selecionada --> Macro das Operações        #");
					System.out.println("#                                                         #");
					System.out.println("###########################################################");
					System.out.println();
					
					try{
						System.out.println("#  Criando 5 vértices diferentes: ");
						Vertice vet = new Vertice(1, 1, "v1", 1);
						Vertice vet1 = new Vertice(2, 2, "v2", 2);
						Vertice vet2 = new Vertice(3, 3, "v3", 3);
						Vertice vet3 = new Vertice(4, 4, "v4", 4);
						Vertice vet4 = new Vertice(5, 5, "v5", 5);

						if(client.addVertice(vet) && client.addVertice(vet1) && client.addVertice(vet2) && client.addVertice(vet3)
								&& client.addVertice(vet4)){
							System.out.println("#  Vértices Criados com sucesso");
							listaVertices(client);
						}else{
							System.out.println("#  Falha ao criar algum dos vértices");
						}
						System.out.println();
						System.out.println("#  Criando vértice repetido: ");
						if(!client.addVertice(vet)){
							System.out.println("#  Vértice já existe");
							System.out.println();
						}
						
						//OPERAÇÕES DE BUSCA
						System.out.println("#  Operação de busca do vértice");
						System.out.println("#  Buscando o vertice (1, 1, 'v1', 1)");
						v1 = client.buscaVertice(1);
						System.out.println("#  Vértice que foi retornado: "+ v1.toString());
						System.out.println();
						System.out.println("#  Buscando um vértice que não existe (6, 6, 'v6', 6)");
						try{
							v1 = client.buscaVertice(6);
						}catch(Exception e){
							System.out.println("#  Vértice não existe no grafo");
							System.out.println();
						}
						
						//OPERAÇÕES DE ATUALIZAÇÃO DO VÉRTICE
						System.out.println("#  Atualiza o vertice (1, 1, 'v1', 1) para (1, 1, 'v1-Atualizado', 1)");
						System.out.println("#  Vértice antes de ser atualizado: "+vet.toString());

						v1 = client.buscaVertice(1);
						v1.setDescricao("v1-Atualizado");
						if(client.atualizaVertice(v1)){
							System.out.println("#  Vértice atualizado: ");
							listaVertices(client);
						}
						System.out.println();
						System.out.println("#  Tentando Atualizar um vértice que não existe");
						
						if(!client.atualizaVertice(new Vertice(6,6,"v6",6))){
							System.out.println("#  Falha ao atualizar o vértice");
							System.out.println();
						}
						
						//EXCLUI VÉRTICE
                                                try{
                                                    System.out.println("#  Excluindo um vértice");
                                                    System.out.println("#  Vértice a ser excluido: "+client.buscaVertice(5));
                                                }catch(NotFoundEx e){
                                                    System.out.println("#  Vértice não encontrado para exclusão");
                                                }
						
						if(client.excluiVertice(5)){
							System.out.println("#  Vértice foi excluido");
							listaVertices(client);
						}
						System.out.println();
						System.out.println("#  Tentando Excluir um vértice que não existe id 6");
						
						if(!client.excluiVertice(6)){
							System.out.println("#  Falha ao excluir o vértice");
							System.out.println();
						}
						
						//OPERAÇÕES COM ARESTAS
						
						//ADICIONAR ARESTAS
						System.out.println("#  Adicionando 3 artestas novas");
						Aresta ar = new Aresta(vet, vet1, 2, false, "a1");
						Aresta ar1 = new Aresta(vet1, vet2, 3, true, "a2");
						Aresta ar2 = new Aresta(vet2, vet3, 4, true, "a3");
                                                Aresta ar3 = new Aresta(vet1, vet, 3, true, "a4");

						if(client.addAresta(ar2) && client.addAresta(ar1) && client.addAresta(ar)){
							listaArestas(client);
						}
						System.out.println("#  Tentando adicionar aresta repetida");
						if(!(client.addAresta(ar2) || client.addAresta(ar3))) {
							System.out.println("#  Falha ao adicionar aresta");
						}
						System.out.println("");
						//BUSCANDO ARESTA
                                                System.out.println("#  Buscando aresta");
                                                System.out.println("#  Aresta a ser buscada id 1 e 2: ");
                                                try{
                                                    a = client.buscaAresta(1, 2);
                                                    System.out.println("#  Aresta encontrada: "+a.toString());
                                                    System.out.println("#  Tentando buscar uma aresta que não existe id 4 e 6");
                                                    client.buscaAresta(4,6);
                                                }catch(NotFoundEx e){
                                                    System.out.println("#  Aresta não encontrada");
                                                }
                                                
                                                //ATUALIZA ARESTA
                                                System.out.println("");
                                                System.out.println("#  Atualizando aresta");
                                                a = client.buscaAresta(1,2);
                                                System.out.println("#  Aresta a ser atualizada: "+ a.toString());
                                                
                                                a.setDescricao("arestaAtualizada");
                                                
                                                if(client.atualizaAresta(a)){
                                                    System.out.println("#  Aresta atualizada com sucesso");
                                                    listaArestas(client);
                                                }
                                                System.out.println("#  Tentando atualizar Aresta que não existe");
                                                System.out.println("#  Aresta a ser atualizada com id 4 e 5");
                                                if(!client.atualizaAresta(new Aresta(vet,vet3,2,true,"art6"))){
                                                    System.out.println("#  Falha ao atualizar aresta");
                                                }
                                                System.out.println("");
                                                System.out.println("#  Excluindo aresta");
                                                System.out.println("#  Aresta a ser excluida: "+client.buscaAresta(2, 1));
                                                if(client.excluiAresta(2, 1)){
                                                    System.out.println("#  Aresta excluida com sucesso");
                                                    listaArestas(client);
                                                }
                                                System.out.println("#  Tentando excluir aresta que não existe");
                                                System.out.println("#  Tenta excluir uma aresta com id 5 e 6 ");
                                                if(!client.excluiAresta(5, 6)){
                                                    System.out.println("#  Falha ao exclui aresta");
                                                }
					}catch(Exception e){
						
					}
					break;
                                case 15:
                                    //easter egg
                                    for(int i = 1; i <= 50; i++)                                        
                                        client.addVertice(new Vertice(i, i, "v"+i, i));
                                    
                                    break;
				case 0:
					break;
				default:
					break;

				}
			}
			scan.close();
			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
	}
	public static final void listaVertices(GrafoHandler.Client client) throws NotFoundEx, TException{
		ArrayList<Vertice> vertices = (ArrayList<Vertice>) client.listarVertices();
		for (Vertice vt : vertices)
			System.out.println(vt.toString());

		System.out.println();
	}
	public static final void listaArestas(GrafoHandler.Client client) throws NotFoundEx, TException{
		ArrayList<Aresta> arestas = (ArrayList<Aresta>) client.listarArestas();
		for (Aresta at : arestas)
			System.out.println(at.toString());

		System.out.println();
	}
}