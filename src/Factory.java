public class Factory {

    public Pay create(String name){
        Pay pay;

        if(name.equals("Master")){
        pay =new MasterService();
         return pay;
        }
        else if(name.equals("Paypal")){
            pay=new Paypal();
            return pay;
        }

        return null;
    }

}
