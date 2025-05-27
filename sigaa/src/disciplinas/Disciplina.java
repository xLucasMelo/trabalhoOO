package sigaa.src.disciplinas;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String nome;
    private String codigo;
    private String cargaHoraria;
    private List<Disciplina> prerequisitos;
    private List<Turma> turmas;

    public Disciplina(String nome, String codigo, String cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.prerequisitos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }
    public void adicionarPrerequisito(Disciplina disciplina) {
        this.prerequisitos.add(disciplina);
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Disciplina> getPrerequisitos() {
        return prerequisitos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}



