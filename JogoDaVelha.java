package jogodavelha;

import java.util.Scanner;

import java.util.Random;

public class JogoDaVelha {

    public static int verifica(char[][] jogo, String player) {
        int l, c, ganhoX = 0, ganhoO = 0;
        for (l = 0; l < jogo.length; l++) {
            for (c = 0; c < jogo[0].length; c++) {
                if (jogo[l][c] == 'X') {
                    ganhoX++;
                }
                if (jogo[l][c] == 'O') {
                    ganhoO++;
                }
                if (ganhoX == 3 || ganhoO == 3) {
                    System.out.println("O jogador " + player + " venceu!");
                    return 1;
                }
            }
            ganhoX = 0;
            ganhoO = 0;
        }
        for (c = 0; c < jogo[0].length; c++) {
            for (l = 0; l < jogo.length; l++) {
                if (jogo[l][c] == 'X') {
                    ganhoX++;
                }
                if (jogo[l][c] == 'O') {
                    ganhoO++;
                }
                if (ganhoX == 3 || ganhoO == 3) {
                    System.out.println("O jogador " + player + " venceu!");
                    return 1;
                }
            }
            ganhoX = 0;
            ganhoO = 0;
        }
        if (jogo[0][0] == 'X' && jogo[1][1] == 'X' && jogo[2][2] == 'X') {
            System.out.println("O jogador " + player + " venceu!");
            return 1;
        }
        if (jogo[0][0] == 'O' && jogo[1][1] == 'O' && jogo[2][2] == 'O') {
            System.out.println("O jogador " + player + " venceu!");
            return 1;
        }
        if (jogo[0][2] == 'X' && jogo[1][1] == 'X' && jogo[2][0] == 'X') {
            System.out.println("O jogador " + player + " venceu!");
            return 1;
        }
        if (jogo[0][2] == 'O' && jogo[1][1] == 'O' && jogo[2][0] == 'O') {
            System.out.println("O jogador " + player + " venceu!");
            return 1;
        }
        return 0;
    }

    public static void exibe(char[][] jogo) {
        int c, l, i = 0, j = 0;
        for (l = 0; l < jogo.length; l++) {
            for (c = 0; c < jogo[l].length; c++) {
                if (jogo[l][c] == 'X' || jogo[l][c] == 'O') {
                    System.out.print(jogo[l][c]);
                } else {
                    System.out.print(" ");
                }
                i++;
                if (i < 3) {
                    System.out.print("|");
                }
            }
            i = 0;
            System.out.println();
            j++;
            if (j < 3) {
                System.out.println("- - -");
            }
        }
    }

    public static int rodada(char[][] jogo, String player, int loop) {
        Scanner input = new Scanner(System.in);
        int l, c;
        System.out.println("=============================");
        System.out.println(player + " é sua vez de jogar.");
        System.out.print("Informe a linha: ");
        l = input.nextInt();
        input.nextLine();
        System.out.print("Informe a coluna: ");
        c = input.nextInt();
        input.nextLine();
        while (jogo[l][c] == 'X' || jogo[l][c] == 'O') {
            System.out.println("=============================");
            System.out.println("Erro, esta posição já está marcada. Escolha outra:");
            System.out.print("Informe a linha: ");
            l = input.nextInt();
            input.nextLine();
            System.out.print("Informe a coluna: ");
            c = input.nextInt();
            input.nextLine();
        }
        if (loop == 0) {
            jogo[l][c] = 'X';
            return 1;
        } else {
            jogo[l][c] = 'O';
            return 0;
        }
    }

    public static int rodadaFacil(char[][] jogo, int loop) {
        Random sorteio = new Random();
        int l, c;
        System.out.println("=============================");
        System.out.println("É a vez do computador de jogar.");
        l = sorteio.nextInt(3);
        c = sorteio.nextInt(3);
        while (jogo[l][c] == 'X' || jogo[l][c] == 'O') {
            l = sorteio.nextInt(3);
            c = sorteio.nextInt(3);
        }
        jogo[l][c] = 'O';
        return 0;
    }

