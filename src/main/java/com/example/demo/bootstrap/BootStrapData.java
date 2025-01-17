package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

    if (partRepository.count() == 0 && outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {

        OutsourcedPart op1= new OutsourcedPart();
        op1.setCompanyName("Mike's Wheels");
        op1.setName("Wheels");
        op1.setInv(60);
        op1.setPrice(1.00);
        op1.setId(122L);
        outsourcedPartRepository.save(op1);
        OutsourcedPart thePart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Wheels"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        OutsourcedPart op2= new OutsourcedPart();
        op2.setCompanyName("Skateboard Place");
        op2.setName("Trucks");
        op2.setInv(60);
        op2.setPrice(4.00);
        op2.setId(128L);
        outsourcedPartRepository.save(op2);
        thePart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Trucks"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        OutsourcedPart op3= new OutsourcedPart();
        op3.setCompanyName("Wilson Skateboard Parts");
        op3.setName("Grip Tape");
        op3.setInv(50);
        op3.setPrice(3.00);
        op3.setId(112L);
        outsourcedPartRepository.save(op3);
        thePart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Grip Tape"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        OutsourcedPart op4= new OutsourcedPart();
        op4.setCompanyName("World of Screws");
        op4.setName("Truck Bolts");
        op4.setInv(100);
        op4.setPrice(1.00);
        op4.setId(102L);
        outsourcedPartRepository.save(op4);
        thePart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Truck Bolts"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        OutsourcedPart op5= new OutsourcedPart();
        op5.setCompanyName("Skateboard Deck World");
        op5.setName("Deck");
        op5.setInv(50);
        op5.setPrice(6.00);
        op5.setId(365L);
        outsourcedPartRepository.save(op5);
        thePart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Decks"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
       for (OutsourcedPart part : outsourcedParts) {
           System.out.println(part.getName() + " " + part.getCompanyName());
        }


        Product flaming_board= new Product("Flaming Board",50.00,20);
        Product white_board= new Product("White Board",50.00,20);
        Product classic_board= new Product("Classic Board",50.00,20);
        Product mario_board= new Product("Mario Board",60.00,20);
        Product dragon_board= new Product("Dragon Board",50.00,20);

        productRepository.save(flaming_board);
        productRepository.save(white_board);
        productRepository.save(classic_board);
        productRepository.save(mario_board);
        productRepository.save(dragon_board);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
