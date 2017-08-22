package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

	@DeclareParents(value="concert.Performance+",defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
	
	//@DeclareParents 指定了要引入的接口
	//value 指定了引入的接口要给那些bean。  这里是Performance+ 代表了所有的他的子类型
	//defaultImpl 指定了为引入功能提供实现的类。也就是实现了Encoreable接口的实现类。
	
	
}
