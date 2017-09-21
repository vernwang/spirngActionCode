package STOMP.marcopolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MarcoController {

    private static final Logger logger=LoggerFactory.getLogger(MarcoController.class);

    @MessageMapping("/marco")   //结束后 默认发送到 /topic/marco
    public Shout handleShout(Shout incoming){
        logger.info(incoming.getMessage());

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        Shout outgoing=new Shout();
        outgoing.setMessage("Polo!");

        return outgoing;
    }

    @SubscribeMapping("/sub")   //隐含当订阅 ／app/sub 的时候触发，结束返回给客户端，一次调用。
    public Shout handleSubscription(){
        Shout outgoing=new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }


}
