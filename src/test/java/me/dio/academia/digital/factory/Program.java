package me.dio.academia.digital.factory;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soma = 0;
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int menor = n1 < n2 ? n1 : n2;
        int maior = n1 > n2 ? n1 : n2;

        for(int i = menor; i <= maior; i++){
            if( i % 13 == 0)
                continue;
            soma += i;
        }

        System.out.println(soma);
    }

}
