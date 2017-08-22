//package soundsystem;
//
//import com.google.inject.Inject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by vern on 2017/7/14.
// */
//@Component
//public class cdPlayerr implements CDPlayer{
//    private CompactDisc sgtPeppers;
//
//    @Autowired  //装配构造器
//    public cdPlayerr(CompactDisc cd){
//        this.cd=cd;
//    }
//
//    @Autowired     //装配在setter方法上
//    public void setCompactDisc(CompactDisc cd){
//        this.cd=cd;
//    }
//
//    @Autowired    //装配在人和方法上，Spring都会尝试满足方法参数上所声明的依赖。
//    public void insertDisc(CompactDisc cd){
//        this.cd=cd;
//    }
//
//    @Inject
//    @Autowired(required=false)   //Spring会尝试执行自动装配，但是如果没有匹配的bean,Spring会让这个Bean处于未装配状态。
//    public cdPlayerr(CompactDisc cd,String s){
//        this.cd=cd;
//    }
//
//
//
//    public void play(){
//        cd.play();
//    }
//
//
//}
