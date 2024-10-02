package ticketsystem;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TicketSystem {

    private static boolean isBookingValidated = false;
    private static boolean isPaymentProcessed = false;
    
    public static void main(String[] args) {
        
       Thread booking = new BookingThread();
       Thread paymentProcess = new PaymentProcessingThread();
       Thread collection = new CollectionProcessThread();
       
       booking.setPriority(Thread.MAX_PRIORITY);
       paymentProcess.setPriority(Thread.NORM_PRIORITY);
       collection.setPriority(Thread.MIN_PRIORITY);
       
       booking.start();
       paymentProcess.start();
       collection.start();
    }
    
    static class BookingThread extends Thread{
        @Override
        public void run(){
            synchronized(TicketSystem.class){
                System.out.println("Booking started.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                isBookingValidated = true;
                System.out.println("Booking completed.");
                TicketSystem.class.notifyAll();
            }
        }
    }
    
    static class PaymentProcessingThread extends Thread{
        @Override
        public void run(){
            synchronized(TicketSystem.class){
                try{
                    while(!isBookingValidated){
                        System.out.println("Waiting for booking validation...");
                        TicketSystem.class.wait();
                    }
                    System.out.println("Payment started.");
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                isPaymentProcessed = true;
                System.out.println("Payment process completed");
                TicketSystem.class.notifyAll();
            }
        }
    }
    
    static class CollectionProcessThread extends Thread{
        @Override
        public void run(){
            synchronized(TicketSystem.class){
                try{
                    while(!isPaymentProcessed){
                        System.out.println("Waiting for payment process...");
                        TicketSystem.class.wait();
                    }
                    System.out.println("Collection process started.");
                    Thread.sleep(1000);
                    System.out.println("Ticket collected.");
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
