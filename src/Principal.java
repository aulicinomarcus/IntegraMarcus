import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();

        //Criar Professores e Prof. adjuntos
        digitalHouseManager.registrarProfessor("Marcelo", "Cepera", 1801, "Mobile");
        digitalHouseManager.registrarProfessor("Peter", "Baldanza", 1807, "Mobile");
        digitalHouseManager.registrarProfessor("Julio", "Linarde", 1802, "Full Stack");
        digitalHouseManager.registrarProfessor("Ricardo", "Mitre", 1805, "Full Stack");
        digitalHouseManager.registrarProfessorAdjunto("Carlos", "Campos", 1803, 0);
        digitalHouseManager.registrarProfessorAdjunto("Sandra", "Santos", 1804, 0);
        digitalHouseManager.registrarProfessorAdjunto("Paulo", "Meirelles", 1806, 0);


        System.out.println("Professor:");
        System.out.println("_____________________");

        for (int i = 0; i < digitalHouseManager.getListaProfessor().size(); i++) {
            System.out.println(digitalHouseManager.getListaProfessor().get(i).getNome() + (" ") + digitalHouseManager.getListaProfessor().get(i).getSobrenome() + (" ")
                    + digitalHouseManager.getListaProfessor().get(i).getCodProfessor());
        }
        System.out.println("________________________");


        // Criar Lista Alunos


        digitalHouseManager.matricularAluno("Debora", "Castanheira", 2248);
        digitalHouseManager.matricularAluno("Mario", "Lamerinha", 2245);
        digitalHouseManager.matricularAluno("Patricia", "Wagner", 2251);
        digitalHouseManager.matricularAluno("Pedro", "Fernandes", 2255);
        digitalHouseManager.matricularAluno("Ricardo", "Bianchi", 2244);
        digitalHouseManager.matricularAluno("Gabriela", "Figueredo", 2265);
        digitalHouseManager.matricularAluno("Carla", "Crescente", 2249);
        digitalHouseManager.matricularAluno("Telma", "Rocha", 2271);
        digitalHouseManager.matricularAluno("Antonio luiz", "Costa", 2262);
        digitalHouseManager.matricularAluno("Rubens", "Sevarolli", 2266);


        System.out.println("Lista Alunos");
        System.out.println("_____________________");

        for (int i = 0; i < digitalHouseManager.getListaAluno().size(); i++) {
            System.out.println(digitalHouseManager.getListaAluno().get(i).getNome() + (" ") + digitalHouseManager.getListaAluno().get(i).getSobrenome()
                    + (" ") + digitalHouseManager.getListaAluno().get(i).getCodigoAluno());
        }
        System.out.println("________________________");

        // Criar Curso e Alocar Professor


        digitalHouseManager.registrarCurso("Full Stack", 2001, 3);
        digitalHouseManager.buscarCursoPorCodigo(2001).setProfessorTitular(digitalHouseManager.buscarProfesorTitular(1802));
        digitalHouseManager.buscarCursoPorCodigo(2001).setProfessorAdjunto(digitalHouseManager.buscarProfesorAdjunto(1803));
        digitalHouseManager.registrarCurso("Androide", 2002, 2);
        digitalHouseManager.buscarCursoPorCodigo(2002).setProfessorTitular(digitalHouseManager.buscarProfesorTitular(1801));
        digitalHouseManager.buscarCursoPorCodigo(2002).setProfessorAdjunto(digitalHouseManager.buscarProfesorAdjunto(1806));

        System.out.println("Curso");
        System.out.println("_____________________");

        for (int i = 0; i < digitalHouseManager.getListaCurso().size(); i++) {
            System.out.println(digitalHouseManager.getListaCurso().get(i).getNome() + (" ") + digitalHouseManager.getListaCurso().get(i).getCodigoCurso()
                    + (" ") + digitalHouseManager.getListaCurso().get(i).getQuantidadeMaximaAlunos());
        }
        System.out.println("________________________");

        digitalHouseManager.matricularAluno(2245, 2001);
        digitalHouseManager.matricularAluno(2248, 2001);
        digitalHouseManager.matricularAluno(2244, 2001);
        digitalHouseManager.matricularAluno(2251, 2002);
        digitalHouseManager.matricularAluno(2245, 2002);


        // Lista de Cursos
        for (Curso curso : digitalHouseManager.getListaCurso()) {
            System.out.println("_____________________________");
            System.out.print("Curso  ");
            System.out.println(curso.getNome());
            System.out.print("Código Curso ");
            System.out.println(curso.getCodigoCurso());
            System.out.print("Prof. titular ");
            System.out.println(curso.getProfessorTitular().getNome() + " " + curso.getProfessorTitular().getSobrenome());
            System.out.println("Prof. Adjunto " + curso.getProfessorAdjunto().getNome() + " " + curso.getProfessorAdjunto().getSobrenome());
            System.out.println("Nº Máximo de Alunos  " + curso.getQuantidadeMaximaAlunos());
            System.out.println(" Lista de Alunos : ");
            for (Aluno aluno : curso.getListaAluno()) {
                System.out.println("nome: " + aluno.getNome() + " " + aluno.getSobrenome() + " " + aluno.getCodigoAluno());
            }
        }
        int opcao = 0;
        System.out.println("Bem Vindo A Digital Marcus");
        System.out.println("Digite o numero ");
        System.out.println("1 - Consulta a Lista");
        System.out.println("2 - Adicionar Aluno");
        System.out.println("3 - Consultar Professor");
        System.out.println("4 - Remover Profesor");
        System.out.println("0 - Sair");

        opcao = scanner.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println(digitalHouseManager.getListaAluno().size());
                    for (Aluno aluno : digitalHouseManager.getListaAluno()) {
                        System.out.println(aluno.getNome());
                    }
                    break;

                case 2:
                    System.out.println("Digite o Nome do Aluno");
                    String nomeAluno = scanner.next();
                    System.out.println("Digite Sobrenome do Aluno");
                    String sobrenomeAluno = scanner.next();
                    System.out.println("digite código Aluno");
                    int codigoAluno = scanner.nextInt();
                    digitalHouseManager.matricularAluno(nomeAluno, sobrenomeAluno, codigoAluno);

                case 3:
                    System.out.println("Digite o código do Professor ");
                    Integer codigoProfessorProfessor = scanner.nextInt();
                    System.out.println(digitalHouseManager.buscarProfessor(codigoProfessorProfessor).getNome());


                case 4:
                    System.out.println("Digite o Código do Professor");
                    Integer codigoProfessor = scanner.nextInt();
                    digitalHouseManager.removerProfessor(codigoProfessor);

            }
            System.out.println("Bem Vindo A Digital Marcus");
            System.out.println("Digite o numero ");
            System.out.println("1 - Consulta a Lista");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("3 - Consultar Professor");
            System.out.println("4 - Remover Profesor");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
        }

    }
}




