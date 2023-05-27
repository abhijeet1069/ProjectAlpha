#include<iostream>
#include<type_traits>

/*
Restrict template to work with same type.
add(2,3)
    Result:5
add(2,2.5) or add(2,"hello")
    Error: conflicting types for parameter T
*/
template<typename T> 
T add(T a, T b){
    std::cout<<"Homogenous called\n";
    return a+b;
}

template<typename T, typename U>
std::common_type<T,U> add(T a, U b){
    std::cout<<"Heterogenous called\n";
    return a+b;
}

int main(){

    T result1 = add(2,3.5);
    std::cout<<"Result: "<<result1<<'\n';
    return 0;
}