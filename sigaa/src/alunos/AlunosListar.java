package sigaa.src.alunos;
import java.util.ArrayList;
import java.util.List;

public class AlunosListar {
    private List<Aluno> listaDeAlunos;

    public AlunosListar() {
        this.listaDeAlunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (existeMatricula(aluno.getMatricula())) {
            System.out.println("Erro: Matrícula já cadastrada.");
            return false;
        }
        listaDeAlunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
        return true;
    }

    public boolean existeMatricula(String matricula) {
        for (Aluno a : listaDeAlunos) {
            if (a.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : listaDeAlunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void listarAlunos() {
        if (listaDeAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : listaDeAlunos) {
            a.exibirDados(); // polimorfismo
            System.out.println("------");
        }
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }
}

