Let's say we own a supermarket where we sale things. We should know the price when customers check out.

It's tricky that the price of a product is product id multiplies 3.5. We also offer a discount for each customer.

Additional, we need to fetch discount rate from HQ server which is a http API. This step could fail due to bad network.

SuperMarket.java is the main class.It has a checkout method which takes product id and returns the final price.