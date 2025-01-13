package config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import videosystem.Avengers;
import videosystem.BlankDisc;
import videosystem.DigitalVideoDisc;

@Configuration
public class DVDConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	@Bean
	public DigitalVideoDisc avengersInfinityWar() {
		BlankDisc dvd = new BlankDisc();
		dvd.setTitle("Avengers Infinity War");
		dvd.setStudio("Marvel");
		
		return dvd;
	}
}
