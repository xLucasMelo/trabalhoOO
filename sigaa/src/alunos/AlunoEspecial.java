package sigaa.src.alunos;

public class AlunoEspecial extends Aluno {
    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public void exibirDados() {
        System.out.println("[Aluno Especial]");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Curso: " + getCurso());
    }

    @Override
    public boolean podeReceberNota() {
        return false;
    }
}