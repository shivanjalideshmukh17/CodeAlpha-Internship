import java.util.Scanner;

public class SimpleChatbot
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("AI Chatbot: Hello! Type 'exit' to end the chat.");
        
        while (true) 
        {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase(); 
            
            if (userInput.equals("exit")) 
            {
                System.out.println("AI Chatbot: Goodbye!");
                break;
            }
            
            String response = getResponse(userInput);
            System.out.println("AI Chatbot: " + response);
        }

        scanner.close();
    }

    public static String getResponse(String input)
     {
        if (input.contains("hi") || input.contains("hello"))
        {
            return "Hello! How can I assist you today?";
        } 
        else if (input.contains("how are you")) 
        {
            return "I'm just a chatbot, but I'm here to help!";
        }
         else if (input.contains("what is your name")) 
        {
            return "I am an AI chatbot!";
        }
         else if (input.contains("bye"))
        {
            return "Goodbye! Have a great day!";
        }
         else if (input.contains("what is ai")) 
        {
            return "AI stands for Artificial Intelligence, the simulation of human intelligence in machines.";
        } 
        else 
        {
            return "I'm not sure how to respond to that. Can you ask something else?";
        }
    }
}