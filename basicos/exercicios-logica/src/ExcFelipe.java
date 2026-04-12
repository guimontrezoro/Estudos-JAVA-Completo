import java.util.Locale;
import java.util.Scanner;

public class ExcFelipe {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Quantos alunos tem na turma?");
            int n = sc.nextInt();
            sc.nextLine();

            int aprovados = 0;
            int recuperacao = 0;
            int reprovados = 0;

            double maiorMedia = -1.0;
            double menorMedia = 11.0;
            String alunoMaiorMedia = "";
            double somaMedias = 0.0;

            for (int i = 0; i < n; i++) {
                System.out.println("Digite o nome do aluno:");
                String nome = sc.nextLine();

                System.out.println("Digite a nota 1:");
                double nota1 = sc.nextDouble();
                while (nota1 < 0 || nota1 > 10) {
                    System.out.println("Nota inválida. Digite a nota 1 novamente:");
                    nota1 = sc.nextDouble();
                }

                System.out.println("Digite a nota 2:");
                double nota2 = sc.nextDouble();
                while (nota2 < 0 || nota2 > 10) {
                    System.out.println("Nota inválida. Digite a nota 2 novamente:");
                    nota2 = sc.nextDouble();
                }

                System.out.println("Digite a nota 3:");
                double nota3 = sc.nextDouble();
                while (nota3 < 0 || nota3 > 10) {
                    System.out.println("Nota inválida. Digite a nota 3 novamente:");
                    nota3 = sc.nextDouble();
                }

                sc.nextLine();

                double media = (nota1 + nota2 + nota3) / 3.0;
                somaMedias += media;

                if (media > maiorMedia) {
                    maiorMedia = media;
                    alunoMaiorMedia = nome;
                }

                if (media < menorMedia) {
                    menorMedia = media;
                }

                System.out.printf("Aluno: %s%n", nome);
                System.out.printf("Média: %.1f%n", media);

                if (media >= 7.0) {
                    aprovados++;
                    System.out.println("Situação: Aprovado");
                } else if (media >= 5.0) {
                    recuperacao++;
                    System.out.println("Situação: Recuperação");
                } else {
                    reprovados++;
                    System.out.println("Situação: Reprovado");
                }

                System.out.println();
            }

            double mediaGeral = somaMedias / n;

            System.out.println("===== RESULTADO FINAL =====");
            System.out.printf("Aprovados: %d%n", aprovados);
            System.out.printf("Recuperação: %d%n", recuperacao);
            System.out.printf("Reprovados: %d%n", reprovados);
            System.out.printf("Maior média da turma: %.1f%n", maiorMedia);
            System.out.printf("Menor média da turma: %.1f%n", menorMedia);
            System.out.printf("Aluno com maior média: %s%n", alunoMaiorMedia);
            System.out.printf("Média geral da turma: %.1f%n", mediaGeral);
        }
    }
}