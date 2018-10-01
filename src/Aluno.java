import java.util.Objects;

public class Aluno {
    private String nome;
    private String sobrenome;
    private Integer codigoAluno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(codigoAluno, aluno.codigoAluno);
    }

    public boolean equals(Aluno aluno){
        return this.codigoAluno.equals(aluno.getCodigoAluno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoAluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAlunoAluno) {
        this.codigoAluno = codigoAlunoAluno;
    }
}
