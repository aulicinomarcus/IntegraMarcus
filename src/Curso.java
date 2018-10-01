import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private Integer codigoCurso;
    private List<Aluno> ListaAluno = new ArrayList<>();
    private Integer quantidadeMaximaAlunos;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;





    public Integer getQuantidadeMaximaAlunos() {
        return quantidadeMaximaAlunos;
    }

    public void setQuantidadeMaximaAlunos(Integer quantidadeMaximaAlunos) {
        this.quantidadeMaximaAlunos = quantidadeMaximaAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public List<Aluno> getListaAluno() {
        return ListaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        ListaAluno = listaAluno;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public Boolean adicionarUmAluno (Aluno umAluno) {
        Integer quantidaeDeAlunoMatriculado = getListaAluno().size();
        if (quantidaeDeAlunoMatriculado < quantidadeMaximaAlunos) {
            getListaAluno().add(umAluno);
            System.out.println(" Aluno matrículado com sucesso ");
            return true;
        } else {
            System.out.println("Sem vagas nesta turma");
            return  false;
        }
    }

    public void removerAluno(Aluno umAluno){
        getListaAluno().remove(umAluno);

    }
}

