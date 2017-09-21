package STOMPUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SpittleFeedServiceImpl  implements SpittleFeedService{

    private SimpMessagingTemplate simpMessagingTemplate;
    private Pattern pattern=Pattern.compile("\\@(\\S+)");

    @Autowired
    public SpittleFeedServiceImpl(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate=simpMessagingTemplate;
    }

    @Override
    public void broadcastSpittle(Spittle spittle) {
        simpMessagingTemplate.convertAndSend("/top/spittlefeed",spittle);

        Matcher matcher=pattern.matcher(spittle.getMessage());
        if(matcher.find()){
            String username=matcher.group(1);
            simpMessagingTemplate.convertAndSendToUser(username,"/queue/notifications"
                    ,new Notification("You just got mentioned!"));

        }


    }
}
