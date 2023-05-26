#include<cstdlib>
#include<cstdio>
#include<iostream>
#include<iomanip>

template<typename T>
class Vec3{
    T x,y,z;
    public:
        Vec3(): x(5), y(5), z(5){};
};

int main(int argc, char **argv){
    Vec3<int> v;
    //std::cout<<v.x<<std::endl;
    return 0;
}