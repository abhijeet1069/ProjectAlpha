#include<iostream>

class Complex{
    private:
        int real, imag;
    public:
        Complex(int r = 0, int i = 0){
            real = r;
            imag = i;
        }

    void print(){
        printf("%d+%di\n",real,imag);
    }

    friend Complex operator+(Complex const& c1, Complex const& c2);
};

Complex operator+(Complex const& c1, Complex const& c2){
    return Complex(c1.real+c2.real , c1.imag+c2.imag);
}

int main(int argc, char **argv){
    Complex c1(10,5) , c2(2,4);
    Complex c3 = c1+c2;

    c3.print();
    return 0;
}