package STOMPUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

@Controller
public class SpittrMessageController {


    private SpittleRepository spittleRepository;
    private SpittleFeedService spittleFeedService;


    @Autowired
    public SpittrMessageController(SpittleRepository spittleRepository, SpittleFeedService spittleFeedService){
        this.spittleFeedService=spittleFeedService;
        this.spittleRepository=spittleRepository;
    }


    @MessageMapping("/spittle")
    @SendToUser("/queue/nofications")
    public Notification handleSpittle(Principal principal,SpittleForm spittleForm){
        Spittle spittle=new Spittle(principal.getName(),spittleForm.getText(),new Date());
        spittleRepository.save(spittle);
        spittleFeedService.broadcastSpittle(spittle);
        return new Notification("Saved Spittle for user: " + principal.getName());

    }




}
