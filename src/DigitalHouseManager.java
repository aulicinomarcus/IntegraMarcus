import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Aluno> listaAluno = new ArrayList<>();
    private List<Professor> listaProfessor = new ArrayList<>();
    private List<Curso> listaCurso = new ArrayList<>();
    private List<Matricula> listaMatriculados = new ArrayList<>();

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }


    public List<Matricula> getListaMatriculados() {
        return listaMatriculados;
    }

    public void setListaMatriculados(List<Matricula> listaMatriculados) {
        this.listaMatriculados = listaMatriculados;
    }


    public void registrarCurso(String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos) {
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setCodigoCurso(codigoCurso);
        curso.setQuantidadeMaximaAlunos(quantidadeMaximaDeAlunos);
        listaCurso.add(curso);
    }

    public void removerCurso(Integer codigoCurso) {
        for (Curso curso : listaCurso) {
            if (curso.getCodigoCurso() == codigoCurso) {
                listaCurso.remove(curso);
            }
        }
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor, Integer quantidadeDeHoras) {
        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto();
        professorAdjunto.setNome(nome);
        professorAdjunto.setSobrenome(sobrenome);
        professorAdjunto.setCodProfessor(codigoProfessor);
        professorAdjunto.setQuantidadeDeHotas(quantidadeDeHoras);
        listaProfessor.add(professorAdjunto);
    }
    public void registrarProfessor(String nome, String sobrenome, Integer codigoProfessor, String especialidade) {
        ProfessorTitular professor = new ProfessorTitular();
        professor.setNome(nome);
        professor.setSobrenome(sobrenome);
        professor.setCodProfessor(codigoProfessor);
        professor.setEspecialidade(especialidade);
        listaProfessor.add(professor);
    }
    public void removerProfessor(Integer codigoProfessor) {
        for (Professor professor : listaProfessor) {
            if (professor.getCodProfessor() == codigoProfessor) {
                listaProfessor.remove(professor);
            }
        }
    }

    public void matricularAluno(String nome, String sobrenome, Integer codigoAluno){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);
        aluno.setCodigoAluno(codigoAluno);
        listaAluno.add(aluno);
    }
    public Aluno buscarAlunoPorCodigo(Integer codigoAluno){
        Aluno umAluno = null;
        for (Aluno aluno : listaAluno){
            if (aluno.getCodigoAluno().equals(codigoAluno)){
                umAluno = aluno;
            }
        }
        return umAluno;
    }
    public Curso buscarCursoPorCodigo (Integer codigoCurso){
        for (Curso curso : listaCurso){
            if (curso.getCodigoCurso().equals(codigoCurso)){
                return curso;
            }
        }
        return null;
    }

    public Professor buscarProfessor (int codProfessor){
        for (Professor professor : listaProfessor){
            if (professor.equals(codProfessor)){
                return professor;
            }
        }
        return null;
    }

    public ProfessorTitular buscarProfesorTitular (Integer codigoProfessorTitular){
        for (Professor professor : listaProfessor){
            if (professor.getCodProfessor().equals(codigoProfessorTitular)){
                return (ProfessorTitular) professor;
            }
        }
        return null;
    }

    public ProfessorAdjunto buscarProfesorAdjunto (Integer codigoProfessorAdjunto){
        for (Professor professor : listaProfessor){
            if (professor.getCodProfessor().equals(codigoProfessorAdjunto)){
                return (ProfessorAdjunto) professor;
            }
        }
        return null;
    }


    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        Matricula matricula = new Matricula ();
        Aluno aluno = buscarAlunoPorCodigo(codigoAluno);
        matricula.setAluno(aluno);
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        matricula.setCurso (curso);
        listaMatriculados.add(matricula);
        System.out.println("Matrícula Realizada");
        curso.adicionarUmAluno(aluno);
    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        curso.setProfessorAdjunto(buscarProfesorAdjunto(codigoProfessorAdjunto));
        curso.setProfessorTitular(buscarProfesorTitular(codigoProfessorTitular));


    }

}



