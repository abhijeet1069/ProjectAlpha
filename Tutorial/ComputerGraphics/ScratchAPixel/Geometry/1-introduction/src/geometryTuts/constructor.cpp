#include<iostream>

class Vec3{
    public:
        Vec3() : x(0), y(0), z(0){}
        int x,y,z;
};

int main(int argc, char **argv){
     Vec3 v;
    std::cout<<v.x<<std::endl;
}