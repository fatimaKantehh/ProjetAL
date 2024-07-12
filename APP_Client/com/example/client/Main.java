package com.example.client;

import java.util.Scanner;

public class Main {
    private static UserService userService = new UserServiceImpl();
    private static RestClient restClient = new RestClient();
    private static SoapClient soapClient = new SoapClient(userService);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez vous authentifier.");
        System.out.print("Nom d'utilisateur : ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        String token = soapClient.authenticateUser(username, password);

        if (token != null) {
            System.out.println("Authentification réussie ! Bienvenue, administrateur.");
            adminMenu(scanner, username, token);
        } else {
            System.out.println("Authentification échouée ou vous n'êtes pas administrateur.");
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner, String username, String token) {
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Administrateur :");
            System.out.println("1. Lister les utilisateurs");
            System.out.println("2. Ajouter un utilisateur");
            System.out.println("3. Mettre à jour un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Voir les articles");
            System.out.println("6. Voir les articles par catégorie");
            System.out.println("7. Voir les articles groupés par catégorie");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choice) {
                case 1:
                    System.out.println("Liste des utilisateurs :");
                    soapClient.listUsers().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Nom d'utilisateur : ");
                    String newUser = scanner.nextLine();
                    System.out.print("Mot de passe : ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Rôle (admin/user) : ");
                    String newRole = scanner.nextLine();
                    soapClient.addUser(new User(newUser, newPassword, newRole), token);
                    System.out.println("Utilisateur ajouté.");
                    break;
                case 3:
                    System.out.print("Nom d'utilisateur : ");
                    String updateUser = scanner.nextLine();
                    System.out.print("Nouveau mot de passe : ");
                    String updatePassword = scanner.nextLine();
                    System.out.print("Nouveau rôle (admin/user) : ");
                    String updateRole = scanner.nextLine();
                    soapClient.updateUser(new User(updateUser, updatePassword, updateRole), token);
                    System.out.println("Utilisateur mis à jour.");
                    break;
                case 4:
                    System.out.print("Nom d'utilisateur à supprimer : ");
                    String deleteUser = scanner.nextLine();
                    soapClient.deleteUser(deleteUser, token);
                    System.out.println("Utilisateur supprimé.");
                    break;
                case 5:
                    System.out.println("Articles :");
                    restClient.getArticles().forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Catégorie : ");
                    String category = scanner.nextLine();
                    System.out.println("Articles de la catégorie " + category + " :");
                    restClient.getArticlesByCategory(category).forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Articles groupés par catégorie :");
                    restClient.getArticlesGroupedByCategory().forEach(cat -> {
                        System.out.println("Catégorie : " + cat.getCategory());
                        cat.getArticles().forEach(System.out::println);
                    });
                    break;
                case 8:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }
        }
    }
}
