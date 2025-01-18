Kalvin Patarawong

Student# 009931191

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

#### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.**

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

Line 43 – 98: Added 5 new parts to the repository.
```
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
```
Line 101 - 111: Added 5 new products to the repository.

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

### F.  Add a “Buy Now” button to your product list.

Filename: mainscreen.html

Line 85: Create Buy Now button next to Product Add and Delete

`<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>`

Create 3 New Files

File Path: src/main/resources/templates/confirmationbuysuccess.html Simple view with a success message.
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
</head>
<body>
<h1>Your product has been successfully purchased!</h1>

<a href="http://localhost:8080/">Link
to Main Screen</a>
</body>
</html>
```

File Path: src/main/resources/templates/confirmationbuyfailure.html Simple view with a failure message.
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Failed</title>
</head>
<body>
<h1>This product is out of stock. Check again later.</h1>

<a href="http://localhost:8080/">Link
to Main Screen</a>
</body>
</html>
```
File Path src/com.example.demo/controllers/BuyProductController Added the buyProduct method. If the inventory of the item is > 0, decrements the inventory by 1 and redirects to confirmationbuyproduct.html, otherwise, redirects to failedbuyproduct.html.
```
packagecom.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BuyProductController {
@Autowired
private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long theId, Model theModel) {
        Optional<Product> productToBuy = productRepository.findById(theId);

        if (productToBuy.isPresent()) {    //check if product in catalog
            Product product = productToBuy.get();

            if (product.getInv() > 0) {    //check if product still in stock
                product.setInv(product.getInv() - 1);   //decrement stock
                productRepository.save(product);    //save to product database

                return "/confirmationbuysuccess";   //successful purchase
            } else {
                return "/confirmationbuyfailure";   //purchase failed: out of stock
            }
        } else {
            return "/confirmationbuyfailure";  //purchase failed: product not found
        }
    }
}
```

### G.  Modify the parts to track maximum and minimum inventory

Modify the parts to track maximum and minimum inventory

Filename: Part

Line 33 – 36: Add parts to track maximum and minimum inventory

`@Min(value = 0, message = "Min Inventory value must be positive")
int minInv;`

`@Min(value = 0, message = "Max Inventory value must be positive")
int maxInv;`

Line 101 – 115: Add Set and Get for maximum and minimum inventory

```
public int getMinInv() {
    return minInv;
}

public void setMinInv(int minInv) {
this.minInv = minInv;
    }

public int getMaxInv() {
   return maxInv;
    }

public void setMaxInv(int maxInv) {
    this.maxInv = maxInv;
    }
```

Add additional fields to the part entity for maximum and minimum inventory.

Filename: mainscreen.html

Line: 38 – 39: Add maximum and minimum to table header

`<th>Min Inventory</th>`
`<th>Max Inventory</th>`

Line 48 – 49: Add maximum and minimum to table

`<td th:text="${tempPart.minInv}">1</td>`
`<td th:text="${tempPart.maxInv}">1</td>`

Modify the sample inventory to include the maximum and minimum fields.

Filename: BootStrapData

Line 56 – 56, 66 - 67, 81 – 82 , 90 - 91, 100 – 101: Add min and max inventory to all 5 parts.

`setMinInv(1);
setMaxInv(70);`

Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

Filename: OutsourcedPartForm.html

Line 17, 19, 22, 25: Add “Part Name”, “Price”, “Inventory”, and “Company Name” titles to fields
```
<p>Part Name: <input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>

<p>Price: <input type="text" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('price')}" th:errors="*{price}">Price Error</p>

<p>Inventory: <input type="text" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

    <p>Company Name: <input type="text" th:field="*{companyName}" placeholder="Company Name" class="form-control mb-4 col-4"/></p>
```

Line 27 – 31: Add additional text inputs for the inventory so the user can set the maximum and minimum values.
```
<p>Min Inventory: <input type="text" th:field="*{minInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Min Inventory Error</p>

    <p>Max Inventory: <input type="text" th:field="*{maxInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Max Inventory Error</p>
```

Filename: InhousePartForm.html

Line 17, 19, 22, 25: Add “Part Name”, “Price”, “Inventory”, and “Company Name” titles to fields
```
 <p>Part Name: <input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>

<p>Price: <input type="text" path="price" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('price')}" th:errors="*{price}">Price Error</p>

<p>Inventory: <input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

    <p>Part ID: <input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/></p>
```

