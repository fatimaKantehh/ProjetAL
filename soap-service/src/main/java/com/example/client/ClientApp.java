package com.example.client;

import java.util.List;
import java.util.Scanner;

import com.example.TokenResponse;
import com.example.User;
import com.example.UserService;

public class ClientApp {
    private static UserService userService;

    public static void main(String[] args) {
        UserServiceImplService service = new UserServiceImplService();
        userService = service.getUserServiceImplPort();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre login:");
        String login = scanner.nextLine();
        System.out.println("Entrez votre mot de passe:");
        String password = scanner.nextLine();

        TokenResponse response = userService.authenticate(login, password);
        String token = response.getToken();

        if (token != null) {
            System.out.println("Authentifié avec succès!");

            while (true) {
                System.out.println("1. Lister les utilisateurs");
                System.out.println("2. Ajouter un utilisateur");
                System.out.println("3. Supprimer un utilisateur");
                System.out.println("4. Mettre à jour un utilisateur");
                System.out.println("5. Quitter");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        listUsers();
                        break;
                    case 2:
                        addUser(scanner);
                        break;
                    case 3:
                        deleteUser(scanner);
                        break;
                    case 4:
                        updateUser(scanner);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide!");
                }
            }
        } else {
            System.out.println("Authentification échouée!");
        }
    }

    private static void listUsers() {
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Utilisateur: " + user.getUsername());
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.println("Entrez le nom d'utilisateur:");
        String username = scanner.nextLine();
        System.out.println("Entrez le mot de passe:");
        String password = scanner.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.addUser(user);
        System.out.println("Utilisateur ajouté avec succès!");
    }

    private static void deleteUser(Scanner scanner) {
        System.out.println("Entrez le nom d'utilisateur à supprimer:");
        String username = scanner.nextLine();
        userService.deleteUser(username);
        System.out.println("Utilisateur supprimé avec succès!");
    }

    private static void updateUser(Scanner scanner) {
        System.out.println("Entrez le nom d'utilisateur à mettre à jour:");
        String username = scanner.nextLine();
        System.out.println("Entrez le nouveau mot de passe:");
        String password = scanner.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.updateUser(user);
        System.out.println("Utilisateur mis à jour avec succès!");
    }
}
