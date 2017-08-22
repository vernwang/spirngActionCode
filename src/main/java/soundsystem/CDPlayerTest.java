package soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vern on 2017/7/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)    //可以在测试开始的时候自动创建Spring应用上下文。
@ContextConfiguration(classes =CDPlayerConfig.class)
public class CDPlayerTest {


    @Autowired
    private CompactDisc cd;

//    @Autowired
//    private  CDPlayer cp;



    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }


//    @Test
//    public void play(){
//        assertNotNull(cp);
//
//    }


}
