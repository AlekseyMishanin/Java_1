package ru.mylife.AnimalHomeWork;

public abstract class Animal implements Print{
    private String name;

    Animal (){ this.name="Unknown"; }
    Animal (String name){ this.name=name; }

    public String getName() {return name;}

    abstract boolean run (int length);
    abstract boolean swim (int length);
    abstract boolean jump (double height);
}

class Cat extends Animal implements CatConst{

    Cat(){super();}
    Cat(String name) {super(name);}

    @Override
    public boolean run (int length){return length<MAXRUNCAT&&length>0 ? true : false;};
    @Override
    public boolean swim (int length){return length<MAXSWIMCAT&&length>0 ? true : false;};
    @Override
    public boolean jump (double height){return height<MAXJUMPCAT&&height>0 ? true : false;};

    @Override
    public void printClass() {
        System.out.println("Семейство: Cat");
    }
}

class Dog extends Animal implements DogConst{

    Dog(){super();}
    Dog(String name) {super(name);}

    @Override
    public boolean run (int length){return length<MAXRUNDOG&&length>0 ? true : false;};
    @Override
    public boolean swim (int length){return length<MAXSWIMDOG&&length>0 ? true : false;};
    @Override
    public boolean jump (double height){return height<MAXJUMPDOG&&height>0 ? true : false;};

    @Override
    public void printClass() {
        System.out.println("Семейство: Dog");
    }
}

class Bulldog extends Dog implements BulldogConst {

    Bulldog(){super();}
    Bulldog(String name) {super(name);}

    @Override
    public boolean run (int length){return length<MAXRUNBULLDOG&&length>0 ? true : false;};
    @Override
    public boolean swim (int length){return length<MAXSWIMBULLDOG&&length>0 ? true : false;};
    @Override
    public boolean jump (double height){return height<MAXJUMPBULLDOG&&height>0 ? true : false;};

    @Override
    public void printClass() {
        super.printClass();
        System.out.println("Порода: Bulldog");
    }
}

class Azawak extends Dog implements AzawakConst{

    Azawak(){super();}
    Azawak(String name) {super(name);}

    @Override
    public boolean run (int length){return length<MAXRUNAZAWAK&&length>0 ? true : false;};
    @Override
    public boolean swim (int length){return length<MAXSWIMAZAWAK&&length>0 ? true : false;};
    @Override
    public boolean jump (double height){return height<MAXJUMPAZAWAK&&height>0 ? true : false;};

    @Override
    public void printClass() {
        super.printClass();
        System.out.println("Порода: Azawak");
    }
}

interface CatConst{
    int MAXRUNCAT = 200;
    int MAXSWIMCAT = 0;
    double MAXJUMPCAT = 2.0;
}

interface DogConst{
    int MAXRUNDOG = 500;
    int MAXSWIMDOG = 10;
    double MAXJUMPDOG = 0.5;
}

interface BulldogConst{
    int MAXRUNBULLDOG = 400;
    int MAXSWIMBULLDOG = 10;
    double MAXJUMPBULLDOG = 0.5;
}

interface AzawakConst{
    int MAXRUNAZAWAK = 600;
    int MAXSWIMAZAWAK = 10;
    double MAXJUMPAZAWAK = 0.5;
}

interface Print {
    default void printClass() {;}
}
