import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        List<Person> students = new ArrayList<Person>();
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nSelecione a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Editar");
            System.out.println("6 - Sair");
            int option = scanner.nextInt();

            switch(option){
                case 1: addStudent(students);
                    break;

                case 2:
                    System.out.println("\nDigite o nome para busca:");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    listStudents(students);
                    break;

                case 4:
                    System.out.println("\nDigite o nome para deletar:");
                    String nameToDelete = scanner.next();
                    deleteStudent(students, nameToDelete);
                    break;

                case 5:
                    System.out.println("\nDigite o nome para editar:");
                    String nameToEdit = scanner.next();
                    editStudent(students, nameToEdit);
                    break;

                case 6:
                    exit = false;
                    break;

                default:
                    System.out.println("\nOpção Invalida");
            }
        }
    }
    //---------------------------Cadastrar-----------------------------------------------------
    private static void addStudent(List<Person> students) {

        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome do estudante");
        student.name = scanner.next();
        students.add(student);
        System.out.println(student.name + " cadastrado.\n");
    }

    //---------------------------Buscar-----------------------------------------------------
    private static void findStudent(List<Person> students, String studentName) {
        var encontrado = false;

        for(int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if(student.name.equals(studentName)){
                encontrado = true;
            }
        }
        if (encontrado == true){
            System.out.println(studentName + " encontrado. \n");
        }else{
            System.out.println(studentName + " Não encontrado. \n");
        }
    }

    //---------------------------Listar-----------------------------------------------------

    private static void listStudents(List<Person> students) {

        System.out.println("\nAlunos Cadastrados:");
        for(int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            System.out.println(student.name);
        }
    }

    //---------------------------Excluir-----------------------------------------------------

    private static void deleteStudent(List<Person> students, String studentName) {
        for (int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if (student.name.equals(studentName)) {
                students.remove(student);
                System.out.println("Aluno " + student.name + " excluido da lista.");
            }
        }
    }

    //---------------------------Editar-----------------------------------------------------

    private static void editStudent(List<Person> students, String studentName) {
        Scanner editName = new Scanner(System.in);
        for (int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if (student.name.equals(studentName)) {
                System.out.println("Digite o novo nome: ");
                student.name = editName.next();
                System.out.println("Nome alterado com sucesso.");
            }
        }
    }
}



