package methodSecurity;

import java.util.List;

import org.mvel2.ast.ReturnNode;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import io.fabric8.common.util.PublicPortMapper.SPI;
import spittr.Spittle;

public class SpittleController {

	@PreAuthorize("hasRole('ROLE_SPITTER')")
	public void addSpittle() {
		
	}
	
	@PreAuthorize("hasRole('ROLE_SPITTER' and #spittle.text.length()<= 140 or hasRole('ROLE_PREMIUM'))")
	public void addSpittle(Spittle spittle) {
		
	}
	
	@PostAuthorize("returnObject.spittle.username==principal.username")
	public Spittle getSpittleById(long id) {
		return null;
	}
	
	
	@PreAuthorize("hasRole('ROLE_SPITTER')")
	@PostFilter("hasRole('ROLE_ADMIN') || filterObject.spitter.username==principal.name")
	public List<Spittle> getOffensiveSpittles(){
		return null;
	}
	 
	
	@PreAuthorize("hasRole('ROLE_SPITTER') || hasRole('ROLE_ADMIN')" )
	@PreFilter("hasRole('ROLE_SPITTER') || targetObject.spitter.username== principal.name")
	public void deleteSpittles(List<Spittle> spittles) {
		
	}
	
	
	
}
