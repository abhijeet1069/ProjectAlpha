#include<iostream>

int add(const int& a, const int& b){ //copy by reference but don't change the data pointed to
    return a+b;
}

int main(){
    int a = 12;
    int b = 14;
    //std::cin.get();
    std::cout<<add(a,b)<<std::endl;
}