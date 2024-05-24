package a3;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    // Scanner para ler a entrada do usuário
    private static Scanner scanner = new Scanner(System.in);
    
    // Lista para armazenar os objetos Carro
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void main(String[] args) {

        // Cadastro automático de pelo menos 7 objetos Carro
        cadastrarCarrosAutomaticamente();

        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Listar Carros");
            System.out.println("3 - Buscar Carro");
            System.out.println("4 - Sair");
            System.out.print("Digite a opção desejada: ");
            
            // Tratamento de erro para entrada inválida do menu
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número de 1 a 4.");
                scanner.next(); // Limpa a entrada inválida
                opcao = 0;
            }

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    listarCarros();
                    break;
                case 3:
                    buscarCarro();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    // Método para cadastrar um carro
    private static void cadastrarCarro() {
        String modelo, marca, cor, placa, ano;

        System.out.print("Digite o modelo do carro: ");
        modelo = scanner.next();

        System.out.print("Digite a marca do carro: ");
        marca = scanner.next();

        System.out.print("Digite o ano do carro: ");
        ano = scanner.next();

        System.out.print("Digite a cor do carro: ");
        cor = scanner.next();

        System.out.print("Digite a placa do carro: ");
        placa = scanner.next();

        // Cria um novo objeto Carro com os dados informados
        Carro carro = new Carro(modelo, marca, ano, cor, placa);
        // Adiciona o carro à lista de carros
        carros.add(carro);
        System.out.println("Carro cadastrado com sucesso!");
    }

    // Método para listar os carros cadastrados
    private static void listarCarros() {
        System.out.println("\nCarros Cadastrados:");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-25s | %-25s |%n", "Modelo", "Marca", "Ano");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        // Itera sobre a lista de carros e imprime seus atributos
        for (Carro carro : carros) {
            System.out.printf("| %-25s | %-25s | %-25s |%n", carro.getModelo(), carro.getMarca(), carro.getAno());
        }
    }

    // Método para buscar um carro por um atributo
    private static void buscarCarro() {
        System.out.print("\nDigite o atributo do carro que deseja buscar: ");
        String atributo = scanner.next();

        System.out.print("Digite o valor do atributo: ");
        String valor = scanner.next();

        Carro carroEncontrado = null;
        // Itera sobre a lista de carros para encontrar o carro que corresponde ao atributo e valor fornecidos
        for (Carro carro : carros) {
            if (carro.getAtributo(atributo).equalsIgnoreCase(valor)) {
                carroEncontrado = carro;
                break;
            }
        }

        // Exibe as informações do carro encontrado ou uma mensagem informando que o carro não foi encontrado
        if (carroEncontrado != null) {
            System.out.println("\nCarro Encontrado:");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s |%n", "Modelo", "Marca", "Ano", "Cor", "Placa");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s |%n", carroEncontrado.getModelo(), carroEncontrado.getMarca(), carroEncontrado.getAno(), carroEncontrado.getCor(), carroEncontrado.getPlaca());
        } else {
            System.out.println("Carro não encontrado!");
        }
    }

    // Método para cadastrar automaticamente pelo menos 7 objetos Carro
    private static void cadastrarCarrosAutomaticamente() {
        carros.add(new Carro("Civic", "Honda", "2020", "Preto", "ABC1234"));
        carros.add(new Carro("Corolla", "Toyota", "2019", "Branco", "DEF5678"));
        carros.add(new Carro("Model S", "Tesla", "2021", "Vermelho", "GHI9012"));
        carros.add(new Carro("Mustang", "Ford", "2018", "Azul", "JKL3456"));
        carros.add(new Carro("Camaro", "Chevrolet", "2017", "Amarelo", "MNO7890"));
        carros.add(new Carro("A4", "Audi", "2022", "Cinza", "PQR2345"));
        carros.add(new Carro("X5", "BMW", "2016", "Verde", "STU6789"));
    }
}

// Classe Carro representando os atributos de um carro
class Carro {
    // Atributos de um carro
    private String modelo;
    private String marca;
    private String ano;
    private String cor;
    private String placa;

    // Construtor da classe Carro
    public Carro(String modelo, String marca, String ano, String cor, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
    }

    // Métodos getters para acessar os atributos do carro
    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    // Método para obter o valor de um atributo específico
    public String getAtributo(String nomeAtributo) {
        switch (nomeAtributo.toLowerCase()) {
            case "modelo":
                return modelo;
            case "marca":
                return marca;
            case "ano":
                return ano;
            case "cor":
                return cor;
            case "placa":
                return placa;
            default:
                return null;
        }
    }
}