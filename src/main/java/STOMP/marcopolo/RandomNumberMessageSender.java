package STOMP.marcopolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class RandomNumberMessageSender {

    private SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public RandomNumberMessageSender(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate=simpMessagingTemplate;
    }

    @Scheduled(fixedRate = 10000)
    public void sendRandomNumber(){
        Shout ran=new Shout();
        ran.setMessage("Random # : " + (Math.random() * 100));

        simpMessagingTemplate.convertAndSend("/topic/marco",ran);

    }




}