Line 27 – 31: Add additional text inputs for the inventory so the user can set the maximum and minimum values.
```
<p>Min Inventory: <input type="text" th:field="*{minInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Min Inventory Error</p>

    <p>Max Inventory: <input type="text" th:field="*{maxInv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Max Inventory Error</p>
```

Rename the file the persistent storage is saved to.

Filename: application.properties

Line 6: Update data source

`spring.datasource.url=jdbc:h2:file:~/skateboard-db119`

Modify the code to enforce that the inventory is between or at the minimum and maximum value.

Create 2 Validators for Max and Min inventory

File Path: src/main/java/com.example.demo/validator/InventoryValidator
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
*
*
*
*
*/
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {

        //Create code to make sure that inventory is between min and max value
        if(part.getInv() > part.getMaxInv())
        {
            //display error message when inventory is greater than max
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it is greater than the max inventory.").addConstraintViolation();
            return false;
        }

        if(part.getInv() < part.getMinInv())
        {
            //display error message when inventory is greater than max
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it is less than the min inventory.").addConstraintViolation();
            return false;
        }
        
                return true;

    }
}
```

File Path: src/main/java/com.example.demo/validator/ValidInventory
```
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*
*
*
*
*/
@Constraint(validatedBy = {InventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventory {
String message() default "Inventory Error";
Class<?> [] groups() default {};
Class<? extends Payload> [] payload() default {};

}
```

Filename: Part

Line 23: Add Valid Inventory validator

`@ValidInventory`


### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:

Create 4 new files MinimumValidator, ValidMinimum, MaximumValidator, and ValidMaximum, and display error messages for Maximum/Minimum fields.

Filename: MinimumValidator
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
*
*
*
*
*/
public class MinimumValidator implements ConstraintValidator<ValidMinimum, Part> {
@Autowired
private ApplicationContext context;
public static ApplicationContext myContext;

    @Override
    public void initialize(ValidMinimum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() > part.getMinInv();
    }

}
```

Filename: ValidMinimum
```
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*
*
*
*
*/
@Constraint(validatedBy = {MinimumValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinimum {
String message() default "Part count falls below set minimum";
Class<?> [] groups() default {};
Class<? extends Payload> [] payload() default {};
}
```

Filename: MaximumValidator
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
*
*
*
*
*/
public class MaximumValidator implements ConstraintValidator<ValidMaximum, Part> {
@Autowired
private ApplicationContext context;
public static ApplicationContext myContext;

    @Override
    public void initialize(ValidMaximum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getInv() <= part.getMaxInv();
    }
}
```

Filename: ValidMaximum
```
package com.example.demo.validators;

import com.example.demo.validators.MaximumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*
*
*
*
*/
@Constraint(validatedBy = {MaximumValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaximum {
String message() default "Part count is above set maximum";
Class<?> [] groups() default {};
Class<? extends Payload> [] payload() default {};
}
```
Modify domain model class files to apply minimum and maximum validator

Filename: Part

Line: 26 -27

`@ValidMinimum`
`@ValidMaximum`

### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

Filename: PartTest

Line 160 -194: Added two unit tests for the maximum and minimum fields
```
@Test
void getMinInv() {
int min_inv=5;
partIn.setMinInv(min_inv);
assertEquals(min_inv,partIn.getMinInv());
partOut.setMinInv(min_inv);
assertEquals(min_inv,partOut.getMinInv());
}

@Test
void setMinInv() {
int min_inv=5;
partIn.setMinInv(min_inv);
assertEquals(min_inv,partIn.getMinInv());
partOut.setMinInv(min_inv);
assertEquals(min_inv,partOut.getMinInv());
}

@Test
void getMaxInv() {
int max_inv=195;
partIn.setMaxInv(max_inv);
assertEquals(max_inv,partIn.getMaxInv());
partOut.setMaxInv(max_inv);
assertEquals(max_inv,partOut.getMaxInv());
}

@Test
void setMaxInv() {
int max_inv=195;
partIn.setMaxInv(max_inv);
assertEquals(max_inv,partIn.getMaxInv());
partOut.setMaxInv(max_inv);
assertEquals(max_inv,partOut.getMaxInv());
}
```
### J.  Remove the class files for any unused validators in order to clean your code.**

Deleted unused validator:

Filename: DeletePartValidator.java

Filename: ValidDeletePart.java
