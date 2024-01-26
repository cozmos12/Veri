public abstract class Pay implements Base {
    String  name;

    Pay(String name){

        this.name=name;

    }

    @Override
    public String show(int price){
        System.out.println(name);

        return "Bilet maili{" +

                ", name='" +name + "'" +
                ", price='" + price + "'" +
                "}";
    }

}
