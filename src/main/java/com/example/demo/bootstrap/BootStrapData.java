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


        if (partRepository.count() == 0 && outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {

        // Create outsourced parts
        OutsourcedPart op1 = new OutsourcedPart();
        op1.setCompanyName("Mike's Wheels");
        op1.setName("Wheels");
        op1.setInv(100);
        op1.setPrice(1.00);
        op1.setId(110);
        outsourcedPartRepository.save(op1);

        OutsourcedPart op2 = new OutsourcedPart();
        op2.setCompanyName("Skateboard Place");
        op2.setName("Trucks");
        op2.setInv(60);
        op2.setPrice(4.00);
        op2.setId(120);
        outsourcedPartRepository.save(op2);

        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }

        // Create in house parts
        InhousePart ip1 = new InhousePart();
        ip1.setName("Grip Tape");
        ip1.setInv(50);
        ip1.setPrice(3.00);
        ip1.setId(130);
        inhousePartRepository.save(ip1);

        InhousePart ip2 = new InhousePart();
        ip2.setName("Truck Bolts");
        ip2.setInv(100);
        ip2.setPrice(1.00);
        ip2.setId(140);
        inhousePartRepository.save(ip2);


        InhousePart ip3 = new InhousePart();
        ip3.setName("Deck");
        ip3.setInv(50);
        ip3.setPrice(6.00);
        ip3.setId(150);
        inhousePartRepository.save(ip3);


        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
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
}
