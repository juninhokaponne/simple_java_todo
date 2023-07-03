import java.util.ArrayList;
import java.util.Scanner;

class TodoList {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("== Lista de Tarefas ==");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Marcar tarefa como concluída");
            System.out.println("3. Exibir todas tarefas");
            System.out.println("4. Exibir tarefas Pendentes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o nome da tarefa: ");
                    String taskName = scanner.nextLine();

                    if (taskName.trim().isEmpty()) {
                        System.out.println("Valor de entrada inválido!");
                    } else if (taskName.matches(".*\\d.*")) {
                        System.out.println("Entrada inválida. O nome da tarefa não pode conter números.");
                    } else {
                        Task task = new Task(taskName);
                        tasks.add(task);
                        System.out.println("Tarefa adicionada com sucesso!");
                    }
                    break;
                }
                case 2 -> {
                    System.out.print("Digite o número da tarefa concluída: ");
                    int completedTaskIndex = scanner.nextInt();
                    if (completedTaskIndex >= 0 && completedTaskIndex < tasks.size()) {
                        Task completedTask = tasks.get(completedTaskIndex);
                        completedTask.setCompleted(true);
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Número de tarefa inválido!");
                    }
                }
                case 3 -> {
                    System.out.println("== Tarefas ==");

                    if(tasks.size() == 0){
                        System.out.println("Nenhuma tarefa ainda adicionada!");
                    }

                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        String status = t.isCompleted() ? "[X]" : "[ ]";
                        System.out.println(i + ". " + status + " " + t.getName());
                    }
                }
                case 4 -> {
                    System.out.println("== Tarefas pendentes ==");
                    boolean hasPendingTasks = false;
                    for(int i = 0; i < tasks.size(); i++){
                        Task task = tasks.get(i);
                        if(!task.isCompleted()) {
                            System.out.println(i + ". " + task.getName());
                            hasPendingTasks = true;
                        }
                    }

                    if(!hasPendingTasks) {
                        System.out.println("Nenhuma tarefa pendente.");
                    }

                    break;
                }
                case 5 -> exit = true;
                default -> System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
