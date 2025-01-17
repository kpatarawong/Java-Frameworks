<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

**C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.**

Filename: mainscreen.html

Line 14: Change shop name to Skateboard King
<title>Skateboard King</title

Line 19: Changed display header to “Skateboard King”
<h1>Skateboard King</h1>

Line 21: Changed header for “Parts” to “Skateboard Parts”
<h2>Skateboard Parts</h2>

Line 53: Changed header for “Products” to “Skateboards”
<h2>Skateboards</h2>


**D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.**

Filename: mainscreen.html

Line 20: Add a link to the About page just below the page title
<a href="/about" style="text-decoration: none; font-weight: bold;">About</a>

Filename: MainScreenController.java

Lines 58-60: Add controller @Getmapping to enable access to About page
@GetMapping("/about")
public String about() {
return "about";

File name: about.html

Lines 1 – 34: Add about.html page with HTML styling and layout copied from mainscreen’s styling
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


**E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.**


Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


J.  Remove the class files for any unused validators in order to clean your code.
