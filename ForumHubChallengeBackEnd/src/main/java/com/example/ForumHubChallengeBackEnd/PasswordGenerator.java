package com.example.ForumHubChallengeBackEnd;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordGenerator {

    public static void main(String[] args) {
        // Cria uma nova instância do BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // A senha que você quer criptografar
        String rawPassword = "12345";

        // Criptografa a senha
        String encodedPassword = encoder.encode(rawPassword);

        // Imprime a senha criptografada no console
        System.out.println("Senha original: " + rawPassword);
        System.out.println("Senha criptografada: " + encodedPassword);
    }
}