    public static int rodadaDificil(char[][] jogo, int loop) {
        Random sorteio = new Random();
        int l, c;
        System.out.println("=============================");
        System.out.println("É a vez do computador de jogar.");
        for (l = 0; l < jogo.length; l++) {
            if (jogo[l][0] == 'O' && jogo[l][1] == 'O') {
                if (jogo[l][2] != 'X' && jogo[l][2] != 'O') {
                    jogo[l][2] = 'O';
                    return 0;
                }
            }
            if (jogo[l][0] == 'O' && jogo[l][2] == 'O') {
                if (jogo[l][1] != 'X' && jogo[l][1] != 'O') {
                    jogo[l][1] = 'O';
                    return 0;
                }
            }
            if (jogo[l][1] == 'O' && jogo[l][2] == 'O') {
                if (jogo[l][0] != 'X' && jogo[l][0] != 'O') {
                    jogo[l][0] = 'O';
                    return 0;
                }
            }
        }
        for (c = 0; c < jogo[0].length; c++) {
            if (jogo[0][c] == 'O' && jogo[1][c] == 'O') {
                if (jogo[2][c] != 'X' && jogo[2][c] != 'O') {
                    jogo[2][c] = 'O';
                    return 0;
                }
            }
            if (jogo[0][c] == 'O' && jogo[2][c] == 'O') {
                if (jogo[1][c] != 'X' && jogo[1][c] != 'O') {
                    jogo[1][c] = 'O';
                    return 0;
                }
            }
            if (jogo[1][c] == 'O' && jogo[2][c] == 'O') {
                if (jogo[0][c] != 'X' && jogo[0][c] != 'O') {
                    jogo[0][c] = 'O';
                    return 0;
                }
            }
        }
        if (jogo[0][0] == 'O' && jogo[2][2] == 'O') {
            if (jogo[1][1] != 'X' && jogo[1][1] != 'O') {
                jogo[1][1] = 'O';
                return 0;
            }
        }
        if (jogo[1][1] == 'O' && jogo[2][2] == 'O') {
            if (jogo[0][0] != 'X' && jogo[0][0] != 'O') {
                jogo[0][0] = 'O';
                return 0;
            }
        }
        if (jogo[0][0] == 'O' && jogo[1][1] == 'O') {
            if (jogo[2][2] != 'X' && jogo[2][2] != 'O') {
                jogo[2][2] = 'O';
                return 0;
            }
        }
        if (jogo[0][2] == 'O' && jogo[2][0] == 'O') {
            if (jogo[1][1] != 'X' && jogo[1][1] != 'O') {
                jogo[1][1] = 'O';
                return 0;
            }
        }
        if (jogo[2][0] == 'O' && jogo[1][1] == 'O') {
            if (jogo[0][2] != 'X' && jogo[0][2] != 'O') {
                jogo[0][2] = 'O';
                return 0;
            }
        }
        if (jogo[0][2] == 'O' && jogo[1][1] == 'O') {
            if (jogo[2][0] != 'X' && jogo[2][0] != 'O') {
                jogo[2][0] = 'O';
                return 0;
            }
        }
        for (l = 0; l < jogo.length; l++) {
            if (jogo[l][0] == 'X' && jogo[l][1] == 'X') {
                if (jogo[l][2] != 'X' && jogo[l][2] != 'O') {
                    jogo[l][2] = 'O';
                    return 0;
                }
            }
            if (jogo[l][0] == 'X' && jogo[l][2] == 'X') {
                if (jogo[l][1] != 'X' && jogo[l][1] != 'O') {
                    jogo[l][1] = 'O';
                    return 0;
                }
            }
            if (jogo[l][1] == 'X' && jogo[l][2] == 'X') {
                if (jogo[l][0] != 'X' && jogo[l][0] != 'O') {
                    jogo[l][0] = 'O';
                    return 0;
                }
            }
        }
        for (c = 0; c < jogo[0].length; c++) {
            if (jogo[0][c] == 'X' && jogo[1][c] == 'X') {
                if (jogo[2][c] != 'X' && jogo[2][c] != 'O') {
                    jogo[2][c] = 'O';
                    return 0;
                }
            }
            if (jogo[0][c] == 'X' && jogo[2][c] == 'X') {
                if (jogo[1][c] != 'X' && jogo[1][c] != 'O') {
                    jogo[1][c] = 'O';
                    return 0;
                }
            }
            if (jogo[1][c] == 'X' && jogo[2][c] == 'X') {
                if (jogo[0][c] != 'X' && jogo[0][c] != 'O') {
                    jogo[0][c] = 'O';
                    return 0;
                }
            }
        }
        if (jogo[0][0] == 'X' && jogo[2][2] == 'X') {
            if (jogo[1][1] != 'X' && jogo[1][1] != 'O') {
                jogo[1][1] = 'O';
                return 0;
            }
        }
        if (jogo[1][1] == 'X' && jogo[2][2] == 'X') {
            if (jogo[0][0] != 'X' && jogo[0][0] != 'O') {
                jogo[0][0] = 'O';
                return 0;
            }
        }
        if (jogo[0][0] == 'X' && jogo[1][1] == 'X') {
            if (jogo[2][2] != 'X' && jogo[2][2] != 'O') {
                jogo[2][2] = 'O';
                return 0;
            }
        }
        if (jogo[0][2] == 'X' && jogo[2][0] == 'X') {
            if (jogo[1][1] != 'X' && jogo[1][1] != 'O') {
                jogo[1][1] = 'O';
                return 0;
            }
        }
        if (jogo[2][0] == 'X' && jogo[1][1] == 'X') {
            if (jogo[0][2] != 'X' && jogo[0][2] != 'O') {
                jogo[0][2] = 'O';
                return 0;
            }
        }
        if (jogo[0][2] == 'X' && jogo[1][1] == 'X') {
            if (jogo[2][0] != 'X' && jogo[2][0] != 'O') {
                jogo[2][0] = 'O';
                return 0;
            }
        }
        l = sorteio.nextInt(3);
        c = sorteio.nextInt(3);
        while (jogo[l][c] == 'X' || jogo[l][c] == 'O') {
            l = sorteio.nextInt(3);
            c = sorteio.nextInt(3);
        }
        jogo[l][c] = 'O';
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random sorteio = new Random();
        char[][] jogo;
        int opcao, loop, result, rodadas;
        String playerA, playerB;
        while (true) {
            jogo = new char[3][3];
            loop = 1;
            result = 0;
            rodadas = 0;
            System.out.println("Jogo da Velha");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    while (loop == 1) {
                        System.out.println("=============================");
                        System.out.println("Jogo da Velha");
                        System.out.println("1 - Um jogador");
                        System.out.println("2 - Dois jogadores");
                        System.out.print("Digite sua opção: ");
                        opcao = input.nextInt();
                        input.nextLine();
                        switch (opcao) {
                            case 1:
                                System.out.print("Informe o nome do jogador humano: ");
                                playerA = input.next();
                                input.nextLine();
                                while (loop == 1) {
                                    System.out.println("NÍVEL DO JOGO");
                                    System.out.println("1 - Fácil");
                                    System.out.println("2 - Difícil");
                                    System.out.print("Digite sua opção: ");
                                    opcao = input.nextInt();
                                    input.nextLine();
                                    switch (opcao) {
                                        case 1:
                                            loop = 0;
                                            System.out.println("Sorteando quem vai começar...");
                                            opcao = sorteio.nextInt(2);
                                            if (opcao == 0) {
                                                System.out.println(playerA + " começa!");
                                                loop = 0;
                                                while (true) {
                                                    if (loop == 0) {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodada(jogo, playerA, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, playerA);
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodadaFacil(jogo, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, "Computador");
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("O computador começa!");
                                                loop = 1;
                                                while (true) {
                                                    if (loop == 0) {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodada(jogo, playerA, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, playerA);
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodadaFacil(jogo, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, "Computador");
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            loop = 0;
                                            System.out.println("Sorteando quem vai começar...");
                                            opcao = sorteio.nextInt(2);
                                            if (opcao == 0) {
                                                System.out.println(playerA + " começa!");
                                                loop = 0;
                                                while (true) {
                                                    if (loop == 0) {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodada(jogo, playerA, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, playerA);
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodadaDificil(jogo, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, "Computador");
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("O computador começa!");
                                                loop = 1;
                                                while (true) {
                                                    if (loop == 0) {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodada(jogo, playerA, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, playerA);
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        if (result == 0) {
                                                            if (rodadas == 9) {
                                                                System.out.println("EMPATE!");
                                                                result = 1;
                                                                loop = 0;
                                                                break;
                                                            }
                                                            loop = rodadaDificil(jogo, loop);
                                                            exibe(jogo);
                                                            result = verifica(jogo, "Computador");
                                                            rodadas++;
                                                        } else {
                                                            loop = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Erro, informe uma opção válida.");
                                            System.out.println("=============================");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                loop = 0;
                                System.out.print("Informe o nome do jogador 1: ");
                                playerA = input.next();
                                input.nextLine();
                                System.out.print("Informe o nome do jogador 2: ");
                                playerB = input.next();
                                input.nextLine();
                                System.out.println("Sorteando quem vai começar...");
                                opcao = sorteio.nextInt(2);
                                if (opcao == 0) {
                                    System.out.println(playerA + " começa!");
                                    loop = 0;
                                    while (true) {
                                        if (loop == 0) {
                                            if (result == 0) {
                                                if (rodadas == 9) {
                                                    System.out.println("EMPATE!");
                                                    result = 1;
                                                    loop = 0;
                                                    break;
                                                }
                                                loop = rodada(jogo, playerA, loop);
                                                exibe(jogo);
                                                result = verifica(jogo, playerA);
                                                rodadas++;
                                            } else {
                                                loop = 0;
                                                break;
                                            }
                                        } else {
                                            if (result == 0) {
                                                if (rodadas == 9) {
                                                    System.out.println("EMPATE!");
                                                    result = 1;
                                                    loop = 0;
                                                    break;
                                                }
                                                loop = rodada(jogo, playerB, loop);
                                                exibe(jogo);
                                                result = verifica(jogo, playerB);
                                                rodadas++;
                                            } else {
                                                loop = 0;
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println(playerB + " começa!");
                                    loop = 1;
                                    while (true) {
                                        if (loop == 0) {
                                            if (result == 0) {
                                                if (rodadas == 9) {
                                                    System.out.println("EMPATE!");
                                                    result = 1;
                                                    loop = 0;
                                                    break;
                                                }
                                                loop = rodada(jogo, playerA, loop);
                                                exibe(jogo);
                                                result = verifica(jogo, playerA);
                                                rodadas++;
                                            } else {
                                                loop = 0;
                                                break;
                                            }
                                        } else {
                                            if (result == 0) {
                                                if (rodadas == 9) {
                                                    System.out.println("EMPATE!");
                                                    result = 1;
                                                    loop = 0;
                                                    break;
                                                }
                                                loop = rodada(jogo, playerB, loop);
                                                exibe(jogo);
                                                result = verifica(jogo, playerB);
                                                rodadas++;
                                            } else {
                                                loop = 0;
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Erro, informe uma opção válida.");
                                System.out.println("=============================");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Obrigado por jogar o Jogo da velha. "
                            + "Criado por Djalma Henrique.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erro, informe uma opção válida.");
                    System.out.println("=============================");
                    break;
            }
        }
    }
}