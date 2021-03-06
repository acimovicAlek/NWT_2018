package com.meminator.imageModule;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.meminator.imageModule.models.Image;
import com.meminator.imageModule.models.ImageType;
import com.meminator.imageModule.repositories.ImageRepository;
import com.meminator.imageModule.repositories.ImageTypeRepository;
import com.meminator.imageModule.repositories.RegisteredUserRepository;


//implements CommandLineRunner
@EnableDiscoveryClient
@SpringBootApplication
public class ImageModuleApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ImageModuleApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST","PUT", "DELETE");;
			}
		};
	}
	/*
	// Kod koji omogućava unos par slogova u bazu podataka + spašavanje slika
	@Override
	public void run(String... arg0) throws Exception {
		
		ImageType imageType = new ImageType((long) 1,"Meme");
		imageTypeRepository.save(imageType);
		
		// image 1
		ClassPathResource backImgFile = new ClassPathResource("images/clapback.png");
		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
		backImgFile.getInputStream().read(arrayPic);
		Image meme = new Image((long) 1, arrayPic,imageType);		
		
		// store image to MySQL via SpringJPA
		imageRepository.save(meme);
		
		// retrieve image from MySQL via SpringJPA
		for(Image imageModel : imageRepository.findAll()){
			Files.write(Paths.get("retrieve_dir/" + imageModel.getId() + "_" + imageModel.getTip().getTypeName()), imageModel.getData());
		}
	}*/
}

