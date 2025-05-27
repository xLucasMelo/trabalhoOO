package sigaa.src.disciplinas;

import sigaa.src.alunos.Aluno;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String codigoTurma;
    private Disciplina disciplina;
    private String professor;
    private int vagas;
    private List<Aluno> matriculados;

    public Turma(String codigoTurma, Disciplina disciplina, String professor, int vagas) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.vagas = vagas;
        this.matriculados = new ArrayList<>();
    }

    public boolean matricularAluno(Aluno aluno) {
        if (matriculados.size() < vagas) {
            matriculados.add(aluno);
            return true;
        }
        return false;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public int getVagasRestantes() {
        return vagas - matriculados.size();
    }

    public List<Aluno> getMatriculados() {
        return matriculados;
    }

    @Override
    public String toString() {
        return "Turma: " + codigoTurma + " | Disciplina: " + disciplina.getNome() +
                " | Professor: " + professor + " | Vagas restantes: " + getVagasRestantes();
    }
}