CREATE TABLE "Employee" (
  "employee_id" string,
  "name" string,
  "telephone" string,
  "email" string,
  "position" enum
);

CREATE TABLE "Book" (
  "book_id" string,
  "name" string,
  "type" enum
);

CREATE TABLE "Payment" (
  "payment_id" string,
  "token" string,
  "redirectUrl" string,
  "transactionStatus" enum
);

CREATE TABLE "Photo" (
  "photo_id" string,
  "size" enum,
  "material" enum
);

CREATE TABLE "stock" (
  "stock_id" string,
  "stock" integer
);

CREATE TABLE "users" (
  "users_id" string,
  "username" string,
  "password" string,
  "isEnabled" string
);

CREATE TABLE "roles_users" (
  "roles_id" string,
  "role" enum
);

CREATE TABLE "Customer" (
  "customer_id" string,
  "name" string,
  "points" integer,
  "telephone" string,
  "email" string
);

CREATE TABLE "Outlet" (
  "outlet_id" string,
  "code" string,
  "location" string,
  "telephone" string,
  "email" string
);

CREATE TABLE "Product" (
  "product_id" string,
  "code" string
);

CREATE TABLE "Product_price" (
  "product_price_id" string,
  "price" integer
);

CREATE TABLE "Transaction" (
  "transaction_id" string,
  "transa_date" date,
  "order_type" enum
);

CREATE TABLE "Transaction_detail" (
  "transaction_detail_id" string,
  "total_sales" integer,
  "quantity" integer
);

CREATE TABLE "sequence_table" (
  "sequence_id" strng,
  "sequence" integer,
  "sequence_name" string
);

CREATE TABLE "discount" (
  "discount_id" string,
  "percentage_discount" enum,
  "required_points" integer
);

ALTER TABLE "Product" ADD FOREIGN KEY ("product_id") REFERENCES "Photo" ("photo_id");

ALTER TABLE "Product" ADD FOREIGN KEY ("product_id") REFERENCES "Book" ("book_id");

ALTER TABLE "stock" ADD FOREIGN KEY ("stock_id") REFERENCES "Product" ("product_id");

ALTER TABLE "stock" ADD FOREIGN KEY ("stock_id") REFERENCES "Outlet" ("outlet_id");

ALTER TABLE "Transaction" ADD FOREIGN KEY ("transaction_id") REFERENCES "Outlet" ("outlet_id");

ALTER TABLE "Payment" ADD FOREIGN KEY ("payment_id") REFERENCES "Transaction" ("transaction_id");

CREATE TABLE "users_roles_users" (
  "users_users_id" string,
  "roles_users_roles_id" string,
  PRIMARY KEY ("users_users_id", "roles_users_roles_id")
);

ALTER TABLE "users_roles_users" ADD FOREIGN KEY ("users_users_id") REFERENCES "users" ("users_id");

ALTER TABLE "users_roles_users" ADD FOREIGN KEY ("roles_users_roles_id") REFERENCES "roles_users" ("roles_id");


ALTER TABLE "users" ADD FOREIGN KEY ("users_id") REFERENCES "Employee" ("employee_id");

ALTER TABLE "Product" ADD FOREIGN KEY ("product_id") REFERENCES "Product_price" ("product_price_id");

ALTER TABLE "Transaction_detail" ADD FOREIGN KEY ("transaction_detail_id") REFERENCES "Transaction" ("transaction_id");

ALTER TABLE "Transaction" ADD FOREIGN KEY ("transaction_id") REFERENCES "Customer" ("customer_id");

ALTER TABLE "Transaction_detail" ADD FOREIGN KEY ("transaction_detail_id") REFERENCES "Product" ("product_id");

ALTER TABLE "users" ADD FOREIGN KEY ("users_id") REFERENCES "Customer" ("customer_id");
