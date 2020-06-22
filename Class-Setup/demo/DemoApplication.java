package eu.additude.demo;

import eu.additude.demo.view.MainForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		JFrame frame=new MainForm("StopKnop");
		frame.setVisible(true);

		SpringApplication.run(DemoApplication.class, args);
	}

}
