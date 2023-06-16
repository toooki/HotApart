package com.pbl3team2.hotspot;

import com.pbl3team2.hotspot.member.Member;
import com.pbl3team2.hotspot.member.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;



@SpringBootApplication
public class HotspotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotspotApplication.class, args);
		System.out.println("안녕하셔유");
	}
}


