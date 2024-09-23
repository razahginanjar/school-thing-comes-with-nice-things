CREATE TABLE "Employee" (
  "employee_id" string
);

CREATE TABLE "users" (
  "users_id" string
);

CREATE TABLE "roles_users" (
  "roles_id" string
);

CREATE TABLE "Customer" (
  "customer_id" string
);

CREATE TABLE "Outlet" (
  "outlet_id" string
);

CREATE TABLE "Product" (
  "product_id" string
);

CREATE TABLE "Product_price" (
  "product_price_id" string
);

CREATE TABLE "Transaction" (
  "transaction_id" string
);

CREATE TABLE "Transaction_detail" (
  "transaction_detail_id" string
);

CREATE TABLE "users_roles_users" (
  "users_users_id" string,
  "roles_users_roles_id" string,
  PRIMARY KEY ("users_users_id", "roles_users_roles_id")
);

ALTER TABLE "users_roles_users" ADD FOREIGN KEY ("users_users_id") REFERENCES "users" ("users_id");

ALTER TABLE "users_roles_users" ADD FOREIGN KEY ("roles_users_roles_id") REFERENCES "roles_users" ("roles_id");


ALTER TABLE "users" ADD FOREIGN KEY ("users_id") REFERENCES "Employee" ("employee_id");

CREATE TABLE "Outlet_Product" (
  "Outlet_outlet_id" string,
  "Product_product_id" string,
  PRIMARY KEY ("Outlet_outlet_id", "Product_product_id")
);

ALTER TABLE "Outlet_Product" ADD FOREIGN KEY ("Outlet_outlet_id") REFERENCES "Outlet" ("outlet_id");

ALTER TABLE "Outlet_Product" ADD FOREIGN KEY ("Product_product_id") REFERENCES "Product" ("product_id");


CREATE TABLE "Product_Product_price" (
  "Product_product_id" string,
  "Product_price_product_price_id" string,
  PRIMARY KEY ("Product_product_id", "Product_price_product_price_id")
);

ALTER TABLE "Product_Product_price" ADD FOREIGN KEY ("Product_product_id") REFERENCES "Product" ("product_id");

ALTER TABLE "Product_Product_price" ADD FOREIGN KEY ("Product_price_product_price_id") REFERENCES "Product_price" ("product_price_id");


ALTER TABLE "Transaction_detail" ADD FOREIGN KEY ("transaction_detail_id") REFERENCES "Transaction" ("transaction_id");

ALTER TABLE "Transaction" ADD FOREIGN KEY ("transaction_id") REFERENCES "Customer" ("customer_id");

ALTER TABLE "Transaction_detail" ADD FOREIGN KEY ("transaction_detail_id") REFERENCES "Product" ("product_id");

ALTER TABLE "Employee" ADD FOREIGN KEY ("employee_id") REFERENCES "Outlet" ("outlet_id");

ALTER TABLE "Transaction_detail" ADD FOREIGN KEY ("transaction_detail_id") REFERENCES "Outlet" ("outlet_id");

ALTER TABLE "users" ADD FOREIGN KEY ("users_id") REFERENCES "Customer" ("customer_id");
