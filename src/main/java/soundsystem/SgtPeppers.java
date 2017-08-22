package soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * Created by vern on 2017/7/13.
 */
//@Component
@Component("sgtPeppers")
//@Named("sgtPeppers")
public class SgtPeppers implements CompactDisc{

    private String title="Sgt.Pepper's";
    private String artist="The Beatles";

    public SgtPeppers(
//    		@Value("${disc.title}") String title,
//    		@Value("${disc.artist}") String artist,
    		@Value("#{systemProperties['disc.title']}") String title,
    		@Value("#{systemProperties['disc.artist']}") String artist
    		) {
    		this.title=title;
    		this.artist=artist;
    }
    

    
    public void play() {
        System.out.println("Playing"+title+artist);
    }

    
    // #{artistSelector.selectArtist()?.toUpperCase()}
    // #{T(java.lang.math).PI*circle.radius}
    // #{admin.email matches 'a-zA-Z0-9'}
    // #{jukebox.songs.}
    

}

