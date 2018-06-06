package ex03_polymorphism.problem;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Lion(), new Snake()};
        ((Cat) animals[0]).printName();
//        ((Cat) animals[1]).printName();       // 에러 발생 : 형변환
//        ((Snake) animals[2]).printName();     // 에러 발생 : 형변환

//        animals[2].ride();      // 에러 발생
        animals[3].printName();
    }

}

// 적절한 형변환이 이루어지지 않았기때문에 에러가 발생하게 된다.