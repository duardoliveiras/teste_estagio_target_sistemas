#include <stdio.h>

int fb(int x){
   if(x == 0){
    return 0;
   }
   else if(x == 1){
    return 1;
   }
   else{
    return fb(x-1) + fb(x-2);
   }
}

int main(void) {

    int x;
    int pertence = 0;
    printf("digite um numero:\n");
    scanf("%d",&x);
    
    for(int i = 0; i <= x; i++){
        int k = fb(i);
        if(k == x){
            printf("o numero %d pertence a sequencia de fibonacci",k);
            pertence = 1;
            break;
        }
    }
    if(!pertence){
        printf("o numero %d nao pertence a sequencia de fibonacci",x);
    }

    return 0;
}