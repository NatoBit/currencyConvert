# Currency Exchange Rate Application

This Java application allows users to retrieve and calculate currency exchange rates for various countries. Users can select their base currency, specify the target currency, and input an amount to convert. The application then displays the converted total using real-time exchange rates.

## Features

- User-friendly CLI with menus and prompts for input
- Option to select base and target currencies from a predefined list of popular currencies
- Real-time exchange rate retrieval
- Validation of user input with error messages for invalid entries
- Option to make multiple queries or exit the application

## Technologies Used

- **Java**: Core language for developing the application
- **Gson**: Library for parsing JSON responses from the API
- **Scanner**: For capturing user input in the command line interface

## Setup and Installation

1. **Clone this repository**:  
   ```bash
   git clone https://github.com/NatoBit/currencyConvert
   cd currency-exchange-app  

2. **Install Dependencies**:

Make sure you have Gson included in your project. If you're using Maven, add the following dependency to your pom.xml:

```xml
<dependency>  
    <groupId>com.google.code.gson</groupId>  
    <artifactId>gson</artifactId>  
    <version>2.8.9</version>  
</dependency>  

3. **Obtain API Key**:
Go to https://app.exchangerate-api.com/ and sign up to get your API key. In the MakeQuery class, set the key variable as follows:

```java
String key = "YOUR_API_KEY_HERE";      
