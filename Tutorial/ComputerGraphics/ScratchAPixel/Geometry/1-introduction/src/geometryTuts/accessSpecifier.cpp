#include<iostream>

/*
Access specifiers are used to define the visibility and accessibility of class members from
different parts of a program.
1) Public - Accessed by objects of the classs as well as outside the class.
2) Private - Accessible only within the class, not even child classes.
3) Protected - Accessible within the class itself and derieved classes.
*/

class MyClass{
    public:
        int publicVar;
        void functionA(){
            std::cout<<"From public function : Hello World!!\n";
        }

    private:
        int privateVar;
        void functionB(){
            std::cout<<"From private function : Hello World\n";
        }

    protected:
        int protectedVar;
        void functionC(){
            std::cout<<"From protected function : HelloWorld\n";
        }
};

class Child:public MyClass{
    public:
        void callFunctionC(){
            functionC();
        }
};

int main(){
    Child obj;
    obj.callFunctionC();
    return 0;
}