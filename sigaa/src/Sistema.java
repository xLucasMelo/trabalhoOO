
import sigaa.src.disciplinas.Disciplina;
import sigaa.src.disciplinas.Turma;
import sigaa.src.alunos.*;
import java.util.*;

private static List<Disciplina> disciplinas = new ArrayList<>();
static AlunosListar alunosListar = new AlunosListar();
private static Scanner sc = new Scanner(System.in);
private static List<Turma> turmas = new ArrayList<>();

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
        System.out.println("1.Cadastrar Turmas");
        System.out.println("2.Listar Turmas");
        System.out.println("3.Cadastrar Disciplina");
        System.out.println("4.Voltar");
        System.out.print("O que deseja?");
        opcaoDisciplina = leitorNumero();
        switch (opcaoDisciplina) {
            case 1:
                cadastrarTurma();
                break;
            case 2:
                listarTurmas();
                break;
            case 3:
                cadastrarDisciplina();
            case 4:
                System.out.println("Voltando...");
        }
    } while (opcaoDisciplina !=4);
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
private static void cadastrarTurma() {
    System.out.print("Código da turma: ");
    String codigoTurma = sc.nextLine();

    System.out.print("Código da disciplina: ");
    String codDisciplina = sc.nextLine();

    Disciplina disciplinaEncontrada = null;
    for (Disciplina d : disciplinas) {
        if (d.getCodigo().equals(codDisciplina)) {
            disciplinaEncontrada = d;
            break;
        }
    }

    if (disciplinaEncontrada == null) {
        System.out.println("Disciplina não encontrada. Cadastre a disciplina primeiro.");
        return;
    }

    System.out.print("Professor responsável: ");
    String professor = sc.nextLine();

    System.out.print("Número de vagas: ");
    int vagas = Integer.parseInt(sc.nextLine());

    Turma turma = new Turma(codigoTurma, disciplinaEncontrada, professor, vagas);
    turmas.add(turma);
    disciplinaEncontrada.getTurmas().add(turma);

    System.out.println("Turma cadastrada com sucesso!");
}
private static void listarTurmas() {
    if (turmas.isEmpty()) {
        System.out.println("Nenhuma turma cadastrada.");
        return;
    }

    System.out.println("\n--- Lista de Turmas ---");
    for (Turma turma : turmas) {
        System.out.println("Código da Turma: " + turma.getCodigoTurma());
        System.out.println("Disciplina: " + turma.getDisciplina().getNome());
        System.out.println("Professor: " + turma.getProfessor());
        System.out.println("Vagas Restantes: " + turma.getVagasRestantes());
        System.out.println("----------------------");
    }
}
private static void cadastrarDisciplina() {
    System.out.print("Nome da disciplina: ");
    String nome = sc.nextLine();

    System.out.print("Código da disciplina: ");
    String codigo = sc.nextLine();

    System.out.print("Carga horária: ");
    String cargaHoraria = sc.nextLine();

    Disciplina novaDisciplina = new Disciplina(nome, codigo, cargaHoraria);

    System.out.print("Essa disciplina possui pré-requisitos? (s/n): ");
    String possuiPrerequisitos = sc.nextLine();

    while (possuiPrerequisitos.equalsIgnoreCase("s")) {
        System.out.print("Informe o código do pré-requisito: ");
        String codPrereq = sc.nextLine();

        Disciplina prereqEncontrado = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codPrereq)) {
                prereqEncontrado = d;
                break;
            }
        }

        if (prereqEncontrado != null) {
            novaDisciplina.adicionarPrerequisito(prereqEncontrado);
            System.out.println("Pré-requisito adicionado.");
        } else {
            System.out.println("Pré-requisito não encontrado.");
        }

        System.out.print("Deseja adicionar outro pré-requisito? (s/n): ");
        possuiPrerequisitos = sc.nextLine();
    }

    disciplinas.add(novaDisciplina);
    System.out.println("Disciplina cadastrada com sucesso!");
}
