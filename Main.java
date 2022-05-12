import java.util.*;

public class Main
{
   
    private static int id;
	public static void bookTicket(Passenger p, int id)
    {
        Ticket ticket = new Ticket();
        
        if(Ticket.availableWaitingList == 0)
        {
            System.out.println("No Tickets Available");
            return;
        }
        
        if((p.berthPreference.equals("L") && Ticket.availableLowerBerths > 0 )||
           (p.berthPreference.equals("M") && Ticket.availableMiddleBerths > 0) ||
           (p.berthPreference.equals("U") && Ticket.availableUpperBerths > 0))
        {
            System.out.println("Preferred Berth Available");
            if(p.berthPreference.equals("L"))
            {
                System.out.println("Lower Berth Given");
                
                ticket.bookTicket(p,(Ticket.lowerBerthsPositions.get(0)),"L",  id++);
                
                Ticket.lowerBerthsPositions.remove(0);
                Ticket.availableLowerBerths--;
                
                

            }
            else if(p.berthPreference.equals("M"))
            {
                System.out.println("Middle Berth Given");
                
                ticket.bookTicket(p,(Ticket.middleBerthsPositions.get(0)),"M",id++);
                
                Ticket.middleBerthsPositions.remove(0);
                Ticket.availableMiddleBerths--;

            }
            else if(p.berthPreference.equals("U"))
            {
                System.out.println("Upper Berth Given");
                
                ticket.bookTicket(p,(Ticket.upperBerthsPositions.get(0)),"U",id++);
               
                Ticket.upperBerthsPositions.remove(0);
                Ticket.availableUpperBerths--;
            }

        }
       
        else if(Ticket.availableLowerBerths > 0)
        {
            System.out.println("Lower Berth Given");
            
            ticket.bookTicket(p,(Ticket.lowerBerthsPositions.get(0)),"L",id++);
            
            Ticket.lowerBerthsPositions.remove(0);
            Ticket.availableLowerBerths--;
            

        }
        else if(Ticket.availableMiddleBerths > 0)
        {
            System.out.println("Middle Berth Given");
           
            ticket.bookTicket(p,(Ticket.middleBerthsPositions.get(0)),"M",id++);
            
            Ticket.middleBerthsPositions.remove(0);
            Ticket.availableMiddleBerths--;

        }
        else if(Ticket.availableUpperBerths > 0)
        {
            System.out.println("Upper Berth Given");
           
            ticket.bookTicket(p,(Ticket.upperBerthsPositions.get(0)),"U",id++);
            
            Ticket.upperBerthsPositions.remove(0);
            Ticket.availableUpperBerths--;
            
        }
        
        else if(Ticket.availableRacTickets > 0)
        {
            System.out.println("RAC available");
            ticket.addToRAC(p,(Ticket.racPositions.get(0)),"RAC" );
        }
        
        else if(Ticket.availableWaitingList > 0)
        {
            System.out.println("Added to Waiting List");
            ticket.addToWaitingList(p,(Ticket.waitingListPositions.get(0)),"WL");
            
        }
        
    }
    
    public static void cancelTicket(int id)
    {
        Ticket ticket = new Ticket();
        
        if(!Ticket.passengers.containsKey(id))
        {
            System.out.println("Passenger detail Unknown");
        }
        else
            ticket.cancelTicket(id);
    }
    public static void main(String[] args)
    {
        try (Scanner s = new Scanner(System.in)) {
			boolean loop = true;
			
			while(loop)
			{
			    System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
			    int choice = s.nextInt();
			    Passenger.id=id;
			    switch(choice)
			    {
			        
			        case 1:
			        {
			            
			            System.out.println("Enter Passenger name,age and berth preference (L,M or U)");
			            String name = s.next();
			            int age = s.nextInt();
  
			            String berthPreference = s.next();
			   
			            Passenger p = new Passenger(name,age,berthPreference);
			            
			            bookTicket(p, id++);
			        }
			        break;
			        
			        case 2:
			        {
			           
			            System.out.println("Enter passenger Id to cancel");
			            int id = s.nextInt();
			            cancelTicket(id);
			        }
			        break;
			     
			        case 3:
			        {
			            Ticket ticket = new Ticket();
			            ticket.printAvailable();
			        }
			        break;
			        
			        case 4:
			        {
			            Ticket ticket = new Ticket();
			            ticket.printPassengers();
			        }
			        break;
			        
			        case 5:
			        {
			            loop = false;
			        }
			        break;
			        default:
			        break;
			    }
			}
		}
    }
}


