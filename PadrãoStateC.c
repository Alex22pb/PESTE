// Simulação do padrão State para um lutador estilo Dragon Ball em C
#include <stdio.h>
#include <string.h>

// Enum para representar os estados do lutador
typedef enum {
    FORMA_NORMAL,
    SSJ1,
    SSJ2,
    SSJ3,
    SSJ_GOD,
    SSJ_BLUE,
    MORTE
} Estado;

const char* getNomeForma(Estado estado) {
    switch (estado) {
        case FORMA_NORMAL: return "Forma Normal";
        case SSJ1: return "SSJ1";
        case SSJ2: return "SSJ2";
        case SSJ3: return "SSJ3";
        case SSJ_GOD: return "SSJ God";
        case SSJ_BLUE: return "SSJ Blue";
        case MORTE: return "Morto";
        default: return "Desconhecido";
    }
}

// Estrutura do lutador
typedef struct {
    char nome[50];
    int ki;
    int vida;
    Estado estado;
    int ataquesConsecutivos;
} Lutador;

void verificarKi(Lutador* l) {
    if ((l->estado == SSJ1 && l->ki < 150) ||
        (l->estado == SSJ2 && l->ki < 200) ||
        (l->estado == SSJ3 && l->ki < 250) ||
        (l->estado == SSJ_GOD && l->ki < 300) ||
        (l->estado == SSJ_BLUE && l->ki < 350)) {

        printf("%s está com Ki insuficiente para manter a forma %s.\n", l->nome, getNomeForma(l->estado));
        regredirForma(l);
    }
}

void transformar(Lutador* l) {
    if (l->estado == MORTE) {
        printf("%s está morto e não pode se transformar.\n", l->nome);
        return;
    }
    if (l->ki >= 350) l->estado = SSJ_BLUE;
    else if (l->ki >= 300) l->estado = SSJ_GOD;
    else if (l->ki >= 250) l->estado = SSJ3;
    else if (l->ki >= 200) l->estado = SSJ2;
    else if (l->ki >= 150) l->estado = SSJ1;
    else l->estado = FORMA_NORMAL;

    printf("%s se transformou em %s!\n", l->nome, getNomeForma(l->estado));
}

void carregarKi(Lutador* l) {
    if (l->estado == MORTE) {
        printf("%s está morto e não pode carregar Ki.\n", l->nome);
        return;
    }
    if (l->estado == SSJ_BLUE) {
        printf("%s já está no nível máximo de transformação.\n", l->nome);
        return;
    }
    l->ki += 50;
    printf("%s carregou 50 de Ki. Total: %d\n", l->nome, l->ki);
}

void regredirForma(Lutador* l) {
    if (l->estado > FORMA_NORMAL && l->estado < MORTE) {
        l->estado--;
        printf("%s regrediu para %s.\n", l->nome, getNomeForma(l->estado));
    }
}

void levarDano(Lutador* l, int dano) {
    if (l->estado == MORTE) {
        printf("%s já está morto.\n", l->nome);
        return;
    }
    l->vida -= dano;
    printf("%s levou %d de dano. Vida restante: %d\n", l->nome, dano, l->vida);
    if (l->vida <= 0) {
        l->estado = MORTE;
        l->vida = 0;
        printf("%s foi derrotado!\n", l->nome);
    }
}

void atacar(Lutador* l) {
    if (l->estado == MORTE) {
        printf("%s está morto e não pode atacar.\n", l->nome);
        return;
    }

    int custoKi;
    switch (l->estado) {
        case FORMA_NORMAL: custoKi = 10; break;
        case SSJ1: custoKi = 20; break;
        case SSJ2: custoKi = 30; break;
        case SSJ3: custoKi = 40; break;
        case SSJ_GOD: custoKi = 50; break;
        case SSJ_BLUE: custoKi = 60; break;
        default: custoKi = 10; break;
    }

    if (l->ki < custoKi) {
        printf("%s não tem Ki suficiente para atacar!\n", l->nome);
        return;
    }

    l->ki -= custoKi;
    l->ataquesConsecutivos++;

    printf("%s atacou em %s! (Ki restante: %d)\n", l->nome, getNomeForma(l->estado), l->ki);

    if (l->ataquesConsecutivos >= 3) {
        if(getNomeForma(l->estado) == FORMA_NORMAL){
            printf("%s atacou com tanta fúria que ultrapassou seus limites!", l->nome);
            printf("Transformando-se espontaneamente para uma nova forma!");
            printf("AAAAAAH! %s vira Super Saiyajin 2!", l->nome);

            l->ki = 200;
            transformar(l);
        }else if(getNomeForma(l->estado) == SSJ1){
            printf("%s atacou com tanta fúria que ultrapassou seus limites!", l->nome);
            printf("Transformando-se espontaneamente para uma nova forma!");
            printf("AAAAAAH! %s vira Super Saiyajin 3!", l->nome);

            l->ki = 250;
            transformar(l);
        }else if(getNomeForma(l->estado) ==  SSJ2){
            printf("%s atacou com tanta fúria que ultrapassou seus limites!", l->nome);
            printf("Transformando-se espontaneamente para uma nova forma!");
            printf("AAAAAAH! %s vira Super Saiyajin Blue!", l->nome);

            l->ki = 300;
            transformar(l);
        }else if(getNomeForma(l->estado) == SSJ3){
            printf("%s atacou com tanta fúria que ultrapassou seus limites!", l->nome);
            printf("Transformando-se espontaneamente para uma nova forma!");
            printf("AAAAAAH! %s vira Super Saiyajin God!", l->nome);

            l->ki = 350;
            transformar(l);
        }else if(getNomeForma(l->estado) == SSJ_BLUE){
            printf("%s liberou um ataque devastador além dos seus limites!\n", l->nome);
            printf("O impacto foi tão grande que ele não conseguiu manter sua transformação...\n");
        }else if(getNomeForma(l->estado) == SSJ_GOD){
            printf("%s liberou um ataque devastador além dos seus limites!\n", l->nome);
            printf("O impacto foi tão grande que ele não conseguiu manter sua transformação...\n");
        }else{
            printf("%s está morto, não consegue fazer ações", l->nome);   
        }
       
        regredirForma(l);
        l->ataquesConsecutivos = 0;
    }
}

void descansar(Lutador* l) {
    l->ataquesConsecutivos = 0;
    printf("%s Descansando, recuperando vida...\n", l->nome);
    l->vida += 10;
}

int main() {
    Lutador goku = {"Goku", 100, 100, FORMA_NORMAL, 0};

    atacar(&goku);
    atacar(&goku);
    atacar(&goku);
    atacar(&goku);

    carregarKi(&goku);
    carregarKi(&goku);
    transformar(&goku);

    atacar(&goku);
    transformar(&goku);

    carregarKi(&goku);
    transformar(&goku);
    atacar(&goku);
    verificarKi(&goku);

    carregarKi(&goku);
    transformar(&goku);
    carregarKi(&goku);
    transformar(&goku);
    atacar(&goku);
    verificarKi(&goku);

    carregarKi(&goku);
    transformar(&goku);
    carregarKi(&goku);
    atacar(&goku);
    verificarKi(&goku);

    descansar(&goku);
    levarDano(&goku, 100);
    verificarKi(&goku);

    return 0;
}
