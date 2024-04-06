# -Inventory-Management-System-
The Inventory Management System APIs provide endpoints to manage suppliers, products, inventories and orders. These endpoints allow for CRUD operations on the correspondig resources within the inventory system. These APIs stand to RESTful principles and utilizes JSON format for data exchange.
## Running the IMS API
You can run the API locally to explore the functionalites and interact with the endpoints.
### Prerequisites
Before running the APIs, make sure you have the following prerequisities installed on your system:
1. Node.js (version 6 or higher)
2. NPM (Node.js package manager)
### Installation
1. Clone this repository to your machine using CMD or gitbash:
> git clone repository-url
2. Navigate to the project directory:
> cd -Inventory-Management-System-
3. Install dependencies using npm:
> npm install 
### Starting the server
Run the following command to start the server:
> npm start

You can access the server at `http://localhost:8080`, it will be on port 8080 by default.
### Viewing documentation
The APIs documentation is provided by Swagger UI, once you run the server you can access it by opening the browser at:
>`http://localhost:8080/docs`

### SwaggerHub Link:
> `https://app.swaggerhub.com/apis/AhmadAbueideh/inventory-management_system_ap_is/1.0.0`


## Entity Relationship Diagram(ERD)
![Inventory Management System ERD](https://github.com/AbuEideh/-Inventory-Management-System-/blob/main/IMS_ERD.drawio.png?raw=true)
## Resources Collections
### Supplier Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/suppliers         | Create    | Create a new supplier | 201 (Created), 400 (Bad Request), 409 (Conflict), 422 (Unprocessable Entity) | `{ "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` | `{ "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` |
| GET/suppliers          | Read      | Retrieve all suppliers | 200 (OK), 403 (Forbidden), 404 (Not Found), 401 (Unauthorized) | N/A | `[ { "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" } ]` |
| GET/suppliers/{id}     | Read      | Retrieve specific supplier | 200 (OK), 403 (Forbidden), 404 (Not Found), 401 (Unauthorized) | N/A | `{ "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` |
| PUT/suppliers          | Replace   | Replace all suppliers with new collection | 200 (OK), 204 (No Content), 400 (Bad Request), 405 (Method Not Allowed) | `[ { "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" } ]` | N/A |
| PATCH/suppliers        | Update    | Update existing supplier | 200 (OK), 204 (No Content), 400 (Bad Request), 422 (Unprocessable Entity) | `{ "name": "New Supplier Name" }` | N/A |
| DELETE/suppliers       | Delete    | Delete all suppliers | 204 (No Content), 400 (Bad Request), 401 (Unauthorized), 403 (Forbidden) | N/A | N/A |
| DELETE/suppliers/{id}  | Delete    | Delete specific supplier | 204 (No Content), 400 (Bad Request), 401 (Unauthorized), 403 (Forbidden) | N/A | N/A|

### Product Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/products         | Create    | Create a new product | 201 (Created), 400 (Bad Request), 409 (Conflict), 422 (Unprocessable Entity) | `{ "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity_available": 100, "supplier_id": 1 }` | `{ "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity_available": 100, "supplier_id": 1 }` |
| GET/products          | Read      | Retrieve all products | 200 (OK), 403 (Forbidden), 404 (Not Found), 401 (Unauthorized) | N/A | `[ { "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity_available": 100, "supplier_id": 1 } ]` |
| GET/products/{id}     | Read      | Retrieve specific product | 200 (OK), 404 (Not Found), 403 (Forbidden), 401 (Unauthorized) | N/A | `{ "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity_available": 100, "supplier_id": 1 }` |
| PUT/products          | Replace   | Replace all products with new collection | 200 (OK), 204 (No Content), 400 (Bad Request), 405 (Method Not Allowed) | `[ { "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity_available": 100, "supplier_id": 1 } ]` | N/A |
| PATCH/products        | Update    | Update existing product | 200 (OK), 204 (No Content), 400 (Bad Request), 422 (Unprocessable Entity) | `{ "name": "New Product Name" }` | N/A |
| DELETE/products       | Delete    | Delete all products | 204 (No Content), 400 (Bad Request), 403 (Forbidden), 401 (Unauthorized) | N/A | N/A |
| DELETE/products/{id}  | Delete    | Delete specific product | 204 (No Content), 400 (Bad Request), 403 (Forbidden), 401 (Unauthorized) | N/A | N/A |

### Inventory Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/inventories         | Create    | Create a new inventory item | 201 (Created), 400 (Bad Request), 409 (Conflict), 422 (Unprocessable Entity) | `{ "product_id": 1, "quantity": 50, "last_restock_date": "2024-04-06T12:00:00", "location": "Warehouse A" }` | `{ "id": 1, "product_id": 1, "quantity": 50,"last_restock_date": "2024-04-06T12:00:00", "location": "Warehouse A" }` |
| GET/inventories          | Read      | Retrieve all inventory items | 200 (OK), 403 (Forbidden), 404 (Not Found), 401 (Unauthorized) | N/A | `[ { "id": 1, "product_id": 1, "quantity": 50, "last_restock_date": "2024-04-06T12:00:00", "location": "Warehouse A" } ]` |
| GET/inventories/{id}     | Read      | Retrieve specific inventory item | 200 (OK), 404 (Not Found), 403 (Forbidden), 401 (Unauthorized) | N/A | `{ "id": 1, "product_id": 1, "quantity": 50, "last_restock_date": "2024-04-06T12:00:00","location": "Warehouse A" }` |
| PUT/inventories          | Replace   | Replace all inventory items with new collection | 200 (OK), 204 (No Content), 400 (Bad Request), 405 (Method Not Allowed) | `[ { "id": 1, "product_id": 1, "quantity": 50, "last_restock_date": "2024-04-06T12:00:00", "location": "Warehouse A" } ]` | N/A |
| PATCH/inventories        | Update    | Update existing inventory item | 200 (OK), 204 (No Content), 400 (Bad Request), 422 (Unprocessable Entity) | `{ "quantity": 100 }` | N/A |
| DELETE/inventories       | Delete    | Delete all inventory items | 204 (No Content), 400 (Bad Request), 403 (Forbidden), 401 (Unauthorized) | N/A | N/A |
| DELETE/inventories/{id}  | Delete    | Delete specific inventory item | 204 (No Content), 400 (Bad Request), 403 (Forbidden), 401 (Unauthorized) | N/A | N/A |

### Orders Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/orders         | Create    | Create a new order | 201 (Created), 400 (Bad Request), 409 (Conflict), 422 (Unprocessable Entity) | `{ "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` | `{ "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` |
| GET/orders          | Read      | Retrieve all orders | 200 (OK), 403 (Forbidden), 404 (Not Found), 401 (Unauthorized) | N/A | `[ { "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" } ]` |
| GET/orders/{id}     | Read      | Retrieve specific order | 200 (OK), 404 (Not Found), 403 (Forbidden), 401 (Unauthorized) | N/A | `{ "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` |
| PUT/orders          | Replace   | Replace all orders with new collection | 200 (OK), 204 (No Content), 400 (Bad Request), 405 (Method Not Allowed) | `[ { "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" } ]` | N/A |
| PATCH/orders        | Update    | Update existing order | 200 (OK), 204 (No Content), 400 (Bad Request), 422 (Unprocessable Entity) | `{ "order_status": "completed" }` | N/A |
| DELETE/orders       | Delete    | Delete all orders | 204 (No Content), 400 (Bad Request), 401 (Unauthorized), 403 (Forbidden) | N/A | N/A |
| DELETE/orders/{id}   | Delete    | Delete specific order | 204 (No Content), 400 (Bad Request), 401 (Unauthorized), 403 (Forbidden) | N/A | N/A |
