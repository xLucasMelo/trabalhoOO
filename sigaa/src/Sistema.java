import java.util.Scanner;
import sigaa.src.alunos.*;
static AlunosListar alunosListar = new AlunosListar();

public void main() {
        int opcaoSelecionada;
        do {
            System.out.println("======MENU PRINCIPAL========");
            System.out.println("1.Aluno");
            System.out.println("2.Disciplinas/Turmas");
            System.out.println("3.Avaliações/Frequências");
            System.out.println("4.Sair");
            System.out.print("Escolha uma Opção:");
            opcaoSelecionada = leitorNumero();

            switch (opcaoSelecionada) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuDisciplina();
                    break;
                case 3:
                    System.out.println("O que deseja?");

                    break;
                case 4:
                    System.out.println("Salvando alterações e saindo....");
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcaoSelecionada !=4);
}
public static void menuAluno() {
    int opcaoAluno;
    do {
        System.out.println("***Menu Aluno***");
        System.out.println("1.Aluno Normal");
        System.out.println("2.Auno Especial");
        System.out.println("3.Voltar");
        System.out.print("Escolha a opção desejada:");
        opcaoAluno = leitorNumero();

        switch (opcaoAluno) {
            case 1:
                cadastrarAluno(false);
                break;
            case 2:
                cadastrarAluno(true);
                break;
            case 3:
                alunosListar.listarAlunos();
                break;
            case 4:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    } while (opcaoAluno !=4);
}

public static void menuDisciplina() {
    int opcaoDisciplina;
    do {
        System.out.println("1.Cadastrar Disciplinas");
        System.out.println("2.Listar Turmas");
        System.out.println("3.Voltar");
        System.out.print("O que deseja?");
        opcaoDisciplina = leitorNumero();
        switch (opcaoDisciplina) {
            case 1:
                //cadstrar disciplinas
                break;
            case 2:
                //listar Turmas
                break;
            case 3:
                System.out.println("Voltando...");
        }
    } while (opcaoDisciplina !=3);
}

public static int leitorNumero() {
    int numero;
    Scanner leitor = new Scanner(System.in);
    numero = leitor.nextInt();
    return numero;
}
public static void cadastrarAluno(boolean especial) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Matrícula: ");
    String matricula = sc.nextLine();

    System.out.print("Curso: ");
    String curso = sc.nextLine();

    Aluno aluno;
    if (especial) {
        aluno = new AlunoEspecial(nome, matricula, curso);
    } else {
        aluno = new AlunoNormal(nome, matricula, curso);
    }

    alunosListar.adicionarAluno(aluno);
}
