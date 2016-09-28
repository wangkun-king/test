public class SimpleService
{
    public String getGreeting(String name)
    {
        return "hello " + name;
    }    
    public int getPrice()
    {
        return new java.util.Random().nextInt(1000);
    }    
}