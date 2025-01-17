Kalvin Patarawong

Student# 009931191

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.**

Filename: mainscreen.html

Line 14: Change shop name to Skateboard King

`<title>Skateboard King</title>
`

Line 19: Changed display header to “Skateboard King”

`<h1>Skateboard King</h1>`

Line 21: Changed header for “Parts” to “Skateboard Parts”

`<h2>Skateboard Parts</h2>`

Line 53: Changed header for “Products” to “Skateboards”

`<h2>Skateboards</h2>`

### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.**

Filename: mainscreen.html

Line 20: Add a link to the About page just below the page title

`<a href="/about" style="text-decoration: none; font-weight: bold;">About</a>`

Filename: MainScreenController.java

Lines 58-60: Add controller @Getmapping to enable access to About page

`@GetMapping("/about")
public String about() {
return "about";`

File name: about.html

Lines 1 – 34: Add about.html page with HTML styling and layout copied from mainscreen’s styling

```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Skateboard King</title>
</head>
<body>

<div class="container">

    <h1>About Skateboard King</h1>
    <a href="/mainscreen" style="text-decoration: none; font-weight: bold;">Go Back Home</a>

    <hr>
    <h2>My Story</h2>
    <p>We created Skateboard King to offer a fresh, unique brand that blends quality, style, and individuality in the skateboarding world.
        Driven by my passion for the sport, I wanted to inspire skaters of all levels to push their limits and express themselves.
        From designing boards to building an online presence, every step has been about celebrating the culture and freedom of skateboarding.
    </p>

</div>

</body>
</html>
```

### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.**

Line 43 – 124: Added 5 new parts to the repository.
```
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
```
Line 127 - 137: Added 5 new products to the repository.

```
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
```

### F.  Add a “Buy Now” button to your product list.**


### G.  Modify the parts to track maximum and minimum inventory
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


## H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


## I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


## J.  Remove the class files for any unused validators in order to clean your code.**
