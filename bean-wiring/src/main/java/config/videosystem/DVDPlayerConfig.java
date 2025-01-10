package config.videosystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import videosystem.Avengers;
import videosystem.DVDPlayer;
import videosystem.DigitalVideoDisc;
import videosystem.IronMan;

@Configuration
public class DVDPlayerConfig {
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	@Bean
	public DigitalVideoDisc ironMan() {
		return new IronMan();
	}
	
	// 의존성 주입(Dependency Injection) 하기1
	// Bean 생성 메소드(avengers())를 직접 호출하는 방법
	// 생성자 주입
	@Bean
	public DVDPlayer dvdPlayer1() {
		return new DVDPlayer(avengers());                                                                   
	}
	
	// 의존성 주입(Dependency Injection) 하기2
	// Parameter로 Bean을 전달하는 방법
	// 생성자 주입
	@Bean("DVDPlayer2nd")
	public DVDPlayer dvdPlayer2(Avengers dvd) {
		return new DVDPlayer(dvd);                                                                   
	}
	
	// 의존성 주입(Dependency Injection) 하기3
	// Parameter로 Bean을 전달하는 방법
	// setter 주입
	@Bean
	public DVDPlayer dvdPlayer3(@Qualifier("ironMan") DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer(dvd);     
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
}
