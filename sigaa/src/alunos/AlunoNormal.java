package sigaa.src.alunos;

public class AlunoNormal extends Aluno {
    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public void exibirDados() {
        System.out.println("[Aluno Normal]");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Curso: " + getCurso());
    }

    @Override
    public boolean podeReceberNota() {
        return true;
    }
}