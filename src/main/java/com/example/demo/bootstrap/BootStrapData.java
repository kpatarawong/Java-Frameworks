package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
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
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

        OutsourcedPart op1 = new OutsourcedPart();
        op1.setCompanyName("Mike's Wheels");
        op1.setName("Wheels");
        op1.setInv(100);
        op1.setPrice(1.00);
        op1.setId(110L);
        outsourcedPartRepository.save(op1);
        OutsourcedPart theOutPart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Wheels"))theOutPart=part;
        }

        System.out.println(theOutPart.getCompanyName());


        OutsourcedPart op2 = new OutsourcedPart();
        op2.setCompanyName("Skateboard Place");
        op2.setName("Trucks");
        op2.setInv(60);
        op2.setPrice(4.00);
        op2.setId(120L);
        outsourcedPartRepository.save(op2);
        theOutPart=null;
        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Trucks"))theOutPart=part;
        }

        System.out.println(theOutPart.getCompanyName());

        outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();

        InhousePart ip1 = new InhousePart();
        ip1.setName("Grip Tape");
        ip1.setInv(50);
        ip1.setPrice(3.00);
        ip1.setId(130L);
        inhousePartRepository.save(ip1);
        InhousePart thePart=null;
        inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:inhouseParts){
            if(part.getName().equals("Grip Tape"))thePart=part;
        }

        InhousePart ip2 = new InhousePart();
        ip2.setName("Truck Bolts");
        ip2.setInv(100);
        ip2.setPrice(1.00);
        ip2.setId(102L);
        inhousePartRepository.save(ip2);
        thePart=null;
        inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:inhouseParts){
            if(part.getName().equals("Truck Bolts"))thePart=part;
        }

        InhousePart ip3 = new InhousePart();
        ip3.setName("Deck");
        ip3.setInv(50);
        ip3.setPrice(6.00);
        ip3.setId(140L);
        inhousePartRepository.save(ip3);
        thePart=null;
        inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:inhouseParts){
            if(part.getName().equals("Deck"))thePart=part;
        }

        inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        for(InhousePart part:inhouseParts){
            System.out.println(part.getName()+" "+part.getId());
        }


        Product flaming_board = new Product("Flaming Board", 50.00, 20);
        Product white_board = new Product("White Board", 50.00, 20);
        Product classic_board = new Product("Classic Board", 50.00, 20);
        Product mario_board = new Product("Mario Board", 60.00, 20);
        Product dragon_board = new Product("Dragon Board", 50.00, 20);

        productRepository.save(flaming_board);
        productRepository.save(white_board);
        productRepository.save(classic_board);
        productRepository.save(mario_board);
        productRepository.save(dragon_board);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());


    }
}
