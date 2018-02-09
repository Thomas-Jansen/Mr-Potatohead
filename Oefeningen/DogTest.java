class Flea {
   
   // Properties of the class...
   private String name;
   
   // Constructor of the class...
   public Flea(String aName) {
      name = aName;
   }

   // Methods of the class...
   public String toString() {
      return "I am a flea called " + name;
   }

}

class Dog {

   // Properties of the class...
   private String name;
   private int    age;
   public Flea   dogsFlea;

   // Constructor of the class...
   public Dog(String aName, int anAge, Flea aFlea) {
      name     = aName;
      age      = anAge;
      dogsFlea = aFlea;
   }
   
   public String toString() {
        return "I am a dog called " + name + ", I am " 
        + age + " years old and this is my flea: " + dogsFlea;
   }

}

class DogOwner {
    
    private String  name;
    private int     salary;
    public Dog     ownersDog;
    
    public DogOwner (String aName, int aSalary, Dog anOwnersDog) {
        name        = aName;
        salary      = aSalary;
        ownersDog   = anOwnersDog;
    }
    
    public String toString() {
        return "I am " + name + ", my salary is $" + salary + 
        " and this is my dog: " + ownersDog;
    }
}

class DogTest {

   // The main method is the point of entry into the program...
   public static void main(String[] args) {
       Flea p = new Flea("Pop");
       Flea s = new Flea("Squeak");
       Flea z = new Flea("Zip");
       
       Dog r = new Dog("Rex",2,p);
       Dog j = new Dog("Jimbo",4,s);
       Dog f = new Dog("Fido",3,z);
       
       DogOwner a = new DogOwner("Angus",10000,r);
       DogOwner b = new DogOwner("Brian",25000,j);
       DogOwner c = new DogOwner("Charles",40000,f);
       
       System.out.println(r.toString());
       System.out.println(j.toString());
       System.out.println(f.toString());
       
       System.out.println(a.toString());
       System.out.println(b.toString());
       System.out.println(c.toString());
       
       System.out.println(a.ownersDog.dogsFlea.toString());

   }
}
