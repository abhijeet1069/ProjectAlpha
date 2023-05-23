#include<stdio.h>

typedef float Point[3];

int main(){
    
    Point corners[8] = {
        {1,-1,-5},
        {1,-1,-3},
        {1,1,-5},
        {1,1,-3},
        {-1,-1,-5},
        {-1,-1,-3},
        {-1,1,-5},
        {-1,1,-3}
    };

    for(int i = 0; i < 8; i++){
        float x_proj = corners[i][0]/-corners[i][2];
        float y_proj = corners[i][1]/-corners[i][2];
        printf("Projected corners: x: %f y: %f \n",x_proj,y_proj);
    }
    return 0;
}