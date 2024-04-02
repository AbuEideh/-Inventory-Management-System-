# -Inventory-Management-System-
This REST API aims to provide endpoints to manage products, inventories, suppliers and orders within an inventory management system.
## Entity Relationship Diagram(ERD)
![Inventory Management System ERD](https://github.com/AbuEideh/-Inventory-Management-System-/blob/main/IMS_ERD.drawio.png?raw=true)
## Resources Collections
### Supplier Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/supplier         | Create    | Create a new supplier | 201 (Created), 400 (Bad Request) | `{ "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` | `{ "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` |
| GET/supplier          | Read      | Retrieve all suppliers | 200 (OK) | N/A | `[ { "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" } ]` |
| GET/supplier/{id}     | Read      | Retrieve specific supplier | 200 (OK), 404 (Not Found) | N/A | `{ "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" }` |
| PUT/supplier          | Replace   | Replace all suppliers with new collection | 200 (OK), 204 (No Content), 400 (Bad Request) | `[ { "id": 1, "name": "Supplier Name", "email": "supplier@example.com", "address": "Supplier Address", "phone": "Supplier Phone" } ]` | N/A |
| PATCH/supplier        | Update    | Update existing supplier | 200 (OK), 204 (No Content), 400 (Bad Request) | `{ "name": "New Supplier Name" }` | N/A |
| DELETE/supplier       | Delete    | Delete all suppliers | 204 (No Content), 400 (Bad Request) | N/A | N/A |
| DELETE/supplier/{id}  | Delete    | Delete specific supplier | 204 (No Content), 400 (Bad Request) | N/A | N/A|

### Product Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/product         | Create    | Create a new product | 201 (Created), 400 (Bad Request) | `{ "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity": 100, "supplier_id": 1 }` | `{ "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity": 100, "supplier_id": 1 }` |
| GET/product          | Read      | Retrieve all products | 200 (OK) | N/A | `[ { "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity": 100, "supplier_id": 1 } ]` |
| GET/product/{id}     | Read      | Retrieve specific product | 200 (OK), 404 (Not Found) | N/A | `{ "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity": 100, "supplier_id": 1 }` |
| PUT/product          | Replace   | Replace all products with new collection | 200 (OK), 204 (No Content), 400 (Bad Request) | `[ { "id": 1, "name": "Product Name", "description": "Product Description", "price": 10.99, "quantity": 100, "supplier_id": 1 } ]` | N/A |
| PATCH/product        | Update    | Update existing product | 200 (OK), 204 (No Content), 400 (Bad Request) | `{ "name": "New Product Name" }` | N/A |
| DELETE/product       | Delete    | Delete all products | 204 (No Content), 400 (Bad Request) | N/A | N/A |
| DELETE/product/{id}  | Delete    | Delete specific product | 204 (No Content), 400 (Bad Request) | N/A | N/A |

### Inventory Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/inventory         | Create    | Create a new inventory item | 201 (Created), 400 (Bad Request) | `{ "product_id": 1, "quantity_available": 50, "location": "Warehouse A" }` | `{ "id": 1, "product_id": 1, "quantity_available": 50, "location": "Warehouse A" }` |
| GET/inventory          | Read      | Retrieve all inventory items | 200 (OK) | N/A | `[ { "id": 1, "product_id": 1, "quantity_available": 50, "location": "Warehouse A" } ]` |
| GET/inventory/{id}     | Read      | Retrieve specific inventory item | 200 (OK), 404 (Not Found) | N/A | `{ "id": 1, "product_id": 1, "quantity_available": 50, "location": "Warehouse A" }` |
| PUT/inventory          | Replace   | Replace all inventory items with new collection | 200 (OK), 204 (No Content), 400 (Bad Request) | `[ { "id": 1, "product_id": 1, "quantity_available": 50, "location": "Warehouse A" } ]` | N/A |
| PATCH/inventory        | Update    | Update existing inventory item | 200 (OK), 204 (No Content), 400 (Bad Request) | `{ "quantity_available": 100 }` | N/A |
| DELETE/inventory       | Delete    | Delete all inventory items | 204 (No Content), 400 (Bad Request) | N/A | N/A |
| DELETE/inventory/{id}  | Delete    | Delete specific inventory item | 204 (No Content), 400 (Bad Request) | N/A | N/A |

### Orders Collection:
| HTTP request (method URI) | Operation | Description | HTTP status codes | Request sample | Response sample |
|--------------|-----------|-------------|-------------------|----------------|-----------------|
| POST/order         | Create    | Create a new order | 201 (Created), 400 (Bad Request) | `{ "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` | `{ "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` |
| GET/order          | Read      | Retrieve all orders | 200 (OK) | N/A | `[ { "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" } ]` |
| GET/order/{id}     | Read      | Retrieve specific order | 200 (OK), 404 (Not Found) | N/A | `{ "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" }` |
| PUT/order          | Replace   | Replace all orders with new collection | 200 (OK), 204 (No Content), 400 (Bad Request) | `[ { "id": 1, "supplier_id": 1, "product_id": 1, "quantity": 10, "order_date": "2024-03-30T12:00:00", "order_status": "processing" } ]` | N/A |
| PATCH/order        | Update    | Update existing order | 200 (OK), 204 (No Content), 400 (Bad Request) | `{ "order_status": "completed" }` | N/A |
| DELETE/order       | Delete    | Delete all orders | 204 (No Content), 400 (Bad Request) | N/A | N/A |
| DELETE/order/{id}   | Delete    | Delete spicific order | 204 (No Content), 400 (Bad Request) | N/A | N/A |
