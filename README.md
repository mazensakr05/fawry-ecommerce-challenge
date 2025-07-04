# fawry-ecommerce-challenge
## 📦 Overview

A Java-based console application designed for the Fawry Full Stack Development Internship challenge.  
The system simulates an e-commerce checkout process, including product validation, shipping logic, and customer balance handling.

---

## ✅ Features

- Define products with:
  - Name, price, quantity
  - Optional expiry date
  - Optional shipping weight
- Add products to cart with quantity limits
- Validate products:
  - Out-of-stock check
  - Expiry check (if applicable)
- Checkout process:
  - Subtotal + shipping fees
  - Deduct total from customer balance
  - Print formatted receipt
- Ship valid shippable items with total weight summary

---

## 📁 Project Structure

src/
├── model/ → All product, customer, and interface classes
├── service/ → Cart, CheckoutService, ShippingService
├── app/ → Main.java (test cases and demo)

## 🧪 Test Cases

Test cases are provided in `Main.java`, including:

- ✅ Successful checkout
- ❌ Expired product error
- ❌ Out-of-stock error
- ❌ Insufficient balance error
- ❌ Too many items added to cart

---

## ▶️ How to Run

1. Open the project in Eclipse
2. Right-click on `Main.java` → **Run As → Java Application**
3. View the console for shipment notice, receipt, and error handling

---

## 📤 Output Example

** Shipment notice **
2x Cheese
1x TV
Total package weight 70.8kg

** Checkout receipt **
2x Cheese 200.00
1x Biscuits 150.00
1x TV 2000.00
1x Scratch Card 50.00
Subtotal: 2400.00
Shipping: 708.00
Total: 3108.00
Balance after payment: 1892.00

yaml
Copy
Edit

---

## 🙋 Author

Developed by [Your Name]  
Fawry Rise Journey Applicant – Full Stack Development Track
